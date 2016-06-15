package com.open.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Created by sandeep on 15/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherElement{
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;
}