package com.tyss.esslite.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * This is a JwtResponse class which gives as a response in this format
 * 
 * @author TYSS
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 6395826843556001826L;

	private boolean error;
	private String message;
	private String employeeId;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	
	

}// end of class
