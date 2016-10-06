package br.com.hanamachi.lotus.ejb.loan;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoanServiceBean implements LoanService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public LoanServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
