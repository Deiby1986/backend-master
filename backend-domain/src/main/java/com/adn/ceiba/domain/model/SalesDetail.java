package com.adn.ceiba.domain.model;

import com.adn.ceiba.domain.exception.FieldEmptyOrNullException;
import com.adn.ceiba.domain.exception.NoStockAvailableForProduct;

public class SalesDetail {
	
	private Long id;	
	
	private Long header;
	
	private Long productId;
	
	private String product;
	
	private Long qtyPurchased;
	
	private Long total;
	
	public SalesDetail() {		
	}

	public SalesDetail(Long id,Long header,Long productId, String product, Long qtyPurchased, Long total) {
		/*if(header == null)
			throw new FieldEmptyOrNullException("Se debe especificar el header");*/
		if(product == null)
			throw new FieldEmptyOrNullException("Se debe especificar el producto");
		if(qtyPurchased == null || qtyPurchased <= 0L)
			throw new FieldEmptyOrNullException("Se debe especificar una cantidad valida");
		if(total <= 0L)
			throw new FieldEmptyOrNullException("Se debe ingresar una cantidad valida");
		/*if(qtyPurchased > product.getQty())
			throw new NoStockAvailableForProduct("No hay stock para el producto "+product.getNombre()+((product.getQty()>0)?("(Cantidad disponible : "+product.getQty()+" )"):""));*/
		this.id = id;
		this.header = header;
		this.product = product;
		this.qtyPurchased = qtyPurchased;
		this.total = total;
		this.productId = productId;
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

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	
	

	
}
