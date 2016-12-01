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
import br.com.hanamachi.lotus.ejb.staff.StaffService;
import br.com.hanamachi.lotus.model.Group;
import br.com.hanamachi.lotus.model.Staff;

@ManagedBean(name="crtStaff")
@ViewScoped
public class StaffController {
	@EJB
	private StaffService staffService;
	
	@EJB
	private GroupService groupService;
	
	private Staff model = new Staff();
	
	private String searchValue;
	
	public Staff getModel() {
		return model;
	}
	
	private List<Staff> colStaffs = new ArrayList<Staff>();
	private List<Group> colGroup = new ArrayList<Group>();
	

	@PostConstruct
	public void init(){
		colStaffs = staffService.findAll();
		colGroup = groupService.findAll();
	}

	public void setModel(Staff model) {
		this.model = model;
	}


	public void save(){
		staffService.save(model);
		init();
	}
	
	public void create(){
		model = new Staff();
		init();
	}
	
	public void search(){
		colStaffs = staffService.getSuporterByDescription(searchValue);
		if(colStaffs.size() == 0){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("ERRO",  "Nenhum registro foi encontrado...") );
		}
	}
	
	public void remove(){
		staffService.delete(model);
		init();
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<Staff> getColStaffs() {
		return colStaffs;
	}

	public void setColStaffs(List<Staff> colStaffs) {
		this.colStaffs = colStaffs;
	}

	public List<Group> getColGroup() {
		return colGroup;
	}

	public void setColGroup(List<Group> colGroup) {
		this.colGroup = colGroup;
	}
	
	
	
	
	
	
	
}
