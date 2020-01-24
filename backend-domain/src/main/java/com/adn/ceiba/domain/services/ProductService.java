package com.adn.ceiba.domain.services;

import com.adn.ceiba.domain.exception.CodeExistsException;
import com.adn.ceiba.domain.model.Product;
import com.adn.ceiba.domain.repository.ProductRepository;

public class ProductService {
	
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {		
		this.productRepository = productRepository;
	}
	
	public Product execute(Product p) {
		if(!validateProduct(p))
			throw  new CodeExistsException();		 
		return productRepository.save(p); 
	}
	
	private boolean validateProduct(Product p) {
		if (p.getId() != null && p.getId() != 0) 
				return true;
		return productRepository.findByCode(p.getCodigo())==null;
	}
	
	
	

}
