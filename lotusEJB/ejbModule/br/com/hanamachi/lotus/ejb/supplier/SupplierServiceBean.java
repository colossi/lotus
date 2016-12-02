package br.com.hanamachi.lotus.ejb.supplier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Supplier;

@Stateless
public class SupplierServiceBean extends LotusServiceBean<Supplier> implements SupplierService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public SupplierServiceBean() {
		super(Supplier.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Supplier> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Supplier toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Supplier c) {
		c = em.find(Supplier.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Supplier> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Supplier g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
