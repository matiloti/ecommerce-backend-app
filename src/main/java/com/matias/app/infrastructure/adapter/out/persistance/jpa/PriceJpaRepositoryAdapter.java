package com.matias.app.infrastructure.adapter.out.persistance.jpa;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matias.app.application.out.PriceRepositoryPort;
import com.matias.app.domain.model.Price;

@Repository
public class PriceJpaRepositoryAdapter implements PriceRepositoryPort {
	
	@Autowired
	private PriceJpaRepository jpaPriceRepository;
	
	@Override
	public Price getPriceForProductByDate(Integer brandId, Integer productId, LocalDateTime date) {
		// TODO Auto-generated method stub
		return null;
	}

}
