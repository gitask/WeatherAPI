package com.gita.weatherapi.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Location {
	private double lat;
	private double lon;
	private String city;
	private String state;
	
	public Location() {
	}
	
	

	public Location(double lat, double lon, String city, String state) {
		this.lat = lat;
		this.lon = lon;
		this.city = city;
		this.state = state;
	}



	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
