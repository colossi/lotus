package br.com.hanamachi.lotus.ejb.login;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginServiceBean implements LoginService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public LoginServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
