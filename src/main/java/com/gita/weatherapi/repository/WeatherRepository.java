package com.gita.weatherapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gita.weatherapi.model.Weather;

public interface WeatherRepository extends CrudRepository<Weather, Integer>{
	
	Weather findById(int id);
	
	List<Weather> findAllByOrderByIdAsc();
	
	List<Weather> findByDate(LocalDate date);
}
