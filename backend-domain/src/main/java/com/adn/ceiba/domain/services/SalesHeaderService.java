package com.adn.ceiba.domain.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.adn.ceiba.domain.exception.CanSellOnWekendsException;
import com.adn.ceiba.domain.exception.InvalidDateException;
import com.adn.ceiba.domain.model.SalesHeader;
import com.adn.ceiba.domain.repository.SalesHeaderRepository;



public class SalesHeaderService {
	
	private SalesHeaderRepository headerRepository;

	public SalesHeaderService(SalesHeaderRepository repository) {
		this.headerRepository = repository;
	}
	
	public SalesHeader execute(SalesHeader header) {
		if(!dateFormatCorrect(header.getDate()))
			throw new InvalidDateException("Especifique la fecha en formato dd/mm/yyyy");
		if(!canSale(header))
			throw new CanSellOnWekendsException("No se puede vender los fines de semana");
		return headerRepository.save(header);
	}
	
	public boolean canSale(SalesHeader header) {
		String stringDate = header.getDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(stringDate, formatter);
		return !(date.getDayOfWeek() ==DayOfWeek.SATURDAY || date.getDayOfWeek()== DayOfWeek.SUNDAY);
					
	}
	
	public boolean dateFormatCorrect(String date) {
		String regexp = "\\d{1,2}/\\d{1,2}/\\d{4}";
		String []dates = date.split(regexp);
		return dates.length == 0;		
	}

}
