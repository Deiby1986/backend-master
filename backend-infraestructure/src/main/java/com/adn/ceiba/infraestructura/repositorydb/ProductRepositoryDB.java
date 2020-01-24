package com.adn.ceiba.infraestructura.repositorydb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.adn.ceiba.domain.model.Product;
import com.adn.ceiba.domain.model.dto.ProductDto;
import com.adn.ceiba.domain.repository.ProductRepository;
import com.adn.ceiba.infraestructura.entitiesdb.ProductJPA;
import com.adn.ceiba.infraestructura.entitiesdbmapper.ProductMapper;
import com.adn.ceiba.infraestructura.jparepositorydb.ProductJPARepository;

@Profile("db")
@Component
public class ProductRepositoryDB implements ProductRepository{	
	
	
	ProductJPARepository productRepository;	

	public ProductRepositoryDB(ProductJPARepository productRepository) {
		this.productRepository = productRepository;
	}	

	@Override
	public List<ProductDto> findAllAsDto() {
		return productRepository.findAll().stream().map(product -> new ProductDto(product.getId(),product.getCodigo(),product.getNombre(),product.getPrice() ,product.getQty()))
				 .collect(Collectors.toList());
	}
	

	@Override
	public Product findByCode(String code) {		
		return ProductMapper.toProduct(productRepository.findByCode(code));
	}	
	

	@Override
	public Product save(Product product) {		
		return ProductMapper.toProduct(productRepository.save(ProductMapper.toProduct(product)));
	}

	@Override
	public Product findById(Long id) {
		return  ProductMapper.toProduct(productRepository.findById(id).orElse(new ProductJPA()));
	}

	

}
