package com.adn.ceiba.application.handlers;

import java.util.List;

import com.adn.ceiba.domain.model.dto.SalesHeaderDto;
import com.adn.ceiba.domain.repository.SalesHeaderRepository;


public class SalesHeaderHandleQuery {
	
	private SalesHeaderRepository salesHeaderRepository;

	public SalesHeaderHandleQuery(SalesHeaderRepository repository) {
		this.salesHeaderRepository = repository;
	}
	
	public List<SalesHeaderDto> list(){
		return salesHeaderRepository.findAllAsDto();
	}

}
