package com.gita.weatherapi.model;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Weather {
	@Id
	@GeneratedValue
	private int id;
	private LocalDate date;
	@Embedded
	private Location location;
	@Lob
	private Float[] temparature;
	
	public Weather() {
		
	}
	
	public Weather(int id, LocalDate date, Location location, Float[] temparature) {
		this.id = id;
		this.date = date;
		this.location = location;
		this.temparature = temparature;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Float[] getTemparature() {
		return temparature;
	}

	public void setTemparature(Float[] temparature) {
		this.temparature = temparature;
	}
	
	
	
	
}
