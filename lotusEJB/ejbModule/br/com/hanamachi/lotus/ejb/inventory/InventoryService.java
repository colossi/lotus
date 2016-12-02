package br.com.hanamachi.lotus.ejb.inventory;

import java.util.List;

import br.com.hanamachi.lotus.model.Inventory;

public interface InventoryService {

	public void save(Inventory toSave);

	public void delete(Inventory c);

	public List<Inventory> getClienteByDescription(String description);

}
