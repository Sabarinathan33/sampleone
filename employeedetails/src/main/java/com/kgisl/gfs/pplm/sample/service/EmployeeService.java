package com.kgisl.gfs.pplm.sample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.gfs.pplm.sample.dto.EmployeeDto;
import com.kgisl.gfs.pplm.sample.exception.BadRequestException;
import com.kgisl.gfs.pplm.sample.model.Employee;
import com.kgisl.gfs.pplm.sample.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public Map<String, Object> createEmployeeDetails(EmployeeDto employeeDto) throws BadRequestException {
		Map<String, Object> output = new HashMap<>();
		Employee employee = new Employee();
		String firstName = employeeDto.getFirstName();
		String email = employeeDto.getEmail();
		Optional<Employee> employeeOptional = repository.findByFirstNameAndEmail(firstName, email);
		Optional<Employee> findByEmail = repository.findByEmail(email);
		if(employeeOptional.isPresent()) {
			throw new BadRequestException( "Employee Details with First Name: " + firstName + " and Email ID: " 
		                                                                                                                 + email + " already exists... ");
		}
		if(findByEmail.isPresent())
			throw new BadRequestException("Email Id is already present in another Employee Detail...");
		employee = createUpdateEmployeeDetails(employee, employeeDto);
		output.put("Status", "Successfully Created...");
		output.put("Employee Id", employee.getId());
		return output;
	}

	private Employee createUpdateEmployeeDetails(Employee employee, EmployeeDto employeeDto) {
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setMobile(employeeDto.getMobile());
		employee.setSalary(employeeDto.getSalary());
		employee = repository.save(employee);
		return employee;
	}

	public List<EmployeeDto> getAllEmployeeList() {
		List<EmployeeDto> employeeDtoList = repository.findAll().stream().map(EmployeeDto::new)
				                                                                                                                  .collect(Collectors.toList());
		return employeeDtoList;
	}

	public Map<String, Object> updateEmployeeDetails(Long employeeId, EmployeeDto employeeDto) throws BadRequestException {
		Map<String, Object> output = new HashMap<>();
		Optional<Employee> employeeOptional = repository.findById(employeeId);
		if(!employeeOptional.isPresent()) {
			throw new BadRequestException("Employee with Employee Id: " + employeeId + " is not found....");
		} 
		Optional<Employee> empOptional = repository.findByIdNotAndFirstNameAndEmail(employeeId, employeeDto.getFirstName(), 
					                                                                                                  employeeDto.getEmail());
		if(empOptional.isPresent()) {
				throw new BadRequestException("First Name and Email Id is found in another Employee Detail. Please give the correct details.");
		}
		Optional<Employee> findByEmail = repository.findByEmailAndIdNot(employeeDto.getEmail(), employeeId);
		if(findByEmail.isPresent())
			throw new BadRequestException("Email Id is already present in another Employee Detail...");
		Employee employee = employeeOptional.get();
		employee = createUpdateEmployeeDetails(employee, employeeDto);
		
		output.put("Status", "Successfully Updated...");
		output.put("Employee Id", employee.getId());
		return output;
	}

	public Map<String, Object> deleteByEmployeeId(Long employeeId) {
		Map<String, Object> output = new HashMap<>();
		repository.deleteById(employeeId);
		output.put("Status", "Successfully deleted the Employee Id: " + employeeId);
		return output;
	}
	
	

}
