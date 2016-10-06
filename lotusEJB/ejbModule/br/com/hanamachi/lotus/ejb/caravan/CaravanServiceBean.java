package br.com.hanamachi.lotus.ejb.caravan;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CaravanServiceBean implements CaravanService{
	
	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public CaravanServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
