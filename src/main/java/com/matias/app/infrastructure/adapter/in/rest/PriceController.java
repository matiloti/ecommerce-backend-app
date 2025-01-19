package com.matias.app.infrastructure.adapter.in.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.app.infrastructure.adapter.in.rest.request.ProductPriceByDateRequest;
import com.matias.app.infrastructure.adapter.in.rest.response.ProductPriceByDateResponse;
import com.matias.app.infrastructure.adapter.in.service.IPriceService;

@RestController
@RequestMapping("/prices")
public class PriceController {

	/**
	 * Controller depends on a Spring service bean (for potentially future 
	 * {@code @Transactional} functionality), which at the same time it depends 
	 * on the application layer respective user cases.
	 */
	@Autowired
	private IPriceService priceService;
	
	@GetMapping("/getProductPriceByDate")
	public ResponseEntity<ProductPriceByDateResponse> 
		getProductPriceByDate(ProductPriceByDateRequest request) {
		return null;
	}
}
