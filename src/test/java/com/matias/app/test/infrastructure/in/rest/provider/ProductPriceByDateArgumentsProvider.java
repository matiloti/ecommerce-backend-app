package com.matias.app.test.infrastructure.in.rest.provider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.matias.app.infrastructure.adapter.in.rest.request.ProductPriceByDateRequest;
import com.matias.app.infrastructure.adapter.in.rest.response.ProductPriceByDateResponse;
	
public class ProductPriceByDateArgumentsProvider implements ArgumentsProvider {

	final static Long BRAND_TEST_ID = Long.valueOf(1);
	final static Long PRODUCT_TEST_ID = Long.valueOf(35455);
	
	// This list contains all requests that are going to be tested
	final static List<Arguments> TEST_LIST = Stream.of(
			Arguments.of(
					ProductPriceByDateRequest.builder().brandId(BRAND_TEST_ID).productId(PRODUCT_TEST_ID).date(shortParse("2020-06-14T10:00:00")).build(),
					ProductPriceByDateResponse.builder().brandId(BRAND_TEST_ID).productId(PRODUCT_TEST_ID).startDate(shortParse("2020-06-14T00:00:00")).endDate(shortParse("2020-12-31T23:59:59")).priceList(Long.valueOf(1)).price(Double.valueOf(35.50)).build()
			),
			Arguments.of(
					ProductPriceByDateRequest.builder().brandId(BRAND_TEST_ID).productId(PRODUCT_TEST_ID).date(shortParse("2020-06-14T16:00:00")).build(),
					ProductPriceByDateResponse.builder().brandId(BRAND_TEST_ID).productId(PRODUCT_TEST_ID).startDate(shortParse("2020-06-14T15:00:00")).endDate(shortParse("2020-06-14T18:30:00")).priceList(Long.valueOf(2)).price(Double.valueOf(25.45)).build()
			),
			Arguments.of(
					ProductPriceByDateRequest.builder().brandId(BRAND_TEST_ID).productId(PRODUCT_TEST_ID).date(shortParse("2020-06-14T21:00:00")).build(),
					ProductPriceByDateResponse.builder().brandId(BRAND_TEST_ID).productId(PRODUCT_TEST_ID).startDate(shortParse("2020-06-14T00:00:00")).endDate(shortParse("2020-12-31T23:59:59")).priceList(Long.valueOf(1)).price(Double.valueOf(35.50)).build()
			),
			Arguments.of(
					ProductPriceByDateRequest.builder().brandId(BRAND_TEST_ID).productId(PRODUCT_TEST_ID).date(shortParse("2020-06-15T10:00:00")).build(),
					ProductPriceByDateResponse.builder().brandId(BRAND_TEST_ID).productId(PRODUCT_TEST_ID).startDate(shortParse("2020-06-15T00:00:00")).endDate(shortParse("2020-06-15T11:00:00")).priceList(Long.valueOf(3)).price(Double.valueOf(30.50)).build()
			),
			Arguments.of(
					ProductPriceByDateRequest.builder().brandId(BRAND_TEST_ID).productId(PRODUCT_TEST_ID).date(shortParse("2020-06-16T21:00:00")).build(),
					ProductPriceByDateResponse.builder().brandId(BRAND_TEST_ID).productId(PRODUCT_TEST_ID).startDate(shortParse("2020-06-15T16:00:00")).endDate(shortParse("2020-12-31T23:59:59")).priceList(Long.valueOf(4)).price(Double.valueOf(38.95)).build()
			)
		).toList();

	/**
	 * Shortcut function to parse a LocalDateTime to a DateTimeFormatter.ISO_LOCAL_DATE_TIME format
	 * @param dateStr The date string
	 * @return The parsed LocalDateTime with DateTimeFormatter.ISO_LOCAL_DATE_TIME format
	 */
	private static LocalDateTime shortParse(String dateStr) {
		return LocalDateTime.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}
	
	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return TEST_LIST.stream();
	}

}