package com.kasokuz.snaildb.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.domain.Taxonomer;

public interface TaxonomerRepository extends CrudRepository<Taxonomer, Integer> {
	
	public Taxonomer findByTaxonomerId(Integer taxonomerId);
	
	public Taxonomer findBySurnameIgnoreCase(String surname);

}
