package com.kgisl.gfs.pplm.sample.dto;

import com.kgisl.gfs.pplm.sample.model.Employee;

public class EmployeeDto {
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private Long salary;
	
	public EmployeeDto() {
	}

	public EmployeeDto(Employee employee) {
		this.employeeId = employee.getId();
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
		this.mobile = employee.getMobile();
		this.salary = employee.getSalary();
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public Long getSalary() {
		return salary;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
}
