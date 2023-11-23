package com.kgisl.gfs.pplm.sample.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.gfs.pplm.sample.dto.EmployeeDto;
import com.kgisl.gfs.pplm.sample.exception.BadRequestException;
import com.kgisl.gfs.pplm.sample.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public Map<String, Object> createEmployeeDetails(@RequestBody EmployeeDto employeeDto) throws BadRequestException {
		Map<String, Object> response = service.createEmployeeDetails(employeeDto);
		return response;
	}
	
	@RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
	public Map<String, Object> updateEmployeeDetails(@PathVariable("id") Long employeeId, 
			                                                                            @RequestBody EmployeeDto employeeDto) 
			                                                                             throws BadRequestException {
		Map<String, Object> response = service.updateEmployeeDetails(employeeId, employeeDto);
		return response;
	}
	
	@RequestMapping(path = "/getall", method = RequestMethod.GET,  produces = "application/json")
	public List<EmployeeDto> getAllEmployeeDetails() {
		List<EmployeeDto> employeeDtoList = service.getAllEmployeeList();
		return employeeDtoList;
	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE,  produces = "application/json")
	public Map<String, Object> deleteEmployeeDetails(@PathVariable("id") Long employeeId) {
		Map<String, Object> response = service.deleteByEmployeeId(employeeId);
		return response;
	}
	
	
}
