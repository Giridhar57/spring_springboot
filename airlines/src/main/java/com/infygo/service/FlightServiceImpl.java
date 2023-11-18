package com.infygo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infygo.beans.Flight;
import com.infygo.repository.FlightRepository;
import com.infygo.validation.Validator;


@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;

	@Override
	public void addNewFlight(Flight flight) throws Exception {
		try {
			Validator.validateFlight(flight);
			flightRepository.addFlight(flight);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteFlight(String flightId) throws Exception {
		boolean status=flightRepository.removeFlight(flightId);
		if(status==false){
			throw new Exception("Flight with given flightID:"+flightId+" not found");
		}
	}

	@Override
	public List<Flight> searchFlight(String source, String destination, LocalDate journeyDate) throws Exception {
		try {
			List<Flight> filteredFlights=new ArrayList<>();
			for(Flight flight:flightRepository.allFlights()) {
				if(flight.getSource().equals(source) && flight.getDestination().equals(destination) && flight.getJourneyDate().equals(journeyDate)) {
					if(journeyDate.getMonthValue()==12 || journeyDate.getMonthValue()==1) {
						flight.setFare(flight.getFare()+0.2*flight.getFare());
					}
					filteredFlights.add(flight);
				}
			}
			if(filteredFlights.isEmpty()) {
				throw new Exception("No Flights found for your given details!");
			}
			return filteredFlights;
		}catch(Exception e) {
			throw e;
		}
	}

}
