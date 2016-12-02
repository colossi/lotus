package br.com.hanamachi.lotus.ejb.inventory;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Inventory;

@Stateless
public class InventoryServiceBean extends LotusServiceBean<Inventory> implements InventoryService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public InventoryServiceBean() {
		super(Inventory.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Inventory> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Inventory toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Inventory c) {
		c = em.find(Inventory.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Inventory> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Inventory g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
