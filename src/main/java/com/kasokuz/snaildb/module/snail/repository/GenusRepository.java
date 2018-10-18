package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.entity.Family;
import com.kasokuz.snaildb.module.snail.entity.Genus;

public interface GenusRepository extends CrudRepository<Genus, Integer> {
	
	public Genus findByNameAndFamily(String name, Family family);

}