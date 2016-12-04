package br.com.hanamachi.lotus.ejb.attraction;

import java.util.List;

import br.com.hanamachi.lotus.model.Attraction;

public interface AttractionService {

	 public void save(Attraction toSave);

	 public void delete(Attraction c);

	 public List<Attraction> getAttractionByDescription(String description);

	public List<Attraction> findAll();

}
