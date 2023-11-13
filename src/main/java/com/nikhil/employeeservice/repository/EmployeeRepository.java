package com.nikhil.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.employeeservice.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee,Long>{

}
