package com.matias.app.application.in.usercase;

import java.util.Optional;

import com.matias.app.application.exception.ApplicationException;
import com.matias.app.application.exception.InfrastructureException;
import com.matias.app.application.in.dto.request.ProductPriceByDateRequestDTO;
import com.matias.app.application.in.dto.response.ProductPriceByDateResponseDTO;

public interface IQueryPricesUseCase {
	/**
	 * Gets the top priority price for a product of a brand given a date.
	 * @param request A ProductPriceByDateRequestDTO with the productId, brandId and a date.
	 * @return A ProductPriceByDateResponseDTO optional object containing the product ID, 
	 * brand ID, final price, fee, and dates in which this price applies.
	 * @throws ApplicationException
	 * @throws InfrastructureException
	 */
	public Optional<ProductPriceByDateResponseDTO> 
		getProductPriceByDate(ProductPriceByDateRequestDTO request) 
				throws ApplicationException, InfrastructureException;
}
