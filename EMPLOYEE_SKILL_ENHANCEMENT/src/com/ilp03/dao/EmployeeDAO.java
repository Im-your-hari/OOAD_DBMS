package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp03.entity.*;
import com.ilp03.entity.Employee;

public class EmployeeDAO {

	
	public static Connection getConnection()
	{
		String connectionString ="jdbc:mysql://localhost:3306/empskillenhancement?useSSL=false";
		String username="root";
		String password="Hari@2002";
		Connection connection=null;
		
		try {
			connection =DriverManager.getConnection(connectionString,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Employee> getAllEmployee(Connection connection)
		
		{
			Statement statement;
			ArrayList<Employee> employeeList=new ArrayList<Employee>();
			try {
				
				statement  = connection.createStatement();			 
	        	 ResultSet resultSet = statement.executeQuery("select * from employee");
				while(resultSet.next())
				{
				int id =resultSet.getInt(1);
				String firstName =resultSet.getString(2);
				String lastName =resultSet.getString(3);
				//String Address =resultSet.getString(4);
				//long phNumber =resultSet.getLong(5);
				
				//Customer customer=new Customer(id,customerFirstName,customerLastName,Address,phNumber);
			    
				Employee employee = new Employee();
				
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				
				employeeList.add(employee);
				}
			}
				
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return employeeList;
				
		}

	//Ivide rand function kodukkanam..
	public static ArrayList<Employee> getAllCompletedEmployee(Connection connection,String skillName)
	
	{
		Statement statement;
		ArrayList<Employee> employeeList=new ArrayList<Employee>();
		try {
			
			statement  = connection.createStatement();			 
			
			
			
			PreparedStatement ps = connection.prepareStatement("select employee.first_name,employee.last_name,skills.skill_name,emp_training_records.completion_date,training_programs.end_date from employee inner join emp_training_records on employee.employee_id=emp_training_records.emp_id inner join training_programs on emp_training_records.program_id=training_programs.program_id inner join skills on training_programs.skill_id=skills.skill_id where skills.skill_name=? and emp_training_records.completion_date<=training_programs.end_date;");
        	ps.setString(1, skillName); 
			
			//ResultSet resultSet = statement.executeQuery("select * from employee");
        	ResultSet resultSet = ps.executeQuery();
			
        	while(resultSet.next())
			{
			//int id =resultSet.getInt(1);
			String firstName =resultSet.getString(1);
			String lastName =resultSet.getString(2);
			String skill = resultSet.getString(3);
			String completionDate = resultSet.getString(4);
			String endDate = resultSet.getString(5);
			//String Address =resultSet.getString(4);
			//long phNumber =resultSet.getLong(5);
			
			//Customer customer=new Customer(id,customerFirstName,customerLastName,Address,phNumber);
		    
			Employee employee = new Employee();
			Skills skills = new Skills();
			Records records = new Records();
			Programs programs = new Programs();
			
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			skills.setSkillName(skill);
			records.setCompletionDate(completionDate);
			programs.setEndDate(endDate);
			
			
			employee.setSkills(skills);
			employee.setRecords(records);
			employee.setPrograms(programs);
			
			employeeList.add(employee);
			}
		}
			
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return employeeList;
			
	}


public static ArrayList<Employee> getAllNotCompletedEmployee(Connection connection,String skillName)
	
	{
		Statement statement;
		ArrayList<Employee> employeeList=new ArrayList<Employee>();
		try {
			
			statement  = connection.createStatement();			 
			
			
			
			PreparedStatement ps = connection.prepareStatement("select employee.first_name,employee.last_name,skills.skill_name,emp_training_records.completion_date,training_programs.end_date from employee inner join emp_training_records on employee.employee_id=emp_training_records.emp_id inner join training_programs on emp_training_records.program_id=training_programs.program_id inner join skills on training_programs.skill_id=skills.skill_id where skills.skill_name=? and emp_training_records.completion_date>training_programs.end_date;");
        	ps.setString(1, skillName); 
			
			//ResultSet resultSet = statement.executeQuery("select * from employee");
        	ResultSet resultSet = ps.executeQuery();
			
        	while(resultSet.next())
			{
			//int id =resultSet.getInt(1);
			String firstName =resultSet.getString(1);
			String lastName =resultSet.getString(2);
			String skill = resultSet.getString(3);
			String completionDate = resultSet.getString(4);
			String endDate = resultSet.getString(5);
			//String Address =resultSet.getString(4);
			//long phNumber =resultSet.getLong(5);
			
			//Customer customer=new Customer(id,customerFirstName,customerLastName,Address,phNumber);
		    
			Employee employee = new Employee();
			Skills skills = new Skills();
			Records records = new Records();
			Programs programs = new Programs();
			
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			skills.setSkillName(skill);
			records.setCompletionDate(completionDate);
			programs.setEndDate(endDate);
			
			
			employee.setSkills(skills);
			employee.setRecords(records);
			employee.setPrograms(programs);
			
			employeeList.add(employee);
			}
		}
			
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return employeeList;
			
	}
	
// Veruthee...........
public static ArrayList<Skills> getAllSkills(Connection connection)

{
	Statement statement;
	ArrayList<Skills> skillList=new ArrayList<Skills>();
	try {
		
		statement  = connection.createStatement();			 
    	 ResultSet resultSet = statement.executeQuery("select skill_name from skills");
		while(resultSet.next())
		{
		//int id =resultSet.getInt(1);
		String skillName =resultSet.getString(1);
		//String lastName =resultSet.getString(3);
		//String Address =resultSet.getString(4);
		//long phNumber =resultSet.getLong(5);
		
		//Customer customer=new Customer(id,customerFirstName,customerLastName,Address,phNumber);
	    
		Skills skill = new Skills();
		
		skill.setSkillName(skillName);
		
		skillList.add(skill);
		}
	}
		
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return skillList;
		
}
	

//select employee.first_name,employee.last_name,skills.skill_name,emp_training_records.completion_date,training_programs.end_date from employee inner join emp_training_records on employee.employee_id=emp_training_records.emp_id inner join training_programs on emp_training_records.program_id=training_programs.program_id inner join skills on training_programs.skill_id=skills.skill_id where skills.skill_name="sql";

public static ArrayList<Employee> getAllEmployeePrograms(Connection connection,String skillName)
	
	{
		Statement statement;
		ArrayList<Employee> programList=new ArrayList<Employee>();
		try {
			
			statement  = connection.createStatement();			 
			
			
			
			PreparedStatement ps = connection.prepareStatement("select employee.first_name,employee.last_name,skills.skill_name,emp_training_records.completion_date,training_programs.end_date from employee inner join emp_training_records on employee.employee_id=emp_training_records.emp_id inner join training_programs on emp_training_records.program_id=training_programs.program_id inner join skills on training_programs.skill_id=skills.skill_id where skills.skill_name=? ;");
        	ps.setString(1, skillName); 
			
			//ResultSet resultSet = statement.executeQuery("select * from employee");
        	ResultSet resultSet = ps.executeQuery();
			
        	while(resultSet.next())
			{
			//int id =resultSet.getInt(1);
			String firstName =resultSet.getString(1);
			String lastName =resultSet.getString(2);
			String skill = resultSet.getString(3);
			String completionDate = resultSet.getString(4);
			String endDate = resultSet.getString(5);
			//String Address =resultSet.getString(4);
			//long phNumber =resultSet.getLong(5);
			
			//Customer customer=new Customer(id,customerFirstName,customerLastName,Address,phNumber);
		    
			Employee employee = new Employee();
			Skills skills = new Skills();
			Records records = new Records();
			Programs programs = new Programs();
			
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			skills.setSkillName(skill);
			records.setCompletionDate(completionDate);
			programs.setEndDate(endDate);
			
			
			employee.setSkills(skills);
			employee.setRecords(records);
			employee.setPrograms(programs);
			
			programList.add(employee);
			}
		}
			
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return programList;
			
	}


	
}
