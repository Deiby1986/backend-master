package com.adn.ceiba.infraestructura.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.ceiba.application.handlers.ProductHandleQuery;
import com.adn.ceiba.domain.model.dto.ProductDto;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/products")

public class ProductQueryController {
	
	ProductHandleQuery productQueryHandler;

	public ProductQueryController(ProductHandleQuery handler) {		
		this.productQueryHandler = handler;
	}
	
	@GetMapping
	@ApiOperation("/list")
	public List<ProductDto> list(){
		return productQueryHandler.list();
	}
	 

}
