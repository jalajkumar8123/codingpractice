package com.tyss.esslite.wrapper;

import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegistrationWrapper {

	

	@NotBlank(message = FIRST_NAME_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_FIRSTNAME_REGEXP_CODE, message = EMPLOYEE_FIRSTNAME_REGEXP_MESSAGE)
	@Size(min=3, max = 35, message = EMPLOYEE_FIRSTNAME_LENGTH)
	private String firstName;

	@NotBlank(message = LAST_NAME_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_LASTNAME_REGEXP_CODE, message = EMPLOYEE_LASTNAME_REGEXP_MESSAGE)
	@Size(min=3,max = 35, message = EMPLOYEE_LASTNAME_LENGTH)
	private String lastName;

	
	@NotBlank(message = EMPLOYEE_EMAIL_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_EMAIL_REGEXP, message = EMPLOYEE_EMAIL_REGEXP_MESSAGE)
	private String email;

	@NotBlank(message = EMPLOYEE_MOBILENUMBER_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_MOBILENUMBER_REGEXP_CODE, message = EMPLOYEE_MOBILENUMBER_REGEXP_MESSAGE)
	private String primaryContactNo;

	@NotBlank(message = FORGOTPASSWORD_PASSWORD_REQUIRED)
	@Pattern(regexp =FORGOT_PASSWORD_REGEXP, message = FORGOTPASSWORD_PASSWORD_REGEXP_MESSAGE)
	@Size(max = 10, min = 8, message = FORGOTPASSWORD_PASSWORD_LENTGH)
	private String password;

	@NotBlank(message = EMPLOYEE_EDUCATION_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_EDUCATION_REGEXP_CODE, message = EMPLOYEE_EDUCATION_REGEXP_MESSAGE)
	@Size(max = 35, message = EMPLOYEE_EDUCATION_UNIT_LENGTH)
	private String education;

	
	@Pattern(regexp = EMPLOYEE_BATCHNAME_REGEXP, message = EMPLOYEE_BATCHNAME_REGEXP_MESSAGE)
	@Size(max = 25, message = EMPLOYEE_BATCHNAME_LENGTH)
	private String batchName;

	@Pattern(regexp = EMPLOYEE_JSPIDERS_NAME_REGEXP, message = EMPLOYEE_JSPIDERS_NAME_MESSAGE)
	@Size(max = 25, message = EMPLOYEE_JSPIDERS_NAME_LENGTH)
	private String jspidersBranch;

	@Pattern(regexp = EMPLOYEE_BUSINESS_UNIT_REGEXP, message = EMPLOYEE_BUSINESS_UNIT_MESSAGE)
	@Size(max = 25, message = EMPLOYEE_BUSINESS_UNIT_LENGTH)
	private String businessUnit;
	
	
	private String designation;
	

}
