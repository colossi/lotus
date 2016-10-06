package br.com.hanamachi.lotus.ejb.natural;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class NaturalServiceBean implements NaturalService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public NaturalServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
