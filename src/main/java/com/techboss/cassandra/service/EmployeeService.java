package com.techboss.cassandra.service;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techboss.cassandra.dto.EmployeeDto;
import com.techboss.cassandra.entity.Employee;
import com.techboss.cassandra.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	private EmployeeRepository employeeRepository;
	
	private ModelMapper modelMapper;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
		this.employeeRepository = employeeRepository;
		this.modelMapper = modelMapper;
	}
	
	public String createEmployee(EmployeeDto employeeDto) {
		logger.info("Creating Employee {}", employeeDto);
		Employee employee = new Employee(employeeDto.getName(), employeeDto.getEmail(),
				employeeDto.getSalary());
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee.getId();
	}
	
	public Collection<EmployeeDto> findAll(){
		List<Employee> employees = employeeRepository.findAll();
		Type setType = new TypeToken<List<EmployeeDto>>(){}.getType();
		return modelMapper.map(employees, setType);
	}
	
	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeDto.getId());
		if(optionalEmployee.isPresent()){
			Employee newEmployee = modelMapper.map(employeeDto, Employee.class);
			employeeRepository.save(newEmployee);
			return employeeDto;
		}
		return null;
	}
	
	public boolean deleteEmployee(String id){
		logger.info("Deleting Employee with Id [{}]", id);
		employeeRepository.deleteById(id);
		return Boolean.TRUE;
	}
	
	public List<EmployeeDto> findByName(String name) {
		logger.info("Getting employees for [{}]", name);
		String query = "%"+name+"%";
		List<Employee> employees = employeeRepository.findByNameLikeIgnoreCase(query);
		Type setType = new TypeToken<List<EmployeeDto>>(){}.getType();
		return modelMapper.map(employees, setType);
	}

}
