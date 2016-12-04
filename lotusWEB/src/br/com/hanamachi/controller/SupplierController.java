package br.com.hanamachi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.hanamachi.lotus.ejb.supplier.SupplierService;
import br.com.hanamachi.lotus.model.Supplier;

@ManagedBean(name="crtSupplier")
@ViewScoped
public class SupplierController {
	@EJB
	private SupplierService supplierService;
	
	private Supplier model = new Supplier();
	
	private String searchValue;
	
	public Supplier getModel() {
		return model;
	}
	
	private List<Supplier> colSuppliers = new ArrayList<Supplier>();
	

	@PostConstruct
	public void init(){
		colSuppliers = supplierService.findAll();
	}

	public void setModel(Supplier model) {
		this.model = model;
	}


	public void save(){
		supplierService.save(model);
		init();
	}
	
	public void create(){
		model = new Supplier();
		init();
	}
	
	public void search(){
		colSuppliers = supplierService.getSuporterByDescription(searchValue);
		if(colSuppliers.size() == 0){
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("ERRO",  "Nenhum registro foi encontrado...") );
		}
	}
	
	public void remove(){
		supplierService.delete(model);
		init();
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<Supplier> getColSuppliers() {
		return colSuppliers;
	}

	public void setColSuppliers(List<Supplier> colSuppliers) {
		this.colSuppliers = colSuppliers;
	}
	
	
	
	
	
}
