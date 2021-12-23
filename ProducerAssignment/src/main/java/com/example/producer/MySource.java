package com.example.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource {
	String WEATHER = "weather";
	String ITSUPPORT = "itsupport";

	@Output(MySource.WEATHER)
	MessageChannel weather();
	

	@Output(MySource.ITSUPPORT)
	MessageChannel itSupport();
}
