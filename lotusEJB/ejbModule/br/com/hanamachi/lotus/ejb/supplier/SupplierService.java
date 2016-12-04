package br.com.hanamachi.lotus.ejb.supplier;

import java.util.List;

import br.com.hanamachi.lotus.model.Supplier;

public interface SupplierService {

	public void save(Supplier toSave);

	public void delete(Supplier c);

	public List<Supplier> getSuporterByDescription(String description);

	public List<Supplier> findAll();

}
