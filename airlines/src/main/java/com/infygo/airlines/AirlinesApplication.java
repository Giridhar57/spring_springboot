package com.infygo.airlines;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import com.infygo.beans.Flight;
import com.infygo.repository.FlightRepository;
import com.infygo.service.FlightService;

@SpringBootApplication
@ComponentScan(basePackages = "com.infygo")
public class AirlinesApplication implements CommandLineRunner{

	@Autowired
	private FlightService flightService;
	
	@Autowired
	Environment environment;
	
	
	private static final Log LOGGER=LogFactory.getLog( AirlinesApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AirlinesApplication.class, args);
	}
	
	private Scanner sc=new Scanner(System.in);
	@Override
    public void run(String... args) throws Exception {
		System.out.println("\nWelcome to Airlines Management System");
		int choice;
		while(true) {
			System.out.println("What action would you like to perform?");
			System.out.println("1. Add a new Flight\n2. Serach Flight\n3.Delete a Flight Data from the Repository\n0. Quit");
			System.out.print("Enter your Choice: ");
			choice=sc.nextInt();
			if(choice==0) {
				break;
			}else if(choice==1) {
				addFlight();
			}else if(choice==2) {
				viewMyFlights();
			}else if(choice==3) {
				deleteFlight();
			}else {
				System.out.print("Invalid choice, Choose a new value:");
				choice=sc.nextInt();
			}
		}
		System.out.println("Thank you!");
    }
	
	private void deleteFlight() {
		System.out.print("Enter the flightId you want to delete: ");
		int id=sc.nextInt();
		try {
			flightService.deleteFlight(Integer.toString(id));
			LOGGER.info("Flight Data with flightId:("+id+") Deleted Successfully");
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
	}
	private void viewMyFlights() {
		System.out.print("Enter the Source: ");
		String source=sc.next();
		
		System.out.print("Enter the Destination: ");
		String destination=sc.next();
		
		System.out.print("Enter the Date of Journey in this format(DD-MM-YYYY): ");
		String[] s=sc.next().split("-");
	    int year=Integer.valueOf(s[2]);
	    int month=Integer.valueOf(s[1]);
	    int day=Integer.valueOf(s[0]);
		LocalDate journeyDate=LocalDate.of(year,month,day);
		try {
			List<Flight> res=flightService.searchFlight(source,destination,journeyDate);
			for(Flight flight:res) {
				LOGGER.info(flight+". Remaining Seats:"+flight.getSeatCount());
			}
		}catch(Exception e){
			LOGGER.error(e);
		}
	}
	private void addFlight() {
        
        try {
        	Flight flight = new Flight();

            System.out.print("Airlines: ");
            flight.setAirlines(sc.next());

            System.out.print("Source: ");
            flight.setSource(sc.next());

            System.out.print("Destination: ");
            flight.setDestination(sc.next());

            System.out.print("Fare: ");
            flight.setFare(Double.parseDouble(sc.next()));

            System.out.print("Journey Date (YYYY-MM-DD): ");
            String dateInput = sc.next();
            LocalDate journeyDate = LocalDate.parse(dateInput);
            flight.setJourneyDate(journeyDate);

            System.out.print("Seat Count: ");
            flight.setSeatCount(Integer.parseInt(sc.next()));
        	flightService.addNewFlight(flight);
        	LOGGER.info("New Flight "+flight.getAirlines()+"("+flight.getFlightId() +") added Successfully!!");
        }catch(Exception e){
        	LOGGER.error(environment.getProperty("FLIGHT-ADDING-FAILURE")+" "+e.getMessage());
        }
	}
}
