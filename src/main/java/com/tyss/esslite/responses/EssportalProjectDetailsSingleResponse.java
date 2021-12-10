package com.tyss.esslite.responses;


import com.tyss.esslite.dto.EmployeeProjectDetails;

/**
 *This is a response class for Project details page.
 * Here you find all responses of EssportalProjectDetailsController for
 * Project page.
 */

public class EssportalProjectDetailsSingleResponse {

	private boolean error;
	private String message;
	private EmployeeProjectDetails data;
	
	public EssportalProjectDetailsSingleResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public EssportalProjectDetailsSingleResponse(boolean error, String message,
			EmployeeProjectDetails data) {
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

	public EmployeeProjectDetails getData() {
		return data;
	}

	public void setData(EmployeeProjectDetails data) {
		this.data = data;
	}

	
	

}
