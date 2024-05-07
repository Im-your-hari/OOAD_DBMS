package com.ilp03.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.dao.*;
import com.ilp03.entity.*;

public class EmployeeServiceImplement implements EmployeeService {
	
	
	public void displayDetails(ArrayList<Employee> employeeList) {
		System.out.println("\n-------------------------------------------------------------------------------");
		System.out.printf("%12s | %12s | %15s | %15s | %12s |","FirstName","LastName","Program(Skill)","CompletionDate","EndDate");
		System.out.println("\n-------------------------------------------------------------------------------");			
		for(Employee employee :employeeList)
		{
			System.out.printf("%12s | %12s | %15s | %15s | %12s |",employee.getFirstName(),employee.getLastName(),employee.getSkills().getSkillName(),employee.getRecords().getCompletionDate(),employee.getPrograms().getEndDate());
			System.out.println();
			//Display cheyyendath kodukkuka..
			
			
			//System.out.println(employee.getId()+" "+employee.getCustomerFirstName()+" "+employee.getCustomerLastname()+" "+employee.getAddress()+" "+customer.getPhnumber());
		}
		System.out.println("--------------------------------------------------------------------------------");
	}

	@Override
	public void getAllEmployee() {
		// TODO Auto-generated method stub
		try {
			
			Connection connection = EmployeeDAO.getConnection();
			Scanner scanner = new Scanner(System.in);
			ArrayList<Employee> employeeList = null;
			ArrayList<Skills> skillList = null;
			
			char option ='y';
			
			//Ivde option kodukkanam...
			
			do {
				System.out.println("-------------------------MENU-------------------------");
				System.out.println("[1].Employee completed training programs on time.");
				System.out.println("[2].Employee not completed training programs on time.");
				System.out.println("------------------------------------------------------");
				
				System.out.print("Enter choice ::");
				int choice = scanner.nextInt();
				scanner.nextLine();
				//Skills display cheyynm..
				skillList = EmployeeDAO.getAllSkills(connection);
				System.out.println("------------------");
				System.out.println("Programs Available");
				System.out.println("------------------");
				for(Skills skill:skillList) {
					System.out.println(skill.getSkillName());
				}
				System.out.println("------------------");
				
				System.out.print("Enter Skill name :: ");
				String skillName = scanner.nextLine();
				
				switch(choice) {
				
				case 1 : employeeList = EmployeeDAO.getAllCompletedEmployee(connection, skillName);
							displayDetails(employeeList);
						break;
				
				case 2 : employeeList=EmployeeDAO.getAllNotCompletedEmployee(connection, skillName);
							displayDetails(employeeList);
						break;
				
				default : System.out.print("Invalid choice..");
				
				}
				
				
				System.out.println("Do you want to continue?(y/n)");
				option = scanner.next().charAt(0);
			}while(option=='y');
			
//			System.out.println("-------------------------MENU-------------------------");
//			System.out.println("[1].Employee completed training programs on time.");
//			System.out.println("[2].Employee not completed training programs on time.");
//			System.out.println("------------------------------------------------------");
//			
//			System.out.print("Enter choice ::");
//			int choice = scanner.nextInt();
//			scanner.nextLine();
//			System.out.print("Enter Skill name :: ");
//			String skillName = scanner.nextLine();
//			
//			switch(choice) {
//			
//			case 1 : employeeList = EmployeeDAO.getAllCompletedEmployee(connection, skillName);
//						displayDetails(employeeList);
//					break;
//			
//			case 2 : employeeList=EmployeeDAO.getAllNotCompletedEmployee(connection, skillName);
//						displayDetails(employeeList);
//					break;
//			
//			default : System.out.print("Invalid choice..");
//			
//			}
//			
			
			//_____________________________________________________________________________
			//ArrayList<Employee> employeeList = EmployeeDAO.getAllCompletedEmployee(connection, skillName);
			
			//ArrayList<Employee> employeeList=EmployeeDAO.getAllNotCompletedEmployee(connection, "javascript");
			
			
			//________________________________________________________________________________
			System.out.println("------------------------------------------------------------");
			System.out.println("FirstName\tLastName\tProgram(Skill)\tCompletionDate\tEndDate");
			System.out.println("------------------------------------------------------------");			
			for(Employee employee :employeeList)
			{
				System.out.println(employee.getFirstName()+"\t\t"+employee.getLastName()+"\t "+employee.getSkills().getSkillName()+"\t "+employee.getRecords().getCompletionDate()+"\t "+employee.getPrograms().getEndDate());
				//Display cheyyendath kodukkuka..
				
				
				//System.out.println(employee.getId()+" "+employee.getCustomerFirstName()+" "+employee.getCustomerLastname()+" "+employee.getAddress()+" "+customer.getPhnumber());
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
