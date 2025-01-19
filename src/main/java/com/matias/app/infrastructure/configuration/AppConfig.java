package com.matias.app.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.matias.app.application.in.usercase.IQueryPricesUseCase;
import com.matias.app.application.in.usercase.QueryPricesUseCase;
import com.matias.app.application.out.persistance.IPriceRepositoryPort;

/**
 * This class configures the system.
 * 
 * Application layer is infrastructure-agnostic (thus, Spring-agnostic too), so it needs
 * the infrastructure layer to create it's beans and inject the required collaborators 
 * (bean dependencies) into them for other beans to use them.
 * 
 * For example, PriceController (a bean from the infrastructure layer) uses PriceService 
 * (not a bean from application layer). Thus, here we declare the priceService bean for 
 * the PriceController to use it. Also, priceService requires the priceRepository collaborator, 
 * so its injected too (a PriceRepositoryPort bean already exists in the IoC container, 
 * so its @Autowired into a field directly).
 */
@Configuration
public class AppConfig {
	
	@Autowired
	private IPriceRepositoryPort priceRepository;
	
	@Bean
	public IQueryPricesUseCase queryPricesUseCase() {
		return new QueryPricesUseCase(this.priceRepository);
	}
	
}
