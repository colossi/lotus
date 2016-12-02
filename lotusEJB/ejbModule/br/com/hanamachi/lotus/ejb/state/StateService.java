package br.com.hanamachi.lotus.ejb.state;

import java.util.List;

import br.com.hanamachi.lotus.model.State;

public interface StateService {

	public void save(State toSave);

	public void delete(State c);

	public List<State> getClienteByDescription(String description);

}
