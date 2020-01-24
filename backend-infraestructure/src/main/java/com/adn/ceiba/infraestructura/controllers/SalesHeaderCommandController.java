package com.adn.ceiba.infraestructura.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.ceiba.application.command.bean.CommandSalesHeader;
import com.adn.ceiba.application.handlers.SalesHeaderHandleCreate;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/sales")

public class SalesHeaderCommandController {
	private SalesHeaderHandleCreate serviceSalesHandle;
	
	
	public SalesHeaderCommandController(SalesHeaderHandleCreate service) {
		this.serviceSalesHandle = service;
	}


	@PostMapping
	@ApiOperation("/addSale")
	public void add(@RequestBody CommandSalesHeader sales){
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Llamando a añadir compra");
		serviceSalesHandle.save(sales);
	}
	
}
