package com.adn.ceiba.application.handlers;

import com.adn.ceiba.application.command.bean.CommandProduct;
import com.adn.ceiba.application.factory.ProductFactory;
import com.adn.ceiba.domain.model.Product;
import com.adn.ceiba.domain.repository.ProductRepository;
import com.adn.ceiba.domain.repository.SalesHeaderRepository;
import com.adn.ceiba.domain.services.ProductService;

public class ProductHandlerCreate {

	ProductFactory productFactory;
	ProductService productService;

	public ProductHandlerCreate(ProductService productService, ProductFactory productFactory) {
		this.productService = productService;
		this.productFactory = productFactory;
	}

	public void save(CommandProduct productCommand) {	
		Product product =productFactory.create(productCommand);
		productService.execute(product);		
	}
	
	

}
