package com.matias.app.domain.model;

import lombok.Data;

@Data
public class Brand {
	private Long id;
	private String name;
	
	// Potentially relevant future data (like nif, accounts...) or domain model validations...
}
