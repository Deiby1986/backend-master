package com.adn.ceiba.infraestructura.repositorydb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.adn.ceiba.domain.model.SalesDetail;
import com.adn.ceiba.domain.model.dto.SalesDetailDto;
import com.adn.ceiba.domain.repository.SalesDetailRepository;
import com.adn.ceiba.infraestructura.entitiesdbmapper.SalesDetailMapper;
import com.adn.ceiba.infraestructura.jparepositorydb.ProductJPARepository;
import com.adn.ceiba.infraestructura.jparepositorydb.SalesDetailJPARepository;
import com.adn.ceiba.infraestructura.jparepositorydb.SalesHeaderJPARepository;

@Profile("db")
@Component
public class SalesDetailRepositoryDB implements SalesDetailRepository{

	private SalesDetailJPARepository detailRepository;
	private ProductJPARepository productRepository;
	private SalesHeaderJPARepository headerRepository;
	
	
	

	public SalesDetailRepositoryDB(SalesDetailJPARepository detailRepository, ProductJPARepository productRepository,
			SalesHeaderJPARepository headerRepository) {
		super();
		this.detailRepository = detailRepository;
		this.productRepository = productRepository;
		this.headerRepository = headerRepository;
	}

	@Override
	public List<SalesDetailDto> findAll() {	
		
		return detailRepository.findAll().stream().map(detail -> 
				new SalesDetailDto(detail.getId(), detail.getHeader().getId(), detail.getProduct().getNombre(), detail.getQtyPurchased(), detail.getProduct().getPrice(), detail.getTotal())
		).collect(Collectors.toList());
		
	}

	@Override
	public SalesDetail save(SalesDetail detail) {	
		SalesDetailMapper detailMapper = new SalesDetailMapper(productRepository, headerRepository);
		
		return detailMapper.toSalesDetail(detailRepository.save(detailMapper.toSalesDetail(detail)));
	}

}
