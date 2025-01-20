package com.matias.app.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceList {
	private Long id;
	
	// Potentially relevant future data (like percentage, creationDate...)
	// Domain logic or validations here...
}
