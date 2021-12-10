package com.tyss.esslite.dto;

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
public class ForgotPassword {
	

	private String employeeId;
	
	@NotBlank(message = EMPLOYEE_EMAIL_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_EMAIL_REGEXP, message = EMPLOYEE_EMAIL_REGEXP_MESSAGE)
	private String email;
	
	@NotBlank(message = FORGOTPASSWORD_PASSWORD_REQUIRED)
	@Pattern(regexp =FORGOT_PASSWORD_REGEXP, message = FORGOTPASSWORD_PASSWORD_REGEXP_MESSAGE)
	@Size(max = 10, min = 8, message = FORGOTPASSWORD_PASSWORD_LENTGH)
	private String password;
	
	

}
