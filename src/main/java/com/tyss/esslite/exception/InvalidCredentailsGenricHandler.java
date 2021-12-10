package com.tyss.esslite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.tyss.esslite.responses.EmployeeRegistrationResponse;

@RestControllerAdvice
public class InvalidCredentailsGenricHandler {

	@ExceptionHandler(value = InvalidCredentailException.class)
	public ResponseEntity<EmployeeRegistrationResponse> invalidCredentails(InvalidCredentailException exception) {
		EmployeeRegistrationResponse response = new EmployeeRegistrationResponse();
		response.setError(true);
		response.setMessage("Invalid credentials");
		response.setData(null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}// end of getDepartmentIdException()

	@ExceptionHandler(value = UnauthorizedException.class)
	public ResponseEntity<EmployeeRegistrationResponse> unathorizedException(UnauthorizedException exception) {
		EmployeeRegistrationResponse response = new EmployeeRegistrationResponse();
		response.setError(true);
		response.setMessage("user not found");
		response.setData(null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}// end of getDepartmentIdException()

}
