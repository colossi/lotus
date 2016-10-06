package br.com.hanamachi.lotus.ejb.supporter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SupporterServiceBean implements SupporterService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public SupporterServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
