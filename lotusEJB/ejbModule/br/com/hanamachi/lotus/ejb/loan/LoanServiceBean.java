package br.com.hanamachi.lotus.ejb.loan;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Loan;

@Stateless
public class LoanServiceBean extends LotusServiceBean<Loan> implements LoanService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public LoanServiceBean() {
		super(Loan.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Loan> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Loan toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Loan c) {
		c = em.find(Loan.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Loan> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Loan g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
