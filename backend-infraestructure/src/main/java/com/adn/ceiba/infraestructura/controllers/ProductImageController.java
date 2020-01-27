package com.adn.ceiba.infraestructura.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="api/products/image",produces = MediaType.IMAGE_JPEG_VALUE)
public class ProductImageController {
	
	@ResponseBody byte[] getImage(String name) {
		return null;
		
	}
		

}
