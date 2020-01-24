package com.adn.ceiba.application.factory;

import java.util.List;
import java.util.stream.Collectors;

import com.adn.ceiba.application.command.bean.CommandSalesHeader;
import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.domain.model.SalesHeader;

public class SalesHeaderFactory {
	
	public SalesHeader create(CommandSalesHeader commandHeader) {
		SalesHeader header = new SalesHeader(commandHeader.getId(),commandHeader.getNombreCliente(), commandHeader.getFecha(), commandHeader.getTotal());
		
		List<SalesDetail> details = commandHeader.getDetails().stream().map(detail ->
																			new SalesDetail(detail.getId(), 
																							header.getId(), 
																							detail.getIdProduct(), "", detail.getQtyPurchased(), detail.getTotal())
		).collect(Collectors.toList());
		header.setDetails(details);
		return header;
	}

}
