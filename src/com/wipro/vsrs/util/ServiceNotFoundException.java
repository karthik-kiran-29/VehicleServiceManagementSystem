package com.wipro.vsrs.util;

public class ServiceNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ServiceNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
}
