package com.adn.ceiba.infraestructura.entitiesnodbmapper;

import com.adn.ceiba.domain.model.Product;
import com.adn.ceiba.domain.model.dto.ProductDto;
import com.adn.ceiba.infraestructura.entitiesnodb.ProductNoDB;

public class ProductMapper {
	
	private ProductMapper() {
		
	}
	
	public static ProductNoDB toProductMongo(Product product) {
		return new ProductNoDB(product.getId(), product.getCodigo(), product.getNombre(), product.getPrice(), product.getQty());
	}
	
	public static ProductDto toProductDto(ProductNoDB product) {
		return new ProductDto(product.getId(), product.getCodigo(), product.getNombre(), product.getPrice(), product.getQty());
	}
	
	
	public static Product toProduct(ProductNoDB product) {
		if(product != null)
			return new Product(product.getId(), product.getCodigo(), product.getNombre(), product.getQty(), product.getPrice());
		return null;
	}

}
