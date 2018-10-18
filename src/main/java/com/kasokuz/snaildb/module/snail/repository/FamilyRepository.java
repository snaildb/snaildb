package com.kasokuz.snaildb.module.snail.repository;

import org.springframework.data.repository.CrudRepository;

import com.kasokuz.snaildb.module.snail.entity.Family;
import com.kasokuz.snaildb.module.snail.entity.Superfamily;

public interface FamilyRepository extends CrudRepository<Family, Integer> {

	public Family findByNameAndSuperfamily(String name, Superfamily superfamily);
	
}