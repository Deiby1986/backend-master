package com.adn.ceiba.infraestructura.entitiesdb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Products")
@NamedNativeQuery(name = "ProductJPA.findByCode", query = "SELECT * FROM products WHERE codigo = ?", resultClass = ProductJPA.class)
public class ProductJPA implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "codigo",  length = 20,nullable = false)
	private String codigo;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "price", nullable = false)
	private Double price;
	@Column(name = "qty", nullable = false)
	private Long qty;
	
	public ProductJPA() {
	
	}

	public ProductJPA(Long id,String codigo, String name, Long qty,Double price) {		
		this.id = id;
		this.codigo = codigo;
		this.nombre = name;
		this.qty = qty;
		this.price = price;
	}

	

	

}
