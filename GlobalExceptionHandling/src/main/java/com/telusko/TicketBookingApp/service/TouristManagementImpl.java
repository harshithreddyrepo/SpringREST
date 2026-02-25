package com.telusko.TicketBookingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.TicketBookingApp.dao.TouristRepo;
import com.telusko.TicketBookingApp.exception.TouristNotFoundException;
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
	
	public Tourist fetchTouristExcep(Integer id){
		Optional<Tourist> optional = repo.findById(id);
		return optional.orElseThrow(()->new TouristNotFoundException("Coustomer not found, invalid id"));
//		if(optional.isPresent()) {
//			return optional.get();
//		}
//		throw new TouristNotFoundException("Coustomer not found, invalid id");
	}
	

	@Override
	public List<Tourist> fetchByPackageType(String packageType) {
		List<Tourist> tourists = repo.findByPackageType(packageType);
		return tourists;
	}

	@Override
	public String uptadeTouristInfo(Tourist tourist) {
		
		Integer id=tourist.getId();
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.save(tourist);
			return "Tourist info with id "+id+" is updated";
		}
		throw new TouristNotFoundException("Tourist with given info is not found to update");
	}

	@Override
	public String updateTouristBudget(Integer id, Double budget) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			int rowsEffected = repo.updateTouristBudget(id, budget);
			return "Budget is updated to "+budget+" for the tourist with id "+id;
		}else {
			throw new TouristNotFoundException("Tourist with given info is not found to update");
		}
	}

	@Override
	public String removeTourist(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.deleteById(id);
			return "Tourist with the id "+id+" is deleted.";
		}else {
			throw new TouristNotFoundException("Tourist with the given id "+id+" not found to delete");
		}
	}
}
