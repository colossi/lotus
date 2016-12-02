package br.com.hanamachi.lotus.ejb.city;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.City;

@Stateless
public class CityServiceBean extends LotusServiceBean<City> implements CityService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public CityServiceBean() {
		super(City.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<City> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(City toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(City c) {
		c = em.find(City.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<City> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from City g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
