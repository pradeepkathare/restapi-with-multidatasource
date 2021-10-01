package com.restapi.customexceptions;

public class CustomException extends Exception {

	private String statusCode;
	private String description;
	private Throwable cause;
	
	
	public CustomException(String statuscode,String description,Throwable cause) {
		
		this.statusCode=statuscode;
		this.description=description;
		this.cause=cause;
	}
}
