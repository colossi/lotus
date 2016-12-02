package br.com.hanamachi.lotus.ejb.item;

import java.util.List;

import br.com.hanamachi.lotus.model.Item;

public interface ItemService {

	public void save(Item toSave);

	public void delete(Item c);

	public List<Item> getClienteByDescription(String description);

}
