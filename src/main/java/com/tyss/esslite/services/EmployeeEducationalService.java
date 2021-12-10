package com.tyss.esslite.services;

/**
 *This is the Service Interface of Educational Page. It is implemented by
 * EmployeeEducationalServiceImpl class. This Interface contains methods to perform the particular 
 * services
 */

import java.util.List;

import javax.validation.Valid;

import com.tyss.esslite.dto.EmployeeEducationalDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeDeleteNotFoundException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.EmployeeUpdateNotFoundException;

public interface EmployeeEducationalService {

	/**
	 * This is GET method to the Education details page
	 * 
	 * @throws EmployeeCustomException
	 * @Param employeeid = It is a ID of the employee
	 */

	public List<EmployeeEducationalDetails> getEmployee(String employeeid) throws EmployeeCustomException;

	/**
	 * This is POST method to the Education details page
	 * 
	 * @throws EmployeeInsertNotFoundException
	 * @throws EmployeeCustomException
	 * @Param details = It is a object of Education details
	 * @throws EmployeeDeleteNotFoundException
	 */

	public List<EmployeeEducationalDetails> saveEmployee(String employeeid, List<EmployeeEducationalDetails> info)
			throws EmployeeInsertNotFoundException, EmployeeCustomException;

	/**
	 * This is PUT method to the Education details page
	 * 
	 * @Param details = It is a object of Education details
	 * @throws EmployeeUpdateNotFoundException
	 * @throws EmployeeCustomException 
	 */

	public List<EmployeeEducationalDetails> updateEmployee(String employeeid, @Valid List<EmployeeEducationalDetails> info)
			throws EmployeeUpdateNotFoundException, EmployeeCustomException;

	/**
	 * This is DELETE method to the Education details page
	 * 
	 * @throws EmployeeDeleteNotFoundException
	 * @Param employeeid = It is a ID of the employee
	 * @throws EmployeeInsertNotFoundException
	 */

	public EmployeeEducationalDetails deleteEmployee(String employeeid, EmployeeEducationalDetails info)
			throws EmployeeDeleteNotFoundException;

}
