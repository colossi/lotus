package br.com.hanamachi.lotus.ejb.company;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CompanyServiceBean implements CompanyService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public CompanyServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
