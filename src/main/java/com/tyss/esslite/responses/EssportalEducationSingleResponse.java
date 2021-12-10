package com.tyss.esslite.responses;

import com.tyss.esslite.dto.EmployeeEducationalDetails;

/**
 *This is a response class for Education page.
 * Here you find all responses of EmployeeEducationalDetailsController for
 * Education page. 
 */

public class EssportalEducationSingleResponse {

private boolean error;
private String message;
private EmployeeEducationalDetails data;


/**
 * This is a Default Constructor
 */

public EssportalEducationSingleResponse() {

}

public EssportalEducationSingleResponse(boolean error, String message, EmployeeEducationalDetails data) {
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

public EmployeeEducationalDetails getData() {
	return data;
}

public void setData(EmployeeEducationalDetails data) {
	this.data = data;
}


}
