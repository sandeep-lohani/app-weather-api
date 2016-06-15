package com.open.weather.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.open.weather.control.service.ControlWeatherService;
import com.open.weather.dto.WeatherDto;

/**
 * Created by sandeep on 15/06/16.
 */
@RestController
@RequestMapping(value = "/weather", produces = APPLICATION_JSON_VALUE)
public class WeatherController {
	
    private static final Logger LOG = LoggerFactory.getLogger(WeatherController.class);
    
    private final ControlWeatherService controlWeatherservice;

    @Autowired
    public WeatherController(ControlWeatherService controlWeatherservice) {
    	this.controlWeatherservice = controlWeatherservice;
    }
    
    /**
     * Entry method to return weather details for a city. 
     * @param city
     * @return
     */
    @RequestMapping(method = GET)
    public
    @ResponseBody
    WeatherDto getWeatherData(@RequestParam String city) {
        LOG.trace("get weather data for city :" + city);
        return controlWeatherservice.getWeatherData(city);        
    }

}
