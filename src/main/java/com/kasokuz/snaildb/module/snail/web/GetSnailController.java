package com.kasokuz.snaildb.module.snail.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kasokuz.snaildb.module.snail.entity.*;
import com.kasokuz.snaildb.module.snail.service.SnailService;

@Controller
@RequestMapping("snail/get")
public class GetSnailController {
	
	@Autowired
	private SnailService service;
	
	@RequestMapping(value = "{superfamily}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result<Superfamily> getSuperfamily(@PathVariable("superfamily") String superfamily) {
		return new Result<>(service.getSuperfamily(superfamily));
	}
	
	@RequestMapping(value = "{superfamily}/{family}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result<Family> getFamily(@PathVariable("superfamily") String superfamily,
													@PathVariable("family") String family) {
		return new Result<>(service.getFamily(family, superfamily));
	}
	
	@RequestMapping(value = "{superfamily}/{family}/{genus}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result<Genus> getGenus(@PathVariable("superfamily") String superfamily,
												@PathVariable("family") String family,
												@PathVariable("genus") String genus) {
		return new Result<>(service.getGenus(genus, superfamily, family));
	}
	
	@RequestMapping(value = "{superfamily}/{family}/{genus}/{species}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result<Species> getSpecies(@PathVariable("superfamily") String superfamily,
													@PathVariable("family") String family,
													@PathVariable("genus") String genus,
													@PathVariable("species") String species) {
		return new Result<>(service.getSpecies(species, superfamily, family, genus));
	}
	
	@RequestMapping(value = "{superfamily}/{family}/{genus}/{species}/{subspecies}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Result<Subspecies> getSubspecies(@PathVariable("superfamily") String superfamily,
															@PathVariable("family") String family,
															@PathVariable("genus") String genus,
															@PathVariable("species") String species,
															@PathVariable("subspecies") String subspecies) {
		return new Result<>(service.getSubspecies(subspecies, superfamily, family, genus, species));
	}
	
	private static class Result<T> {
		
		private T result;
		
		public Result(T result) {
			this.result = result;
		}
		
		@SuppressWarnings("unused")
		public T getResult() {
			return result;
		}
		
	}
	
}