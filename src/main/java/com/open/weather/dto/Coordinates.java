package com.open.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Created by sandeep on 15/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates{
	private double lon;
	private double lat;
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
}