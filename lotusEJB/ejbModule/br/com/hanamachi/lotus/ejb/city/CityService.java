package br.com.hanamachi.lotus.ejb.city;

import java.util.List;

import br.com.hanamachi.lotus.model.City;

public interface CityService {

	public void save(City toSave);

	public void delete(City c);

	public List<City> getClienteByDescription(String description);

}
