package com.matias.app.application.in;

import com.matias.app.application.in.dto.request.ProductPriceByDateRequestDTO;
import com.matias.app.application.in.dto.response.ProductPriceByDateResponseDTO;
import com.matias.app.application.out.PriceRepositoryPort;

public class PriceServiceImpl implements PriceService {

	private PriceRepositoryPort priceRepository;
	
	public PriceServiceImpl(PriceRepositoryPort priceRepository) {
		this.priceRepository = priceRepository;
	}
	
	@Override
	public ProductPriceByDateResponseDTO getPriceForProductByDate(ProductPriceByDateRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

}
