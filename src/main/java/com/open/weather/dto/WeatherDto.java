package com.open.weather.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.open.weather.util.JsonDateSerializer;

/**
 * Created by sandeep on 15/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date today;	
    private String cityname;
	private String description;
	private String temperatureInF;
	private String temperatureInC;
	private String sunrise;
	private String sunset;
	private boolean valid;
	public WeatherDto() {
		super();
	}
	public WeatherDto(Date today, String cityname, String description,
			double temperature, long sunrise, long sunset) {
		super();
		this.today = today;
		this.cityname = cityname;
		this.description = description;
	}
	public String getCityname() {
		return cityname;
	}
	public String getDescription() {
		return description;
	}
	public String getSunrise() {
		return sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public String getTemperatureInC() {
		return temperatureInC;
	}
    public String getTemperatureInF() {
		return temperatureInF;
	}
	public Date getToday() {
		return today;
	}
	public boolean isValid() {
		return valid;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public void setTemperatureInC(String temperatureInC) {
		this.temperatureInC = temperatureInC;
	}
	public void setTemperatureInF(String temperatureInF) {
		this.temperatureInF = temperatureInF;
	}
	public void setToday(Date today) {
		this.today = today;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
    
}
