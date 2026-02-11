package com.telusko.REST3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.REST3.model.Alien;

@RestController
@RequestMapping("/api")
public class AlienController {

	@GetMapping("/getResponse")
	public ResponseEntity<Alien> getAlien(){
		Alien alien=new Alien(702, "Harshith", "Warangal");
		ResponseEntity<Alien> responseEntity = new ResponseEntity<>(alien, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveAlien(@RequestBody Alien alien){
		String res="failed";
		if(alien!=null) {
			res="Data Stored Successfully";
		}
		ResponseEntity<String> responseEntity = new ResponseEntity<>(res, HttpStatus.OK);
		return responseEntity;
	}
}
