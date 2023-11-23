package com.kgisl.gfs.pplm.sample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.gfs.pplm.sample.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Optional<Employee> findByFirstNameAndEmail(String firstName, String email);

	Optional<Employee> findByIdNotAndFirstNameAndEmail(Long employeeId, String firstName, String email);

	Optional<Employee> findByEmail(String email);

	Optional<Employee> findByEmailAndIdNot(String email, Long employeeId);
	
}
