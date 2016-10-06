package br.com.hanamachi.lotus.ejb.item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ItemServiceBean implements ItemService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public ItemServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
