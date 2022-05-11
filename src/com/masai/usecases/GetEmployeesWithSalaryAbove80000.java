package com.masai.usecases;

import java.util.List;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.model.Employee;

public class GetEmployeesWithSalaryAbove80000 {

	public static void main(String[] args) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		
		List<Employee> list = dao.getAllEmployeesWithsalaryAbove80000();
		
		
		if(!list.isEmpty()) {
		for (Employee employee : list) {
			
			System.out.println("Employee Id : "+employee.getId());
			System.out.println("Employee name : "+employee.getName());
			System.out.println("Employee address : "+employee.getAddress());
			System.out.println("Employee salary : "+employee.getSalary());
			
			
			System.out.println("===========================================");
			
		}
		}
		else
		{
			System.out.println("No employees found");
		}
		
	}
		
	}
	

