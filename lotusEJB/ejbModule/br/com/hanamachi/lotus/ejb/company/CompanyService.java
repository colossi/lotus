package br.com.hanamachi.lotus.ejb.company;

import java.util.List;

import br.com.hanamachi.lotus.model.Company;

public interface CompanyService {

	public void save(Company toSave);

	public void delete(Company c);

	public List<Company> getClienteByDescription(String description);

}
