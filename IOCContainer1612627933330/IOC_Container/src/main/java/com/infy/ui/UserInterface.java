package com.infy.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.infy.configuration.SpringConfig;
import com.infy.repository.EmployeeRepository;
import com.infy.service.EmployeeService;


public class UserInterface {
	public static final Log LOGGER = LogFactory.getLog(UserInterface.class); 

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		EmployeeService service = applicationContext.getBean(EmployeeService.class);
		LOGGER.info(service.getEmployeeDepartment());
		
		EmployeeRepository emp = applicationContext.getBean(EmployeeRepository.class);
		LOGGER.info(emp.getEmployeeStatus());
	}
}
