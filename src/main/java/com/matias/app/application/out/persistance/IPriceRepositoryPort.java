package com.matias.app.application.out.persistance;

import java.time.LocalDateTime;
import java.util.List;

import com.matias.app.domain.model.Price;

public interface IPriceRepositoryPort {
	/**
	 * Gets prices for a product of a brand in given a date.
	 * @param brandId The brand ID of the price
	 * @param productId The product ID of the price
	 * @param date The date in which the price applies
	 * @return Returns a list of {@code Price} objects with {@code product.productId}, 
	 * {@code startDate}, {@code endDate}, {@code priceList.id} and {@code price} fields
	 */
	public List<Price> findProductPriceByDate(Long brandId, Long productId, LocalDateTime date);
}
