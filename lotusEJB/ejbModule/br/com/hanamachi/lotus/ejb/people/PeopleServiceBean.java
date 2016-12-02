package br.com.hanamachi.lotus.ejb.people;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.People;

/**
 * Session Bean implementation class PeopleBean
 */
@Stateless
public class PeopleServiceBean extends LotusServiceBean<People> implements PeopleService {

    /**
     * Default constructor. 
     */
	@PersistenceContext(name="lotusweb")
	private EntityManager em;
    public PeopleServiceBean() {
        super(People.class);
    }
    
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<People> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(People toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(People c) {
		c = em.find(People.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<People> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from People g where g.description like %" + description + "%");
		return q.getResultList();
	}

}
