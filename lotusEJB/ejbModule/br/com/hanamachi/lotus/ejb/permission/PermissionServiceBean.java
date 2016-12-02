package br.com.hanamachi.lotus.ejb.permission;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Permission;

@Stateless
public class PermissionServiceBean extends LotusServiceBean<Permission> implements PermissonService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public PermissionServiceBean() {
		super(Permission.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Permission> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Permission toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Permission c) {
		c = em.find(Permission.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Permission> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Permission g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
