package com.nikhil.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nikhil.employeeservice.dto.DepartmentDto;

@FeignClient(url="http://localhost:8080", value ="Department-Service")
public interface ApiClient {
@GetMapping("v1/departments/{department-code}")
DepartmentDto getDepartment(@PathVariable("department-code")String departmentCode);
}
