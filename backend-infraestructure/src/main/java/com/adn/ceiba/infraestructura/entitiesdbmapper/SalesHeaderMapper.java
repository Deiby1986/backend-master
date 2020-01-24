package com.adn.ceiba.infraestructura.entitiesdbmapper;

import java.util.stream.Collectors;

import com.adn.ceiba.domain.model.SalesHeader;
import com.adn.ceiba.domain.model.dto.SalesDetailDto;
import com.adn.ceiba.domain.model.dto.SalesHeaderDto;
import com.adn.ceiba.infraestructura.entitiesdb.SalesHeaderJPA;

public class SalesHeaderMapper {
	
	private SalesHeaderMapper() {
		
	}
	public static SalesHeader toHeader(SalesHeaderJPA header) {
		return new SalesHeader(header.getId(),header.getClientName(), header.getDate(), header.getTotal());
	}
	
	public static SalesHeaderJPA toHeader(SalesHeader header) {
		return new SalesHeaderJPA(header.getId(),header.getClientName(), header.getDate(), header.getTotal());
		
	}
	
	public static SalesHeaderDto toHeaderDto(SalesHeaderJPA header) {
		return new SalesHeaderDto(
									header.getId(),
									header.getClientName(), 
									header.getDate(), 
									header.getTotal(),
									header.getDetails().stream().map(detail -> new SalesDetailDto(
																									detail.getId(), 
																									header.getId(), 
																									detail.getProduct().getNombre(), 
																									detail.getQtyPurchased(), 
																									0D, 
																									detail.getTotal()
																								)).collect(Collectors.toList())
								);
		
	}

}
