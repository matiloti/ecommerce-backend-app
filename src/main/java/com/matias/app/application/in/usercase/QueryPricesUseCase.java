package com.matias.app.application.in.usercase;

import java.util.Optional;

import com.matias.app.application.in.dto.request.ProductPriceByDateRequestDTO;
import com.matias.app.application.in.dto.response.ProductPriceByDateResponseDTO;
import com.matias.app.application.out.persistance.IPriceRepositoryPort;
import com.matias.app.domain.model.Price;

public class QueryPricesUseCase implements IQueryPricesUseCase {

	private IPriceRepositoryPort priceRepository;
	
	public QueryPricesUseCase(IPriceRepositoryPort priceRepository) {
		this.priceRepository = priceRepository;
	}
	
	@Override
	public Optional<ProductPriceByDateResponseDTO> getProductPriceByDate(ProductPriceByDateRequestDTO request) {
		Optional<Price> priceOpt = this.priceRepository.getProductPriceByDate(request.getBrandId(), request.getProductId(), request.getDate());
		return priceOpt.map(ProductPriceByDateResponseDTO::mapFromDomain);
	}

}
