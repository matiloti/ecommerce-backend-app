package com.matias.app.domain.exception;

@SuppressWarnings("serial")
public class DomainException extends Exception {
	public DomainException(String message) {
		super(message);
	}
	
	public DomainException(String message, Throwable cause) {
		super(message, cause);
	}
}
