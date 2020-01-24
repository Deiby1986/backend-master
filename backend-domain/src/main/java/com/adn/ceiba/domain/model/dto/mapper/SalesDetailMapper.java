package com.adn.ceiba.domain.model.dto.mapper;

import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.domain.model.dto.SalesDetailDto;

public class SalesDetailMapper {
	
	public static SalesDetail fromDto(SalesDetailDto detail) {
		return new SalesDetail(detail.getId(),detail.getHeader(), detail.getProductId(),detail.getProduct(), detail.getQtyPurchased(), detail.getTotal());
	}
	
	
	

}
