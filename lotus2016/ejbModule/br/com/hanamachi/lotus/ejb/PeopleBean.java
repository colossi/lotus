package br.com.hanamachi.lotus.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class PeopleBean
 */
@Stateless
public class PeopleBean implements PeopleBeanLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(name="dsi2016context")
	private EntityManager em;
    public PeopleBean() {
        // TODO Auto-generated constructor stub
    }

}
