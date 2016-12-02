package br.com.hanamachi.lotus.ejb.routines;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Routines;

@Stateless
public class RoutinesServiceBean extends LotusServiceBean<Routines> implements RoutinesService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public RoutinesServiceBean() {
		super(Routines.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Routines> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Routines toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Routines c) {
		c = em.find(Routines.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Routines> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Routines g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
