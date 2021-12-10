package com.tyss.esslite.services;

import java.util.List;

import com.tyss.esslite.dto.TechnologyDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;

/**
 * This is the Service Interface of Technology page. It is implemented by
 * EmployeeStackSkillServiceImpl class. This Interface contains methods to perform the particular 
 * services
 */
public interface EmployeeTechnologyService {
	

	
	
	public List<TechnologyDetails> saveTechnology(String employeeId, List<TechnologyDetails> info) throws EmployeeCustomException;
	
	public List<TechnologyDetails> getTechnologies(String employeeid) throws EmployeeInsertNotFoundException;
	
	
	
	
	
	
	
	
	
	
	
	
	
}
