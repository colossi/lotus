package br.com.hanamachi.lotus.ejb.product;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Product;

@Stateless
public class ProductServiceBean extends LotusServiceBean<Product> implements ProductService{
	
	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public ProductServiceBean() {
		super(Product.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Product> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Product toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Product c) {
		c = em.find(Product.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Product> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Product g where g.description like %" + description + "%");
		return q.getResultList();
	}
	
}
