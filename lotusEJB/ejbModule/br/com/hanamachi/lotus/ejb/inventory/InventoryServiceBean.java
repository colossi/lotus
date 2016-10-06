package br.com.hanamachi.lotus.ejb.inventory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InventoryServiceBean implements InventoryService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public InventoryServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
