package com.adn.ceiba.infraestructura.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products/image")
public class ProductImageController {

	@GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getImage(String name) throws Exception {
		
		Resource resource = new ClassPathResource("product.jpg");	

		File file = resource.getFile();
		BufferedImage bImage = ImageIO.read(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "jpg", bos);
		return bos.toByteArray();

	}

}
