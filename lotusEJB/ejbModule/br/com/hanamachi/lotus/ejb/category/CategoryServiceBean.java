package br.com.hanamachi.lotus.ejb.category;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Category;

@Stateless
public class CategoryServiceBean extends LotusServiceBean<Category> implements CategoryService {

	@PersistenceContext(unitName="lotusweb")
    private EntityManager em;
	
	public CategoryServiceBean(){
		super(Category.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Category> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Category toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Category c) {
		c = em.find(Category.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Category> getCategoryByDescription(String description) {
		Query q = em.createQuery("Select g from Category g where g.description like %" + description + "%");
		return q.getResultList();
	}
	
}
