package com.masai.dao;

import java.util.List;

import com.masai.model.Employee;

public interface EmployeeDao {
	
	public int getSalaryOfEmployee(int id);
	public List<Employee> getAllEmployees();
	public String addBonus(int bonus);
	public String insertEmployee(int id,String name,int salary);
	public Employee getEmployeeDetails(int id);
	public List<Employee> getAllEmployeesWithsalaryAbove80000();
	

}
