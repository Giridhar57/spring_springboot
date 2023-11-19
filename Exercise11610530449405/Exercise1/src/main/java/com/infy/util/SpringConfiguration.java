package com.infy.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infy.repository.EmployeeRepository;
import com.infy.repository.EmployeeRepositoryImpl;
import com.infy.service.EmployeeServiceImpl;

@Configuration
public class SpringConfiguration {
	@Bean
	public EmployeeRepositoryImpl employeeRepository() {
		return new EmployeeRepositoryImpl();
	}
	
	@Bean
	public EmployeeServiceImpl employeeService(EmployeeRepositoryImpl employeeRepository) {
		return new EmployeeServiceImpl(employeeRepository);
	}
	
	@Bean(name="employeeService")
	public EmployeeServiceImpl getEmployeeService(EmployeeRepositoryImpl employeeRepository) {
		return new EmployeeServiceImpl(employeeRepository);
	}
}
