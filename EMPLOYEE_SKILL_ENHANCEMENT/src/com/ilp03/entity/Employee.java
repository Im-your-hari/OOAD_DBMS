package com.ilp03.entity;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	
	private Skills skills;
	private Programs programs;
	private Records records;
	
	
	public Employee() {}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Skills getSkills() {
		return skills;
	}
	public void setSkills(Skills skills) {
		this.skills = skills;
	}
	public Programs getPrograms() {
		return programs;
	}
	public void setPrograms(Programs programs) {
		this.programs = programs;
	}
	public Records getRecords() {
		return records;
	}
	public void setRecords(Records records) {
		this.records = records;
	}
	
	
	
	
}
