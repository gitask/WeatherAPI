package com.gita.weatherapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gita.weatherapi.service.WeatherService;
import com.gita.weatherapi.model.Location;
import com.gita.weatherapi.model.Weather;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class WeatherapiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WeatherapiApplication.class, args);
		WeatherService weatherService = context.getBean(WeatherService.class);
		
		Location loc = new Location(38.6175, -82.3415, "Fremont", "California");
		Float[] temp = {(float) 37.3,
				(float)30.8,
				(float)36.4,
				(float)36.0,
				(float)35.6,
				(float)35.3,
				(float)35.0,
				(float)34.9,
				(float)35.8,
				(float)38.0,
				(float)40.2,
				(float)42.3,
				(float)43.8,
				(float)44.9,
				(float)45.5,
				(float)45.7,
				(float)44.9,
				(float)43.0,
				(float)41.7,
				(float)40.8,
				(float)39.9,
				(float)39.2,
				(float)38.6,
				(float)38.1};
		LocalDate date = LocalDate.parse("2020-01-01");
		Weather weather = new Weather();
		weather.setId(5);
		weather.setDate(date);
		weather.setLocation(loc);
		weather.setTemparature(temp);
		
		weatherService.save(weather);
	}
	
	@Bean
	CommandLineRunner runner(WeatherService weatherService) {
		return args -> {
			//read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			TypeReference<List<Weather>> typeReference = new TypeReference<List<Weather>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/weatherData.json");
			try {
				List<Weather> weatherList = mapper.readValue(inputStream, typeReference);
				weatherService.save(weatherList);
				System.out.println("Weather data saved!");
			} catch(IOException e) {
				System.out.println("Unable to save weather data: " + e.getMessage());
			}
			
		};
	}

}
