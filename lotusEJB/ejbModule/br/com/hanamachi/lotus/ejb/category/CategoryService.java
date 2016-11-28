package br.com.hanamachi.lotus.ejb.category;

import java.util.List;

import br.com.hanamachi.lotus.model.Category;

public interface CategoryService {
	
	public List<Category> findAll();

	void save(Category toSave);

	void delete(Category c);

	List<Category> getCategoryByDescription(String description);

}
