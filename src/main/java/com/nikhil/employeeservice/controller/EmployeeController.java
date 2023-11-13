package com.nikhil.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.employeeservice.dto.ApiResponseDto;
import com.nikhil.employeeservice.dto.EmployeeDto;
import com.nikhil.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("v1/employees")
public class EmployeeController {
EmployeeService employeeService;
@PostMapping
public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
	EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
	return new ResponseEntity<EmployeeDto>(saveEmployee, HttpStatus.CREATED);
}

@GetMapping("{employeeId}")
public  ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("employeeId") Long employeeId) {
	ApiResponseDto apiResponseDto = employeeService.getEmpoloyee(employeeId);
	return new ResponseEntity<ApiResponseDto>(apiResponseDto,HttpStatus.OK);
}
}
