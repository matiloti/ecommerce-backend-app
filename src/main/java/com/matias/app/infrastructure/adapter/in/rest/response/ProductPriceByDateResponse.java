package com.matias.app.infrastructure.adapter.in.rest.response;

import java.time.LocalDateTime;

import com.matias.app.application.in.dto.response.ProductPriceByDateResponseDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPriceByDateResponse {
	private Long brandId;
	private Long productId;
	private Long priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double price;
	
	public static ProductPriceByDateResponse mapFromApplication(ProductPriceByDateResponseDTO response) {
		return ProductPriceByDateResponse.builder()
				.brandId(response.getBrandId())
				.productId(response.getProductId())
				.priceList(response.getPriceList())
				.startDate(response.getStartDate())
				.endDate(response.getEndDate())
				.price(response.getPrice()).build();
	}
}
