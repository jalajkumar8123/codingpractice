package com.tyss.esslite.responses;

import java.util.List;

import com.tyss.esslite.dto.EmployeeEducationalDetails;

/**
 * This is a response class for Education page. Here you find all responses of
 * EssportalEducationalController for Education page.
 */

public class EssportalEducationalResponse {
	private boolean error;
	private String message;
	private List<EmployeeEducationalDetails> data;

	public EssportalEducationalResponse() {
	}

	public EssportalEducationalResponse(boolean error, String message, List<EmployeeEducationalDetails> data) {
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

	public List<EmployeeEducationalDetails> getData() {
		return data;
	}

	public void setData(List<EmployeeEducationalDetails> data) {
		this.data = data;
	}

}
