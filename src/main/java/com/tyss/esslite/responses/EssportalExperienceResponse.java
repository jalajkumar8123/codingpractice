package com.tyss.esslite.responses;

import java.util.List;

import com.tyss.esslite.dto.EmployeeExperienceDetails;

/**
 * This is a response class for Acheivement details page. Here you find all
 * responses of EssportalAcheivementController for Acheivement page.
 */

public class EssportalExperienceResponse {
	private boolean error;
	private String message;
	private List<EmployeeExperienceDetails> data;

	public EssportalExperienceResponse() {
	}

	public EssportalExperienceResponse(boolean error, String message, List<EmployeeExperienceDetails> data) {
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

	public List<EmployeeExperienceDetails> getData() {
		return data;
	}

	public void setData(List<EmployeeExperienceDetails> data) {
		this.data = data;
	}
}
