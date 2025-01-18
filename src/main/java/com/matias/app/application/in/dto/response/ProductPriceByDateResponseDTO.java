package com.matias.app.application.in.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductPriceByDateResponseDTO {
	private Integer brandId;
	private Integer productId;
	private Integer priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double price;
}
