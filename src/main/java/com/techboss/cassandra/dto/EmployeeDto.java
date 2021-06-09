package com.techboss.cassandra.dto;

public class EmployeeDto {
	private String id;
	private String name;
	private String email;
	private double salary;
	
	public EmployeeDto() {}
	
	public EmployeeDto(String id, String name, String email, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDto [name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}
	
}
