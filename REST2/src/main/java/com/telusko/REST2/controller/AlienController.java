package com.telusko.REST2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.REST2.controller.model.Alien;

@RestController
@RequestMapping("/api2")
public class AlienController {

	@GetMapping("/getAlien")
	public Alien getResponse() {
		Alien alien = new Alien(101, "Rest", "Web Services");
		return alien;
	}
}
