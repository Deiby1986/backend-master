package com.adn.ceiba.infraestructura.entitiesdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SalesDetail")
public class SalesDetailJPA {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_salesheader", nullable = false)
	private SalesHeaderJPA header;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", nullable = false)
	private ProductJPA product;
	
	private Long qtyPurchased;
	
	private Long total;
	
	public SalesDetailJPA() {		
	}

	public SalesDetailJPA(SalesHeaderJPA header, ProductJPA product, Long qtyPurchased, Long total) {		
		this.header = header;
		this.product = product;
		this.qtyPurchased = qtyPurchased;
		this.total = total;
	}
	
	

	
	
	

}
