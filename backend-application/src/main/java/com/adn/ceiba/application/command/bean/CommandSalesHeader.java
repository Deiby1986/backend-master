package com.adn.ceiba.application.command.bean;

import java.util.ArrayList;
import java.util.List;

public class CommandSalesHeader {

	private Long id;
	private String nombreCliente;
	private String fecha;
	private Double total;

	private List<CommandSalesDetail> details;

	public CommandSalesHeader() {

	}

	public CommandSalesHeader(Long id, String nombreCliente, String fecha, Double total,
			List<CommandSalesDetail> details) {
		this.id = id;
		this.nombreCliente = nombreCliente;
		this.fecha = fecha;
		this.total = total;
		setDetails(details);
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

	public List<CommandSalesDetail> getDetails() {
		return new ArrayList<>(details);
	}

	public void setDetails(List<CommandSalesDetail> details) {
		this.details = new ArrayList<>();		
		this.details.addAll(details);
	}

}
