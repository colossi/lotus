package br.com.hanamachi.lotus.ejb.messages;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Messages;

@Stateless
public class MessagesServiceBean extends LotusServiceBean<Messages> implements MessagesService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public MessagesServiceBean() {
		super(Messages.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Messages> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Messages toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Messages c) {
		c = em.find(Messages.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Messages> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Messages g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
