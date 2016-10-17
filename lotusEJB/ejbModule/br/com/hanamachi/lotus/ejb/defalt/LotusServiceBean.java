package br.com.hanamachi.lotus.ejb.defalt;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public abstract class LotusServiceBean<T> {

	@PersistenceContext(name = "lotusweb")
	private EntityManager em;

	private Class<T> entityClass;
	
	public LotusServiceBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

	protected abstract EntityManager getEntityManager();

	public T persist(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	public T edit(T entity) {
		getEntityManager().merge(entity);
		return entity;
	}

	public T remove(T entity) {
		getEntityManager().remove(entity);
		return entity;
	}

	public List<T> findAll() {

		Query q = getEntityManager().createQuery("SELECT e FROM " + entityClass.getName() + " e");
		List<T> list = (List<T>) q.getResultList();
		return list;
	}

	public T find(Long id) {
		T e = getEntityManager().find(entityClass, id);
		return e;
	}

}
