package com.example.producer;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@EnableBinding(MySource.class)
public class TicketPublisher {
	@Autowired
	private MySource source;

	@Scheduled(fixedDelay = 5000)
	public void publishTicketData() {
		Ticket ticket = buildTicket();
		this.source.itSupport().send(
				MessageBuilder.withPayload(ticket)
//				.setHeader("partitionKey", ticket.getType()) // uncomment for q3
				.build()
				);
	}
	
	private static final String[] title = new String[] {
            "Internet is not working", "Laptop is not working"
            };
	private static final String[] type = new String[] {
            "InternetIssue", "LaptopIssue"
            };
	
	private Ticket buildTicket() {
		Ticket ticket = new Ticket();
		ticket.setNo("IT-"+new Random().nextInt(100));
		ticket.setStatus("ready");
		
		int nextInt = new Random().nextInt(title.length);
		ticket.setTitle(title[nextInt]);
		ticket.setType(type[nextInt]);
		
		return ticket;
	}
}
