package br.com.hanamachi.lotus.ejb.permission;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PermissionServiceBean implements PermissonService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public PermissionServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
