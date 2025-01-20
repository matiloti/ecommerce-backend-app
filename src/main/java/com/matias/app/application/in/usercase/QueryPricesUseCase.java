package com.matias.app.application.in.usercase;

import java.util.List;
import java.util.Optional;

import com.matias.app.application.exception.ApplicationException;
import com.matias.app.application.exception.InfrastructureException;
import com.matias.app.application.in.dto.request.ProductPriceByDateRequestDTO;
import com.matias.app.application.in.dto.response.ProductPriceByDateResponseDTO;
import com.matias.app.application.out.persistance.IPriceRepositoryPort;
import com.matias.app.domain.exception.DomainException;
import com.matias.app.domain.model.Price;
import com.matias.app.domain.service.IPriceService;

public class QueryPricesUseCase implements IQueryPricesUseCase {

	private IPriceRepositoryPort priceRepository;
	private IPriceService priceService;
	
	public QueryPricesUseCase(IPriceRepositoryPort priceRepository, IPriceService priceService) {
		this.priceRepository = priceRepository;
		this.priceService = priceService;
	}
	
	@Override
	public Optional<ProductPriceByDateResponseDTO> 
		getProductPriceByDate(ProductPriceByDateRequestDTO request) 
			throws ApplicationException, InfrastructureException {
		List<Price> prices;
		try {
			// Query prices for a product of a brand in a given date
			prices = this.priceRepository
					.findProductPriceByDate(request.getBrandId(), request.getProductId(), request.getDate());
		} catch (Exception e) {
			throw new InfrastructureException("An error ocurred querying getProductPriceByDate", e);
		}
		
		try {
			// Return the response with the correct price
			return priceService
					.getTopPriorityPrice(prices) // Price service handles price selection
					.map(ProductPriceByDateResponseDTO::mapFromDomain); // Maps Price to a ProductPriceByDateResponseDTO
		} catch (DomainException e) {
			throw new ApplicationException(e.getMessage(), e);
		}
	}

}
