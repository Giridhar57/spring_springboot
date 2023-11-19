package com.infy.service;

import com.infy.dto.EmployeeDTO;
import com.infy.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	public void insert(EmployeeDTO employee) {
		employeeRepository.insertEmployee(employee);
		System.out.println("Employee: "+employee.getEmpId()+" added successfully");
	}

	public void delete(int empId) {
		employeeRepository.removeEmployee(empId);
		System.out.println("Employee: "+empId+" deleted successfully");
	}
	public void viewEmployee(int id) {
		System.out.println(employeeRepository.viewEmployee(id));
	}

}
