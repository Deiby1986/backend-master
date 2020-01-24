package com.adn.ceiba.infraestructura.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.ceiba.application.command.bean.CommandProduct;
import com.adn.ceiba.application.handlers.ProductHandlerCreate;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/products")
public class ProductCommandController {
	
	ProductHandlerCreate serviceProduct;	
	
	public ProductCommandController(ProductHandlerCreate serviceProduct) {	
		this.serviceProduct = serviceProduct;
	}
	
	@PostMapping
	@ApiOperation("/addProduct")
	public void add(@RequestBody CommandProduct productCommand){
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Llamando a añadir producto");
		serviceProduct.save(productCommand);
	}

}
