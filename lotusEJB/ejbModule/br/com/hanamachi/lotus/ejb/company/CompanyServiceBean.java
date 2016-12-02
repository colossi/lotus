package br.com.hanamachi.lotus.ejb.company;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Company;
import br.com.hanamachi.lotus.model.Group;

@Stateless
public class CompanyServiceBean extends LotusServiceBean<Company> implements CompanyService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public CompanyServiceBean() {
		super(Company.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Company> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Company toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Company c) {
		c = em.find(Company.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Company> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Company g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
