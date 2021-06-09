package com.techboss.cassandra.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techboss.cassandra.dto.EmployeeDto;
import com.techboss.cassandra.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private EmployeeService employeeService;

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public Collection<EmployeeDto> findAll(){
		return employeeService.findAll();
	}
	
	@PostMapping
	public String createEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.createEmployee(employeeDto);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteEmployee(@PathVariable("id") String id){
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping
	public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.updateEmployee(employeeDto);
	}
	
	@GetMapping("/name/{query}")
	public Collection<EmployeeDto> findByName(@PathVariable("query") String name) {
		return employeeService.findByName(name);
	}
}
