package com.tyss.esslite.controller;

import static com.tyss.esslite.constants.PersonalConstants.*;

import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.net.URL;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyss.esslite.dto.EmployeePersonalDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeDeleteNotFoundException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.MultipartFileIsEmptyException;
import com.tyss.esslite.responses.EmployeeSingleResponse;
import com.tyss.esslite.responses.ProfilePictureUploadResponse;
import com.tyss.esslite.responses.UrlDisplayResponse;
import com.tyss.esslite.services.EmployeePersonalDetailsService;
import com.tyss.esslite.wrapper.EmployeeProfileDetailsUpdateWrapper;
import com.tyss.esslite.wrapper.ProfileImageUploadWrapper;

/**
 * This is a controller class for Employee Personal details. Here you find GET,
 * POST, PUT controllers for the Personal Details page. Here you can find the
 * URL path for all the Personal details services.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class EmployeePersonalDetailsController {

	Logger logger = LoggerFactory.getLogger(EmployeePersonalDetailsController.class);
	
	/**
	 * This is a constructor. This enables automatic dependency injection of
	 * EmployeePersonalDetailsService class.This service object is used by every
	 * method in the Employee controller to call the DAO methods.
	 */
	@Autowired
	private EmployeePersonalDetailsService employeePersonalDetailsService;

	/**
	 * This is GET controller for Employee Personal details. The EmployeeService
	 * class helps calling the method from "EmployeeRepository", if it gets
	 * succeeded it returns the data else throws Bad_Request as output.
	 * 
	 * @Param employeeid = ID of the employee
	 * 
	 * @return = It returns the message whether successfully getting the record or
	 *         the record is not getting
	 * @throws EmployeeCustomException
	 * 
	 */
	@GetMapping("esslite/employee-personal-detail")
	public ResponseEntity<EmployeeSingleResponse> findEmployee(@Valid String employeeid)
			throws EmployeeCustomException {
		EmployeePersonalDetails employee = employeePersonalDetailsService.getEmployee(employeeid);

		logger.debug(DEBUG);
		
		if (employee != null) {
			return new ResponseEntity<>(new EmployeeSingleResponse(false, EXPERIENCE_SUCCESS_MESSAGE, employee),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EmployeeSingleResponse(true, EXPERIENCE_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * * This is POST and PUT controller for Employee Personal details. The
	 * EmployeePersonalDetailsService class helps calling the method from
	 * "EmployeeRepository", if it gets succeeded it returns the data else throws
	 * Bad_Request as output.
	 * 
	 * @Param details = It is a object of Personal details.
	 * 
	 * @return = It returns the message whether successfully inserting the record or
	 *         the record is not inserted.
	 * @throws EmployeeInsertNotFoundException
	 * 
	 */
	@PostMapping("esslite/employee-personal-details")
	public ResponseEntity<EmployeeSingleResponse> saveEmployee(@Valid @RequestBody EmployeePersonalDetails details)
			throws EmployeeInsertNotFoundException {
		EmployeePersonalDetails employeeData = employeePersonalDetailsService.saveEmployee(details);

		logger.debug(DEBUG);
		
		if (employeeData != null) {
			return new ResponseEntity<>(
					new EmployeeSingleResponse(false, EXPERIENCE_INSERT_SUCCESS_MESSAGE, employeeData), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EmployeeSingleResponse(true, EXPERIENCE_INSERT_FAIL_MESSAGE, null),
					HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * * This is POST controller for Employee File Upload. The
	 * EmployeeFileUploadService class helps calling the method from
	 * "EmployeeFileUploadRepository", if it gets succeeded it returns the data else
	 * throws Bad_Request as output.
	 * 
	 * @Param details = It is a object of Personal details.
	 * 
	 * @return = It returns the message whether successfully inserting the record or
	 *         the record is not inserted.
	 * @throws EmployeeDeleteNotFoundException
	 * @throws IOException
	 * @throws MultipartFileIsEmptyException
	 * @throws EmployeeCustomException
	 * @throws EmployeeInsertNotFoundException
	 * 
	 */
	@PostMapping("esslite/user/upload-profile-image")
	public ResponseEntity<ProfilePictureUploadResponse> uploadImage(@Valid @RequestParam("media") MultipartFile file,
			String employeeid, @RequestParam("profileDetails") String profileDetails)
			throws MultipartFileIsEmptyException, IOException, EmployeeCustomException {
		EmployeeProfileDetailsUpdateWrapper readValue = new ObjectMapper().readValue(profileDetails,
				EmployeeProfileDetailsUpdateWrapper.class);
		ProfileImageUploadWrapper storedProfileImage = employeePersonalDetailsService.storeProfileImage(file,
				employeeid, readValue);
		
		logger.debug(DEBUG);

		if (storedProfileImage != null) {
			return new ResponseEntity<>(
					new ProfilePictureUploadResponse(false, PROFILE_PIC_UPLOADED, storedProfileImage), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ProfilePictureUploadResponse(true, PROFILE_PIC_NOT_UPLOADED, null),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 * @param profileId
	 * @return
	 * @throws IOException
	 * @throws EmployeeCustomException
	 */

	@PostMapping("esslite/user/show-profile-image")
	public ResponseEntity<UrlDisplayResponse> dispalyImage(@Valid String profileid)
			throws IOException, EmployeeCustomException {
		URL profileImage = employeePersonalDetailsService.profileImage(profileid);
		
		logger.debug(DEBUG);
		
		if (profileImage != null) {
			return new ResponseEntity<>(new UrlDisplayResponse(false, PROFILE_PIC_DISPLAY, profileImage.toString()),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new UrlDisplayResponse(true, PROFILE_PIC_NOT_DISPLAY, null),
					HttpStatus.BAD_REQUEST);
		}
	}

}
