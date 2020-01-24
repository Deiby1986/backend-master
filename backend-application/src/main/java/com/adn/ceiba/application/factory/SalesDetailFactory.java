package com.adn.ceiba.application.factory;

import com.adn.ceiba.application.command.bean.CommandSalesDetail;
import com.adn.ceiba.domain.model.Product;
import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.domain.model.SalesHeader;
import com.adn.ceiba.domain.repository.ProductRepository;
import com.adn.ceiba.domain.repository.SalesHeaderRepository;

public class SalesDetailFactory {
	
	
	SalesHeaderRepository salesHeaderRepository;
	ProductRepository productRepository;
	
	
	
	
	public SalesDetailFactory(SalesHeaderRepository salesHeaderRepository, ProductRepository productRepository) {
		super();
		this.salesHeaderRepository = salesHeaderRepository;
		this.productRepository = productRepository;
	}




	public SalesDetail create(CommandSalesDetail detail) {		
		Product product = productRepository.findById(detail.getIdProduct());	
		return new SalesDetail(detail.getId(),detail.getIdHeader(),product.getId(), product.getNombre(), detail.getQtyPurchased(), detail.getTotal());
		
	}
}
