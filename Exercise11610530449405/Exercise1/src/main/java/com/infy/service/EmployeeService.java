package com.infy.service;

import com.infy.dto.EmployeeDTO;

public interface EmployeeService {

	public void insert(EmployeeDTO employee);
	
	public void delete(int empId);
	
	public void viewEmployee(int id);

}