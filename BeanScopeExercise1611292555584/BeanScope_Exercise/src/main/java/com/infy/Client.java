package com.infy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.infy.dto.EmployeeDTO;
import com.infy.repository.EmployeeRepositoryImpl;
import com.infy.service.EmployeeService;
import com.infy.service.EmployeeServiceImpl;
import com.infy.util.SpringConfiguration;

public class Client 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
    	EmployeeServiceImpl e1=context.getBean(EmployeeServiceImpl.class);
//    	e1.setEmployeeRepository(context.getBean(EmployeeRepositoryImpl.class));
    	EmployeeServiceImpl e2=context.getBean(EmployeeServiceImpl.class);
//    	e2.setEmployeeRepository(context.getBean(EmployeeRepositoryImpl.class));
    	EmployeeRepositoryImpl c1=context.getBean(EmployeeRepositoryImpl.class);
    	EmployeeRepositoryImpl c2=context.getBean(EmployeeRepositoryImpl.class);
    	System.out.println(c1.hashCode());
    	System.out.println(c2.hashCode());
    	
    }
}
