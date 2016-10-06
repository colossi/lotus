package br.com.hanamachi.lotus.ejb.attraction;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AttractionServiceBean implements AttractionService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public AttractionServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
