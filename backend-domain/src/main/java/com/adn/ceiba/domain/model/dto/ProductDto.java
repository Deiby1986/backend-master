package com.adn.ceiba.domain.model.dto;




public class ProductDto {
	
	private Long id;
	private String codigo;
	private String nombre;
	private Double price;
	private Long qty;	
	
	public ProductDto(Long id, String codigo, String nombre,Double price, Long qty) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.price = price;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}
	
	

	
	

}
