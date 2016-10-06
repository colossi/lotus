package br.com.hanamachi.lotus.ejb.product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductServiceBean implements ProductService{
	
	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public ProductServiceBean() {
		// TODO Auto-generated constructor stub
	}
	
}
