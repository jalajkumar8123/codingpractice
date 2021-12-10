package com.tyss.esslite.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import static com.tyss.esslite.constants.ExperienceConstants.*;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*This is a Entity class for experience page.
 * Here you find all fields of experience table for
 * experience page.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeExperienceDetails {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int experienceId;

	@Column(length = 25)
	@NotEmpty(message = DESIGNATION_REQUIRED_MESSAGE)
	@Pattern(regexp = DESIGNATION_REGEXP_CODE, message = DESIGNATION_REGEXP_MESSAGE)
	@Size(min = 3, message = DESIGNATION_MINIMUM_SIZE_MESSAGE)
	private String designation;

	@Column(length = 100)
	@NotEmpty(message = COMPANY_REQUIRED_MESSAGE)
	@Pattern(regexp = COMPANY_REGEXP_CODE, message = COMPANY_REGEXP_MESSAGE)
	@Size(min = 3, message = COMPANY_MINIMUM_SIZE_MESSAGE)
	private String company;

	@Column
	@Past(message = WORKING_FROM_VALIDITY_MESSAGE)
	private LocalDate workingFrom;

	@Column
	@PastOrPresent(message = WORKING_TILL_VALIDITY_MESSAGE)
	private LocalDate workingTill;

	@Column(length = 75)
	@NotEmpty(message = CITY_REQUIRED_MESSAGE)
	@Pattern(regexp = CITY_REGEXP_CODE, message = CITY_REGEXP_MESSAGE)
	@Size(min = 3, message = CITY_MINIMUM_SIZE_MESSAGE)
	private String city;

	@Column(length = 5)
	@NotEmpty(message = TOTAL_EXPERIENCE_REQUIRED_MESSAGE)
	@Pattern(regexp = TOTAL_EXPERIENCE_REGEX,message = TOTAL_EXPERIENCE_REGEX_MESSAGE)
	private String totalExperience;

	@Column(length = 5)
	@NotEmpty(message = RELEVANT_EXPERIENCE_REQUIRED_MESSAGE)
	@Pattern(regexp = RELEVENT_EXPERIENCE_REGEX,message = RELEVENT_EXPERIENCE_REGEX_MESSAGE)
	private String relevantExperience;

	@Column(length = 15)
	private String employeeId;

	
}
