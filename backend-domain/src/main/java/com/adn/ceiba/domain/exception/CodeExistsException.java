package com.adn.ceiba.domain.exception;

public class CodeExistsException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public CodeExistsException() {
	    super("Codigo ya se encuentra registrado");
	}

}
