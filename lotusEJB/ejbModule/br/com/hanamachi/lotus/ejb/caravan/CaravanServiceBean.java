package br.com.hanamachi.lotus.ejb.caravan;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Caravan;
import br.com.hanamachi.lotus.model.Caravan;

@Stateless
public class CaravanServiceBean extends LotusServiceBean<Caravan> implements CaravanService {

	@PersistenceContext(unitName = "lotusweb")
	private EntityManager em;

	public CaravanServiceBean(){
		super(Caravan.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<Caravan> findAll() {
		return super.findAll();
	}

	@Override
	public void save(Caravan toSave) {

		if (toSave.getId() == null) {
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}

	}

	@Override
	public void delete(Caravan c) {
		c = em.find(Caravan.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Caravan> getClienteByDescription(String description) {
		Query q = em.createQuery("Select g from Caravan g where g.description like %" + description + "%");
		return q.getResultList();
	}
}
