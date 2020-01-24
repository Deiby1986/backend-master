package com.adn.ceiba.infraestructura.repositorydb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.adn.ceiba.domain.model.SalesHeader;
import com.adn.ceiba.domain.model.dto.SalesDetailDto;
import com.adn.ceiba.domain.model.dto.SalesHeaderDto;
import com.adn.ceiba.domain.repository.SalesHeaderRepository;
import com.adn.ceiba.infraestructura.entitiesdbmapper.SalesHeaderMapper;
import com.adn.ceiba.infraestructura.jparepositorydb.SalesHeaderJPARepository;

@Profile("db")
@Component
public class SalesHeaderRepositoryDB implements SalesHeaderRepository{

	SalesHeaderJPARepository salesHeaderRepository;	

	public SalesHeaderRepositoryDB(SalesHeaderJPARepository repository) {
		this.salesHeaderRepository = repository;
	}	

	@Override
	public SalesHeader save(SalesHeader header) {		
		return SalesHeaderMapper.toHeader(salesHeaderRepository.save(SalesHeaderMapper.toHeader(header)));
	}	
	
	public List<SalesHeaderDto> findAllAsDto(){		
		
		return salesHeaderRepository.findAll().
										stream().map(header -> new SalesHeaderDto(header.getId(), 
																				  header.getClientName(), 
																				  header.getDate(), 
																				  header.getTotal(), 
																				  header.getDetails().stream().map(detail -> new SalesDetailDto(detail.getId(), header.getId(), detail.getProduct().getNombre(), detail.getQtyPurchased(), 0D, detail.getTotal())).collect(Collectors.toList())
																				  )
																/*SalesHeaderMapper.toHeaderDto(
																		SalesHeaderMapper.toHeader(header)
																)*/
										).collect(Collectors.toList());
	}

	@Override
	public SalesHeader findById(Long id) {		
		return SalesHeaderMapper.toHeader(salesHeaderRepository.findById(id).orElse(null)) ;
	}
	



	

}
