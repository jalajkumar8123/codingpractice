package com.tyss.esslite.dto;

import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.*;

import java.net.URL;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;
import static com.tyss.esslite.constants.PersonalConstants.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a Entity class for Employee personal details . Here you find all
 * fields of personal_details table for Employee personal details page.
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePersonalDetails {

	@Id
	@Column(length = 15)
	private String employeeId;

	@Column(length = 20)
	@NotBlank(message = FIRST_NAME_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_FIRSTNAME_REGEXP_CODE, message = EMPLOYEE_FIRSTNAME_REGEXP_MESSAGE)
	@Size(min = 3, max = 35, message = EMPLOYEE_FIRSTNAME_LENGTH)
	private String name;

	@Column(length = 10)
	@NotBlank(message = GENDER_NOTEMPTY)
	@Pattern(regexp = GENDER_REGEXP_CODE, message = GENDER_REGEXP_MESSAGE)
	@Size(min = 3, max = 10, message = GENDER_LENGTH)
	private String gender;

	@Column(length = 25)
	@NotBlank(message = EMPLOYEE_MOBILENUMBER_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_MOBILENUMBER_REGEXP_CODE, message = EMPLOYEE_MOBILENUMBER_REGEXP_MESSAGE)
	private String contactNumber;

	@Column(length = 25)
	@NotBlank(message = EMPLOYEE_MOBILENUMBER_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_MOBILENUMBER_REGEXP_CODE, message = EMPLOYEE_MOBILENUMBER_REGEXP_MESSAGE)
	private String alternativeNumber;

	@Column(length = 25)
	@NotBlank(message = EMPLOYEE_MOBILENUMBER_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_MOBILENUMBER_REGEXP_CODE, message = EMPLOYEE_MOBILENUMBER_REGEXP_MESSAGE)
	private String emergencyContactNumber1;

	@Column(length = 25)
	@NotBlank(message = EMPLOYEE_MOBILENUMBER_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_MOBILENUMBER_REGEXP_CODE, message = EMPLOYEE_MOBILENUMBER_REGEXP_MESSAGE)
	private String emergencyContactNumber2;

	@Column(length = 35)
	@NotBlank(message = EMPLOYEE_EMAIL_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_EMAIL_REGEXP, message = EMPLOYEE_EMAIL_REGEXP_MESSAGE)
	private String personalMailId;

	@Column(length = 100)
	@NotBlank(message = ADDRESS_NOTEMPTY)
	@Size(min = 3, max = 35, message = ADDRESS_LENGTH)
	private String permanentAddress;

	@Column(length = 100)
	@NotBlank(message = ADDRESS_NOTEMPTY)
	@Size(min = 3, max = 35, message = ADDRESS_LENGTH)
	private String temporaryAddresss;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private EmployeeResumeData employeeData;

	@Column
	private URL image;

}
