package com.matias.app.application.out;

import java.time.LocalDateTime;

import com.matias.app.domain.model.Price;

public interface PriceRepositoryPort {
	/**
	 * Gets the top priority price for a product of a brand given a date.
	 * @param brandId The brand ID of the price
	 * @param productId The product ID of the price
	 * @param date The date in which the price applies
	 * @return Returns {@code product.productId} , {@code startDate}, {@code endDate}, 
	 * {@code priceList.id} and {@code price} fields of the {@code Price} object.
	 */
	public Price getPriceForProductByDate(Integer brandId, Integer productId, LocalDateTime date);
}
