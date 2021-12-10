package com.tyss.esslite.responses;
import java.util.List;

import com.tyss.esslite.dto.EmployeeProjectDetails;


/**
 *This is a response class for Project details page.
 * Here you find all responses of EssportalProjectDetailsController for
 * Project page. 
 */

public class EssportalProjectDetailsResponse {

	private boolean error;
	private String message;
	private List<EmployeeProjectDetails> data;
	
	
	public EssportalProjectDetailsResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public EssportalProjectDetailsResponse(boolean error, String message,
			List<EmployeeProjectDetails> data) {
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
	public List<EmployeeProjectDetails> getData() {
		return data;
	}
	public void setData(List<EmployeeProjectDetails> data) {
		this.data = data;
	}
}
