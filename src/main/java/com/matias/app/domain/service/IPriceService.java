package com.matias.app.domain.service;

import java.util.List;
import java.util.Optional;

import com.matias.app.domain.exception.DomainException;
import com.matias.app.domain.model.Price;

public interface IPriceService {
	public Optional<Price> getTopPriorityPrice(List<Price> prices) throws DomainException;
}
