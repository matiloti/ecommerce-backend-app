package com.matias.app.infrastructure.adapter.out.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "brands")
@Data
public class BrandEntity {
	@Id
	private Long id;
	private String name;
}
