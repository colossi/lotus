package br.com.hanamachi.lotus.ejb.staff;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StaffServiceBean {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public StaffServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
