package com.open.weather.control.service;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;

import com.open.weather.control.service.ControlWeatherService;
import com.open.weather.controller.WeatherController;
import com.open.weather.dto.WeatherDto;

@RunWith(MockitoJUnitRunner.class)
public class ControlWeatherServiceTest {

	@Mock
	private ControlWeatherService controlWeatherService;
	
	private WeatherController weatherController;
	
	@Before
	public void setup(){
		weatherController = new WeatherController(controlWeatherService);
	}
	
	@Test
	public void testGetWeatherData() {
		WeatherDto weatherDto = mockWeatherDto();
		Mockito.when(controlWeatherService.getWeatherData(Mockito.anyString())).thenReturn(weatherDto);
		weatherDto = weatherController.getWeatherData("London");
		Assert.notNull(weatherDto);
		Assert.isTrue(weatherDto.getCityname().equals("London"));
	}
	
	private WeatherDto mockWeatherDto() {
		WeatherDto weatherDto = new WeatherDto();
		weatherDto.setToday(new Date());
		weatherDto.setTemperatureInC("23");
		weatherDto.setCityname("London");
        return weatherDto;
    }

}
