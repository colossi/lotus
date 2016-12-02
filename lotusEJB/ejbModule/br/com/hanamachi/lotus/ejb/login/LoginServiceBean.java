package br.com.hanamachi.lotus.ejb.login;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Login;

@Stateless
public class LoginServiceBean extends LotusServiceBean<Login> implements LoginService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public LoginServiceBean() {
		super(Login.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Login> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Login toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Login c) {
		c = em.find(Login.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Login> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Login g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
