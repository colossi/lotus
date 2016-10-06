package br.com.hanamachi.lotus.ejb.state;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StateServiceBean implements StateService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public StateServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
