package com.matias.app.test.infrastructure.in.rest;

import java.time.format.DateTimeFormatter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.matias.app.infrastructure.adapter.in.rest.request.ProductPriceByDateRequest;
import com.matias.app.infrastructure.adapter.in.rest.response.ProductPriceByDateResponse;
import com.matias.app.test.infrastructure.in.rest.provider.ProductPriceByDateArgumentsProvider;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	/**
	 * This test verifies the correctness of the PriceController.getProductPriceByDate method.
	 * 
	 * To do so, it performs and validates a rest request to the controller using MockMvc.
	 * 
	 * Using {@code @ParameterizedTest} and leveraging {@code @ArgumentsSource} avoids repeating code.
	 * 
	 * @param request The request to test coming from ProductPriceByDateArgumentsProvider class
	 * @param expectedResponse The expected response for this rest coming from ProductPriceByDateArgumentsProvider class
	 */
	@ParameterizedTest
	@ArgumentsSource(ProductPriceByDateArgumentsProvider.class)
	public void testGetProductPriceByDate_mockRestRequest(
			ProductPriceByDateRequest request, 
			ProductPriceByDateResponse expectedResponse
		) throws Exception {
		
		// Using MockMvc to perform a test rest request to the controller
		mockMvc.perform(MockMvcRequestBuilders
				.get("/prices/getProductPriceByDate")
				.accept(MediaType.APPLICATION_JSON)
				.param("brandId", request.getBrandId().toString())
				.param("productId", request.getProductId().toString())
				.param("date", request.getDate().toString()))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(expectedResponse.getBrandId().toString()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(expectedResponse.getProductId().toString()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value(expectedResponse.getStartDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value(expectedResponse.getEndDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(expectedResponse.getPriceList().toString()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(expectedResponse.getPrice().toString()));
	}
	
}
