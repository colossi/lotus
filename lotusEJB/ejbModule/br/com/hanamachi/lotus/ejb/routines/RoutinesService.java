package br.com.hanamachi.lotus.ejb.routines;

import java.util.List;

import br.com.hanamachi.lotus.model.Routines;

public interface RoutinesService {

	public void save(Routines toSave);

	public void delete(Routines c);

	public List<Routines> getClienteByDescription(String description);

}
