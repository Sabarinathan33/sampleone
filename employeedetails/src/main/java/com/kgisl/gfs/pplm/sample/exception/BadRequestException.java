package com.kgisl.gfs.pplm.sample.exception;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 7586435916766893455L;

	
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}
	
}
