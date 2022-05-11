package com.masai.usecases;

import java.util.Iterator;
import java.util.List;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.model.Employee;

public class GetAllEmployeesUseCase {
	
	public static void main(String[] args) {
		
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		
		List<Employee> list = dao.getAllEmployees();
		
		
		
		for (Employee employee : list) {
			
			System.out.println("Employee Id : "+employee.getId());
			System.out.println("Employee name : "+employee.getName());
			System.out.println("Employee address : "+employee.getAddress());
			System.out.println("Employee salary : "+employee.getSalary());
			
			
			System.out.println("===========================================");
			
		}
		
		
	}
	
	
}
