package br.com.hanamachi.lotus.ejb.messages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MessagesServiceBean implements MessagesService {

	@PersistenceContext(name="lotusweb")
	private EntityManager em;
	public MessagesServiceBean() {
		// TODO Auto-generated constructor stub
	}
}
