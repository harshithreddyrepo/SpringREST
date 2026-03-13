package com.telusko.REST1.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetingService{

	@Override
	public String generateSomeWish() {
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
		return wish;
	}

}
