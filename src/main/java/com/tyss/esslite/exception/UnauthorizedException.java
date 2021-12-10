package com.tyss.esslite.exception;
/**
 * This is a UnauthorizedException class which occurs when we performing
 * the services on supplier
 * 
 * @author TYSS
 *
 */
public class UnauthorizedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4250011375376349965L;
	
	public UnauthorizedException(String message) {
		super(message);
	}

}//End of class
