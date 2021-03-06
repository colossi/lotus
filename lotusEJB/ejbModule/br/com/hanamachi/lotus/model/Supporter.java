package br.com.hanamachi.lotus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Supporter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String site;

	private String facebook;
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	private Natural natural = new Natural();
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	private Company company = new Company();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public Natural getNatural() {
		return natural;
	}

	public void setNatural(Natural natural) {
		this.natural = natural;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


	
}
