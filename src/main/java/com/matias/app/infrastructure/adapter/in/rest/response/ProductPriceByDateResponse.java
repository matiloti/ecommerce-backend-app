package com.matias.app.infrastructure.adapter.in.rest.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPriceByDateResponse {
	private Integer brandId;
	private Integer productId;
	private Integer priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double price;
}
