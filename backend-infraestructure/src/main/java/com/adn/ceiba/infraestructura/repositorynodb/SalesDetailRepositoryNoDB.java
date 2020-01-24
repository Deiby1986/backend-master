package com.adn.ceiba.infraestructura.repositorynodb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.domain.model.dto.SalesDetailDto;
import com.adn.ceiba.domain.repository.SalesDetailRepository;
import com.adn.ceiba.infraestructura.mongorepositorynodb.ProductMongoRepository;
import com.adn.ceiba.infraestructura.mongorepositorynodb.SalesDetailMongoRepository;
import com.adn.ceiba.infraestructura.mongorepositorynodb.SalesHeaderMongoRepository;

@Profile("nodb")
@Component
public class SalesDetailRepositoryNoDB implements SalesDetailRepository {
	
	private SalesDetailMongoRepository detailRepository;
	private ProductMongoRepository productRepository;
	private SalesHeaderMongoRepository headerRepository;
	
	

	public SalesDetailRepositoryNoDB(SalesDetailMongoRepository detailRepository,
			ProductMongoRepository productRepository, SalesHeaderMongoRepository headerRepository) {
		super();
		this.detailRepository = detailRepository;
		this.productRepository = productRepository;
		this.headerRepository = headerRepository;
	}
	
	

	@Override
	public List<SalesDetailDto> findAll() {		
		return detailRepository.findAll().stream().map(detail -> 
															new SalesDetailDto(detail.getId(), detail.getHeader().getId(), 
																				detail.getProduct().getNombre(), detail.getQtyPurchased(), 
																				detail.getProduct().getPrice(), detail.getTotal()
																			   )
												).collect(Collectors.toList());
	}

	@Override
	public SalesDetail save(SalesDetail detail) {
		return detail;		
	}

}
