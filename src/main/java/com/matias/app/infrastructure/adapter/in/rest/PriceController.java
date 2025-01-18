package com.matias.app.infrastructure.adapter.in.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.app.application.in.PriceService;
import com.matias.app.infrastructure.adapter.in.rest.request.ProductPriceByDateRequest;
import com.matias.app.infrastructure.adapter.in.rest.response.ProductPriceByDateResponse;

@RestController
@RequestMapping("/prices")
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@GetMapping("/getProductPriceByDate")
	public ResponseEntity<ProductPriceByDateResponse> 
		getProductPriceByDate(ProductPriceByDateRequest request) {
		return null;
	}
}
