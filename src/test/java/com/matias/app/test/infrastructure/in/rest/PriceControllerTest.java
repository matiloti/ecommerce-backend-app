package com.matias.app.test.infrastructure.in.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.matias.app.infrastructure.adapter.in.rest.PriceController;
import com.matias.app.infrastructure.adapter.in.rest.request.ProductPriceByDateRequest;
import com.matias.app.infrastructure.adapter.in.rest.response.ProductPriceByDateResponse;
import com.matias.app.test.infrastructure.in.rest.provider.ProductPriceByDateArgumentsProvider;

@SpringBootTest
public class PriceControllerTest {

	@Autowired
	private PriceController priceRestController;
	
	// Using @ParameterizedTest and leveraging @ArgumentsSource avoids repeating code
	@ParameterizedTest
	@ArgumentsSource(ProductPriceByDateArgumentsProvider.class)
	public void testGetProductPriceByDate(ProductPriceByDateRequest request, ProductPriceByDateResponse expectedResponse) {
		// Controller call
		ResponseEntity<ProductPriceByDateResponse> response = this.priceRestController.getProductPriceByDate(request);
		
		// Assertions
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedResponse, response.getBody());
	}
	
}
