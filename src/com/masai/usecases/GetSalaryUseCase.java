package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class GetSalaryUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID");
		
		int id = Integer.parseInt(sc.nextLine());
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		int salary = dao.getSalaryOfEmployee(id);
		
		if(salary != -1) {
			
			System.out.println("Salary of Employee with id "+ id + " is "+salary);
		}
		
		else
		{
			System.out.println("Invalid id Employee not found");
		}
	
		sc.close();
	}
	
}
