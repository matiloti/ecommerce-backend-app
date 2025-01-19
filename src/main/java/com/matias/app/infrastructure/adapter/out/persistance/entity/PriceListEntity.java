package com.matias.app.infrastructure.adapter.out.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "price_list")
@Data
public class PriceListEntity {
	@Id
	private Long id;
}
