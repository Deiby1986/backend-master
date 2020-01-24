package com.adn.ceiba.domain.model;

import java.io.Serializable;

import com.adn.ceiba.domain.exception.FieldEmptyOrNullException;
import com.adn.ceiba.domain.exception.FieldLengthException;

public class Product  {
	
	
	private Long id;
	
	private String codigo;
	
	private String nombre;
	
	private Double price;
	
	private Long qty;	
	

	public Product(Long id,String codigo, String name, Long qty,Double price) {
		if(codigo == null || codigo.trim().length() == 0)
			throw new FieldEmptyOrNullException("Codigo del producto no puede ser vacio");
		if(name == null || name.trim().length() == 0)
			throw new FieldEmptyOrNullException("Nombre del producto no puede ser vacio");	
		if(codigo.length()<5)
			throw new FieldLengthException("Longitud del codigo no puede ser menor que 5");
		if(name.length()<5)
			throw new FieldLengthException("Longitud del nombre no puede ser menor que 5");
		this.id = id;
		this.codigo = codigo;
		this.nombre = name;
		this.qty = qty;
		this.price = price;
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
