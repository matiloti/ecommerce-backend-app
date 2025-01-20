package com.matias.app.domain.exception;

public enum DomainExceptionEnum {

	MULTIPLE_PRICES_WITH_SAME_PRIORITY("Two or more prices have the same priority for the same product, brand and dates");
	
	private String errorMsg;
	
	DomainExceptionEnum(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public DomainException getException() {
		return new DomainException(errorMsg);
	}
}
