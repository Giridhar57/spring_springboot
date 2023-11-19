package com.infy.service;

import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
	
	public EmployeeService() {
		System.out.println("Inside Service");
	}

	public String getEmployeeDepartment() {
		return "Employee Department: IT Support";
	}
}
