package com.telusko.TicketBookingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.TicketBookingApp.model.Tourist;

@Repository
public interface TouristRepo extends JpaRepository<Tourist, Integer> {

}
