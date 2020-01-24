package com.adn.ceiba.application.command.bean;



public class CommandProduct {
	private Long id;	
	private String codigo;	
	private String nombre;
	private Long qty;
	private double price;
	
	public CommandProduct() {
		
	}
	
	
	public CommandProduct(String codigo, String nombre, Long qty) {		
		this.codigo = codigo;
		this.nombre = nombre;
		this.qty = qty;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
