package br.com.hanamachi.lotus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private long amount;
	
	@OneToMany(cascade={CascadeType.ALL})
	private Item[] item;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Item[] getItem() {
		return item;
	}

	public void setItem(Item[] item) {
		this.item = item;
	}


}
