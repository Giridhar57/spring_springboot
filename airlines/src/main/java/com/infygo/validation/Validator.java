package com.infygo.validation;


import java.time.LocalDate;

import com.infygo.beans.Flight;

public class Validator {
	public static void validateFlight(Flight flight) throws Exception {
		String res=validate(flight);
		if(res!="") {
			throw new Exception(res);
		}
	}
	
	public static String validate(Flight flight) {
		if(flight.getAirlines().isEmpty()) {
			return "Empty value given for Flight Name";
		}
		if(flight.getSource().isEmpty()) {
			return "Empty value given for source";
		}
		if(flight.getDestination().isEmpty()) {
			return "Empty value given for destination";
		}
		if(flight.getFare()<=0) {
			return "Fare should not be Zero and Less!";
		}
		if(flight.getSeatCount()<=0) {
			return "Seat Count should be greater than Zero";
		}
		if(flight.getJourneyDate().isBefore(LocalDate.now())) {
			return "Journey Date should by today or Afterwards only but previous date was given";
		}
		return "";
	}
}
