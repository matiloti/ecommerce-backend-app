package com.matias.app.application.in.dto.response;

import java.time.LocalDateTime;

import com.matias.app.domain.model.Price;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPriceByDateResponseDTO {
	private Long brandId;
	private Long productId;
	private Long priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double price;
	
	/**
	 * Map a Price object from domain layer into a ProductPriceByDateResponseDTO
	 * from application layer.
	 * @param price The price from the domain layer to map
	 * @return The object mapped to a response of application layer
	 */
	public static ProductPriceByDateResponseDTO mapFromDomain(Price price) {
		return ProductPriceByDateResponseDTO.builder()
				.brandId(price.getBrand() == null ? null : price.getBrand().getId())
				.productId(price.getProduct() == null ? null : price.getProduct().getId())
				.priceList(price.getPriceList() == null ? null : price.getPriceList().getId())
				.startDate(price.getStartDate())
				.endDate(price.getEndDate())
				.price(price.getPrice()).build();
	}
}
