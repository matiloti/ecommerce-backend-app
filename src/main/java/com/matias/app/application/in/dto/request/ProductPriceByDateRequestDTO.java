package com.matias.app.application.in.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductPriceByDateRequestDTO {
	private Integer brandId;
	private Integer productId;
	private LocalDateTime date;
}
