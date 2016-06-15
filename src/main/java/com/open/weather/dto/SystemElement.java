package com.open.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Created by sandeep on 15/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemElement{
	private long sunrise;
	private long sunset;
	public long getSunrise() {
		return sunrise;
	}
	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}
	public long getSunset() {
		return sunset;
	}
	public void setSunset(long sunset) {
		this.sunset = sunset;
	}
}
