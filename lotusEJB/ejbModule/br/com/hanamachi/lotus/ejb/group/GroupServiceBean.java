package br.com.hanamachi.lotus.ejb.group;

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

	
}
