package com.matias.app.infrastructure.adapter.out.persistance.entity;

import java.time.LocalDateTime;

import com.matias.app.infrastructure.adapter.out.persistance.entity.pk.PriceEntityPk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * We could declare this class with references to classes like BrandEntity, ProductEntity, etc.
 * However, we only require this data from the repository. So, to avoid
 * fetching unnecessary data we only declare the required fields.
 */
@Entity
@Table(name = "price")
@IdClass(PriceEntityPk.class)
@Data
public class PriceEntity {

	@Id
	private Long brandId;

	@Id
	private Long productId;

	@Id
	private LocalDateTime startDate;

	@Id
	private LocalDateTime endDate;

	@Id
	private Integer priority;
	
	private Integer priceList;
	private Double price;
}
