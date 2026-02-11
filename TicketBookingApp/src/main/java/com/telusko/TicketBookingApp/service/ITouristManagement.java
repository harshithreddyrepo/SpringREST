package com.telusko.TicketBookingApp.service;

import java.util.List;

import com.telusko.TicketBookingApp.model.Tourist;

public interface ITouristManagement {

	String registerTourist(Tourist tourist);
	public List<Tourist> getTourists();
	 Tourist fetchTourist(Integer id);
}
