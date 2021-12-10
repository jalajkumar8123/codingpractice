package com.tyss.esslite.wrapper;

import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EMAIL_NOTEMPTY;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EMAIL_REGEXP;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EMAIL_REGEXP_MESSAGE;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempOtp {
	
	private int otp;
	
	@NotBlank(message = EMPLOYEE_EMAIL_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_EMAIL_REGEXP, message = EMPLOYEE_EMAIL_REGEXP_MESSAGE)
	private String mailId;

}
