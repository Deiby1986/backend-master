package com.adn.ceiba.infraestructura.entitiesnodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "products")
public class ProductNoDB {
	
	@Id
	private Long id;
	
	private String codigo;
	
	private String nombre;
	
	private Double price;
	
	private Long qty;

	public ProductNoDB(Long id, String codigo, String nombre, Double price, Long qty) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.price = price;
		this.qty = qty;
	}
	
	

}
