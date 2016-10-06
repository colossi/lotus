package br.com.hanamachi.lotus.ejb.supplier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SupplierServiceBean implements SupplierService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public SupplierServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
