package com.adn.ceiba.infraestructura.mongorepositorynodb;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adn.ceiba.infraestructura.entitiesnodb.SalesHeaderNoDB;

@Profile("nodb")
@Repository
public interface SalesHeaderMongoRepository extends MongoRepository<SalesHeaderNoDB, Long> {

}
