package com.adn.ceiba.infraestructura.entitiesnodbmapper;

import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.domain.model.dto.SalesDetailDto;
import com.adn.ceiba.infraestructura.entitiesnodb.ProductNoDB;
import com.adn.ceiba.infraestructura.entitiesnodb.SalesDetailNoDB;
import com.adn.ceiba.infraestructura.entitiesnodb.SalesHeaderNoDB;
import com.adn.ceiba.infraestructura.mongorepositorynodb.ProductMongoRepository;
import com.adn.ceiba.infraestructura.mongorepositorynodb.SalesHeaderMongoRepository;

public class SalesDetailMapper {
	
	ProductMongoRepository productRepository;
	SalesHeaderMongoRepository headerRepository;
	
	
	
	public SalesDetailMapper(ProductMongoRepository productRepository, SalesHeaderMongoRepository headerRepository) {		
		this.productRepository = productRepository;
		this.headerRepository = headerRepository;
	}

	public static SalesDetail toSalesDetail(SalesDetailNoDB detail) {
		return new SalesDetail(detail.getId(),
							   detail.getHeader().getId(), 
							   detail.getProduct().getId(), 
							   detail.getProduct().getNombre(), 
							   detail.getQtyPurchased(), 
							   detail.getTotal());
	}
	
	public static SalesDetailDto toSalesDetailDto(SalesDetailNoDB detail) {
		return new SalesDetailDto(detail.getId(),
							   detail.getHeader()==null?0:detail.getHeader().getId(),							
							   detail.getProduct()==null?"": detail.getProduct().getNombre(), 
							   detail.getQtyPurchased(), 
							   0D,
							   detail.getTotal());		
	}
	
	
	public SalesDetailNoDB toSalesDetailNoDB(SalesDetail detail) {
		ProductNoDB product = productRepository.findById(detail.getProductId()).orElse(null);
		SalesHeaderNoDB header = headerRepository.findById(detail.getHeader()).orElse(null);
		return new SalesDetailNoDB(detail.getId(),
							   header, 
							   product,
							   detail.getQtyPurchased(), 
							   detail.getTotal());
	}
	

}
