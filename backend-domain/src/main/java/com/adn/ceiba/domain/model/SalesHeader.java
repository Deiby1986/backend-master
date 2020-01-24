package com.adn.ceiba.domain.model;

import java.util.List;

import com.adn.ceiba.domain.exception.FieldEmptyOrNullException;

public class SalesHeader {

	private Long id;
	
	private String clientName;
	
	private String date;
	
	private Double total;
	

	private List<SalesDetail> details; 
	
	public SalesHeader() {
		
	}
	public SalesHeader(Long id,String clientName, String date, Double total) {
		if(clientName == null || clientName.trim().length() == 0)
			throw new FieldEmptyOrNullException("Nombre del cliente no puede ser vacio");
		if(date == null || date.trim().length() == 0)
			throw new FieldEmptyOrNullException("Fecha de la venta no puede ser vacio");
		if(total == null || total <= 0)
			throw new FieldEmptyOrNullException("Total de la venta es invalido");
		this.id = id;
		this.clientName = clientName;
		this.date = date;
		this.total = total;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<SalesDetail> getDetails() {
		return details;
	}
	public void setDetails(List<SalesDetail> details) {
		this.details = details;
	}
	
	

}
