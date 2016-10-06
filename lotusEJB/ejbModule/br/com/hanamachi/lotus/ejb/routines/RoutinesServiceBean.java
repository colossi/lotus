package br.com.hanamachi.lotus.ejb.routines;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoutinesServiceBean implements RoutinesService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public RoutinesServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
