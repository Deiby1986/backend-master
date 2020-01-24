package com.adn.ceiba.infraestructura.entitiesnodbmapper;

import java.util.stream.Collectors;

import com.adn.ceiba.domain.model.SalesHeader;
import com.adn.ceiba.domain.model.dto.SalesHeaderDto;
import com.adn.ceiba.infraestructura.entitiesnodb.SalesDetailNoDB;
import com.adn.ceiba.infraestructura.entitiesnodb.SalesHeaderNoDB;
import com.adn.ceiba.infraestructura.repositorynodb.ProductRepositoryNoDB;

public class SalesHeaderMapper {
	
	ProductRepositoryNoDB productRepository;
	
	public SalesHeaderMapper(ProductRepositoryNoDB productRepository) {
		this.productRepository = productRepository;
		
	}
	
	public SalesHeaderNoDB toSalesHeaderNoDB(SalesHeader header) {		
		return new SalesHeaderNoDB(header.getId(), 
									header.getClientName(), 
									header.getDate(), 
									header.getTotal(),
									header.getDetails().stream().map(detail -> new SalesDetailNoDB(0L, null,ProductMapper.toProductMongo(productRepository.findById(detail.getProductId())), detail.getQtyPurchased(), detail.getTotal())).collect(Collectors.toList())
									
				);
												    
	}
	
	public static SalesHeader toSalesHeader(SalesHeaderNoDB header) {
		return new SalesHeader(header.getId(), header.getClientName(), header.getDate(), header.getTotal());		
	}
	
	public static SalesHeaderDto toSalesHeaderDto(SalesHeaderNoDB header) {
		return new SalesHeaderDto(header.getId(), header.getClientName(), header.getDate(), header.getTotal(),
				header.getDetails().stream().map(SalesDetailMapper::toSalesDetailDto).collect(Collectors.toList()));		
	}

}
