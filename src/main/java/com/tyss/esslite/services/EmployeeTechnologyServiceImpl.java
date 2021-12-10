package com.tyss.esslite.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.esslite.dao.TechnologyDetailsRepo;
import com.tyss.esslite.dao.TechnologySkillsRepository;
import com.tyss.esslite.dto.TechnologyDetails;
import com.tyss.esslite.dto.TechnologySkills;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import static com.tyss.esslite.constants.EmployeeTechnologyConstants.*;
import static com.tyss.esslite.constants.PersonalConstants.ERROR;

/**
 * *This is a Servic Implementation class for Technology. Here you find GET,
 * POST, PUT and DELETE method for the EmployeeData.
 */
@Service
public class EmployeeTechnologyServiceImpl implements EmployeeTechnologyService {

	Logger logger = LoggerFactory.getLogger(EmployeeTechnologyServiceImpl.class);
	
	@Autowired
	private TechnologyDetailsRepo technologyDetailsRepo;

	@Autowired
	private TechnologySkillsRepository skillsRepository;

	@Override
	public List<TechnologyDetails> getTechnologies(String employeeId) throws EmployeeInsertNotFoundException {
		List<TechnologyDetails> technologyList = null;
		try {
			technologyList = technologyDetailsRepo.getTechsByEmployeeId(employeeId);
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeInsertNotFoundException(TECHNOLOGY_GET_FAIL_MESSAGE);
		}
		return technologyList;
	}

	@Override
	public List<TechnologyDetails> saveTechnology(String employeeId, List<TechnologyDetails> technologyDetailsList)
			throws EmployeeCustomException {
		ArrayList<TechnologyDetails> detailsArrayList = new ArrayList<>();

		try {

			List<TechnologyDetails> techsByEmployeeId = technologyDetailsRepo.getTechsByEmployeeId(employeeId);

			if (!techsByEmployeeId.isEmpty()) {

				for (TechnologyDetails technologyDetails : techsByEmployeeId) {

					for (TechnologySkills skills : technologyDetails.getSkills()) {
						skillsRepository.deleteById(skills.getSkillId());

					}
					technologyDetailsRepo.deleteById(technologyDetails.getTypeId());
				}
			}

			for (TechnologyDetails technologyDetailsSave : technologyDetailsList) {
				ArrayList<TechnologySkills> skillsArrayList = new ArrayList<>();

				for (TechnologySkills technologySkills : technologyDetailsSave.getSkills()) {

					technologySkills.setSkillId(0);

					TechnologySkills save = skillsRepository.save(technologySkills);
					skillsArrayList.add(save);
				}

				technologyDetailsSave.setEmployeeId(employeeId);
				technologyDetailsSave.setTypeId(0);
				technologyDetailsSave.setSkills(skillsArrayList);

				TechnologyDetails save = technologyDetailsRepo.save(technologyDetailsSave);

				save.setSkills(skillsArrayList);

				detailsArrayList.add(save);
			}
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(UPDATED_FAILED);
		}
		return detailsArrayList;

	}

}
