package br.com.hanamachi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.hanamachi.lotus.ejb.group.GroupService;
import br.com.hanamachi.lotus.model.Group;

@ManagedBean(name="crtGroup")
@ViewScoped
public class GroupController {
	@EJB
	private GroupService groupService;
	
	private Group model = new Group();
	
	private String searchValue;
	
	public Group getModel() {
		return model;
	}
	
	private List<Group> colGroups = new ArrayList<Group>();
	
	@PostConstruct
	public void init(){
		colGroups = groupService.findAll();
	}

	public void setModel(Group model) {
		this.model = model;
	}


	public void save(){
		groupService.save(model);
	}
	
	public void create(){
		model = new Group();
		init();
	}
	
	public void search(){
		colGroups = groupService.getClienteByDescription(searchValue);
		if(colGroups.size() == 0){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("ERRO",  "Nenhum registro foi encontrado...") );
		}
	}
	
	public void remove(){
		groupService.delete(model);
		init();
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<Group> getColGroups() {
		return colGroups;
	}

	public void setColGroups(List<Group> colGroups) {
		this.colGroups = colGroups;
	}
	
	
	
	
	
}
