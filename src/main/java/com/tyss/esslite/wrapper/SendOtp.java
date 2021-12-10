package com.tyss.esslite.wrapper;

import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EMAIL_NOTEMPTY;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EMAIL_REGEXP;
import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.EMPLOYEE_EMAIL_REGEXP_MESSAGE;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SendOtp {

	@NotBlank(message = EMPLOYEE_EMAIL_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_EMAIL_REGEXP, message = EMPLOYEE_EMAIL_REGEXP_MESSAGE)
	private String mailId;
	
	private int otp;
	
	
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	@JsonIgnore
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	
	
}
