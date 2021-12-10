package com.tyss.esslite.wrapper;

import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_DESIGNATION_NOTEMPTY;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_DESIGNATION_REGEXP_CODE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_DESIGNATION_REGEXP_MESSAGE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_DESIGNATION_UNIT_LENGTH;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EDUCATION_NOTEMPTY;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EDUCATION_REGEXP_CODE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EDUCATION_REGEXP_MESSAGE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EDUCATION_UNIT_LENGTH;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EMAIL_NOTEMPTY;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EMAIL_REGEXP;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EMAIL_REGEXP_MESSAGE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_FIRSTNAME_LENGTH;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_FIRSTNAME_REGEXP_CODE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_FIRSTNAME_REGEXP_MESSAGE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_LASTNAME_LENGTH;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_LASTNAME_REGEXP_CODE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_LASTNAME_REGEXP_MESSAGE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_MOBILENUMBER_NOTEMPTY;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_MOBILENUMBER_REGEXP_CODE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_MOBILENUMBER_REGEXP_MESSAGE;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_TECHNOLOGY_LENGTH;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_TECHNOLOGY_NOTEMPTY;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.FIRST_NAME_NOTEMPTY;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.LAST_NAME_NOTEMPTY;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProfileDetailsUpdateWrapper {
	
	@NotBlank(message = FIRST_NAME_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_FIRSTNAME_REGEXP_CODE, message = EMPLOYEE_FIRSTNAME_REGEXP_MESSAGE)
	@Size(min=3, max = 35, message = EMPLOYEE_FIRSTNAME_LENGTH)
	private String firstName;
	
	@NotBlank(message = LAST_NAME_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_LASTNAME_REGEXP_CODE, message = EMPLOYEE_LASTNAME_REGEXP_MESSAGE)
	@Size(min=3,max = 35, message = EMPLOYEE_LASTNAME_LENGTH)
	private String lastName;

	@NotBlank(message = EMPLOYEE_EDUCATION_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_EDUCATION_REGEXP_CODE, message = EMPLOYEE_EDUCATION_REGEXP_MESSAGE)
	@Size(max = 35, message = EMPLOYEE_EDUCATION_UNIT_LENGTH)
	private String education;

	@NotBlank(message = EMPLOYEE_MOBILENUMBER_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_MOBILENUMBER_REGEXP_CODE, message = EMPLOYEE_MOBILENUMBER_REGEXP_MESSAGE)
	private String phoneNo;
	
	@NotBlank(message = EMPLOYEE_TECHNOLOGY_NOTEMPTY)
	@Size(max = 50, message = EMPLOYEE_TECHNOLOGY_LENGTH)
	private String technology;
	
	@NotBlank(message = EMPLOYEE_EMAIL_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_EMAIL_REGEXP, message = EMPLOYEE_EMAIL_REGEXP_MESSAGE)
	private String email;
	
	@NotBlank(message = EMPLOYEE_DESIGNATION_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_DESIGNATION_REGEXP_CODE, message = EMPLOYEE_DESIGNATION_REGEXP_MESSAGE)
	@Size(max = 35, message = EMPLOYEE_DESIGNATION_UNIT_LENGTH)
	private String designation;

}
