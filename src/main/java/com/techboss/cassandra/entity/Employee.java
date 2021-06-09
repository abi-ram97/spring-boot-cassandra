package com.techboss.cassandra.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.SASI;
import org.springframework.data.cassandra.core.mapping.SASI.IndexMode;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Employee {
	@PrimaryKey
	private String id;
	
	@SASI(indexMode = IndexMode.CONTAINS)
	@SASI.NonTokenizingAnalyzed(caseSensitive = false)
	private String name;
	
	private String email;
	
	private double salary;
	
	public Employee() {}
	
	public Employee(String name, String email, double salary) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.salary = salary;
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

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}
	
}
