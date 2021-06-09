package com.techboss.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.techboss.cassandra.entity.Employee;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, String> {
	List<Employee> findByNameLikeIgnoreCase(String name);
}
