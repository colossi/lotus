package br.com.hanamachi.lotus.ejb.group;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GroupServiceBean implements GroupService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public GroupServiceBean(){
		
		
		
	}
	
}
