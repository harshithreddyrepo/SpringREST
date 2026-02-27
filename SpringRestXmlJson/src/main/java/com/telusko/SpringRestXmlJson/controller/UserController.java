package com.telusko.SpringRestXmlJson.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SpringRestXmlJson.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping(value="/addUser", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> addUserInfo( @RequestBody User user){
		String msg = user.getFirstName()+ " has been added into the records";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getUser", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public User getUserInfo() {
		User user=new User();
		user.setFirstName("Varun");
		user.setEmail("Varun@Gmail.com");
		return user;
	}
}
