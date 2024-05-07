package com.ilp03.utility;
import com.ilp03.service.*;

public class EmployeeUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EmployeeService employeeService = new EmployeeServiceImplement();
		
		employeeService.getAllEmployee();
	}

}
