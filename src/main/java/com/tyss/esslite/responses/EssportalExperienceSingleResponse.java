package com.tyss.esslite.responses;

import com.tyss.esslite.dto.EmployeeExperienceDetails;

/**
 *This is a response class for Experience page.
 * Here you find all responses of EssportalExperienceController for
 * Experience page. 
 */

public class EssportalExperienceSingleResponse {
	private boolean error;
	private String message;
	private EmployeeExperienceDetails data;
	
	
	public EssportalExperienceSingleResponse() {
		// TODO Auto-generated constructor stub
	}

	public EssportalExperienceSingleResponse(boolean error, String message, EmployeeExperienceDetails data) {
		super();
		this.error = error;
		this.message = message;
		this.data = data;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EmployeeExperienceDetails getData() {
		return data;
	}

	public void setData(EmployeeExperienceDetails data) {
		this.data = data;
	}
}
