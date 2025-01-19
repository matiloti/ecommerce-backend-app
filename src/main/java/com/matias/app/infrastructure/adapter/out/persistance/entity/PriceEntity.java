package com.matias.app.infrastructure.adapter.out.persistance.entity;

import java.time.LocalDateTime;

import com.matias.app.infrastructure.adapter.out.persistance.entity.pk.PriceEntityPk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * We could declare this class with references to classes like BrandEntity, ProductEntity, etc.
 * However, we only require this data from the repository and creating @ManyToOne relationships
 * would trigger Hibernate to fetch unnecessary data when accessing the brand and product IDs. 
 * 
 * So, to avoid fetching unnecessary data, we only declare the required fields (the IDs).
 */
@Entity
@Table(name = "PRICES")
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
	
	@NotNull
	private String currency;

	@NotNull
	private Integer priceList;

	@NotNull
	private Double price;
	
	private LocalDateTime lastUpdate;
	private String lastUpdateBy;
}
