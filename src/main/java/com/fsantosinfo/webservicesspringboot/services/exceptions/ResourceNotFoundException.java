package com.fsantosinfo.webservicesspringboot.services.exceptions;

// This is a custom exception class

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. id " + id);
	}

}
