package com.kasokuz.snaildb.controller.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasokuz.snaildb.controller.get.response.GetTotalResponse;
import com.kasokuz.snaildb.service.SnailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "getinfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetInfoController {

	@Autowired
	private SnailService service;
	
	@GetMapping(value = "total")
	public GetTotalResponse getTotal() {
		return new GetTotalResponse(service.countTaxonomers(), service.countSuperfamilies(), service.countFamilies(), service.countGenuses(), service.countSpecies(), service.countSubspecies());
	}
	
	@GetMapping(value = "speciesnotextinct")
	public Long getSpeciesNotExtinct() {
		return service.countSpeciesNotExtinct();
	}
	
}
