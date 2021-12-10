package com.tyss.esslite.services;


import java.io.IOException;
import java.net.URL;

import org.springframework.web.multipart.MultipartFile;

import com.tyss.esslite.dto.EmployeePersonalDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.MultipartFileIsEmptyException;
import com.tyss.esslite.wrapper.EmployeeProfileDetailsUpdateWrapper;
import com.tyss.esslite.wrapper.ProfileImageUploadWrapper;


/**
 *This is the Service Interface of Employee Personal Page. It is implemented by
 * EmployeeServiceImpl class. This Interface contains methods to perform the particular 
 * services
 *
 */
public interface EmployeePersonalDetailsService {
	
	/**
	 * This is GET method to the Personal details page
	 * @throws EmployeeCustomException 
	 * @Param employeeid = It is a ID of the employee 
	 */
	public EmployeePersonalDetails getEmployee(String employeeId) throws EmployeeCustomException;
	
	/**
	 * This is POST and PUT method to the Personal details page
	 * @throws EmployeeInsertNotFoundException 
	 * @Param details = It is a object of Personal details
	 */
	public EmployeePersonalDetails saveEmployee(EmployeePersonalDetails details) throws EmployeeInsertNotFoundException;
	
	/**
	 * This is a post service for This is a Get service of EmployeeProfile Picture Upload
	 * @param employeeid = Id of employee	
	 * @throws MultipartFileIsEmptyException 
	 * @throws IOException 
	 * @throws EmployeeCustomException 
	 */
	ProfileImageUploadWrapper storeProfileImage(MultipartFile file, String employeeId, EmployeeProfileDetailsUpdateWrapper employeeProfileDetailsUpdateWrapper) throws MultipartFileIsEmptyException, IOException, EmployeeCustomException;
	
	public URL profileImage(String profileId) throws IOException, EmployeeCustomException;
	
}
