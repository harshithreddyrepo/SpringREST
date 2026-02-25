package com.telusko.TicketBookingApp.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telusko.TicketBookingApp.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristErrorController {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleExceptionForTourist(TouristNotFoundException e){
		ErrorDetails error = new ErrorDetails("404 Not Found", e.getMessage(), LocalDateTime.now());
		 return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleExceptionGlobally(Exception e){
		ErrorDetails error = new ErrorDetails("404 Not Found", e.getMessage(), LocalDateTime.now());
		 return new ResponseEntity<> (error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
