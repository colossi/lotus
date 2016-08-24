package br.com.hanamachi.lotus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Long amount;

	private int entryDate;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Category category;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public int getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(int entryDate) {
		this.entryDate = entryDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	

}
