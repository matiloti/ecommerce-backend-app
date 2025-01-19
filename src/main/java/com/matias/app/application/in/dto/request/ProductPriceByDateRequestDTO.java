package com.matias.app.application.in.dto.request;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPriceByDateRequestDTO {
	private Long brandId;
	private Long productId;
	private LocalDateTime date;
}
