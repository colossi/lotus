package br.com.hanamachi.lotus.ejb.people;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class PeopleBean
 */
@Stateless
public class PeopleServiceBean implements PeopleService {

    /**
     * Default constructor. 
     */
	@PersistenceContext(name="lotus")
	private EntityManager em;
    public PeopleServiceBean() {
        // TODO Auto-generated constructor stub
    }

}
