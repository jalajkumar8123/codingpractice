package com.tyss.esslite.controller;

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

import com.tyss.esslite.dto.TechnologyDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.responses.StackSkillInfoSingleResponse;
import com.tyss.esslite.services.EmployeeTechnologyService;

import static com.tyss.esslite.constants.PersonalConstants.DEBUG;
import static com.tyss.esslite.constants.TechnologyConstants.*;

import java.util.List;

import javax.validation.Valid;

/**
 * This is a controller class for Technology page. Here you find GET controllers
 * for the Technology page. Here you can find the URL path for technology page
 * details.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
@Validated
public class EmployeeTechnologyController {

	Logger logger = LoggerFactory.getLogger(EmployeeTechnologyController.class);
	
	@Autowired
	private EmployeeTechnologyService employeeTechnologyService;

	@PostMapping("esslite/technology-stackskill")
	public ResponseEntity<StackSkillInfoSingleResponse> saveTechnology(String employeeid,
			@Valid @RequestBody List<TechnologyDetails> info)
			throws  EmployeeCustomException {
		List<TechnologyDetails> savedEmployee = employeeTechnologyService.saveTechnology(employeeid, info);

		logger.debug(DEBUG);
		
		if (savedEmployee != null) {
			return new ResponseEntity<>(new StackSkillInfoSingleResponse(false,TECHNOLOGY_INSERT_SUCCESS_MESSAGE,savedEmployee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new StackSkillInfoSingleResponse(true,TECHNOLOGY_INSERT_FAIL_MESSAGE,savedEmployee), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("esslite/technology-employeeskills")
	public ResponseEntity<StackSkillInfoSingleResponse> findEmployee(String employeeid)
			throws EmployeeInsertNotFoundException {
		List<TechnologyDetails> technologyList = employeeTechnologyService.getTechnologies(employeeid);
		
		logger.debug(DEBUG);
		
		if (technologyList != null) {
			return new ResponseEntity<>(new StackSkillInfoSingleResponse(false,TECHNOLOGY_SUCCESS_MESSAGE,technologyList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new StackSkillInfoSingleResponse(true,TECHNOLOGY_FAIL_MESSAGE,null), HttpStatus.BAD_REQUEST);
		}

	}

}
