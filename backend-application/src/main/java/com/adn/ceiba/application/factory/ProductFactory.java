package com.adn.ceiba.application.factory;

import com.adn.ceiba.application.command.bean.CommandProduct;
import com.adn.ceiba.domain.model.Product;

public class ProductFactory {
	
	public Product create(CommandProduct productCommand) {
		return new Product(productCommand.getId(),productCommand.getCodigo(), productCommand.getNombre(), productCommand.getQty(),productCommand.getPrice());		
	}

}
