package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.dto.EmployeeDTO;
import com.infy.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl() {
	}
	
//  setter injection	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	public void insert(EmployeeDTO employee) {
		employeeRepository.insertEmployee(employee);
	}

	public void delete(int empId) {
		employeeRepository.removeEmployee(empId);
	}
	
	public List<EmployeeDTO> getAllCustomer() {
		return employeeRepository.fetchCustomer();
	}
	
	public EmployeeDTO getEmployeeDTO(int empId) {
		return employeeRepository.getEmployee(empId);
	}

}
