package com.matias.app.domain.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.matias.app.domain.exception.DomainException;
import com.matias.app.domain.exception.DomainExceptionEnum;
import com.matias.app.domain.model.Price;

public class PriceService implements IPriceService {

	@Override
	public Optional<Price> getTopPriorityPrice(List<Price> prices) throws DomainException {
		// If null, return empty optional
		if(prices == null) return Optional.empty();
		
		// Get the top priority price from the list
		Optional<Price> maxPriceOpt = prices.stream().max(Comparator.comparing(Price::getPriority));
		
		/*
		 *  If list is not empty and returns a max value, check there are no more 
		 *  items with that max value.
		 *  
		 *  In other words, check if this is the unique top priority price as there 
		 *  could, wrongly, be more prices with the same priority.
		 *  
		 *  This is done because we cannot trust that the external infrastructure handles
		 *  this restriction correctly.
		 */
		if(maxPriceOpt.isPresent()) {
			// Count number of prices with the same max priority
			int numberOfPricesWithSamePriority = prices.stream()
					.filter(price -> price.getPriority() == maxPriceOpt.get().getPriority())
					.toList()
					.size();
			
			// If there is more than one, error
			if(numberOfPricesWithSamePriority > 1) {
				throw DomainExceptionEnum.MULTIPLE_PRICES_WITH_SAME_PRIORITY.getException();
			}
		}
		
		// If everything correct, return the price with the max priority value
		return maxPriceOpt;
	}
	
}
