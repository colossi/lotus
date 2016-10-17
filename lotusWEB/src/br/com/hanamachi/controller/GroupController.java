package br.com.hanamachi.controller;

import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.hanamachi.lotus.ejb.group.GroupService;
import br.com.hanamachi.lotus.model.Group;

@ManagedBean(name="crtGroup")
@ViewScoped
public class GroupController {
	
	@EJB
	private GroupService groupService;
	
	public Collection<Group> findAll() {
		return groupService.findAll();
	}
	

}
