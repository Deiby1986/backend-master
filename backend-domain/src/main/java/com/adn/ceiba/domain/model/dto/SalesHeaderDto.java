package com.adn.ceiba.domain.model.dto;

import java.util.ArrayList;
import java.util.List;

public class SalesHeaderDto {
	
	private Long id;
	private String nombreCliente;
	private String fecha;	
	private Double total;
	
	private List<SalesDetailDto> details;


	public SalesHeaderDto(Long id, String nombreCliente, String fecha, Double total, List<SalesDetailDto> details) {
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.fecha = fecha;
		this.total = total;
		this.details = new ArrayList<>(details);
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public List<SalesDetailDto> getDetails() {
		return details;
	}


	public void setDetails(List<SalesDetailDto> details) {
		this.details = details;
	}
	
	
	
	
	
	
	
	
}
