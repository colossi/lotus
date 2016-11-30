package br.com.hanamachi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.hanamachi.lotus.ejb.supporter.SupporterService;
import br.com.hanamachi.lotus.model.Supporter;

@ManagedBean(name="crtSupporter")
@ViewScoped
public class SupporterController {
	@EJB
	private SupporterService supporterService;
	
	private Supporter model = new Supporter();
	
	private String searchValue;
	
	public Supporter getModel() {
		return model;
	}
	
	private List<Supporter> colSupporters = new ArrayList<Supporter>();
	

	@PostConstruct
	public void init(){
		colSupporters = supporterService.findAll();
	}

	public void setModel(Supporter model) {
		this.model = model;
	}


	public void save(){
		supporterService.save(model);
		init();
	}
	
	public void create(){
		model = new Supporter();
		init();
	}
	
	public void search(){
		colSupporters = supporterService.getSuporterByDescription(searchValue);
		if(colSupporters.size() == 0){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("ERRO",  "Nenhum registro foi encontrado...") );
		}
	}
	
	public void remove(){
		supporterService.delete(model);
		init();
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<Supporter> getColSupporters() {
		return colSupporters;
	}

	public void setColSupporters(List<Supporter> colSupporters) {
		this.colSupporters = colSupporters;
	}
	
	
	
	
	
}
