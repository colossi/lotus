package br.com.hanamachi.lotus.ejb.natural;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Natural;

@Stateless
public class NaturalServiceBean extends LotusServiceBean<Natural> implements NaturalService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public NaturalServiceBean() {
		super(Natural.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Natural> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Natural toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Natural c) {
		c = em.find(Natural.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Natural> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Natural g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
