package com.telusko.REST1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.telusko.REST1.controller.GreetingController;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.telusko.REST1.service.IGreetingService;

@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

	@MockitoBean
	private IGreetingService service;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
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
}
