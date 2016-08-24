package br.com.hanamachi.lotus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;

	private String name;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private State state;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}


}
