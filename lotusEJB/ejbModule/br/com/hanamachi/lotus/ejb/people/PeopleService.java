package br.com.hanamachi.lotus.ejb.people;

import java.util.List;

import javax.ejb.Local;

import br.com.hanamachi.lotus.model.People;

@Local
public interface PeopleService {

	public void save(People toSave);

	public void delete(People c);

	public List<People> getClienteByDescription(String description);

}
