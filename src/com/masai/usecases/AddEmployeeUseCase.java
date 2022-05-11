package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class AddEmployeeUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee ID");
		
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Employee name");
		
		String name = sc.nextLine();
		
		System.out.println("Enter Employee salary");
		
		int salary = Integer.parseInt(sc.nextLine());
		
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		System.out.println(dao.insertEmployee(id, name, salary));
		
		sc.close();
	}
	
}
