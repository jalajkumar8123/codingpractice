package com.tyss.esslite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.esslite.dto.EmployeeRegistration;

public interface EmployeeRegistrationRepository extends JpaRepository<EmployeeRegistration, String>{
	
	EmployeeRegistration findByEmail(String email);
	
	
	EmployeeRegistration findByEmployeeId(String employeeId);

}
