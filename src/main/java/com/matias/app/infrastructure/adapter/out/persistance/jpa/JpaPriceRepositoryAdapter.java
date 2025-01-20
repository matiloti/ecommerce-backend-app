package com.matias.app.infrastructure.adapter.out.persistance.jpa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matias.app.application.out.persistance.IPriceRepositoryPort;
import com.matias.app.domain.model.Price;
import com.matias.app.infrastructure.adapter.out.persistance.entity.PriceEntity;

@Repository
public class JpaPriceRepositoryAdapter implements IPriceRepositoryPort {

	private static final Logger logger = LoggerFactory.getLogger(JpaPriceRepositoryAdapter.class);

	@Autowired
	private PriceJpaRepository jpaPriceRepository;
		
	@Override
	public List<Price> findProductPriceByDate(Long brandId, Long productId, LocalDateTime date) {
			logger.debug("Querying product price by date with args: [brandId={}, productId={}, date={}]", brandId, productId, date);
			List<PriceEntity> prices = this.jpaPriceRepository
					.findProductPriceByDate(brandId, productId, date);
			logger.debug("Query returned {} registries", prices.size());
			return prices.stream().map(p -> p.mapToDomain())
						.collect(Collectors.toList());
	}

}
