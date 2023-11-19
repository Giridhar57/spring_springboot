package com.infy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.infy.dto.EmployeeDTO;
import com.infy.repository.EmployeeRepositoryImpl;
import com.infy.service.EmployeeServiceImpl;
import com.infy.util.SpringConfiguration;

public class Client 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        
        EmployeeServiceImpl service = (EmployeeServiceImpl) context.getBean("employeeService");
        EmployeeServiceImpl serviceNew = context.getBean(EmployeeServiceImpl.class);
        EmployeeRepositoryImpl employeeRepository=context.getBean(EmployeeRepositoryImpl.class);
        
        EmployeeDTO emp=new EmployeeDTO();
        emp.setEmpId(1);
        emp.setName("Abc Def");
        emp.setDepartment("Spring Boot");
        
        serviceNew.insert(emp);
        
        EmployeeDTO emp1=new EmployeeDTO();
        emp1.setEmpId(2);
        emp1.setName("Jakson");
        emp1.setDepartment("Core Java");
        
        serviceNew.insert(emp1);
        
        for(EmployeeDTO e:employeeRepository.fetchCustomer()) {
        	System.out.println(e.toString());
        }
        
        service.delete(1);
        
        for(EmployeeDTO e:employeeRepository.fetchCustomer()) {
        	System.out.println(e.toString());
        }
        service.viewEmployee(2);
        context.close();
        
    }
}
