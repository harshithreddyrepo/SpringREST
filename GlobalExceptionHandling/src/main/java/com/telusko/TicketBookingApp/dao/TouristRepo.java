package com.telusko.TicketBookingApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telusko.TicketBookingApp.model.Tourist;

@Repository
public interface TouristRepo extends JpaRepository<Tourist, Integer> {

	public List<Tourist> findByPackageType(String packageType);
	
	@Query("Update Tourist Set budget= :budget where id= :id ")
	public int updateTouristBudget(@Param("id") Integer id, @Param("budget") Double budget);
}
