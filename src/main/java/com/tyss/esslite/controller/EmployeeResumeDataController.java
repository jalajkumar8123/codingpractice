package com.tyss.esslite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.esslite.dto.EmployeeResumeData;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.responses.EmployeeDataResponse;
import com.tyss.esslite.services.EmployeeResumeDataService;
import static com.tyss.esslite.constants.EmployeeDataConstants.*;
import static com.tyss.esslite.constants.PersonalConstants.DEBUG;

/**
 * This is a controller class for EmployeeResumeData . Here you find GET
 * controller for the Resume page. Here you can find the URL path for GET all
 * the pages details.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class EmployeeResumeDataController {

	Logger logger = LoggerFactory.getLogger(EmployeeResumeDataController.class);
	
	/**
	 * This enables automatic dependency injection of EmployeeResumeDataService
	 * class This service object is used by GET method in the Employee Resume Data
	 * controller to call the EmployeeResumeDataRepository class.
	 * 
	 */
	@Autowired
	private EmployeeResumeDataService employeeResumeDataService;

	/**
	 * This is GET controller for Employee Data[Resume] page. The
	 * EmployeeDataService class helps calling the method from DAO Implementation of
	 * "EmployeeDataDaoImpl".
	 * 
	 * @Param employeeId = ID of the employee
	 * @return = It returns the message whether successfully getting the record or
	 *         the record is not getting
	 * @throws EmployeeInsertNotFoundException
	 */
	@GetMapping("esslite/employee-resume-data")
	public ResponseEntity<EmployeeDataResponse> findEmployee(String employeeid) throws EmployeeInsertNotFoundException {
		EmployeeResumeData resumeData = employeeResumeDataService.getEmployee(employeeid);

		logger.debug(DEBUG);
		
		if (resumeData != null) {
			return new ResponseEntity<>(new EmployeeDataResponse(false, EMPLOYEE_DATA_SUCCESS_MESSAGE, resumeData),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EmployeeDataResponse(true, EMPLOYEE_DATA_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}

	}

}
