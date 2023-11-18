package com.infygo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infygo.beans.Flight;

@Repository
public class FlightRepositoryImpl implements FlightRepository{
	
	private List<Flight> flights=new ArrayList<>();
	
	public void addFlight(Flight flight){
		flights.add(flight);
	}

	@Override
	public Boolean removeFlight(String flightId) {
		for(Flight flight:flights) {
		if(flight.getFlightId().equals(flightId)) {
			flights.remove(flight);
			return true;
		}
	}
	return false;
	}

	@Override
	public List<Flight> allFlights() {
		return flights;
	}
}
