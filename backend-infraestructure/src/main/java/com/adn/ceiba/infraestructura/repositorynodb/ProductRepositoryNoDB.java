package com.adn.ceiba.infraestructura.repositorynodb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.adn.ceiba.domain.model.Product;
import com.adn.ceiba.domain.model.dto.ProductDto;
import com.adn.ceiba.domain.repository.ProductRepository;
import com.adn.ceiba.infraestructura.entitiesnodbmapper.ProductMapper;
import com.adn.ceiba.infraestructura.mongorepositorynodb.ProductMongoRepository;

@Profile("nodb")
@Component
public class ProductRepositoryNoDB implements ProductRepository {

	
	private ProductMongoRepository repository;
	
	public ProductRepositoryNoDB(ProductMongoRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<ProductDto> findAllAsDto() {
		
		return repository.findAll().stream().map(product -> new ProductDto(product.getId(), product.getCodigo(), product.getNombre(), product.getPrice(), product.getQty())).collect(Collectors.toList());
	}

	@Override
	public Product findByCode(String code) {		
		return ProductMapper.toProduct(repository.findByCodigo(code));
	}

	@Override
	public Product findById(Long id) {
		
		return ProductMapper.toProduct(repository.findById(id).orElse(null));
	}

	@Override
	public Product save(Product product) {
		if(product.getId() == null || product.getId() <1)
			product.setId(Long.MAX_VALUE-1);
		return ProductMapper.toProduct(repository.save(ProductMapper.toProductMongo(product)));
	}

}
