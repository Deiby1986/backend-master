package com.adn.ceiba.infraestructura.mongorepositorynodb;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adn.ceiba.infraestructura.entitiesnodb.ProductNoDB;

@Profile("nodb")
@Repository
public interface ProductMongoRepository extends MongoRepository<ProductNoDB,Long> {
	
	
	public ProductNoDB findByCodigo(String codigo);

}
