package com.adn.ceiba.infraestructura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.adn.ceiba.domain.services.ProductService;
import com.adn.ceiba.domain.services.SalesDetailService;
import com.adn.ceiba.domain.services.SalesHeaderService;
import com.adn.ceiba.infraestructura.mongorepositorynodb.ProductMongoRepository;
import com.adn.ceiba.infraestructura.mongorepositorynodb.SalesDetailMongoRepository;
import com.adn.ceiba.infraestructura.mongorepositorynodb.SalesHeaderMongoRepository;
import com.adn.ceiba.infraestructura.repositorynodb.ProductRepositoryNoDB;
import com.adn.ceiba.infraestructura.repositorynodb.SalesDetailRepositoryNoDB;
import com.adn.ceiba.infraestructura.repositorynodb.SalesHeaderRepositoryNoDB;

@Profile("nodb")
@Configuration
@EnableMongoRepositories(basePackageClasses = com.adn.ceiba.infraestructura.mongorepositorynodb.ProductMongoRepository.class)
public class BeanServicioNoDB {
	
	@Bean
	public ProductService createProductService(ProductMongoRepository daopDao) {		
		return new ProductService(new ProductRepositoryNoDB(daopDao));
	} 
	
	@Bean
	public SalesDetailService createDetailService(SalesDetailMongoRepository detailRepository,ProductMongoRepository productRepository,SalesHeaderMongoRepository headerRepository) {
		return new SalesDetailService(new SalesDetailRepositoryNoDB(detailRepository, productRepository, headerRepository));
	}
	
	@Bean
	public SalesHeaderService createHeaderService(SalesHeaderMongoRepository salesHeaderRepository,ProductMongoRepository productRepository) {
		return new SalesHeaderService(new SalesHeaderRepositoryNoDB(salesHeaderRepository,productRepository));
	}	
}
