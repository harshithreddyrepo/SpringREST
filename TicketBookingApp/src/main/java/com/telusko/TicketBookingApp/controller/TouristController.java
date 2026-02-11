package com.telusko.TicketBookingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.TicketBookingApp.model.Tourist;
import com.telusko.TicketBookingApp.service.ITouristManagement;

@RestController
@RequestMapping("api")
public class TouristController {

	@Autowired
	private  ITouristManagement service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		String msg = service.registerTourist(tourist);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(msg, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getTouristList")
	public ResponseEntity<List<Tourist>> getTouristList(){
		List<Tourist> tourists = service.getTourists();
		tourists.stream().forEach((x)->System.out.println(x));
		ResponseEntity<List<Tourist>> responseEntity = new ResponseEntity<>(tourists, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/fetchTourist/{id}")
	public ResponseEntity<String> findTouristById(@PathVariable("id") Integer id){
		Tourist tourist = service.fetchTourist(id);
		
		if(tourist==null) {
			return new ResponseEntity<>("Tourist with the given id doesn't exist", HttpStatus.OK);
		}
		
		return new ResponseEntity<>(tourist.getName(), HttpStatus.OK);
	}
}
