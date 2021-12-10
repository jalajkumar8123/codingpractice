package com.tyss.esslite.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Exclude;

/**
 * This is a Entity class for Employee Resume Data.
 * Here you find all fields of employee_data table for
 * Employee Resume data page.
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeResumeData {
	
	@Id
	@Column
	private String employeeId;


	@Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId")
	private EmployeePersonalDetails  personalDetails;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
	private List<EmployeeEducationalDetails> educationalDetails;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
	private List<TechnologyDetails> technologyDetails;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
	private List<EmployeeExperienceDetails> experienceDetails;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
	private List<EmployeeProjectDetails> projectdetailsDetails;
	
}
