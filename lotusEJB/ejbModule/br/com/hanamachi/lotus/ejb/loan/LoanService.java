package br.com.hanamachi.lotus.ejb.loan;

import java.util.List;

import br.com.hanamachi.lotus.model.Loan;

public interface LoanService {

	public void save(Loan toSave);

	public void delete(Loan c);

	public List<Loan> getClienteByDescription(String description);

}
