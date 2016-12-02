package br.com.hanamachi.lotus.ejb.natural;

import java.util.List;

import br.com.hanamachi.lotus.model.Natural;

public interface NaturalService {

	public void save(Natural toSave);

	public void delete(Natural c);

	public List<Natural> getClienteByDescription(String description);

}
