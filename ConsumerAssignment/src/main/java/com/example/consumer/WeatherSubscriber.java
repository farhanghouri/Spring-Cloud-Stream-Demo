package com.example.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MySink.class)
public class WeatherSubscriber {

	@StreamListener(MySink.WEATHER)
	public void weatherHandler(Weather weather) {
		System.out.println(weather);
	}
}
