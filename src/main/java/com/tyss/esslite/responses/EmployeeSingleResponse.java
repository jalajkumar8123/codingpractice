package com.tyss.esslite.responses;

import com.tyss.esslite.dto.EmployeePersonalDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * This is a response class for Personal details page. Here you find all
 * responses of EmployeePersonalDetailsController for Personal details page.
 */
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSingleResponse {

	private boolean error;
	private String message;
	private EmployeePersonalDetails data;

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

	public EmployeePersonalDetails getData() {
		return data;
	}

	public void setData(EmployeePersonalDetails data) {
		this.data = data;
	}

}
