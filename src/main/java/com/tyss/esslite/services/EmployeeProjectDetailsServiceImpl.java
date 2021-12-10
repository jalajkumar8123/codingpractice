package com.tyss.esslite.services;

import java.util.ArrayList;

/**
 *This is a Service Implementation class for Project Details page.
 * Here you find GET, PUT, POST and DELETE method for the EmployeeEducationalDetails.
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.esslite.dao.EmployeeProjectDetailRepository;
import com.tyss.esslite.dto.EmployeeProjectDetails;
import com.tyss.esslite.exception.EmployeeCustomException;

import static com.tyss.esslite.constants.PersonalConstants.ERROR;
import static com.tyss.esslite.constants.ProjectDetailsConstants.*;
import static com.tyss.esslite.constants.ExperienceConstants.*;

@Service
public class EmployeeProjectDetailsServiceImpl implements EmployeeProjectDetailsService {

	Logger logger = LoggerFactory.getLogger(EmployeeProjectDetailsServiceImpl.class);
	
	@Autowired
	private EmployeeProjectDetailRepository employeeProjecDetailsRepo;

	@Override
	public List<EmployeeProjectDetails> getProjectDetails(String employeeId) throws EmployeeCustomException {
		List<EmployeeProjectDetails> projectList = null;
		try {
			projectList = employeeProjecDetailsRepo.findByEmployeeid(employeeId);
			if (!projectList.isEmpty()) {
				return projectList;
			} else {
				throw new EmployeeCustomException(RECORDS_NOT_PRESENT);
			}
		} catch (EmployeeCustomException e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(RECORDS_NOT_PRESENT);
		}
	}

	@Override
	public List<EmployeeProjectDetails> saveProjectDetails(List<EmployeeProjectDetails> projectDetails,
			String employeeId) throws EmployeeCustomException {
		List<EmployeeProjectDetails> projectList = null;
		List<EmployeeProjectDetails> newProjectList = new ArrayList<>();
		try {
			projectList = employeeProjecDetailsRepo.findByEmployeeid(employeeId);
			if (projectList.isEmpty()) {
				for (EmployeeProjectDetails project : projectDetails) {
					project.setEmployeeId(employeeId);
					newProjectList.add(employeeProjecDetailsRepo.save(project));
				}
				return newProjectList;
			} else {
				for (EmployeeProjectDetails project : projectList) {
					employeeProjecDetailsRepo.delete(project);
				}
				for (EmployeeProjectDetails newProject : projectDetails) {
					newProject.setEmployeeId(employeeId);
					newProjectList.add(employeeProjecDetailsRepo.save(newProject));
				}
				return newProjectList;
			}
		} catch(Exception e) {
			logger.error(ERROR);
			 throw new EmployeeCustomException(EXPERINCE_NOT_STORED);
		}
	}

}
