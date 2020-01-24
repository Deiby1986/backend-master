package com.adn.ceiba.infraestructura.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.adn.ceiba.domain.services.ProductService;
import com.adn.ceiba.domain.services.SalesDetailService;
import com.adn.ceiba.domain.services.SalesHeaderService;
import com.adn.ceiba.infraestructura.jparepositorydb.ProductJPARepository;
import com.adn.ceiba.infraestructura.jparepositorydb.SalesDetailJPARepository;
import com.adn.ceiba.infraestructura.jparepositorydb.SalesHeaderJPARepository;
import com.adn.ceiba.infraestructura.repositorydb.ProductRepositoryDB;
import com.adn.ceiba.infraestructura.repositorydb.SalesDetailRepositoryDB;
import com.adn.ceiba.infraestructura.repositorydb.SalesHeaderRepositoryDB;




@Profile("db")
@Configuration
public class BeanServicioDB {
	
	@Bean
	public ProductService createProductService(ProductJPARepository daopDao) {		
		return new ProductService(new ProductRepositoryDB(daopDao));
	} 
	
	@Bean
	public SalesDetailService createDetailService(SalesDetailJPARepository detailRepository,ProductJPARepository productRepository,SalesHeaderJPARepository headerRepository) {
		return new SalesDetailService(new SalesDetailRepositoryDB(detailRepository, productRepository, headerRepository));
	}
	
	@Bean
	public SalesHeaderService createHeaderService(SalesHeaderJPARepository daoHeader) {
		return new SalesHeaderService(new SalesHeaderRepositoryDB(daoHeader));
	}
}
