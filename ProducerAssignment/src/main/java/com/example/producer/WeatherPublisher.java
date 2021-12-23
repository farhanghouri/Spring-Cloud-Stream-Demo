package com.example.producer;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@EnableBinding(MySource.class)
public class WeatherPublisher {

	@Autowired
	private MySource source;

	@Scheduled(fixedDelay = 5000)
	public void publishWeatherData() {
		this.source.weather().send(
				MessageBuilder.withPayload(buildWeather())
				.build()
				);
	}
	
	private static final String[] temp = new String[] {
            "18c", "20c", "6c"
            };
	private static final String[] wind = new String[] {
            "14km/h", "16km/h", "11km/h"
            };
	private static final String[] humi = new String[] {
            "53%", "40%", "50%"
            };
	
	private Weather buildWeather() {
		Weather weather = new Weather();
		weather.setTemperature( temp[new Random().nextInt(temp.length)]);
		weather.setWind( wind[new Random().nextInt(wind.length)]);
		weather.setHumidity( humi[new Random().nextInt(humi.length)]);
		
		return weather;
	}
}
