package com.adn.ceiba.application.command.bean;






public class CommandSalesDetail {
	
	private Long id;	
	private Long  idHeader;
	private Long  idProduct;	
	private Long qtyPurchased;	
	private Long total;	
	
	public CommandSalesDetail() {
		
	}
	
	public CommandSalesDetail(Long idHeader, Long idProduct, Long qtyPurchased, Long total) {		
		this.idHeader = idHeader;
		this.idProduct = idProduct;
		this.qtyPurchased = qtyPurchased;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	

	public void setIdHeader(Long idHeader) {
		this.idHeader = idHeader;
	}

	public Long getIdHeader() {
		return idHeader;
	}

	

	public Long getIdProduct() {
		return idProduct;
	}

	

	public Long getQtyPurchased() {
		return qtyPurchased;
	}

	

	public Long getTotal() {
		return total;
	}

		
}
