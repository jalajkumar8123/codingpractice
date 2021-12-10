package com.tyss.esslite.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import static com.tyss.esslite.constants.EducationConstants.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*This is a Entity class for Educational page.
 * Here you find all fields of educational table for
 * Education page.
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEducationalDetails {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationalId;

	@Column(length = 35)
	@NotEmpty(message = QUALIFICATION_INFO_REQUIRED_MESSAGE)
	@Pattern(regexp = QUALIFICATION_INFO_REGEXP_CODE, message = QUALIFICATION_INFO_REGEXP_MESSAGE)
	@Size(min = 3, message = QUALIFICATION_INFO_MINIMUM_SIZE_MESSAGE)
	private String qualification;

	@Column(length = 35)
	@NotEmpty(message = COURSE_INFO_REQUIRED_MESSAGE)
	@Pattern(regexp = COURSE_INFO_REGEXP_CODE, message = COURSE_INFO_REGEXP_MESSAGE)
	@Size(min = 3, message = COURSE_INFO_MINIMUM_SIZE_MESSAGE)
	private String course;

	@Column(length = 25)
	@NotEmpty(message = SPECIALIZATION_REQUIRED_MESSAGE)
	@Pattern(regexp = SPECIALIZATION_INFO_REGEXP_CODE, message = SPECIALIZATION_REGEXP_MESSAGE)
	@Size(min = 3, message = SPECIALIZATION_MINIMUM_SIZE_MESSAGE)
	private String specialization;

	@Column(length = 100)
	@NotEmpty(message = INSTITUTION_REQUIRED_MESSAGE)
	@Pattern(regexp = INSTITUTION_INFO_REGEXP_CODE, message = INSTITUTION_REGEXP_MESSAGE)
	@Size(min = 3, message = INSTITUTION_MINIMUM_SIZE_MESSAGE)
	private String institution;

	@Max(value = 2100, message = PASSOUT_YEAR_INVALID_MESSAGE)
	@Min(value = 1900, message = PASSOUT_YEAR_INVALID_MESSAGE)
	private int passOutYear;

	@Column(length = 6)
	@NotNull(message = PERCENTAGE_YEAR_REQUIRED_MESSAGE)
	@Digits(integer = 3, fraction = 3, message = PERCENTAGE_INVALID_MESSAGE)
	private double percentage;

	@Column(length = 100)
	@NotEmpty(message = UNIVERSITY_REQUIRED_MESSAGE)
	@Pattern(regexp = UNIVERSITY_INFO_REGEXP_CODE, message = UNIVERSITY_REGEXP_MESSAGE)
	@Size(min = 3, message = UNIVERSITY_MINIMUM_SIZE_MESSAGE)
	private String university;

	@Column(length = 15)
	private String employeeId;

}
