package com.adn.ceiba.infraestructura.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.ceiba.application.handlers.SalesHeaderHandleQuery;
import com.adn.ceiba.domain.model.dto.SalesHeaderDto;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/sales")
public class SalesHeaderQueryController {
	
	SalesHeaderHandleQuery salesHeaderHandler;

	public SalesHeaderQueryController(SalesHeaderHandleQuery handler) {
		this.salesHeaderHandler = handler;
	}	
	
	@GetMapping
	@ApiOperation("/list")
	public List<SalesHeaderDto> list(){
		return salesHeaderHandler.list();
	}

}
