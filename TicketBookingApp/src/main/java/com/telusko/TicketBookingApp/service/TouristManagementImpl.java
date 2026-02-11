package com.telusko.TicketBookingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.TicketBookingApp.dao.TouristRepo;
import com.telusko.TicketBookingApp.model.Tourist;

@Service
public class TouristManagementImpl implements ITouristManagement {

	@Autowired
	private TouristRepo repo;
	
	public String registerTourist(Tourist tourist) {
		Integer id = repo.save(tourist).getId();
		return "Tourist info saved with an ID:"+id;
	}
	
	public List<Tourist> getTourists(){
		List<Tourist> tourists = repo.findAll();
		return tourists;
	}
	
	public Tourist fetchTourist(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
