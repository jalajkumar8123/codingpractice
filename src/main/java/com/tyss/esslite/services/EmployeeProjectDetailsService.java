package com.tyss.esslite.services;

import java.util.List;

import com.tyss.esslite.dto.EmployeeProjectDetails;
import com.tyss.esslite.exception.EmployeeCustomException;

/**
 *This is the Service Interface of Educational Page. It is implemented by
 * EmployeeProjectDetailsServiceImpl class. This Interface contains methods to perform the particular 
 * services
 */

public interface EmployeeProjectDetailsService {

	public List<EmployeeProjectDetails> getProjectDetails(String employeeId) throws EmployeeCustomException;
	
	public List<EmployeeProjectDetails> saveProjectDetails(List<EmployeeProjectDetails> projectDetails, String employeeId) throws EmployeeCustomException;
}