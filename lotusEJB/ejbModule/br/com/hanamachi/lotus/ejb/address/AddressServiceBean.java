package br.com.hanamachi.lotus.ejb.address;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Address;

@Stateless
public class AddressServiceBean extends LotusServiceBean<Address> implements AddressService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	
	public AddressServiceBean() {
		super(Address.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	@Override
	public List<Address> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Address toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Address c) {
		c = em.find(Address.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Address> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Address g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
