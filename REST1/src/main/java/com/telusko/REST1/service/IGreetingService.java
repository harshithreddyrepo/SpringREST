package com.telusko.REST1.service;

import org.springframework.stereotype.Service;

import com.telusko.REST1.model.User;

@Service
public interface IGreetingService {

	String generateSomeWish();
	String registerUser(User user);
}
