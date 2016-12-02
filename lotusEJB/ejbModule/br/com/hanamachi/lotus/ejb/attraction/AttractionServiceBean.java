package br.com.hanamachi.lotus.ejb.attraction;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Attraction;

@Stateless
public class AttractionServiceBean extends LotusServiceBean<Attraction> implements AttractionService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public AttractionServiceBean() {
		super(Attraction.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Attraction> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Attraction toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Attraction c) {
		c = em.find(Attraction.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Attraction> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Attraction g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
