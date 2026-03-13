package com.telusko.TicketBookingWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import com.telusko.TicketBookingWebApp.reqres.Ticket;

@SpringBootApplication
public class TicketBookingWebAppApplication {
	
	private static String GET_URL="http://localhost:8484/TicketBookingApp/api/book-ticket/getTicket/{ticketNumber}";


	public static void main(String[] args) {
		SpringApplication.run(TicketBookingWebAppApplication.class, args);
		System.out.println("Request to API Started......");
     WebClient webClient = WebClient.create();
		
		webClient.get()
		.uri(GET_URL, 4444)
		.retrieve()
		.bodyToMono(String.class).subscribe(TicketBookingWebAppApplication::handleResponse);
		//.block();
		
	//	System.out.println(ticket);
		System.out.println("Request to API ended....");
	}
	
	public static void handleResponse(String ticket)
	{
		System.out.println(ticket);
	}

}
