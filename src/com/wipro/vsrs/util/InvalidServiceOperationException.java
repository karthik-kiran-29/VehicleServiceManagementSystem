package com.wipro.vsrs.util;

public class InvalidServiceOperationException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidServiceOperationException(String message,Throwable cause) {
		super(message,cause);
	}
}
