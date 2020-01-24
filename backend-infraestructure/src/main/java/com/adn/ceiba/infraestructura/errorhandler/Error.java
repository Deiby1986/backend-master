package com.adn.ceiba.infraestructura.errorhandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    
    private String excepcionName;
    private String message;
    
    
	public Error(String excepcionName, String message) {
		this.excepcionName = excepcionName;
		this.message = message;
	}


	
	
    
    

}
