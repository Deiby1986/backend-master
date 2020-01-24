package com.adn.ceiba.domain.repository;

import java.util.List;

import com.adn.ceiba.domain.model.Product;
import com.adn.ceiba.domain.model.SalesHeader;
import com.adn.ceiba.domain.model.dto.SalesHeaderDto;



public interface SalesHeaderRepository {
	
	public SalesHeader save(SalesHeader p);	
	public SalesHeader findById(Long id);
	public List<SalesHeaderDto> findAllAsDto();
}
