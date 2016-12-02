package br.com.hanamachi.lotus.ejb.permission;

import java.util.List;

import br.com.hanamachi.lotus.model.Permission;

public interface PermissonService {

	public void save(Permission toSave);

	public void delete(Permission c);

	public List<Permission> getClienteByDescription(String description);

}
