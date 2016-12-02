package br.com.hanamachi.lotus.ejb.address;

import java.util.List;

import br.com.hanamachi.lotus.model.Address;

public interface AddressService {

	public void save(Address toSave);

	public void delete(Address c);

	public List<Address> getClienteByDescription(String description);

	
}
