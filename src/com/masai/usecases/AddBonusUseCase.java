package com.masai.usecases;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class AddBonusUseCase {
	
	public static void main(String[] args) {
		
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		String s = dao.addBonus(500);
		
		System.out.println(s);
		
	}
	
}
