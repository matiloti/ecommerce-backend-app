package com.matias.app.infrastructure.adapter.in.rest.request;

import java.time.LocalDateTime;

import com.matias.app.application.in.dto.request.ProductPriceByDateRequestDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPriceByDateRequest {
	
	@NotNull
	private Long brandId;

	@NotNull
	private Long productId;

	@NotNull
	private LocalDateTime date;
	
	public ProductPriceByDateRequestDTO mapToApplication() {
		return ProductPriceByDateRequestDTO.builder()
				.brandId(brandId)
				.productId(productId)
				.date(date).build();
	}
}
