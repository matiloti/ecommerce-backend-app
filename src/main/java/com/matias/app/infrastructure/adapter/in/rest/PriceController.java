package com.matias.app.infrastructure.adapter.in.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.app.infrastructure.adapter.in.rest.request.ProductPriceByDateRequest;
import com.matias.app.infrastructure.adapter.in.rest.response.ProductPriceByDateResponse;
import com.matias.app.infrastructure.adapter.in.service.IPriceService;
import com.matias.app.infrastructure.adapter.out.persistance.jpa.JpaPriceRepositoryAdapter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prices")
public class PriceController {

	private static final Logger logger = LoggerFactory.getLogger(JpaPriceRepositoryAdapter.class);

	/**
	 * Controller depends on a Spring service bean in the infrastructure layer
	 * (for potentially future {@code @Transactional} functionality), which at 
	 * the same time it depends on the application layer respective user cases.
	 */
	@Autowired
	private IPriceService priceService;
	
	/**
	 * Gets the top priority price for a product of a brand given a date.
	 * @param request A ProductPriceByDateRequest object
	 * @return The ProductPriceByDateResponse wrapped in ResponseEntity object
	 */
	@GetMapping("/getProductPriceByDate")
	public ResponseEntity<ProductPriceByDateResponse> 
		getProductPriceByDate(@Valid ProductPriceByDateRequest request) {
		try {
			return this.priceService.getPriceForProductByDate(request)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.noContent().build());
		} catch(Exception e) {
			logger.info("An uncontrolled error ocurred");
			logger.error("Error: {}", e.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}
}
