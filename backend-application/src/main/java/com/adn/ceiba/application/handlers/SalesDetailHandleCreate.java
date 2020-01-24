package com.adn.ceiba.application.handlers;

import com.adn.ceiba.application.command.bean.CommandSalesDetail;
import com.adn.ceiba.application.factory.SalesDetailFactory;
import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.domain.services.SalesDetailService;




public class SalesDetailHandleCreate {

	private SalesDetailService salesDetailService;
	private SalesDetailFactory salesDetailFactory;
	
	public SalesDetailHandleCreate(SalesDetailService service, SalesDetailFactory factory) {		
		this.salesDetailService = service;
		this.salesDetailFactory = factory;
	}
	
	public void save(CommandSalesDetail commandDetail) {
		SalesDetail detail = salesDetailFactory.create(commandDetail);
		salesDetailService.execute(detail);
	}
	
	
}
