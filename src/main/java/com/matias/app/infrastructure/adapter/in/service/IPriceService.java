package com.matias.app.infrastructure.adapter.in.service;

import java.util.Optional;

import com.matias.app.application.exception.ApplicationException;
import com.matias.app.application.exception.InfrastructureException;
import com.matias.app.infrastructure.adapter.in.rest.request.ProductPriceByDateRequest;
import com.matias.app.infrastructure.adapter.in.rest.response.ProductPriceByDateResponse;

public interface IPriceService {
	/**
	 * Gets, from the application layer, the top priority price for a product of a brand given a date.
	 * @param request A ProductPriceByDateRequest object
	 * @return A ProductPriceByDateResponse optional object
	 * @throws ApplicationException
	 * @throws InfrastructureException
	 */
	public Optional<ProductPriceByDateResponse> 
		getPriceForProductByDate(ProductPriceByDateRequest request)
				throws ApplicationException, InfrastructureException;
}
