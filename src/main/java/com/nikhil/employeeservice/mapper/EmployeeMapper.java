package com.nikhil.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nikhil.employeeservice.dto.EmployeeDto;
import com.nikhil.employeeservice.entity.Employee;



@Mapper
public interface EmployeeMapper {
	EmployeeMapper MAPPER=Mappers.getMapper(EmployeeMapper.class);
	Employee mapToEmployee(EmployeeDto employeeDto);
	EmployeeDto maptoEmployeeDto(Employee employee);
}
