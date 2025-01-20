package com.matias.app.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.matias.app.application.in.usercase.IQueryPricesUseCase;
import com.matias.app.application.in.usercase.QueryPricesUseCase;
import com.matias.app.application.out.persistance.IPriceRepositoryPort;
import com.matias.app.domain.service.IPriceService;
import com.matias.app.domain.service.PriceService;

/**
 * This class configures the system.
 * 
 * Application layer is infrastructure-agnostic (thus, Spring-agnostic too), so it needs
 * the infrastructure layer to create it's beans and inject the required collaborators 
 * (bean dependencies) into them for other beans to use them.
 * 
 * </br>
 * </br>
 * 
 * For example, {@code PriceService} (a bean from the infrastructure layer) uses {@code IQueryPricesUseCase} 
 * (not a bean from application layer). Thus, here we declare the {@code queryPricesUseCase} bean for 
 * the {@code PriceService} to use it. Also, {@code queryPricesUseCase} requires the {@code priceRepository} 
 * collaborator, so its injected too (a {@code PriceRepositoryPort} bean already exists in the IoC container, 
 * {@code JpaPriceRepositoryAdapter}, so its {@code @Autowired} into a field directly).
 */
@Configuration
public class AppConfig {
	
	@Autowired
	private IPriceRepositoryPort priceRepository;
	
	@Bean
	public IPriceService priceDomainService() {
		return new PriceService();
	}
	
	@Bean
	public IQueryPricesUseCase queryPricesUseCase() {
		return new QueryPricesUseCase(this.priceRepository, priceDomainService());
	}
	
}
