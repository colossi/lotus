package br.com.hanamachi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.hanamachi.lotus.ejb.caravan.CaravanService;
import br.com.hanamachi.lotus.model.Caravan;

@ManagedBean(name="crtCaravan")
@ViewScoped
public class CaravanController {
	@EJB
	private CaravanService caravanService;
	
	private Caravan model = new Caravan();
	
	private String searchValue;
	
	public Caravan getModel() {
		return model;
	}
	
	private List<Caravan> colCaravans = new ArrayList<Caravan>();
	
	@PostConstruct
	public void init(){
		colCaravans = caravanService.findAll();
	}

	public void setModel(Caravan model) {
		this.model = model;
	}


	public void save(){
		caravanService.save(model);
		init();
	}
	
	public void create(){
		model = new Caravan();
		init();
	}
	
	public void search(){
		colCaravans = caravanService.getClienteByDescription(searchValue);
		if(colCaravans.size() == 0){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("ERRO",  "Nenhum registro foi encontrado...") );
		}
	}
	
	public void remove(){
		caravanService.delete(model);
		init();
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<Caravan> getColCaravans() {
		return colCaravans;
	}

	public void setColCaravans(List<Caravan> colCaravans) {
		this.colCaravans = colCaravans;
	}
	
	
	
	
	
}
