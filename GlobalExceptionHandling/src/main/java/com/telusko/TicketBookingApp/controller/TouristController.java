package com.telusko.TicketBookingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<?> findTouristByIdExcep(@PathVariable("id") Integer id){
		
			Tourist tourist = service.fetchTouristExcep(id);
			return new ResponseEntity<>(tourist, HttpStatus.OK);
		
	}
	
	@GetMapping("/fetchClinetsByPackageType/{packageType}")
	public ResponseEntity<List<Tourist>> findTouristsBypackageType( @PathVariable String packageType){
		List<Tourist> tourists = service.fetchByPackageType(packageType);
		return new ResponseEntity<>(tourists, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTouristInfo(@RequestBody Tourist tourist){
		
			service.uptadeTouristInfo(tourist);
			return new ResponseEntity<>("Tourist info updated successfully", HttpStatus.OK);
		
	}
	
	@PatchMapping("/updateBudget/{id}/{budget}")
	public ResponseEntity<String> updateBudget(@PathVariable("id")Integer id, @PathVariable("budget") Double budget){
		
			String msg = service.updateTouristBudget(id, budget);
			return new ResponseEntity<>(msg, HttpStatus.OK);
		
		
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTourist( @PathVariable("id") Integer id){
		
			String msg = service.removeTourist(id);
			return new ResponseEntity<>(msg, HttpStatus.OK);
		
	}
	
	
}
