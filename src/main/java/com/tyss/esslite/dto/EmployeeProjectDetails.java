package com.tyss.esslite.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.tyss.esslite.utility.ListToStringConverter;
import static com.tyss.esslite.constants.ProjectDetailsConstants.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a Entity class for Project Details page.
 * Here you find all fields of project details table for
 * project details page.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProjectDetails {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;

	@Column
	@NotBlank(message = PROJECT_NAME_REQUIRED_MESSAGE)
	@Size(min = 3, message = PROJECT_NAME_MINIMUM_MESSAGE)
	private String projectName;

	@Convert(converter = ListToStringConverter.class)
	private List<String> technologyUsed;

	@Column(length = 1000)
	@NotBlank(message = PROJECT_SUMMARY_REQUIRED_MESSAGE)
	@Size(min = 3, message = PROJECT_SUMMARY_MINIMUM_MESSAGE)
	private String projectSummary;

	@Column
	@NotBlank(message = ROLES_AND_RESPONSIBILITIES_REQUIRED_MESSAGE)
	@Size(min = 3, message = ROLES_AND_RESPONSIBILITIES_MINIMUM_MESSAGE)
	private String rolesAndResponsibility;

	@Column
	private String employeeId;

}
