package com.open.weather.control.service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.open.weather.dto.WeatherAPIResponseDto;
import com.open.weather.dto.WeatherDto;
import com.open.weather.dto.WeatherElement;
/**
 * Created by sandeep on 15/06/16.
 */
@Component
public class ControlWeatherServiceImpl implements ControlWeatherService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${owm.api.url}")
    private String ormUrl;
	
	@Value("${owm.api.key}")
    private String ormAppKey;
	
	private static final Logger LOG = LoggerFactory
			.getLogger(ControlWeatherServiceImpl.class);
	
	private static final DecimalFormat df = new DecimalFormat("#.##");
	private static final DateFormat dateFormat = new SimpleDateFormat("hh:mm a");

	/* (non-Javadoc)
	 * @see com.open.weather.control.service.ControlWeatherService#getWeatherData(java.lang.String)
	 */
	@Override
	public WeatherDto getWeatherData(String city) {
		WeatherDto weatherDto = new WeatherDto();
		WeatherAPIResponseDto weatherAPIResponseDto = null;
		if(city!=null && !city.isEmpty()){			
			String description = null;
			String ormUri = ormUrl + "?q=" + city + "&units=imperial&appid=" + ormAppKey;
			try{
				ResponseEntity<WeatherAPIResponseDto> forEntity = restTemplate.getForEntity(ormUri, WeatherAPIResponseDto.class);
				weatherAPIResponseDto = forEntity.getBody();
			} catch(RestClientException restException) {
				LOG.error("owm api thrown an error :" + restException.getMessage());
				throw restException;
			}
			//convert to weather dto
			WeatherElement weatherElementFirst = weatherAPIResponseDto.getWeatherElements().get(0);
			if(weatherElementFirst!=null){
				description = weatherElementFirst.getDescription();
			}
			String celciusTemp = getTemperatureCelcius(weatherAPIResponseDto.getMainElement().getTemp());
			weatherDto.setCityname(city);
			weatherDto.setDescription(description);
			weatherDto.setTemperatureInC(celciusTemp + " °C");
			weatherDto.setTemperatureInF(weatherAPIResponseDto.getMainElement().getTemp() + " °F");
			if(weatherAPIResponseDto.getSystemElement()!=null){
				weatherDto.setSunrise(dateFormat.format(new Date(weatherAPIResponseDto.getSystemElement().getSunrise()*1000)));
				weatherDto.setSunset(dateFormat.format(new Date(weatherAPIResponseDto.getSystemElement().getSunset()*1000)));				
			}
			weatherDto.setToday(new Date());
			weatherDto.setValid(true);
			
		} else{
			LOG.error("city cannot be empty or null");
			throw new RuntimeException("cannot retrive weather data...please enter correct city name");
		}		
		return weatherDto;
	}

	/**
	 * get temperature in celcius
	 * @param weatherAPIResponseDto
	 * @return
	 */
	private String getTemperatureCelcius(
			double temperature) {
		double celcius = (temperature - 32) * (5.0/9.0);		
		String celciusTemp = df.format(celcius);
		return celciusTemp;
	}
}
