package com.matias.app.infrastructure.adapter.out.persistance.jpa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matias.app.infrastructure.adapter.out.persistance.entity.PriceEntity;
import com.matias.app.infrastructure.adapter.out.persistance.entity.pk.PriceEntityPk;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, PriceEntityPk> {
	
	/**
	 * Find prices for a product of a brand in a given date.
	 * @param brandId The brand ID of the price
	 * @param productId The product ID of the price
	 * @param date The date in which the price applies
	 * @return Returns a list of PriceEntity objects.
	 */
	@Query("""
			SELECT p 
			FROM PriceEntity p 
			WHERE p.brandId = :brandId 
				AND p.productId = :productId 
				AND p.startDate <= :date 
				AND :date <= p.endDate 
			""")
	public List<PriceEntity> findProductPriceByDate(Long brandId, Long productId, LocalDateTime date);
}
