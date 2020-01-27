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
	
	
	
	public SalesDetailMapper(ProductMongoRepository productRepository) {		
		this.productRepository = productRepository;		
	}

	public SalesDetail toSalesDetail(SalesDetailNoDB detail) {
		ProductNoDB product = productRepository.findById(detail.getId()).orElse(new ProductNoDB(1L, "", "", 0D, 0L));
		return new SalesDetail(detail.getId(),
							   detail.getHeader(), 
							   product.getId(), 
							   product.getNombre(), 
							   detail.getQtyPurchased(), 
							   detail.getTotal());
	}
	
	public SalesDetailDto toSalesDetailDto(SalesDetailNoDB detail) {
		ProductNoDB product = productRepository.findById(detail.getId()).orElse(new ProductNoDB(1L, "", "", 0D, 0L));
		return new SalesDetailDto(detail.getId(),
							   detail.getHeader()==null?0:detail.getHeader(),							
							   product.getNombre(), 
							   detail.getQtyPurchased(), 
							   product.getPrice(),
							   detail.getTotal());		
	}
	
	
	public SalesDetailNoDB toSalesDetailNoDB(SalesDetail detail) {		
		return new SalesDetailNoDB(detail.getId(),
							   detail.getHeader(), 
							   detail.getProductId(),
							   detail.getQtyPurchased(), 
							   detail.getTotal());
	}
	

}
