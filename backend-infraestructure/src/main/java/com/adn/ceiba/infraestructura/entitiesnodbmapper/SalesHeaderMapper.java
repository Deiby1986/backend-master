package com.adn.ceiba.infraestructura.entitiesnodbmapper;

import java.util.stream.Collectors;

import com.adn.ceiba.domain.model.SalesHeader;
import com.adn.ceiba.domain.model.dto.SalesHeaderDto;
import com.adn.ceiba.infraestructura.entitiesnodb.SalesDetailNoDB;
import com.adn.ceiba.infraestructura.entitiesnodb.SalesHeaderNoDB;
import com.adn.ceiba.infraestructura.mongorepositorynodb.ProductMongoRepository;
import com.adn.ceiba.infraestructura.mongorepositorynodb.SalesHeaderMongoRepository;
import com.adn.ceiba.infraestructura.repositorynodb.ProductRepositoryNoDB;

public class SalesHeaderMapper {
	
	ProductMongoRepository productRepository;	
	
	public SalesHeaderMapper(ProductMongoRepository productRepository) {
		this.productRepository = productRepository;
		
		
	}
	
	public SalesHeaderNoDB toSalesHeaderNoDB(SalesHeader header) {		
		return new SalesHeaderNoDB(header.getId(), 
									header.getClientName(), 
									header.getDate(), 
									header.getTotal(),
									header.getDetails().stream().map(detail -> new SalesDetailNoDB(0L, null,detail.getProductId(), detail.getQtyPurchased(), detail.getTotal())).collect(Collectors.toList())
									
				);
												    
	}
	
	public static SalesHeader toSalesHeader(SalesHeaderNoDB header) {
		return new SalesHeader(header.getId(), header.getClientName(), header.getDate(), header.getTotal());		
	}
	
	public SalesHeaderDto toSalesHeaderDto(SalesHeaderNoDB header) {
		SalesDetailMapper detailMapper = new SalesDetailMapper(this.productRepository);
		return new SalesHeaderDto(header.getId(), header.getClientName(), header.getDate(), header.getTotal(),
				header.getDetails().stream().map(detail ->detailMapper.toSalesDetailDto(detail)).collect(Collectors.toList()));		
	}

}
