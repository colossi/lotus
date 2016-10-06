package br.com.hanamachi.lotus.ejb.address;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AddressServiceBean implements AddressService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public AddressServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
