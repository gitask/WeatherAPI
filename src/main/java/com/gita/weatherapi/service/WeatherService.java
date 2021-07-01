package com.gita.weatherapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gita.weatherapi.model.Weather;
import com.gita.weatherapi.repository.WeatherRepository;

@Service
public class WeatherService {
	@Autowired
	private WeatherRepository weatherRepository;	

	public WeatherService(WeatherRepository weatherRepository) {
		this.weatherRepository = weatherRepository;
	}

	public Weather save(Weather weather) {
		return weatherRepository.save(weather);
	}
	
	public Iterable<Weather> save(List<Weather> weather) {
		return weatherRepository.saveAll(weather);
	}

	public Iterable<Weather> list() {	
		return weatherRepository.findAllByOrderByIdAsc();
	}
	
	public boolean getWeather(int id) {
		Weather weather = weatherRepository.findById(id);
		if(weather != null) 
			return true;
		else
			return false;
	}
	
	public Iterable<Weather> getWeatherDataByDate(LocalDate date) {
		return weatherRepository.findByDate(date);
	}
	
	public void delete() {
		weatherRepository.deleteAll();
	}

}
