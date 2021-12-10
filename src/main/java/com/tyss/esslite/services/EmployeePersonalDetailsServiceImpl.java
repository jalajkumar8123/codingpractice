package com.tyss.esslite.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.esslite.dao.EmployeeRegistrationRepository;
import com.tyss.esslite.dao.EmployeeRepository;
import com.tyss.esslite.dto.EmployeePersonalDetails;
import com.tyss.esslite.dto.EmployeeRegistration;
import com.tyss.esslite.dto.EmployeeResumeData;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.MultipartFileIsEmptyException;
import com.tyss.esslite.wrapper.ConvertFileToUrl;
import com.tyss.esslite.wrapper.EmployeeProfileDetailsUpdateWrapper;
import com.tyss.esslite.wrapper.ProfileImageUploadWrapper;

import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPTY_FILE_MESSAGE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.*;
import static com.tyss.esslite.constants.PersonalConstants.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * This is a Service Implementation class for Personal Details page. Here you
 * find GET, POST and PUT method for the EmployeePersonalDetails .
 */

@Service
public class EmployeePersonalDetailsServiceImpl implements EmployeePersonalDetailsService {

	Logger logger = LoggerFactory.getLogger(EmployeePersonalDetailsServiceImpl.class);
	
	@Value("${server.folder.path}")
	private String fileUploadPath;
	
	/**
	 * This enables automatic dependency injection of
	 * EmployeeProjectDetailsServiceImpl class This service calls the
	 * EmployeeRepository methods from EmployeeRepository with the help of its
	 * object employeePersonalRepository.
	 */
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeRegistrationRepository employeeRegistrationRepository;
	

	/**
	 * This is GET method to the Employee Personal details page
	 *
	 * @Param employeeId = It is the employee Id
	 * @return = It returns employee details with the help of employeeId present in
	 *         the Database.
	 * @throws EmployeeCustomException
	 */
	@Override
	public EmployeePersonalDetails getEmployee(String employeeId) throws EmployeeCustomException {
		EmployeePersonalDetails employee = null;
		try {
			employee = employeeRepository.findByEmployeeID(employeeId);
		} catch (Exception e) {
			throw new EmployeeCustomException(EXPERIENCE_SUCCESS_MESSAGE);
		}
		logger.error(ERROR);
		return employee;
	}

	/**
	 * This is POST method to the Personal details page The object of
	 * EmployeePersonalDetails is getting stored by save method, in the Database.
	 *
	 * @return = It returns employee details with the help of employeeId present in
	 *         the Database.
	 * @throws EmployeeInsertNotFoundException
	 * @Param info = It is a object of EmployeePersonalDetails details.
	 */
	@Override
	public EmployeePersonalDetails saveEmployee(EmployeePersonalDetails details)
			throws EmployeeInsertNotFoundException {
		EmployeePersonalDetails info = null;
		try {
			EmployeeResumeData data = new EmployeeResumeData();
			data.setEmployeeId(details.getEmployeeId());
			details.setEmployeeData(data);
			info = employeeRepository.save(details);
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeInsertNotFoundException(EXPERIENCE_INSERT_FAIL_MESSAGE);
		}
		return info;
	}

