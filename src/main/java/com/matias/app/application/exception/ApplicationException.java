package com.matias.app.application.exception;

/**
 * Exception thrown when an application layer error occurs.
 * 
 * This exceptions messages can be returned to the client.
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {
	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
