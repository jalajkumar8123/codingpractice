package com.tyss.esslite.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.tyss.esslite.constants.EducationConstants.*;
import static com.tyss.esslite.constants.PersonalConstants.*;

import com.tyss.esslite.dto.EmployeeEducationalDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeDeleteNotFoundException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.EmployeeUpdateNotFoundException;
import com.tyss.esslite.responses.EssportalEducationSingleResponse;
import com.tyss.esslite.responses.EssportalEducationalResponse;
import com.tyss.esslite.services.EmployeeEducationalService;

/**
 * This is a controller class for Education Page. Here you find GET, POST, PUT
 * and DELETE controllers for the Education Page.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
@Validated
public class EmployeeEducationalDetailsController {

	Logger logger = LoggerFactory.getLogger(EmployeeEducationalDetailsController.class);
	
	/**
	 * This enables automatic dependency injection of EmployeeEducationalService
	 * class This service object is used by every method in the Educational
	 * controller to call the Service methods.
	 */
	@Autowired
	private EmployeeEducationalService employeeEducationalService;

	/**
	 * This is GET controller for Education details. The EmployeeEducationService
	 * class helps calling the method from "EmployeeEducationRepository", if it gets
	 * succeeded it returns the data else throws Bad_Request as output.
	 *
	 * @Param employeeid = ID of the employee
	 * @return = It returns the message whether successfully getting the record or
	 *         the record is not getting
	 * @throws EmployeeCustomException
	 * 
	 */

	@GetMapping("esslite/employee-education")
	public ResponseEntity<EssportalEducationalResponse> findEmployee(String employeeid) throws EmployeeCustomException {
		List<EmployeeEducationalDetails> educationalDetailList = employeeEducationalService.getEmployee(employeeid);
	
		logger.debug(DEBUG);
		
		if (!educationalDetailList.isEmpty()) {
			return new ResponseEntity<>(
					new EssportalEducationalResponse(false, EDUCATION_SUCCESS_MESSAGE, educationalDetailList),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EssportalEducationalResponse(true, EDUCATION_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * This is POST controller for Education details. The EmployeeEducationService
	 * class helps calling the method from "EmployeeEducationRepository", if it gets
	 * succeeded it returns the data else throws Bad_Request as output.
	 * 
	 * @Param employeeid = ID of the employee.
	 * @Param info = It is a object of Educational details.
	 * @return = It returns the message whether successfully inserting the record or
	 *         the record is not inserted.
	 * @throws EmployeeInsertNotFoundException
	 * @throws EmployeeCustomException
	 */

	@PostMapping("esslite/employee-education")
	public ResponseEntity<EssportalEducationalResponse> saveEmployee(String employeeid,
			@Valid @RequestBody List<EmployeeEducationalDetails> info)
			throws EmployeeInsertNotFoundException, EmployeeCustomException {
		List<EmployeeEducationalDetails> savedDetailsList = employeeEducationalService.saveEmployee(employeeid, info);
		
		logger.debug(DEBUG);
		
		if (!savedDetailsList.isEmpty()) {
			return new ResponseEntity<>(
					new EssportalEducationalResponse(false, EDUCATION_UPDATE_SUCCESS_MESSAGE, savedDetailsList),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EssportalEducationalResponse(true, EDUCATION_UPDATE_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This is PUT controller for Education details. The EmployeeEducationService
	 * class helps calling the method from "EmployeeEducationRepository", if it gets
	 * succeeded it returns the data else throws Bad_Request as output.
	 * 
	 * @Param employeeid = ID of the employee.
	 * @Param info = It is a object of Educational details.
	 * @return = It returns the message whether successfully updating the record or
	 *         the record is not updated.
	 * @throws EmployeeUpdateNotFoundException
	 * @throws EmployeeCustomException
	 */

	@PutMapping("esslite/employee-education")
	public ResponseEntity<EssportalEducationalResponse> updateEmployee(String employeeId,
			@Valid @RequestBody List<EmployeeEducationalDetails> info)
			throws EmployeeUpdateNotFoundException, EmployeeCustomException {
		List<EmployeeEducationalDetails> updatedDetailsList = employeeEducationalService.updateEmployee(employeeId,
				info);
		
		logger.debug(DEBUG);
		
		if (!updatedDetailsList.isEmpty()) {
			return new ResponseEntity<>(
					new EssportalEducationalResponse(false, EDUCATION_UPDATE_SUCCESS_MESSAGE, updatedDetailsList),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					new EssportalEducationalResponse(true, EDUCATION_UPDATE_FAIL_MESSAGE, updatedDetailsList),
					HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * This is DELETE controller for Education details. The EmployeeEducationService
	 * class helps calling the method from "EmployeeEducationRepository", if it gets
	 * succeeded it returns the data else throws Bad_Request as output.
	 * 
	 * @Param employeeid = It is a ID of the employee
	 * @Param info = It is a object of Educational details.
	 * @return = It returns the message whether successfully deleting the record or
	 *         the record is not deleted
	 * @throws EmployeeDeleteNotFoundException
	 */

	@DeleteMapping("esslite/employee-education")
	public ResponseEntity<EssportalEducationSingleResponse> deleteEmployee(String employeeId,
			@Valid @RequestBody EmployeeEducationalDetails info) throws EmployeeDeleteNotFoundException {
		info.setEmployeeId(employeeId);
		EmployeeEducationalDetails details = employeeEducationalService.deleteEmployee(employeeId, info);
		
		logger.debug(DEBUG);
		
		if (details != null) {
			return new ResponseEntity<>(
					new EssportalEducationSingleResponse(false, EDUCATION_DELETE_SUCCESS_MESSAGE, details),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EssportalEducationSingleResponse(true, EDUCATION_DELETE_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}
	}

}
