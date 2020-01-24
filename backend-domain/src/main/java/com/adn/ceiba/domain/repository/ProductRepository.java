package com.adn.ceiba.domain.repository;

import java.util.List;

import com.adn.ceiba.domain.model.Product;
import com.adn.ceiba.domain.model.dto.ProductDto;



public interface ProductRepository {
	public List<ProductDto> findAllAsDto();	
	public Product findByCode(String code);
	public Product findById(Long id);
	
	public Product save(Product p);
	

}
