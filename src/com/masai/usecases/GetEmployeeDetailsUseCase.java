package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.model.Employee;

public class GetEmployeeDetailsUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID");
		
		int id = Integer.parseInt(sc.nextLine());
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		Employee emp = dao.getEmployeeDetails(id);
		
		if(emp != null) {
		System.out.println("Employee Name: "+emp.getName());
		System.out.println("Employee Address: "+emp.getAddress());
		System.out.println("Employee Salary: "+emp.getSalary());
		
		}
		else
		{
			System.out.println("Invalid employee Id");
		}
		
		sc.close();
	}
	
	
}
