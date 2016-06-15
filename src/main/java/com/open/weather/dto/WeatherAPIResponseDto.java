package com.open.weather.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sandeep on 15/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherAPIResponseDto {
	@JsonProperty("coord")
	private Coordinates coordinates;
	
	@JsonProperty("weather")
	private List<WeatherElement> weatherElements;
	@JsonProperty("main")
	private MainElement mainElement;
	@JsonProperty("sys")
	private SystemElement systemElement;
	

	public List<WeatherElement> getWeatherElements() {
		return weatherElements;
	}

	public void setWeatherElements(List<WeatherElement> weatherElements) {
		this.weatherElements = weatherElements;
	}

	public MainElement getMainElement() {
		return mainElement;
	}

	public void setMainElement(MainElement mainElement) {
		this.mainElement = mainElement;
	}

	public SystemElement getSystemElement() {
		return systemElement;
	}

	public void setSystemElement(SystemElement systemElement) {
		this.systemElement = systemElement;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
}

