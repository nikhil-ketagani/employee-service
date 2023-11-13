package com.nikhil.employeeservice.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.nikhil.employeeservice.dto.EmployeeDto;
import com.nikhil.employeeservice.entity.Employee;
import com.nikhil.employeeservice.mapper.EmployeeMapper;
import com.nikhil.employeeservice.repository.EmployeeRepository;
import com.nikhil.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
EmployeeRepository employeeRepository;
ModelMapper modelMapper;
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		//convert Employee DTO to Employee JPA entity
//				Employee Employee = new Employee(
//						employeeDto.getId(),
//						employeeDto.getFirstName(),
//						employeeDto.getLastName(),
//						employeeDto.getEmail()
//						);
		//use mapstruct library
//		Employee Employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
	    //use Modelmapper library
		Employee employee = modelMapper.map(employeeDto, Employee.class);
				//save Employee JPA entity into database
				Employee savedEmployee = employeeRepository.save(employee);
				
				//convert saved JPA entity back to DTO
//				EmployeeDto savedEmployeeDto = new EmployeeDto(
//						savedEmployee.getId(),
//						savedEmployee.getFirstName(),
//						savedEmployee.getLastName(),
//						savedEmployee.getEmail()
//						);
				//use mapstruct library
//				EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.maptoEmployeeDto(savedEmployee);
				//use Modelmapper library
				EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
				return savedEmployeeDto;
	}
	@Override
	public EmployeeDto getEmpoloyee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		//convert saved JPA entity back to DTO
//		EmployeeDto employeeDto = new EmployeeDto(
//				employee.getId(),
//				employee.getFirstName(),
//				employee.getLastName(),
//				employee.getEmail()
//				);
		//use mapstruct library
//		EmployeeDto employeeDto = EmployeeMapper.MAPPER.maptoEmployeeDto(employee);
		//use Modelmapper library
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		return employeeDto;
	}

}
