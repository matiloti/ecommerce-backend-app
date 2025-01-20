package com.matias.app.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Brand {
	private Long id;
	private String name;
	
	// Potentially relevant future data (like nif, accounts...)
	// Domain logic or validations here...
}
