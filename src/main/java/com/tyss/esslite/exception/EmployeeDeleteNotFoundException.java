package com.tyss.esslite.exception;

public class EmployeeDeleteNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3777170068607543189L;

	/**
	 * This is a Constructor   
	 * @param message 
	 */
	public EmployeeDeleteNotFoundException(String message) {
        super(message);
    }
}
