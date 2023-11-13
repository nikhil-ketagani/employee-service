package com.nikhil.employeeservice.service;

import com.nikhil.employeeservice.dto.ApiResponseDto;
import com.nikhil.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
EmployeeDto saveEmployee(EmployeeDto employeeDto);
ApiResponseDto getEmpoloyee(Long employeeId);
}
