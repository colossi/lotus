package br.com.hanamachi.lotus.ejb.stand;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Stand;

@Stateless
public class StandServiceBean extends LotusServiceBean<Stand> implements StandService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public StandServiceBean() {
		super(Stand.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Stand> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Stand toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Stand c) {
		c = em.find(Stand.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Stand> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Stand g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
