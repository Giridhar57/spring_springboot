package com.infy.repository;

import java.util.ArrayList;
import java.util.List;

import com.infy.dto.EmployeeDTO;

public class EmployeeRepositoryImpl implements EmployeeRepository{
	private List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
	public void insertEmployee(EmployeeDTO emp) {
		list.add(emp);
	}
	public void removeEmployee(int id) {
		EmployeeDTO emp=null;
		for(EmployeeDTO e:list) {
			if(e.getEmpId()==id) {
				emp=e;
			}
		}
		list.remove(emp);
	}
	public List<EmployeeDTO> fetchCustomer(){
		return list;
	}
	public EmployeeDTO viewEmployee(int id) {
		EmployeeDTO emp=null;
		for(EmployeeDTO e:list) {
			if(e.getEmpId()==id) {
				emp=e;
			}
		}
		return emp;
	}
}
