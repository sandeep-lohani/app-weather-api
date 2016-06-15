package com.open.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Created by sandeep on 15/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainElement{
	private double temp;

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}
}