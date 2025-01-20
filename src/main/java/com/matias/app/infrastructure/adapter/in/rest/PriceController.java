package com.matias.app.infrastructure.adapter.in.rest;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.app.application.exception.ApplicationException;
import com.matias.app.application.exception.InfrastructureException;
import com.matias.app.infrastructure.adapter.in.rest.request.ProductPriceByDateRequest;
import com.matias.app.infrastructure.adapter.in.rest.response.ErrorResponse;
import com.matias.app.infrastructure.adapter.in.rest.response.ProductPriceByDateResponse;
import com.matias.app.infrastructure.adapter.in.service.IPriceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prices")
public class PriceController {

	private static final Logger logger = LoggerFactory.getLogger(PriceController.class);

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
	@GetMapping
	public ResponseEntity<?> 
		getProductPriceByDate(@Valid ProductPriceByDateRequest request) {
		try {
			// Get price from service
			Optional<ProductPriceByDateResponse> optResponse = this.priceService.getPriceForProductByDate(request);
			
			// If no results, 404
			if(optResponse.isEmpty()) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body(new ErrorResponse("No results found"));
			}
			
			// If results, 200 and return them
			return optResponse.map(ResponseEntity::ok).get();
		} catch(ApplicationException e) {
			logger.error("An application error ocurred");
			logger.error("Error: {}", e.getMessage());
			if(e.getCause() != null) logger.debug("Cause: {}", e.getCause().getMessage());
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ErrorResponse(e.getMessage()));
		} catch(InfrastructureException e) {
			logger.error("An infrastructure error ocurred");
			logger.error("Error: {}", e.getMessage());
			if(e.getCause() != null) logger.debug("Cause: {}", e.getCause().getMessage());
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorResponse("A system error ocurred")); // Masking the internal system error to the client
		} catch(Exception e) {
			logger.error("An uncontrolled error ocurred");
			logger.error("Error: {}", e.getMessage());
			if(e.getCause() != null) logger.debug("Cause: {}", e.getCause().getMessage());
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorResponse("A system error ocurred")); // Masking the internal system error to the client
		}
	}
}
