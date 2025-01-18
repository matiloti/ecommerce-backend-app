package com.matias.app.application.in;

import com.matias.app.application.in.dto.request.ProductPriceByDateRequestDTO;
import com.matias.app.application.in.dto.response.ProductPriceByDateResponseDTO;

public interface PriceService {
	/**
	 * Gets the top priority price for a product of a brand given a date.
	 * @param request A GetPriceForProductByDateRequestDTO with the productId, brandId and a date.
	 * @return A GetPriceForProductByDateResponseDTO response object containing the product ID, brand ID, final price, fee, and dates in which this price applies.
	 */
	public ProductPriceByDateResponseDTO getPriceForProductByDate(ProductPriceByDateRequestDTO request);
}
