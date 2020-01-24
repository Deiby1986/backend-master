package com.adn.ceiba.application.handlers;

import java.util.List;

import com.adn.ceiba.domain.model.dto.ProductDto;
import com.adn.ceiba.domain.repository.ProductRepository;
import com.adn.ceiba.domain.repository.SalesHeaderRepository;


public class ProductHandleQuery {
	
	ProductRepository productRepository;
	

	public ProductHandleQuery(ProductRepository productRepository) {		
		this.productRepository = productRepository;
	}
	
	
	public List<ProductDto>  list(){
		return productRepository.findAllAsDto();
	}
	
	
      
}
