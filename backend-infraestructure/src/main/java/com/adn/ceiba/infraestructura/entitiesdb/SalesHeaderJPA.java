package com.adn.ceiba.infraestructura.entitiesdb;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SalesHeader")
public class SalesHeaderJPA {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre_cliente", nullable = false)
	private String clientName;
	@Column(name = "fecha", nullable = false)
	private String date;
	@Column(name = "total", nullable = false)
	private Double total;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true,
	        fetch = FetchType.EAGER
	    )
	@JoinColumn(name = "id_salesheader")
	private List<SalesDetailJPA> details; 
	
	public SalesHeaderJPA() {
		
	}
	public SalesHeaderJPA(Long id,String clientName, String date, Double total) {
		this.id = id;
		this.clientName = clientName;
		this.date = date;
		this.total = total;
	}

}
