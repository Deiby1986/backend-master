package com.adn.ceiba.infraestructura.jparepositorydb;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adn.ceiba.infraestructura.entitiesdb.ProductJPA;


@Profile("db")
@Repository
public interface ProductJPARepository extends JpaRepository<ProductJPA, Long> {
	
	public ProductJPA findByCode(String code);

}
