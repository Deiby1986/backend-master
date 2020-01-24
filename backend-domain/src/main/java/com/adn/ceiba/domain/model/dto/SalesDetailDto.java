package com.adn.ceiba.domain.model.dto;


public class SalesDetailDto {
	private Long id;	
	
	private Long header;	
	
	private Long productId;
	
	private String product;
	
	private Long qtyPurchased;
	
	private Double price;
	
	private Long total;

	public SalesDetailDto(Long id,Long header, String product, Long qtyPurchased, Double price, Long total) {
		this.id = id;
		this.header = header;
		this.product = product;
		this.qtyPurchased = qtyPurchased;
		this.price = price;
		this.total = total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHeader() {
		return header;
	}

	public void setHeader(Long header) {
		this.header = header;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQtyPurchased() {
		return qtyPurchased;
	}

	public void setQtyPurchased(Long qtyPurchased) {
		this.qtyPurchased = qtyPurchased;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	
	

	
	
	
	


}
