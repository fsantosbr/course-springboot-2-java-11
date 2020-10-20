package com.fsantosinfo.webservicesspringboot.services.exceptions;

//This is a custom exception class for integrity violations

public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		super(msg);
	}
	
	

}
