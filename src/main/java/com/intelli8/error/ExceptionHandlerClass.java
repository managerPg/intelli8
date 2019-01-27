package com.intelli8.error;

/*
* @author G V Kushal 
*/
import java.util.Date;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler
	private ResponseEntity<CustomError> handleException(NoVacancyException exc) {

		CustomError error = new CustomError();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(new Date());
		return new ResponseEntity<CustomError>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	private ResponseEntity<CustomError> handleException(HibernateException exc) {
		CustomError error = new CustomError();
		error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(new Date());
		return new ResponseEntity<CustomError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	private ResponseEntity<CustomError> handleException(UserNotFoundException exc) {
		CustomError error = new CustomError();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(new Date());
		return new ResponseEntity<CustomError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	private ResponseEntity<CustomError> handleException(Exception exc) {
		CustomError error = new CustomError();
		error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(new Date());
		return new ResponseEntity<CustomError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
