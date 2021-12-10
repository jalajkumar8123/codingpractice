package com.tyss.esslite.validation;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tyss.esslite.responses.ValidationResponse;

/**
 * 
 * This class is used for validation in dto level for all the entity
 *
 */
@RestControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {
	/**
	 * This is a get method which is used to handle MethodArgumentNotValidException
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fileldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fileldName, message);
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	/**
	 * This is a get method which is used to handle the ConstraintViolationException
	 * 
	 * @param e
	 * @return ValidationResponse
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationResponse handleValidationException(ConstraintViolationException e) {
		ValidationResponse validationResponse = new ValidationResponse();
		validationResponse.setError(true);
		StringBuilder bld = new StringBuilder();
		for (ConstraintViolation<?> s : e.getConstraintViolations()) {
			bld.append(s.getMessageTemplate());
		}
		validationResponse.setMessage(bld.toString());
		return validationResponse;
	}

}// End of the class
