package com.tyss.esslite.services;

import java.util.List;

import com.tyss.esslite.dto.EmployeeExperienceDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeDeleteNotFoundException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.EmployeeUpdateNotFoundException;

public interface EmployeeExperienceService {
	/**
	 * This is GET method to the Experience details page
	 * @throws EmployeeCustomException 
	 * @Param employeeid = It is a ID of the employee 
	 */
	
	public List<EmployeeExperienceDetails> getEmployee(String employeeid) throws EmployeeCustomException;

	/**
	 *This is POST method to the Experience details page
	 * @throws EmployeeInsertNotFoundException 
	 * @throws EmployeeCustomException 
	 * @Param details = It is a object of Experience details 
	 * @throws EmployeeDeleteNotFoundException
	 */
	
	public List<EmployeeExperienceDetails> saveEmployee(String employeeid, List<EmployeeExperienceDetails> info) throws EmployeeInsertNotFoundException, EmployeeCustomException;
	
	/**
	 * This is PUT method to the Experience details page
	 * 
	 * @Param details = It is a object of Experience details
	 * @throws EmployeeUpdateNotFoundException
	 * @throws EmployeeCustomException
	 */
	
	public List<EmployeeExperienceDetails> updateEmployee(String employeeid,List<EmployeeExperienceDetails> info) throws EmployeeUpdateNotFoundException, EmployeeCustomException;

	/**
	 *This is DELETE method to the Experience details page
	 * @throws EmployeeDeleteNotFoundException 
	 * @Param employeeid = It is a ID of the employee
	 * @throws EmployeeInsertNotFoundException
	 */
	
	public EmployeeExperienceDetails deleteEmployee(String employeeid, EmployeeExperienceDetails info) throws EmployeeDeleteNotFoundException;
	 
}
