package com.adn.ceiba.infraestructura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adn.ceiba.application.factory.ProductFactory;
import com.adn.ceiba.application.factory.SalesDetailFactory;
import com.adn.ceiba.application.factory.SalesHeaderFactory;
import com.adn.ceiba.application.handlers.ProductHandleQuery;
import com.adn.ceiba.application.handlers.ProductHandlerCreate;
import com.adn.ceiba.application.handlers.SalesDetailHandleCreate;
import com.adn.ceiba.application.handlers.SalesHeaderHandleCreate;
import com.adn.ceiba.application.handlers.SalesHeaderHandleQuery;
import com.adn.ceiba.domain.repository.ProductRepository;
import com.adn.ceiba.domain.repository.SalesHeaderRepository;
import com.adn.ceiba.domain.services.ProductService;
import com.adn.ceiba.domain.services.SalesDetailService;
import com.adn.ceiba.domain.services.SalesHeaderService;

@Configuration
public class BeanServicio {
	@Bean
	public ProductHandleQuery createProductHandleQuery(ProductRepository repository) {
		return new ProductHandleQuery(repository);
	}	
	
	@Bean
	public ProductHandlerCreate createProductHandlerCreate(ProductService service) {
		return new ProductHandlerCreate(service,new ProductFactory());
	}
	
	
	@Bean
	public SalesDetailHandleCreate createSalesDetailHandleCreate(SalesDetailService service, SalesDetailFactory factory) {
		return new SalesDetailHandleCreate(service, factory);
	}
	
	
	@Bean
	public SalesHeaderHandleCreate createSalesHeaderHandleCreate(SalesHeaderService service, SalesHeaderFactory factory,SalesDetailHandleCreate detailCreate) {
		return new SalesHeaderHandleCreate(service,factory,detailCreate);
	}
	
	@Bean
	public SalesHeaderHandleQuery createSalesHeaderHandleQuery(SalesHeaderRepository repository) {
		return new SalesHeaderHandleQuery(repository);
	}
	
	@Bean
	public SalesHeaderFactory createSalesHeaderFactory() {
		return new SalesHeaderFactory();
	}
	
	@Bean
	public SalesDetailFactory createSalesDetailFactory(SalesHeaderRepository salesHeaderRepository, ProductRepository productRepository) {
		return new SalesDetailFactory(salesHeaderRepository,productRepository);
	}
}
