package br.com.hanamachi.lotus.ejb.group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GroupServiceBean implements GroupService{

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public GroupServiceBean(){
		
		
		
	}
	
}
