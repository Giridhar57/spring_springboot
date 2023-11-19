package com.infy.repository;

import java.util.List;

import com.infy.dto.EmployeeDTO;

public interface EmployeeRepository {
	public void insertEmployee(EmployeeDTO emp) ;
	public void removeEmployee(int id) ;
	public List<EmployeeDTO> fetchCustomer();
	public EmployeeDTO viewEmployee(int id);
}
