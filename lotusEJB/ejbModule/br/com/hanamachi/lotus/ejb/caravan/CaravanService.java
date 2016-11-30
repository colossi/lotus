package br.com.hanamachi.lotus.ejb.caravan;

import java.util.List;

import br.com.hanamachi.lotus.model.Caravan;

public interface CaravanService {

	void save(Caravan toSave);

	void delete(Caravan c);

	List<Caravan> getClienteByDescription(String description);

	List<Caravan> findAll();

}
