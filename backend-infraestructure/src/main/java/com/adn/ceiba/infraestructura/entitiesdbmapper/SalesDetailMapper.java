package com.adn.ceiba.infraestructura.entitiesdbmapper;

import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.infraestructura.entitiesdb.ProductJPA;
import com.adn.ceiba.infraestructura.entitiesdb.SalesDetailJPA;
import com.adn.ceiba.infraestructura.entitiesdb.SalesHeaderJPA;
import com.adn.ceiba.infraestructura.jparepositorydb.ProductJPARepository;
import com.adn.ceiba.infraestructura.jparepositorydb.SalesHeaderJPARepository;

public class SalesDetailMapper {
	
	ProductJPARepository productRepository;
	SalesHeaderJPARepository headerRepository;
	
	

	

	public SalesDetailMapper(ProductJPARepository productRepository, SalesHeaderJPARepository headerRepository) {
		super();
		this.productRepository = productRepository;
		this.headerRepository = headerRepository;
	}

	public SalesDetail toSalesDetail(SalesDetailJPA salesdetail) {
		return new SalesDetail(salesdetail.getId(),salesdetail.getHeader().getId(), 
				salesdetail.getProduct().getId(),
				salesdetail.getProduct().getNombre(), 
				salesdetail.getQtyPurchased(), 
				salesdetail.getTotal());
	}
	
	public SalesDetailJPA toSalesDetail(SalesDetail salesdetail) {
		
		SalesHeaderJPA header = this.headerRepository.findById(salesdetail.getHeader()).orElse(null);
		ProductJPA product = this.productRepository.findById(salesdetail.getProductId()).orElse(null);
		
		return new SalesDetailJPA(header, 
				product, 
				salesdetail.getQtyPurchased(), 
				salesdetail.getTotal());
	}

}
