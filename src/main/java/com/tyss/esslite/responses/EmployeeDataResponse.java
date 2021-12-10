package com.tyss.esslite.responses;

import com.tyss.esslite.dto.EmployeeResumeData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *This is a response class for Employee Data [Resume] page.
 * Here you find all responses of EssportalResumeDataController for
 * Employee Data [Resume] page.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDataResponse {
	
	private boolean error;
	private String message;

	private EmployeeResumeData data;

}
