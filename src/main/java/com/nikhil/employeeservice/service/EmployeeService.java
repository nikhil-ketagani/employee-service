package com.nikhil.employeeservice.service;

import com.nikhil.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
EmployeeDto saveEmployee(EmployeeDto employeeDto);
EmployeeDto getEmpoloyee(Long employeeId);
}
