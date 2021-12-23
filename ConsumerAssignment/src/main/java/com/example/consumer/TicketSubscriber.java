package com.example.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

@EnableBinding(MySink.class)
public class TicketSubscriber {
	
	int engineerID = 1;
	
	@StreamListener(MySink.ITSUPPORT)
	public void ticketHandler(Ticket ticket, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
		System.out.println(ticket + " " + "Partion: " + partition + " Engineer: " + engineerID);
		
		///////////////////
		// Inserting ticket details in db with status 'processed'
		//////////////////
		
//		ticket.setStatus("processed");
//		DBService.insert(ticket, engineerID);
		
		////////////////////////////////////
	}
}
