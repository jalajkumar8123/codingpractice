package com.tyss.esslite.responses;

import com.tyss.esslite.dto.EmployeeRegistration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegistrationResponse {
	
	private boolean error;
	private String message;
	private EmployeeRegistration data;

}
