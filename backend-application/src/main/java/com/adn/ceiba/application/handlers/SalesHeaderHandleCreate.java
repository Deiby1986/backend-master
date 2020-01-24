package com.adn.ceiba.application.handlers;

import java.util.List;

import com.adn.ceiba.application.command.bean.CommandSalesDetail;
import com.adn.ceiba.application.command.bean.CommandSalesHeader;
import com.adn.ceiba.application.factory.SalesHeaderFactory;
import com.adn.ceiba.domain.model.SalesHeader;
import com.adn.ceiba.domain.services.SalesHeaderService;


public class SalesHeaderHandleCreate {
	
	private SalesHeaderService headerService;	
	private SalesHeaderFactory headerFactory;
	SalesDetailHandleCreate detailHandler;
	public SalesHeaderHandleCreate(SalesHeaderService service, SalesHeaderFactory factory,SalesDetailHandleCreate detailCreate) {
		this.headerService = service;
		this.headerFactory = factory;
		this.detailHandler = detailCreate;
	}
	
	//TODO: Resolve @Transactional
	
	//@Transactional
	public void save(CommandSalesHeader command) {
		List<CommandSalesDetail> details =  command.getDetails();		
		SalesHeader headerTosave = headerFactory.create(command);
		SalesHeader header = headerService.execute(headerTosave);		
		saveDetails(details, header);
	}
	
	private void saveDetails(List<CommandSalesDetail> details,SalesHeader header) {		
		if(details == null || details.isEmpty())
			return;			
		for (int i = 0; i < details.size(); i++) {
			CommandSalesDetail det = details.get(i);
			det.setIdHeader(header.getId());
		 	detailHandler.save(det);		
		}
		
	}
	
	
	
	

}
