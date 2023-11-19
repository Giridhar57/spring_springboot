package com.infy.repository;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {
	
	public EmployeeRepository() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside Repository");
	}
	
	public String getEmployeeStatus() {
		return "Employee Confirmed";
	}
}