	/**
	 * This is a post service for This is a Get service of EmployeeProfile Picture
	 * Upload
	 * 
	 * @param employeeId = Id of employee
	 * @throws MultipartFileIsEmptyException
	 * @throws IOException
	 * @throws EmployeeCustomException 
	 */
	@Override
	public ProfileImageUploadWrapper storeProfileImage(MultipartFile file, String employeeId,
			EmployeeProfileDetailsUpdateWrapper employeeProfileDetailsUpdateWrapper)
			throws MultipartFileIsEmptyException, IOException, EmployeeCustomException {
		FileOutputStream fileWriter = null;
		String inDir = null;
		ProfileImageUploadWrapper profileImageUploadWrapper = new ProfileImageUploadWrapper();
		try {
			EmployeePersonalDetails findImage = employeeRepository.findByEmployeeID(employeeId);
			
			if(findImage == null) {
				throw new EmployeeCustomException(ID_NOT_FOUND);
			}

			if (findImage.getImage() != null) {
				deleteProfileImage(employeeId);
			}

			if (file.isEmpty()) {
				throw new MultipartFileIsEmptyException(EMPTY_FILE_MESSAGE);
			}

			File path = new File(fileUploadPath + employeeId + IMAGE );
			if (!path.exists()) {
				path.mkdirs();
			}
			inDir = fileUploadPath + employeeId + IMAGE + "/" + file.getOriginalFilename();
			fileWriter = new FileOutputStream(new File(inDir));
			fileWriter.write(file.getBytes());
			fileWriter.close();
			EmployeePersonalDetails findById = employeeRepository.findByEmployeeID(employeeId);
			if (findById != null) {
				EmployeeRegistration employeeRegistration = employeeRegistrationRepository.findByEmployeeId(employeeId);
				if (employeeRegistration == null) {
					throw new EmployeeCustomException(ID_NOT_FOUND);
				}
				employeeRegistration.setFirstName(employeeProfileDetailsUpdateWrapper.getFirstName());
				employeeRegistration.setLastName(employeeProfileDetailsUpdateWrapper.getLastName());
				employeeRegistration.setEducation(employeeProfileDetailsUpdateWrapper.getEducation());
				employeeRegistration.setTechnology(employeeProfileDetailsUpdateWrapper.getTechnology());
				employeeRegistration.setPrimaryContactNo(employeeProfileDetailsUpdateWrapper.getPhoneNo());
				employeeRegistration.setEmail(employeeProfileDetailsUpdateWrapper.getEmail());
				employeeRegistration.setDesignation(employeeProfileDetailsUpdateWrapper.getDesignation());
				employeeRegistration = employeeRegistrationRepository.save(employeeRegistration);

				profileImageUploadWrapper.setFirstName(employeeRegistration.getFirstName());
				profileImageUploadWrapper.setLastName(employeeRegistration.getLastName());
				profileImageUploadWrapper.setEducation(employeeRegistration.getEducation());
				profileImageUploadWrapper.setPhoneNo(employeeRegistration.getPrimaryContactNo());
				profileImageUploadWrapper.setTechnology(employeeRegistration.getTechnology());
				profileImageUploadWrapper.setEmail(employeeRegistration.getEmail());
				profileImageUploadWrapper.setImageUrl(inDir);
				profileImageUploadWrapper.setDesignation(employeeRegistration.getDesignation());

				findById.setImage(new ConvertFileToUrl().convertFileToUrl(inDir));
				employeeRepository.save(findById);

			} else {
				throw new EmployeeCustomException(ID_NOT_FOUND);
			}
		} catch (MultipartFileIsEmptyException e) {
			logger.error(ERROR);
			throw new MultipartFileIsEmptyException(EMPTY_FILE_MESSAGE);
		}catch (EmployeeCustomException e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(ID_NOT_FOUND);
		}

		return profileImageUploadWrapper;

	}

	public String deleteProfileImage( String employeeId) throws IOException {
		String inDir = fileUploadPath + employeeId + IMAGE;
		File path = new File(inDir);
		deleteDirectory(path);
		return employeeId;
	}

	public static void deleteDirectory(File file) {
		for (File subfile : file.listFiles()) {
			if (subfile.isDirectory()) {
				deleteDirectory(subfile);
			}
			subfile.delete();
		}
	}

	@Override
	public URL profileImage(String profileId) throws IOException, EmployeeCustomException {
		URL imageUrl = null;
		try {
			EmployeePersonalDetails findByEmployeeID = employeeRepository.findByEmployeeID(profileId);
			String join = new String(findByEmployeeID.getImage().toString());
			String[] split = join.split(SPLIT_FILE);
			String joinHostName = JOIN_IMAGE_URL_HOST+split[1];
			imageUrl = new URL(joinHostName);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ERROR);
			throw new EmployeeCustomException(ID_NOT_FOUND);
		}
		return imageUrl;
	}

}
