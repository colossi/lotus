package br.com.hanamachi.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean(name="groupConverter")
@RequestScoped
public class GroupConverter implements Converter, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{crtStaff}")
	private StaffController staffController;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		int posicao = Integer.parseInt(arg2);
		
		return staffController.getColGroup().get(posicao);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		return String.valueOf(
				staffController.getColGroup().indexOf(arg2));
	}

	public void setCrtCliente(StaffController staffController) {
		this.staffController = staffController;
	}

}
