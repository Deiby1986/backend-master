package com.adn.ceiba.domain.repository;

import java.util.List;

import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.domain.model.dto.SalesDetailDto;



public interface SalesDetailRepository {
	public List<SalesDetailDto> findAll();
	public SalesDetail save(SalesDetail p);
	

}
