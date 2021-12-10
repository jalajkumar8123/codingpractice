package com.tyss.esslite.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.esslite.dto.EmployeePersonalDetails;


/**
* This is a Achievement Repository which extends JpaRepository
* to get the built in methods of Jpa Repository.
*/
public interface EmployeeRepository extends JpaRepository<EmployeePersonalDetails, String>{
	
	@Transactional
	@Query("select e from EmployeePersonalDetails e where e.employeeId=?1")
	EmployeePersonalDetails findByEmployeeID(String employeeId);
	

}
