package com.kasokuz.snaildb.controller.get.response;

import java.util.ArrayList;
import java.util.List;

public class GetSpeciesResponse extends CommonResponse {
	
	public final Integer genusId, subgenusId;
	
	public final String type;
	
	public final Boolean viviparous, extinct;
	
	public final List<GetSubspeciesResponse> subspecies = new ArrayList<>();
	
	public GetSpeciesResponse(com.kasokuz.snaildb.domain.Species species) {
		super(species.getSpeciesId(), species.getName(), species.getTaxonomers(), species.getTaxonomyYear());
		this.genusId = species.getGenus().getGenusId();
		if(species.getSubgenus() != null) this.subgenusId = species.getSubgenus().getSubgenusId();
		else this.subgenusId = null;
		this.type = species.getGenus().getFamily().getSuperfamily().getType();
		this.viviparous = species.getViviparous();
		this.extinct = species.getExtinct();
		for(com.kasokuz.snaildb.domain.Subspecies subspecies : species.getSubspecies()) {
			this.subspecies.add(new GetSubspeciesResponse(subspecies));
		}
	}
	
	public static GetSpeciesResponse from(com.kasokuz.snaildb.domain.Species species) {
		if(species == null) return null;
		else return new GetSpeciesResponse(species);
	}

}
