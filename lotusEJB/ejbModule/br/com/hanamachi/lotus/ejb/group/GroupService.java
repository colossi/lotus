package br.com.hanamachi.lotus.ejb.group;

import java.util.List;

import br.com.hanamachi.lotus.model.Group;

public interface GroupService {

	public List<Group> findAll();

	void save(Group toSave);

	void delete(Group c);

	List<Group> getClienteByDescription(String description);
	

}
