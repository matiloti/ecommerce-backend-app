package com.matias.app.infrastructure.adapter.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matias.app.application.in.usercase.IQueryPricesUseCase;
import com.matias.app.infrastructure.adapter.in.rest.request.ProductPriceByDateRequest;
import com.matias.app.infrastructure.adapter.in.rest.response.ProductPriceByDateResponse;

/**
 * Price service that groups user cases from application layer. 
 * 
 * </br>
 * </br>
 * 
 * Also, it allows operations to have the {@code @Transactional} tag if necessary
 * (application layer is Spring-agnostic, so it would not be able to add
 * transactional functionalities).
 */
@Service
public class PriceService implements IPriceService {
	
	@Autowired
	IQueryPricesUseCase queryPricesUseCase;
	
	public ProductPriceByDateResponse getPriceForProductByDate(ProductPriceByDateRequest request) {
		return null;
	}
	
	// Future services which may implement @Transactional annotation...
}
