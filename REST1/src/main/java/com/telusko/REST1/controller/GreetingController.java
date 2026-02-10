package com.telusko.REST1.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/api")
public class GreetingController {

	@GetMapping("/greet")
	//@ResponseBody
	public ResponseEntity<String> generateGreetings() {
		String wish=null;
		LocalDateTime now = LocalDateTime.now();
		int hr=now.getHour();
		if(hr<12) {
			wish="Good Morning";
		}else if(hr<16) {
			wish="Good Afternoon";
		}else if(hr<20) {
			wish="Good Evening";
		}else {
			wish="Good Night";
		}
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(wish, HttpStatus.OK);
		
		return responseEntity;
	}
}
