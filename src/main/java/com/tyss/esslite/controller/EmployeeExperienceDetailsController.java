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
import static com.tyss.esslite.constants.ExperienceConstants.*;
import static com.tyss.esslite.constants.PersonalConstants.DEBUG;

import com.tyss.esslite.dto.EmployeeExperienceDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeDeleteNotFoundException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.EmployeeUpdateNotFoundException;
import com.tyss.esslite.responses.EssportalExperienceResponse;
import com.tyss.esslite.responses.EssportalExperienceSingleResponse;
import com.tyss.esslite.services.EmployeeExperienceService;

/**
 * This is a controller class for Experience Page. Here you find GET, POST, PUT
 * and DELETE controllers for the Experience Page.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
@Validated
public class EmployeeExperienceDetailsController {

	Logger logger = LoggerFactory.getLogger(EmployeeExperienceDetailsController.class);
	
	/**
	 * This enables automatic dependency injection of EmployeeEducationalService
	 * class This service object is used by every method in the Educational
	 * controller to call the Service methods.
	 */

	@Autowired
	private EmployeeExperienceService employeeExperienceService;

	/**
	 * This is GET controller for Experience details. The EmployeeExperienceService
	 * class helps calling the method from "EmployeeExperienceRepository", if it
	 * gets succeeded it returns the data else throws Bad_Request as output.
	 * 
	 * @Param employeeid = ID of the employee
	 * @return = It returns the message whether successfully getting the record or
	 *         the record is not getting
	 * @throws EmployeeCustomException
	 * 
	 */

	@GetMapping("esslite/employee-experience")
	public ResponseEntity<EssportalExperienceResponse> findEmployee(String employeeid) throws EmployeeCustomException {

		List<EmployeeExperienceDetails> experienceDetailsList = employeeExperienceService.getEmployee(employeeid);

		logger.debug(DEBUG);	
		
		if (!experienceDetailsList.isEmpty()) {
			return new ResponseEntity<>(
					new EssportalExperienceResponse(false, EXPERIENCE_SUCCESS_MESSAGE, experienceDetailsList),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					new EssportalExperienceResponse(true, EXPERIENCE_FAIL_MESSAGE, experienceDetailsList),
					HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * This is POST controller for Experience details. The EmployeeExperienceService
	 * class helps calling the method from "EmployeeExperienceRepository", if it
	 * gets succeeded it returns the data else throws Bad_Request as output.
	 * 
	 * @Param employeeid = ID of the employee.
	 * @Param info = It is a object of Educational details.
	 * @return = It returns the message whether successfully inserting the record or
	 *         the record is not inserted.
	 * @throws EmployeeInsertNotFoundException
	 * @throws EmployeeCustomException
	 */

	@PostMapping("esslite/employee-experience")
	public ResponseEntity<EssportalExperienceResponse> saveEmployee(String employeeid,
			@Valid @RequestBody List<EmployeeExperienceDetails> info)
			throws EmployeeInsertNotFoundException, EmployeeCustomException {
		List<EmployeeExperienceDetails> savedExperienceDetailsList = employeeExperienceService.saveEmployee(employeeid,
				info);
		
		logger.debug(DEBUG);;
		
		if (!savedExperienceDetailsList.isEmpty()) {
			return new ResponseEntity<>(new EssportalExperienceResponse(false, EXPERIENCE_INSERT_SUCCESS_MESSAGE,
					savedExperienceDetailsList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					new EssportalExperienceResponse(true, EXPERIENCE_INSERT_FAIL_MESSAGE, savedExperienceDetailsList),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This is PUT controller for Experience details. The EmployeeExperienceService
	 * class helps calling the method from "EmployeeExperienceRepository", if it
	 * gets succeeded it returns the data else throws Bad_Request as output.
	 * 
	 * @Param employeeid = ID of the employee.
	 * @Param info = It is a object of Educational details.
	 * @return = It returns the message whether successfully updating the record or
	 *         the record is not updated.
	 * @throws EmployeeUpdateNotFoundException
	 * @throws EmployeeCustomException
	 */

	@PutMapping("esslite/employee-experience")
	public ResponseEntity<EssportalExperienceResponse> updateEmployee(String employeeid,
			@Valid @RequestBody List<EmployeeExperienceDetails> info)
			throws EmployeeUpdateNotFoundException, EmployeeCustomException {
		List<EmployeeExperienceDetails> updatedExperienceDetailsList = employeeExperienceService
				.updateEmployee(employeeid, info);

		logger.debug(DEBUG);
		
		if (!updatedExperienceDetailsList.isEmpty()) {
			return new ResponseEntity<>(new EssportalExperienceResponse(false, EXPERIENCE_UPDATE_SUCCESS_MESSAGE,
					updatedExperienceDetailsList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					new EssportalExperienceResponse(true, EXPERIENCE_UPDATE_FAIL_MESSAGE, updatedExperienceDetailsList),
					HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * This is DELETE controller for Experience details. The
	 * EmployeeExperienceService class helps calling the method from
	 * "EmployeeExperienceRepository", if it gets succeeded it returns the data else
	 * throws Bad_Request as output.
	 * 
	 * @Param employeeid = It is a ID of the employee
	 * @Param info = It is a object of Educational details.
	 * @return = It returns the message whether successfully deleting the record or
	 *         the record is not deleted
	 * @throws EmployeeDeleteNotFoundException
	 */

	@DeleteMapping("esslite/employee-experience")
	public ResponseEntity<EssportalExperienceSingleResponse> deleteEmployee(String employeeid,
			@Valid @RequestBody EmployeeExperienceDetails info) throws EmployeeDeleteNotFoundException {
		EmployeeExperienceDetails deletedExperience = employeeExperienceService.deleteEmployee(employeeid, info);
		
		logger.debug(DEBUG);
		
		if (deletedExperience != null) {
			return new ResponseEntity<>(
					new EssportalExperienceSingleResponse(false, EXPERIENCE_DELETE_SUCCESS_MESSAGE, deletedExperience),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					new EssportalExperienceSingleResponse(true, EXPERIENCE_DELETE_FAIL_MESSAGE, deletedExperience),
					HttpStatus.BAD_REQUEST);
		}
	}

}
