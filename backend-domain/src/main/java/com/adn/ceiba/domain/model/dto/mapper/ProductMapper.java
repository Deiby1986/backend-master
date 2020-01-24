package com.adn.ceiba.domain.model.dto.mapper;

import com.adn.ceiba.domain.model.Product;
import com.adn.ceiba.domain.model.dto.ProductDto;

public class ProductMapper {
	
	private ProductMapper() {		
	}
	
	public static Product fromDto(ProductDto product) {
		return new Product(product.getId(), product.getCodigo(), product.getNombre(), product.getQty(), product.getPrice());
	}
	
	public static ProductDto toDto(Product product) {
		return new ProductDto(product.getId(), product.getCodigo(), product.getNombre(), product.getPrice(), product.getQty());
	}

}
