package br.com.hanamachi.lotus.ejb.state;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.State;

@Stateless
public class StateServiceBean extends LotusServiceBean<State> implements StateService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public StateServiceBean() {
		super(State.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<State> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(State toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(State c) {
		c = em.find(State.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<State> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from State g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
