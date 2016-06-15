package com.open.weather.control.service;

import com.open.weather.dto.WeatherDto;
/**
 * Created by sandeep on 15/06/16.
 */
public interface ControlWeatherService {

	/**
	 * This service method takes a city as an argument and returns the weather data using open weather map api. 
	 * @param city
	 * @return WeatherDto
	 */
	WeatherDto getWeatherData(String city);

}
