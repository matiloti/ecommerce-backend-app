package com.matias.app.infrastructure.adapter.out.persistance.jpa;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matias.app.application.out.persistance.IPriceRepositoryPort;
import com.matias.app.domain.model.Price;
import com.matias.app.infrastructure.adapter.out.persistance.entity.PriceEntity;

@Repository
public class PriceJpaRepositoryAdapter implements IPriceRepositoryPort {

	private static final Logger logger = LoggerFactory.getLogger(PriceJpaRepositoryAdapter.class);

	@Autowired
	private PriceJpaRepository jpaPriceRepository;
		
	@Override
	public Optional<Price> getProductPriceByDate(Long brandId, Long productId, LocalDateTime date) {
		logger.debug("Querying product price by date with args: [brandId={}, productId={}, date={}]", brandId, productId, date);
		Optional<PriceEntity> priceOpt = this.jpaPriceRepository
				.getProductPriceByDate(brandId, productId, date);
		logger.debug("Query returned: {}", priceOpt.orElse(null));
		return priceOpt.map(p -> p.mapToDomain());
	}

}
