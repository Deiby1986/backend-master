package com.adn.ceiba.infraestructura.entitiesnodb;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.adn.ceiba.infraestructura.entitiesdb.ProductJPA;
import com.adn.ceiba.infraestructura.entitiesdb.SalesHeaderJPA;

import lombok.Getter;


@Getter
@Document(collection = "details")
public class SalesDetailNoDB {
    @Id
	private Long id;

	private SalesHeaderNoDB header;

	private ProductNoDB product;

	private Long qtyPurchased;

	private Long total;

	public SalesDetailNoDB(Long id, SalesHeaderNoDB header, ProductNoDB product, Long qtyPurchased, Long total) {		
		this.id = id;
		this.header = header;
		this.product = product;
		this.qtyPurchased = qtyPurchased;
		this.total = total;
	}
	
	
	

}
