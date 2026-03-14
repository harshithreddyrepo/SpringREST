package com.telusko.REST1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.REST1.model.User;
import com.telusko.REST1.service.IGreetingService;

//@Controller
@RestController
//@RequestMapping("/api")
public class GreetingController {
	
	@Autowired
	IGreetingService service;

	@GetMapping("/greet")
	//@ResponseBody
	public ResponseEntity<String> generateGreetings() {
		
		String wish = service.generateSomeWish();
		
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(wish, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		// Logic to persist  the user in the database (optional)
		// The actual purpose is to figure out how to send the Request Body during the API testing.
		String msg=service.registerUser(user);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(msg, HttpStatus.CREATED);
		return responseEntity;
	}
}
