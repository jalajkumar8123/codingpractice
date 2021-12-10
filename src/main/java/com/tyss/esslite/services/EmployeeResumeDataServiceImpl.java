package com.tyss.esslite.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.tyss.esslite.constants.EmployeeDataConstants.*;
import static com.tyss.esslite.constants.PersonalConstants.ERROR;

import com.tyss.esslite.dao.EmployeeResumeDataRepository;
import com.tyss.esslite.dto.EmployeeResumeData;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;

/**
 *This is a Servic Implementation class for EmployeeData[Resume].
 * Here you find GET method for the EmployeeData.
 */
@Service
public class EmployeeResumeDataServiceImpl implements EmployeeResumeDataService {
	
	Logger logger = LoggerFactory.getLogger(EmployeeResumeDataServiceImpl.class);
	
	private EmployeeResumeDataRepository repo;
	
	/**
	* This enables automatic dependency injection of
	* EmployeeResumeDataServiceImpl class This service calls the
	* EmployeeResumeDataRepository methods from EmployeeResumeDataRepository with the help of its
	* object repo.
	*/
	
	@Autowired
	public EmployeeResumeDataServiceImpl(EmployeeResumeDataRepository repo) {
		this.repo =  repo;
	}
	
	public EmployeeResumeDataServiceImpl() {
	}

	/**
	 * This is GET method to the EmployeeData[Resume] page
	 * @return = It returns employeedata to the EmployeeResumeDataRepo interface
	 * @throws EmployeeInsertNotFoundException 
	 * @Param id = It is the employeeid
	 */
	@Override
	public EmployeeResumeData getEmployee(String employeeid) throws EmployeeInsertNotFoundException {
		EmployeeResumeData employee = null;
		try {
			Optional<EmployeeResumeData> result = repo.findById(employeeid);
			if (result.isPresent()) {
				employee = result.get();	
			}
		}catch(Exception e) {
			logger.error(ERROR);
			throw new EmployeeInsertNotFoundException(EMPLOYEE_DATA_SUCCESS_MESSAGE);
		}
		return employee;
	}
	
	

}
