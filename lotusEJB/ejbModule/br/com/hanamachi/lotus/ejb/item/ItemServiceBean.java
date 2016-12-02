package br.com.hanamachi.lotus.ejb.item;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Item;

@Stateless
public class ItemServiceBean extends LotusServiceBean<Item> implements ItemService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public ItemServiceBean() {
		super(Item.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Item> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Item toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Item c) {
		c = em.find(Item.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Item> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Item g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
