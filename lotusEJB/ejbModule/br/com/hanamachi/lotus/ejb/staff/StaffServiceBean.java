package br.com.hanamachi.lotus.ejb.staff;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Staff;

@Stateless
public class StaffServiceBean extends LotusServiceBean<Staff> implements StaffService {

	@PersistenceContext(unitName="lotusweb")
    private EntityManager em;
	
	public StaffServiceBean(){
		super(Staff.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Staff> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Staff toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Staff c) {
		c = em.find(Staff.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Staff> getSuporterByDescription(String searchValue) {
		Query q = em.createQuery("Select g from Staff g where g.description like %" + searchValue + "%");
		return q.getResultList();
	}
}
