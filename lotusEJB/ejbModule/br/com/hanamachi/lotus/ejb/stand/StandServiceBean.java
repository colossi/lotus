package br.com.hanamachi.lotus.ejb.stand;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StandServiceBean implements StandService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public StandServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
