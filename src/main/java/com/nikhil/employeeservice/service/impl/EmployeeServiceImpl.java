package com.nikhil.employeeservice.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.nikhil.employeeservice.dto.ApiResponseDto;
import com.nikhil.employeeservice.dto.DepartmentDto;
import com.nikhil.employeeservice.dto.EmployeeDto;
import com.nikhil.employeeservice.entity.Employee;
import com.nikhil.employeeservice.execption.ResourceNotFoundException;
import com.nikhil.employeeservice.mapper.EmployeeMapper;
import com.nikhil.employeeservice.repository.EmployeeRepository;
import com.nikhil.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
EmployeeRepository employeeRepository;
RestTemplate restTemplate;
ModelMapper modelMapper;
WebClient webClient;
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
	public ApiResponseDto getEmpoloyee(Long employeeId) {
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		
		Employee employee = employeeOptional.orElseThrow(()->  new ResourceNotFoundException("Employee","employeeId", employeeId));
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
		DepartmentDto departmentDto=null;
		if(employeeDto.getDepartmentCode()!=null) {
		//use RestTemplate to call department service
//		ResponseEntity<DepartmentDto> response = restTemplate.getForEntity("http://localhost:8080/v1/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
//		 departmentDto = response.getBody();
		//use webclient to call department service
		 departmentDto = webClient.get().uri("http://localhost:8080/v1/departments/"+employee.getDepartmentCode())
		.retrieve()
		.bodyToMono(DepartmentDto.class)
		.block();
			
		}
		ApiResponseDto apiResponseDto = ApiResponseDto.builder().departmentDto(departmentDto).employeeDto(employeeDto).build();
		
		return apiResponseDto;
	}

}
