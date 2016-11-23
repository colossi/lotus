package br.com.hanamachi.lotus.ejb.group;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.hanamachi.lotus.ejb.defalt.LotusServiceBean;
import br.com.hanamachi.lotus.model.Group;


@Stateless
public class GroupServiceBean extends LotusServiceBean<Group> implements GroupService{

	@PersistenceContext(unitName="lotusweb")
    private EntityManager em;
	
	public GroupServiceBean(){
		super(Group.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	@Override
	public List<Group> findAll(){
		return super.findAll();
	}
	
	@Override
	public void save(Group toSave){
		
		if(toSave.getId() == null){
			em.persist(toSave);
		} else {
			em.merge(toSave);
		}
		
	}
	
	@Override
	public void delete(Group c) {
		c = em.find(Group.class, c.getId());
		em.remove(c);
	}

	@Override
	public List<Group> getClienteByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

	
}
