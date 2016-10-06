package br.com.hanamachi.lotus.ejb.city;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CityServiceBean implements CityService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public CityServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
