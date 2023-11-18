package com.infygo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.infygo.beans.Flight;


public interface FlightService {
	public void addNewFlight(Flight flight) throws Exception;
	public void deleteFlight(String flightId) throws Exception;
	public List<Flight> searchFlight(String source,String destination,LocalDate journeyDate) throws Exception;
}
