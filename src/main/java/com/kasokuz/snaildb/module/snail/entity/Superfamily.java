package com.kasokuz.snaildb.module.snail.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "snail_superfamily")
public class Superfamily {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer superfamilyId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "superfamily")
	private List<Family> families;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "taxonomer_id")
	private Taxonomer taxonomer;
	
	@Column(nullable = false)
	private Integer taxonomyYear;

	public Integer getSuperfamilyId() {
		return superfamilyId;
	}

	public void setSuperfamilyId(Integer superfamilyId) {
		this.superfamilyId = superfamilyId;
	}

	public List<Family> getFamilies() {
		return families;
	}

	public void setFamilies(List<Family> families) {
		this.families = families;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Taxonomer getTaxonomer() {
		return taxonomer;
	}

	public void setTaxonomer(Taxonomer taxonomer) {
		this.taxonomer = taxonomer;
	}

	public Integer getTaxonomyYear() {
		return taxonomyYear;
	}

	public void setTaxonomyYear(Integer taxonomyYear) {
		this.taxonomyYear = taxonomyYear;
	}

}
