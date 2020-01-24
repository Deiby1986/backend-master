package com.adn.ceiba.domain.services;

import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.domain.repository.SalesDetailRepository;

public class SalesDetailService {
	
	private SalesDetailRepository detailRepository;

	public SalesDetailService(SalesDetailRepository repository) {		
		this.detailRepository = repository;
	}
	
	public SalesDetail execute(SalesDetail d) {
		
		//d.getProduct().setQty(d.getProduct().getQty()-d.getQtyPurchased());
		return detailRepository.save(d);
	}
	
	

}
