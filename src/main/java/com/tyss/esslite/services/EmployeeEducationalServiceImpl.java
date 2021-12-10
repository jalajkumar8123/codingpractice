package com.tyss.esslite.services;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *This is a Service Implementation class for Educational page.
 * Here you find GET, PUT, POST and DELETE method for the EmployeeEducationalDetails.
 */

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.esslite.dao.EmployeeEducationRepository;
import com.tyss.esslite.dto.EmployeeEducationalDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeDeleteNotFoundException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.EmployeeUpdateNotFoundException;
import static com.tyss.esslite.constants.EducationConstants.*;
import static com.tyss.esslite.constants.PersonalConstants.ERROR;

@Service
public class EmployeeEducationalServiceImpl implements EmployeeEducationalService {

	Logger logger = LoggerFactory.getLogger(EmployeeEducationalServiceImpl.class);
	
	/**
	 * This enables automatic dependency injection of EmployeeEducationalServiceImpl
	 * class This service calls the EmployeeRepository methods from
	 * EmployeeRepository with the help of its object repo.
	 */
	
	@Autowired
	private EmployeeEducationRepository employeeEducationRepository;

	/**
	 * This is GET method to the Education details page
	 * 
	 * @Param employeeid = It is the employee Id
	 * @return = It returns employee details with the help of employeeid present in
	 *         the Database.
	 * @throws EmployeeCustomException
	 */

	@Override
	public List<EmployeeEducationalDetails> getEmployee(String employeeid) throws EmployeeCustomException {
		List<EmployeeEducationalDetails> result = null;
		try {
			result = employeeEducationRepository.findByEmployeeid(employeeid);
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(EDUCATION_FAIL_MESSAGE);
		}
		return result;
	}

	/**
	 * This is POST method to the Education details page The object of
	 * EmployeeEducationalDetails is getting stored by save method, in the Database.
	 * 
	 * @return = It returns employee details with the help of employeeid present in
	 *         the Database.
	 * @throws EmployeeInsertNotFoundException
	 * @throws EmployeeCustomException
	 * @Param info = It is a object of EmployeeEducationalDetails details.
	 */

	@Override
	public List<EmployeeEducationalDetails> saveEmployee(String employeeid, List<EmployeeEducationalDetails> info)
			throws EmployeeInsertNotFoundException, EmployeeCustomException {

		List<EmployeeEducationalDetails> list = new ArrayList<>();
	    try {
	    	employeeEducationRepository.deleteRecord(employeeid);

			for (EmployeeEducationalDetails employeeEducational : info) {

				int year = LocalDate.now().getYear();
				if (employeeEducational.getPassOutYear() > year) {
					throw new EmployeeCustomException(PASSOUT_YEAR_ERROR_MESSAGE);
				} else if (employeeEducational.getPercentage() > 100) {
					throw new EmployeeCustomException(PERCENTAGE_ERROR_MESSAGE);
				}
				employeeEducational.setEducationalId(0);
				employeeEducational.setEmployeeId(employeeid);
				EmployeeEducationalDetails save = employeeEducationRepository.save(employeeEducational);
				list.add(save);
			}
		} catch (EmployeeCustomException e) {
			logger.error(ERROR);
			throw e;
		}
		return list;
	}

	/**
	 * This is PUT method to the Education details page The object of
	 * EmployeeEducationalDetails is getting updated by save method, in the
	 * Database.
	 * 
	 * @return = It returns employee details with the help of employeeid present in
	 *         the Database.
	 * @throws EmployeeUpdateNotFoundException
	 * @throws EmployeeCustomException
	 * @Param info = It is a object of EmployeeEducationalDetails details.
	 */

	@Override
	public List<EmployeeEducationalDetails> updateEmployee(String employeeid,
			@Valid List<EmployeeEducationalDetails> info)
			throws EmployeeUpdateNotFoundException, EmployeeCustomException {
		List<EmployeeEducationalDetails> list = new ArrayList<>();

		for (@Valid
		EmployeeEducationalDetails employeeEducational : info) {

			try {
				employeeEducational.setEmployeeId(employeeid);
				list.add(employeeEducationRepository.save(employeeEducational));
			} catch (Exception e) {
				logger.error(ERROR);
				throw new EmployeeCustomException(EDUCATION_INSERT_FAIL_MESSAGE);
			}
		}

		return list;
	}

	/**
	 * This is DELETE method to the Education details page The object of
	 * EmployeeEducationalDetails is getting deleted by deleteRecord method, in the
	 * Database.
	 * 
	 * @return = It returns employee details with the help of employeeid present in
	 *         the Database.
	 * @throws EmployeeDeleteNotFoundException
	 * @Param info = It is a object of EmployeeEducationalDetails details.
	 */

	@Override
	public EmployeeEducationalDetails deleteEmployee(String employeeid, EmployeeEducationalDetails educationalDetailsinfo)
			throws EmployeeDeleteNotFoundException {
		EmployeeEducationalDetails result = null;
		try {
			result = employeeEducationRepository.findById(educationalDetailsinfo.getEducationalId()).orElse(null);
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeDeleteNotFoundException(EDUCATION_DELETE_FAIL_MESSAGE);
		}
		return result;
	}

}
