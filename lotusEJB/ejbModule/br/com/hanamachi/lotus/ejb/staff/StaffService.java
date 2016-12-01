package br.com.hanamachi.lotus.ejb.staff;

import java.util.List;

import br.com.hanamachi.lotus.model.Staff;

public interface StaffService {

	List<Staff> getSuporterByDescription(String searchValue);

	void delete(Staff c);

	void save(Staff toSave);

	List<Staff> findAll();

}
