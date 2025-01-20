package com.matias.app.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
	private Long id;
	
	// Potentially relevant future data (like name, sku...)
	// Domain logic or validations here...
}
