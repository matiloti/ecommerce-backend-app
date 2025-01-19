package com.matias.app.infrastructure.adapter.out.persistance.jpa;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.matias.app.infrastructure.adapter.out.persistance.entity.PriceEntity;
import com.matias.app.infrastructure.adapter.out.persistance.entity.pk.PriceEntityPk;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, PriceEntityPk> {
	
	/**
	 * Gets the top priority price for a product of a brand given a date.
	 * @param brandId The brand ID of the price
	 * @param productId The product ID of the price
	 * @param date The date in which the price applies
	 * @return Returns PriceEntity object.
	 */
	@Query("""
			SELECT p 
			FROM PriceEntity p 
			WHERE p.brandId = :brandId 
				AND p.productId = :productId 
				AND p.startDate <= :date 
				AND :date <= p.endDate 
			ORDER BY p.priority DESC
			LIMIT 1
			""")
	public Optional<PriceEntity> getProductPriceByDate(Long brandId, Long productId, LocalDateTime date);
}
