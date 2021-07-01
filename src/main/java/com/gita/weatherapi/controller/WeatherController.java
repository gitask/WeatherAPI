package com.gita.weatherapi.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.gita.weatherapi.model.Weather;
import com.gita.weatherapi.service.WeatherService;

@RestController
@RequestMapping("/")
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@GetMapping("/weather")
	public ResponseEntity<Iterable<Weather>> getList() {
		try {
			Iterable<Weather> iter =  weatherService.list();
			return new ResponseEntity<>(iter, HttpStatus.OK);
		} catch(Exception ex) {
			String errorMessage;
			errorMessage = ex + " <== error";
			return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/weather")
	public ResponseEntity addWeather(@RequestBody Weather weather) {
		int id = weather.getId();
		if(!weatherService.getWeather(id)) {
			weatherService.save(weather);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/weather", params = "date")
	public Iterable<Weather> getWeatherByDate(@RequestParam("date") @DateTimeFormat(iso=ISO.DATE) LocalDate date) 
	{
		return weatherService.getWeatherDataByDate(date);
	}
	
	@DeleteMapping(value = "/erase")
	public ResponseEntity delete() {
		weatherService.delete();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
