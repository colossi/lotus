package br.com.hanamachi.lotus.ejb.category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryServiceBean implements CategoryService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public CategoryServiceBean() {

	}
}
