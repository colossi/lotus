package br.com.hanamachi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.hanamachi.lotus.ejb.attraction.AttractionService;
import br.com.hanamachi.lotus.model.Attraction;

@ManagedBean(name="crtAttraction")
@ViewScoped
public class AttractionController {
	@EJB
	private AttractionService attractionService;
	
	private Attraction model = new Attraction();
	
	private String searchValue;
	
	public Attraction getModel() {
		return model;
	}
	
	private List<Attraction> colAttraction = new ArrayList<Attraction>();
	
	@PostConstruct
	public void init(){
		colAttraction = attractionService.findAll();
	}

	public void setModel(Attraction model) {
		this.model = model;
	}


	public void save(){
		attractionService.save(model);
		init();
	}
	
	public void create(){
		model = new Attraction();
		init();
	}
	
	public void search(){
		colAttraction = attractionService.getAttractionByDescription(searchValue);
		if(colAttraction.size() == 0){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("ERRO",  "Nenhum registro foi encontrado...") );
		}
	}
	
	public void remove(){
		attractionService.delete(model);
		init();
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<Attraction> getColAttraction() {
		return colAttraction;
	}

	public void setColAttraction(List<Attraction> colAttraction) {
		this.colAttraction = colAttraction;
	}
	
	
	
	
	
}
