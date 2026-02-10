package com.telusko.REST2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {
	
	@GetMapping("/welcome/{name}")
	public String greet2(@PathVariable(value="name", required=false)String name) {
		String greet="Hello! "+name+" welcome back to learn SpringREST";
		return greet;
	}

	@GetMapping("/welcome")
	public String greet1(@RequestParam(value="name", required=false, defaultValue="Developer")String name) {
		String greet="Hello! "+name+" welcome back to learn SpringREST";
		return greet;
	}
	
}
