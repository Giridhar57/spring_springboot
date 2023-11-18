package com.infygo.beans;

import java.time.LocalDate;

public class Flight {
	private static int count=1000;
	private String flightId;
    private String airlines;
    private String source;
    private String destination;
    private Double fare;
    private LocalDate journeyDate;
    private Integer seatCount;
    
    public Flight(){
    	count+=1;
    	setFlightId(String.valueOf(count));
    }
    
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	public Integer getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}
	
	public String toString() {
		return "The "+airlines+"("+flightId+") flight flying from "+source+" to "+destination+" on "+journeyDate+" which cost Rs."+fare;
	}
}
