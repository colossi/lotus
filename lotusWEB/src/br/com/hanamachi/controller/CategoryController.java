package br.com.hanamachi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.hanamachi.lotus.ejb.category.CategoryService;
import br.com.hanamachi.lotus.model.Category;

@ManagedBean(name="crtCategory")
@ViewScoped
public class CategoryController {
	@EJB
	private CategoryService categoryService;
	
	private Category model = new Category();
	
	private String searchValue;
	
	public Category getModel() {
		return model;
	}
	
	private List<Category> colCategory = new ArrayList<Category>();
	
	@PostConstruct
	public void init(){
		colCategory = categoryService.findAll();
	}

	public void setModel(Category model) {
		this.model = model;
	}


	public void save(){
		categoryService.save(model);
	}
	
	public void create(){
		model = new Category();
		init();
	}
	
	public void search(){
		colCategory = categoryService.getCategoryByDescription(searchValue);
		if(colCategory.size() == 0){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("ERRO",  "Nenhum registro foi encontrado...") );
		}
	}
	
	public void remove(){
		categoryService.delete(model);
		init();
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<Category> getColCategory() {
		return colCategory;
	}

	public void setColCategory(List<Category> colCategory) {
		this.colCategory = colCategory;
	}
	
	
	
	
	
}
