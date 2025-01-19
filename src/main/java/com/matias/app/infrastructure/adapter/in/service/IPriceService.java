package com.matias.app.infrastructure.adapter.in.service;

import com.matias.app.infrastructure.adapter.in.rest.request.ProductPriceByDateRequest;
import com.matias.app.infrastructure.adapter.in.rest.response.ProductPriceByDateResponse;

public interface IPriceService {
	/**
	 * Gets, from the application layer, the top priority price for a product of a brand given a date.
	 * @param request A ProductPriceByDateRequest object
	 * @return A ProductPriceByDateResponse object
	 */
	public ProductPriceByDateResponse getPriceForProductByDate(ProductPriceByDateRequest request);
}
