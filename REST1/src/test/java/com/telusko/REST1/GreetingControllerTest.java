package com.telusko.REST1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import com.telusko.REST1.controller.GreetingController;
import com.telusko.REST1.model.User;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.telusko.REST1.service.IGreetingService;

import tools.jackson.databind.ObjectMapper;

@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

	@MockitoBean
	private IGreetingService service;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	@Disabled
	public void testGenerateGreetingsUnit() throws Exception {
		
		//Mocking
		Mockito.when(service.generateSomeWish()).thenReturn("Good Night");
		
		//Request Object
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet");
		
		ResultActions result = mockMvc.perform(requestBuilder);
		
		MvcResult mvcResult = result.andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		
		int status = response.getStatus();
		
		Assertions.assertEquals(200, status);
		
	}
	
	@Test
	public void testUserRegistrartion() throws Exception {
		
		// Mocking
		Mockito.when(service.registerUser(ArgumentMatchers.any())).thenReturn("User registered with id xxxx");
		
		// Java object to Json
		User user = new User(101, "Arjun", "Hyderabad");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(user);
		
		// Request Object
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register").contentType(MediaType.APPLICATION_JSON).content(json);
		ResultActions result = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = result.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		
		// Assertion
		int status=response.getStatus();
		Assertions.assertEquals(201, status);
	}
}
