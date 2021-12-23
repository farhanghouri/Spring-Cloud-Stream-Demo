package com.example.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface MySink {
	String WEATHER = "weather";
	String ITSUPPORT = "itsupport";

	@Input(MySink.WEATHER)
	MessageChannel weather();
	

	@Input(MySink.ITSUPPORT)
	MessageChannel itSupport();
}
