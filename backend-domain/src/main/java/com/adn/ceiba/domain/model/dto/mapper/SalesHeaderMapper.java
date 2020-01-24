package com.adn.ceiba.domain.model.dto.mapper;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.domain.model.SalesHeader;
import com.adn.ceiba.domain.model.dto.SalesDetailDto;
import com.adn.ceiba.domain.model.dto.SalesHeaderDto;

public class SalesHeaderMapper {
	
	private SalesHeaderMapper() {	
	}
	
	public static SalesHeader fromDto(SalesHeaderDto header) {
		return new SalesHeader(header.getId(),header.getNombreCliente(), header.getFecha(), header.getTotal());
	}
	
	public static SalesHeaderDto toDto(SalesHeader header) {
		return new SalesHeaderDto(header.getId(),header.getClientName(), header.getDate(), header.getTotal(),null);
	}
	
	public static SalesHeaderDto toDto(SalesHeader header,List<SalesDetail> details) {		
		return new SalesHeaderDto(
									header.getId(),
									header.getClientName(), 
									header.getDate(), 
									header.getTotal(),
									details.stream().map(detail -> new SalesDetailDto(detail.getId(), detail.getHeader(), detail.getProduct(), detail.getQtyPurchased(), 0D, detail.getTotal())).collect(Collectors.toList())
								);
	}

}
