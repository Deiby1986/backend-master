package com.adn.ceiba.infraestructura.entitiesnodb;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;


@Getter
@Document(collection = "sales")
public class SalesHeaderNoDB{
	
	@Id
	private Long id;
	
	private String clientName;
	
	private String date;
	
	private Double total;
	
	private List<SalesDetailNoDB> details;
	
	public SalesHeaderNoDB() {		
	}
	

	public SalesHeaderNoDB(Long id, String clientName, String date, Double total) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.date = date;
		this.total = total;
	}


	public SalesHeaderNoDB(Long id, String clientName, String date, Double total, List<SalesDetailNoDB> details) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.date = date;
		this.total = total;
		this.details = details;
	}
	
	
	
	
	

}
