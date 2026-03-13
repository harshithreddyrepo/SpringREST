package com.telusko.TicketBookingWebApp.service;

import java.net.URI;
import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import com.telusko.TicketBookingWebApp.reqres.Passenger;
import com.telusko.TicketBookingWebApp.reqres.Ticket;

@Service
public class BookingTicketService implements IBookingTicketService {

	private String BOOKING_URL=
			"http://localhost:8484/TicketBookingApp/api/book-ticket/getTicketNumber";
	private String GET_URL="http://localhost:8484/TicketBookingApp/api/book-ticket/getTicket/{ticketNumber}";

	@Override
	public Ticket bookTicket(Passenger passenger) 
	{
//		RestTemplate restTemplate=new RestTemplate();
//		ResponseEntity<Ticket> responseEntity = restTemplate.postForEntity(BOOKING_URL, passenger, Ticket.class);
//		return responseEntity.getBody();
		
//		String str="Telusko";
//		str=str.toLowerCase();
//		str=str.concat(" Java");
//		str.length();
//		
//		str.toLowerCase().concat(" java").length();
		
	//	LocalDate date = LocalDate.now();
		
		//Get The WebClient
		WebClient webClient = WebClient.create();
		
	
		//send the request and process the response
		 Ticket ticket = webClient.post()
		 .uri(BOOKING_URL)
		 .bodyValue(passenger)
		 .retrieve()
		 .bodyToMono(Ticket.class)
		 .block();
		 
		 return ticket;
		
		
	}

	@Override
	public Ticket getFullTicketInfo(Integer ticketNumber) 
	{
//		RestTemplate restTemplate=new RestTemplate();
//
//		
//		Ticket ticket = restTemplate.getForObject(GET_URL, Ticket.class, ticketNumber);
//		return ticket;
		
		//get the WeBClient Object
		
		WebClient webClient = WebClient.create();
		
		Ticket ticket = webClient.get()
		.uri(GET_URL, ticketNumber)
		.retrieve()
		.bodyToMono(Ticket.class)
		.block();
		
		return ticket;
		
		
		
	}

}
