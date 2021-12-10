package com.tyss.esslite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tyss.esslite.responses.EmployeeSingleResponse;

@ControllerAdvice
public class GenericExceptionHandler {

	/**
	 * This Exception handling method is for DELETE method This is a response method
	 * for Controller
	 * 
	 * @param exception = This is used to specify EmployeeDeleteNotFoundException
	 * @return = It handles the exception and returns custom error message
	 */
	@ExceptionHandler(value = EmployeeDeleteNotFoundException.class)
	public ResponseEntity<EmployeeSingleResponse> deleteEmployeeIdException(EmployeeDeleteNotFoundException exception) {

		EmployeeSingleResponse response = new EmployeeSingleResponse();
		response.setError(true);
		response.setMessage(exception.getMessage());
		response.setData(null);
		return new ResponseEntity<EmployeeSingleResponse>(response, HttpStatus.NOT_FOUND);
	}

	/**
	 * This Exception handling method is for POST method This is a response method
	 * for EmployeeController
	 * 
	 * @param exception = This is used to specify EmployeeInsertNotFoundException
	 * @return = It handles the exception and returns custom error message
	 */
	@ExceptionHandler(value = EmployeeInsertNotFoundException.class)
	public ResponseEntity<EmployeeSingleResponse> addEmployeeIdException(EmployeeInsertNotFoundException exception) {

		EmployeeSingleResponse response = new EmployeeSingleResponse();
		response.setError(true);
		response.setMessage(exception.getMessage());
		response.setData(null);
		return new ResponseEntity<EmployeeSingleResponse>(response, HttpStatus.NOT_FOUND);
	}

	/**
	 * This Exception handling method is for PUT method. This is a response method
	 * for EmployeeController
	 * 
	 * @param exception = This is used to specify EmployeePersonalNotFoundException
	 * @return = It handles the exception and returns custom error message
	 */
	@ExceptionHandler(value = EmployeeUpdateNotFoundException.class)
	public ResponseEntity<EmployeeSingleResponse> updateEmployeeIdException(EmployeeUpdateNotFoundException exception) {

		EmployeeSingleResponse response = new EmployeeSingleResponse();
		response.setError(true);
		response.setMessage(exception.getMessage());
		response.setData(null);
		return new ResponseEntity<EmployeeSingleResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MultipartFileIsEmptyException.class)
	public ResponseEntity<EmployeeSingleResponse> multipartFileException(MultipartFileIsEmptyException exception) {

		EmployeeSingleResponse response = new EmployeeSingleResponse();
		response.setError(true);
		response.setMessage(exception.getMessage());
		response.setData(null);
		return new ResponseEntity<EmployeeSingleResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EmployeeCustomException.class)
	public ResponseEntity<EmployeeSingleResponse> customExceptionHandler(EmployeeCustomException exception) {

		return new ResponseEntity<>(new EmployeeSingleResponse(true, exception.getMessage(), null),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = CandidateStatusOnboardingNotFoundException.class)
	public ResponseEntity<EmployeeSingleResponse> statusNotFound(CandidateStatusOnboardingNotFoundException exception) {

		EmployeeSingleResponse response = new EmployeeSingleResponse();
		response.setError(true);
		response.setMessage(exception.getMessage());
		response.setData(null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
}
