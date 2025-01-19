package com.matias.app.infrastructure.adapter.out.persistance.entity.pk;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class PriceEntityPk implements Serializable {
	private Long brandId;
	private Long productId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priority;
}
