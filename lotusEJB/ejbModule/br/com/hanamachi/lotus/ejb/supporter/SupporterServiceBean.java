package br.com.hanamachi.lotus.ejb.supporter;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Group;
import br.com.hanamachi.lotus.model.Supporter;

@Stateless
public class SupporterServiceBean extends LotusServiceBean<Supporter> implements SupporterService{

	@PersistenceContext(unitName="lotusweb")
    private EntityManager em;
	
	public SupporterServiceBean(){
		super(Supporter.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Supporter> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Supporter toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Supporter c) {
		c = em.find(Supporter.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Supporter> getSuporterByDescription(String searchValue) {
		Query q = em.createQuery("Select g from Supporter g where g.description like %" + searchValue + "%");
		return q.getResultList();
	}


}
