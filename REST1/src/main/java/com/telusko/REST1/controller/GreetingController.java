package com.telusko.REST1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
