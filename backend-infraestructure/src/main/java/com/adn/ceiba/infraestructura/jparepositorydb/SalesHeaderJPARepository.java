package com.adn.ceiba.infraestructura.jparepositorydb;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.adn.ceiba.infraestructura.entitiesdb.SalesHeaderJPA;



@Profile("db")
@Component
public interface SalesHeaderJPARepository extends JpaRepository<SalesHeaderJPA, Long>{

}
