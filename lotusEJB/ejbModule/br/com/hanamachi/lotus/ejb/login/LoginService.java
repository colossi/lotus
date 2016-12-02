package br.com.hanamachi.lotus.ejb.login;

import java.util.List;

import br.com.hanamachi.lotus.model.Login;

public interface LoginService {

	public void save(Login toSave);

	public void delete(Login c);

	public List<Login> getClienteByDescription(String description);

}
