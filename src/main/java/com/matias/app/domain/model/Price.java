package com.matias.app.domain.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Price {
	private Brand brand;
	private Product product;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priority;
	private String currency;
	private PriceList priceList;
	private Double price;
}
