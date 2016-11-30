package br.com.hanamachi.lotus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Caravan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String caravanName;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Natural natural = new Natural();
	
	@OneToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaravanName() {
		return caravanName;
	}

	public void setCaravanName(String caravanName) {
		this.caravanName = caravanName;
	}

	public Natural getNatural() {
		return natural;
	}

	public void setNatural(Natural natural) {
		this.natural = natural;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

}
