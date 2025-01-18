package com.matias.app.infrastructure.adapter.in.rest.request;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPriceByDateRequest {
	private Integer brandId;
	private Integer productId;
	private LocalDateTime date;
}
