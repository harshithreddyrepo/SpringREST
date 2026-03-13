package com.telusko.TicketBookingApp.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.TicketBookingApp.model.Passenger;
import com.telusko.TicketBookingApp.model.Ticket;
import com.telusko.TicketBookingApp.service.ITicketBookingService;

@RestController
@RequestMapping("api/book-ticket")
public class TicketBookingRestController 
{
	@Autowired
	private ITicketBookingService service;
	
	@PostMapping("/getTicketNumber")
	public ResponseEntity<Ticket> registerPassenger(@RequestBody Passenger passenger)
	{
		Passenger pass=service.registerPassenger(passenger);
		Ticket ticket=new Ticket();
		ticket.setTicketNumber(pass.getPid());
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
	
	@GetMapping("/getTicket/{ticketNumber}")
	public ResponseEntity<Ticket> getMyFullTicket(@PathVariable("ticketNumber")Integer ticketNumber)
	{
		Ticket ticket=new Ticket();
		
		Passenger passenger=service.fetchPassengerInfo(ticketNumber);
		
		ticket.setStatus("Confirmed");
		ticket.setTicketCost(45454.4);
		ticket.setName(passenger.getName());
		ticket.setDeparture(passenger.getDeparture());
		ticket.setArrival(passenger.getArrival());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setTicketNumber(passenger.getPid());
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

}
