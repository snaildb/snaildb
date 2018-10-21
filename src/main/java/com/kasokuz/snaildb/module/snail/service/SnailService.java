package com.kasokuz.snaildb.module.snail.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasokuz.snaildb.module.snail.dto.*;
import com.kasokuz.snaildb.module.snail.repository.*;

@Service
public class SnailService {
	
	@Autowired
	private TaxonomerRepository taxonomerRepository;
	
	@Autowired
	private SuperfamilyRepository superfamilyRepository;
	
	@Autowired
	private FamilyRepository familyRepository;
	
	@Autowired
	private GenusRepository genusRepository;
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	@Autowired
	private SubspeciesRepository subspeciesRepository;
	
	// SAVE
	
	@Transactional
	public Taxonomer saveTaxonomer(Taxonomer taxonomer) {
		return taxonomerRepository.save(taxonomer);
	}

	@Transactional
	public Superfamily saveSuperfamily(Superfamily superfamily) {
		return superfamilyRepository.save(superfamily);
	}

	@Transactional
	public Family saveFamily(Family family) {
		return familyRepository.save(family);
	}
	
	@Transactional
	public Genus saveGenus(Genus genus) {
		return genusRepository.save(genus);
	}

	@Transactional
	public Species saveSpecies(Species species) {
		return speciesRepository.save(species);
	}

	@Transactional
	public Subspecies saveSubspecies(Subspecies subspecies) {
		return subspeciesRepository.save(subspecies);
	}
	
	// GET
	
	public Iterable<Superfamily> getSuperfamilies() {
		return superfamilyRepository.findAll();
	}
	
	// GET BY ID
	
	public Taxonomer getTaxonomer(Integer taxonomerId) {
		return taxonomerRepository.findByTaxonomerId(taxonomerId);
	}
	
	public Superfamily getSuperfamily(Integer superfamilyId) {
		return superfamilyRepository.findBySuperfamilyId(superfamilyId);
	}
	
	public Family getFamily(Integer familyId) {
		return familyRepository.findByFamilyId(familyId);
	}
	
	public Genus getGenus(Integer genusId) {
		return genusRepository.findByGenusId(genusId);
	}
	
	public Species getSpecies(Integer speciesId) {
		return speciesRepository.findBySpeciesId(speciesId);
	}
	
	public Subspecies getSubspecies(Integer subspeciesId) {
		return subspeciesRepository.findBySubspeciesId(subspeciesId);
	}
	
	// GET BY NAME
	
	public Taxonomer getTaxonomer(String surname) {
		return taxonomerRepository.findBySurnameIgnoreCase(surname);
	}

	public Superfamily getSuperfamily(String superfamily) {
		return superfamilyRepository.findByName(superfamily);
	}
	
	public Family getFamily(String family, String superfamily) {
		return familyRepository.findByNameAndSuperfamily(family, getSuperfamily(superfamily));
	}
	
	public Genus getGenus(String genus, String superfamily, String family) {
		return genusRepository.findByNameAndFamily(genus, getFamily(family, superfamily));
	}
	
	public Species getSpecies(String species, String superfamily, String family, String genus) {
		return speciesRepository.findByNameAndGenus(species, getGenus(genus, superfamily, family));
	}
	
	public Subspecies getSubspecies(String subspecies, String superfamily, String family, String genus, String species) {
		return subspeciesRepository.findByNameAndSpecies(subspecies, getSpecies(species, superfamily, family, genus));
	}
	
	// SEARCH
	
	public Iterable<Superfamily> searchSuperfamilies(String query) {
		return superfamilyRepository.findByNameContaining(query);
	}
	
	public Iterable<Family> searchFamilies(String query) {
		return familyRepository.findByNameContaining(query);
	}
	
	public Iterable<Genus> searchGenuses(String query) {
		return genusRepository.findByNameContaining(query);
	}
	
	public Iterable<Species> searchSpecies(String query) {
		return speciesRepository.findByNameContaining(query);
	}
	
	public Iterable<Subspecies> searchSubspecies(String query) {
		return subspeciesRepository.findByNameContaining(query);
	}
	
	// DELETE
	
	@Transactional
	public void deleteTaxonomer(Integer taxonomerId) {
		taxonomerRepository.deleteById(taxonomerId);
	}
	
	@Transactional
	public void deleteSuperfamily(Integer superfamilyId) {
		superfamilyRepository.deleteById(superfamilyId);
	}
	
	@Transactional
	public void deleteFamily(Integer familyId) {
		familyRepository.deleteById(familyId);
	}
	
	@Transactional
	public void deleteGenus(Integer genusId) {
		genusRepository.deleteById(genusId);
	}
	
	@Transactional
	public void deleteSpecies(Integer speciesId) {
		speciesRepository.deleteById(speciesId);
	}
	
	@Transactional
	public void deleteSubspecies(Integer subspeciesId) {
		subspeciesRepository.deleteById(subspeciesId);
	}

}
