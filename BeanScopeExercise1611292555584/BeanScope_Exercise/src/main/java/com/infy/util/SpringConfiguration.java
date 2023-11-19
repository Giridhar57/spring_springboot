package com.infy.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.infy.repository.EmployeeRepositoryImpl;
import com.infy.service.EmployeeServiceImpl;

@Configuration
public class SpringConfiguration {
	@Bean
	@Scope("prototype")
	public EmployeeServiceImpl employeeServiceImpl() {
		return new EmployeeServiceImpl();
	}
	
	@Bean
	@Scope("singleton")
	public EmployeeRepositoryImpl employeeRepository() {
		return new EmployeeRepositoryImpl();
	}
	
}
