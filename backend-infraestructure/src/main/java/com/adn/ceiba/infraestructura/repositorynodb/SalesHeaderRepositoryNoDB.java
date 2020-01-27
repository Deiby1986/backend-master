package com.adn.ceiba.infraestructura.repositorynodb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.adn.ceiba.domain.model.SalesHeader;
import com.adn.ceiba.domain.model.dto.SalesHeaderDto;
import com.adn.ceiba.domain.repository.SalesHeaderRepository;
import com.adn.ceiba.infraestructura.entitiesnodb.SalesHeaderNoDB;
import com.adn.ceiba.infraestructura.entitiesnodbmapper.SalesHeaderMapper;
import com.adn.ceiba.infraestructura.mongorepositorynodb.ProductMongoRepository;
import com.adn.ceiba.infraestructura.mongorepositorynodb.SalesHeaderMongoRepository;

@Profile("nodb")
@Component
public class SalesHeaderRepositoryNoDB implements SalesHeaderRepository{
	
	private SalesHeaderMongoRepository salesHeaderRepository;	
	private SalesHeaderMapper mapper;
	
	

	public SalesHeaderRepositoryNoDB(SalesHeaderMongoRepository salesHeaderRepository,ProductMongoRepository productRepository) {
		this.salesHeaderRepository = salesHeaderRepository;		
		this.mapper = new SalesHeaderMapper(productRepository);
	}

	@Override
	public SalesHeader save(SalesHeader header) {		
		
		if(header.getId() == null || header.getId() <1)
			header.setId(Long.MAX_VALUE-(long)(Math.random()*Long.MAX_VALUE));
		return SalesHeaderMapper.toSalesHeader(salesHeaderRepository.save(mapper.toSalesHeaderNoDB(header)));
	}

	@Override
	public SalesHeader findById(Long id) {
		return SalesHeaderMapper.toSalesHeader(salesHeaderRepository.findById(id).orElse(null));
	}

	@Override
	public List<SalesHeaderDto> findAllAsDto() {		
		List<SalesHeaderNoDB> headers = salesHeaderRepository.findAll();		
		return headers.stream().map(header ->mapper.toSalesHeaderDto(header)).collect(Collectors.toList());
	}

}
