package com.tyss.esslite.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.esslite.dao.EmployeeExperienceRepository;
import com.tyss.esslite.dto.EmployeeExperienceDetails;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeDeleteNotFoundException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.EmployeeUpdateNotFoundException;

import static com.tyss.esslite.constants.ExperienceConstants.*;
import static com.tyss.esslite.constants.PersonalConstants.ERROR;

@Service
public class EmployeeExperienceServiceImpl implements EmployeeExperienceService {

	Logger logger = LoggerFactory.getLogger(EmployeeExperienceServiceImpl.class);
	
	/**
	 * This enables automatic dependency injection of
	 * EmployeeExperiencealServiceImpl class This service calls the
	 * EmployeeExperienceRepository methods from EmployeeExperienceRepository with
	 * the help of its object employeeExperienceRepository.
	 */
	@Autowired
	private EmployeeExperienceRepository employeeExperienceRepository;


	/**
	 * This is GET method to the Experience details page
	 * 
	 * @Param employeeid = It is the employee Id
	 * @return = It returns employee details with the help of employeeid present in
	 *         the Database.
	 * @throws EmployeeCustomException
	 */

	@Override
	public List<EmployeeExperienceDetails> getEmployee(String employeeid) throws EmployeeCustomException {
		List<EmployeeExperienceDetails> result = null;
		try {
			result = employeeExperienceRepository.findByEmployeeid(employeeid);
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(EXPERIENCE_FAIL_MESSAGE);
		}
		return result;
	}

	/**
	 * This is POST method to the Experience details page The object of
	 * EmployeeExperienceDetails is getting stored by save method, in the Database.
	 * 
	 * @return = It returns employee details with the help of employeeid present in
	 *         the Database.
	 * @throws EmployeeInsertNotFoundException
	 * @throws EmployeeCustomException
	 * @Param info = It is a object of EmployeeExperienceDetails details.
	 */

	@Override
	public List<EmployeeExperienceDetails> saveEmployee(String employeeid, List<EmployeeExperienceDetails> info)
			throws EmployeeInsertNotFoundException, EmployeeCustomException {
		List<EmployeeExperienceDetails> list = new ArrayList<>();

		try {
			employeeExperienceRepository.deleteRecord(employeeid);

			for (EmployeeExperienceDetails employeeExperience : info) {
				String [] totalExperience = employeeExperience.getTotalExperience().split("/");
				String [] releventExperience = employeeExperience.getRelevantExperience().split("/");
				if(Integer.parseInt(totalExperience[0])<Integer.parseInt(releventExperience[0])||Integer.parseInt(totalExperience[1])<Integer.parseInt(releventExperience[1])) {
					throw new EmployeeInsertNotFoundException(WRONG_TOTAL_EXPERIENCE);
				}
				if (Integer.parseInt(totalExperience[1]) > 12) {
					throw new EmployeeInsertNotFoundException(WRONG_MONTH);
				}
				employeeExperience.setExperienceId(0);

				employeeExperience.setEmployeeId(employeeid);
				list.add(employeeExperienceRepository.save(employeeExperience));
			}
		} catch (NumberFormatException | EmployeeInsertNotFoundException  e ) {
			logger.error(ERROR);
			throw e;
		} catch(Exception e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(EXPERINCE_NOT_STORED);
		}

		return list;
	}

	/**
	 * This is PUT method to the Experience details page The object of
	 * EmployeeExperienceDetails is getting updated by save method, in the Database.
	 * 
	 * @return = It returns employee details with the help of employeeid present in
	 *         the Database.
	 * @throws EmployeeUpdateNotFoundException
	 * @throws EmployeeCustomException
	 * @Param info = It is a object of EmployeeExperienceDetails details.
	 */

	@Override
	public List<EmployeeExperienceDetails> updateEmployee(String employeeid, List<EmployeeExperienceDetails> info)
			throws EmployeeUpdateNotFoundException, EmployeeCustomException {
		List<EmployeeExperienceDetails> list = new ArrayList<>();
		for (EmployeeExperienceDetails employeeExperience : info) {

			try {
				employeeExperience.setEmployeeId(employeeid);
				list.add(employeeExperienceRepository.save(employeeExperience));
			} catch (Exception e) {
				logger.error(ERROR);
				throw new EmployeeCustomException(EXPERIENCE_UPDATE_FAIL_MESSAGE);
			}
		}

		return list;
	}

	/**
	 * This is DELETE method to the Experience details page The object of
	 * EmployeeExperienceDetails is getting deleted by deleteRecord method, in the
	 * Database.
	 * 
	 * @return = It returns employee details with the help of employeeid present in
	 *         the Database.
	 * @throws EmployeeDeleteNotFoundException
	 * @Param info = It is a object of EmployeeExperienceDetails details.
	 */

	@Override
	public EmployeeExperienceDetails deleteEmployee(String employeeid, EmployeeExperienceDetails info)
			throws EmployeeDeleteNotFoundException {
		EmployeeExperienceDetails result = null;
		info.setEmployeeId(employeeid);
		try {
			result = employeeExperienceRepository.findById(info.getExperienceId()).orElse(null);
			if (!Objects.isNull(result)) {
				employeeExperienceRepository.deleteRecord(employeeid);
			}
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeDeleteNotFoundException(EXPERIENCE_DELETE_FAIL_MESSAGE);
		}
		return result;
	}
}
