package com.tyss.esslite.exception;

public class EmployeeUpdateNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6439058393339896296L;

	/**
	 * This is a Constructor   
	 * @param message 
	 */
	public EmployeeUpdateNotFoundException(String message) {
		super(message);
	}
}
