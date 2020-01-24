package com.adn.ceiba.domain.exception;

public class NoStockAvailableForProduct extends RuntimeException{
	
	public NoStockAvailableForProduct(String message) {
		super(message);
	}

}
