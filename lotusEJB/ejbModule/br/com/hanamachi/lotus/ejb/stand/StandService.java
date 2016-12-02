package br.com.hanamachi.lotus.ejb.stand;

import java.util.List;

import br.com.hanamachi.lotus.model.Stand;

public interface StandService {

	public void save(Stand toSave);

	public void delete(Stand c);

	public List<Stand> getClienteByDescription(String description);

}
