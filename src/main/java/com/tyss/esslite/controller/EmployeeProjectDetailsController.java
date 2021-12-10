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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.esslite.dto.EmployeeProjectDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.responses.EssportalProjectDetailsResponse;
import com.tyss.esslite.services.EmployeeProjectDetailsService;

import static com.tyss.esslite.constants.PersonalConstants.*;
import static com.tyss.esslite.constants.ProjectDetailsConstants.*;

/**
 * This is a controller class for Project Details Page. Here you find GET, POST,
 * PUT and DELETE controllers for the Project Details Page.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
@Validated
public class EmployeeProjectDetailsController {

	Logger logger = LoggerFactory.getLogger(EmployeeProjectDetailsController.class);
	
	@Autowired
	private EmployeeProjectDetailsService employeeProjectDetailsService;

	@PostMapping("esslite/employee-project-details")
	public ResponseEntity<EssportalProjectDetailsResponse> saveProjectDetails(
			@Valid @RequestBody List<EmployeeProjectDetails> projectDeatilsList, String employeeid)
			throws EmployeeCustomException {

		List<EmployeeProjectDetails> resultList = employeeProjectDetailsService.saveProjectDetails(projectDeatilsList,
				employeeid);

		logger.debug(DEBUG);
		
		if (!resultList.isEmpty()) {
			return new ResponseEntity<>(
					new EssportalProjectDetailsResponse(false, PROJECT_DETAILS_SUCCESS_MESSAGE, resultList),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EssportalProjectDetailsResponse(true, PROJECT_DETAILS_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("esslite/employee-project-details")
	public ResponseEntity<EssportalProjectDetailsResponse> getProjectDeatils(String employeeid)
			throws EmployeeCustomException {
		List<EmployeeProjectDetails> resultList = employeeProjectDetailsService.getProjectDetails(employeeid);
	
		logger.debug(DEBUG);
		
		if (!resultList.isEmpty()) {
			return new ResponseEntity<>(
					new EssportalProjectDetailsResponse(false, PROJECT_DETAILS_GET_SUCCESS_MESSAGE, resultList),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					new EssportalProjectDetailsResponse(true, PROJECT_DETAILS_GET_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}
	}
}
