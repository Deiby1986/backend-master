package com.adn.ceiba.infraestructura.entitiesdbmapper;

import com.adn.ceiba.domain.model.Product;
import com.adn.ceiba.infraestructura.entitiesdb.ProductJPA;

public class ProductMapper {
	
	private ProductMapper() {
		
	}
	
	public static Product toProduct(ProductJPA product) {		
		return new Product(product.getId(), product.getCodigo(), product.getNombre(), product.getQty(), product.getPrice());
	}
	
	public static ProductJPA toProduct(Product product) {
		return new ProductJPA(product.getId(), product.getCodigo(), product.getNombre(), product.getQty(), product.getPrice());
	}

}
