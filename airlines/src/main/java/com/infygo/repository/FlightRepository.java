package com.infygo.repository;

import java.util.List;

import com.infygo.beans.Flight;

public interface FlightRepository {
	public void addFlight(Flight flight);
	public Boolean removeFlight(String flightId);
	public List<Flight> allFlights();
}
