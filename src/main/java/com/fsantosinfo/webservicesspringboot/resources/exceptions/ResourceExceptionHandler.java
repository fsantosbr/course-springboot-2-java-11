package com.fsantosinfo.webservicesspringboot.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fsantosinfo.webservicesspringboot.services.exceptions.DatabaseException;
import com.fsantosinfo.webservicesspringboot.services.exceptions.ResourceNotFoundException;

// This class will treat manually the errors

@ControllerAdvice // This annotation will intercept any error in order to this object (class) makes any possible treatment
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) //This annotation will catch any exception of type 'ResourceNotFoundException' and provide the treatment inside of this method
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	
	@ExceptionHandler(DatabaseException.class) //This annotation will catch any exception of type 'DatabaseException' and provide the treatment inside of this method
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
