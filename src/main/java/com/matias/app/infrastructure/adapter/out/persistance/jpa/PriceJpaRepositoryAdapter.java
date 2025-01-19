package com.matias.app.infrastructure.adapter.out.persistance.jpa;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matias.app.application.out.persistance.IPriceRepositoryPort;
import com.matias.app.domain.model.Price;

@Repository
public class PriceJpaRepositoryAdapter implements IPriceRepositoryPort {
	
	@Autowired
	private PriceJpaRepository jpaPriceRepository;
		
	@Override
	public Optional<Price> getProductPriceByDate(Long brandId, Long productId, LocalDateTime date) {
		return this.jpaPriceRepository
				.getProductPriceByDate(brandId, productId, date)
				.map(p -> p.mapToDomain());
	}

}
