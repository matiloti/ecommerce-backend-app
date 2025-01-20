package com.matias.app.application.exception;

/**
 * Exception thrown when an infrastructure layer error occurs.
 * 
 * This exceptions messages cannot be returned to the client.
 */
@SuppressWarnings("serial")
public class InfrastructureException extends Exception {
	public InfrastructureException(String message) {
		super(message);
	}
	
	public InfrastructureException(String message, Throwable cause) {
		super(message, cause);
	}
}
