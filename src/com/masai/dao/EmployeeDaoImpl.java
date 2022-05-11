package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.model.Employee;
import com.masai.utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public int getSalaryOfEmployee(int id) {
		
		int sal = -1;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select salary from employee where eid =?");
			
			ps.setInt(1, id);
			
		 	ResultSet rs = ps.executeQuery();
		 	
		 	if(rs.next())
		 	{
		 		sal = rs.getInt("salary");
		 	}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return sal;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> li = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				
				int id = set.getInt("eid");
				String name = set.getString("name");
				String address = set.getString("address");
				int salary = set.getInt("salary");
				
				Employee e = new Employee(id, name, address, salary);
				
				li.add(e);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return li;
	}

	@Override
	public String addBonus(int bonus) {
		
		String message = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update employee set salary=salary+?");
			
			ps.setInt(1, bonus);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "updated salaries of "+x+" employees with bonus "+bonus;
			}
	
		} catch (SQLException e) {
			
			message = e.getMessage();
			
		}
	
		return message;
	}

	@Override
	public String insertEmployee(int id,String name,int salary) {
		String message = "Not added...!";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = 
					conn.prepareStatement("insert into employee(eid,name,salary) values(?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, salary);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Employee added successfully...!";
			}
			
			
			
		} catch (SQLException e) {
			
			message = e.getMessage();
		}
		
		
		
		return message;
	}

	@Override
	public Employee getEmployeeDetails(int id) {
		
		Employee emp = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employee where eid = ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int eid = rs.getInt("eid");
				String name = rs.getString("name");
				String address = rs.getString("address");
				int salary = rs.getInt("salary");
		
				emp = new Employee(eid, name, address, salary);
		
			}
			else
			{
				emp = null;
			}
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmployeesWithsalaryAbove80000() {
		List<Employee> li = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =
					conn.prepareStatement("select * from employee where salary>80000");
			
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				
				int id = set.getInt("eid");
				String name = set.getString("name");
				String address = set.getString("address");
				int salary = set.getInt("salary");
				
				Employee e = new Employee(id, name, address, salary);
				
				li.add(e);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return li;
	}

}
