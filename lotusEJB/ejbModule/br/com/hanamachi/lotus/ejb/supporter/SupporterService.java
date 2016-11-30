package br.com.hanamachi.lotus.ejb.supporter;

import java.util.List;

import br.com.hanamachi.lotus.model.Supporter;

public interface SupporterService {

	List<Supporter> findAll();

	void save(Supporter toSave);

	void delete(Supporter c);

	List<Supporter> getSuporterByDescription(String searchValue);

}
