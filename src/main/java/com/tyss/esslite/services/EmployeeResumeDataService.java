package com.tyss.esslite.services;

import com.tyss.esslite.dto.EmployeeResumeData;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;


/**
 *This is the Service Interface of Employee Resume Data. It is implemented by
 * EmployeeResumeDataServiceImpl class. This Interface contains methods to perform the particular 
 * services
 */
public interface EmployeeResumeDataService {

	
	/**
	 *This is GET method to the All Employee Resume data details page
	 * @throws EmployeeInsertNotFoundException 
	 * @Param employeeid = It is a ID of the employee 
	 */
	public EmployeeResumeData getEmployee(String employeeid) throws EmployeeInsertNotFoundException;

}
