package br.com.hanamachi.lotus.model;

public class Routines {

	private Long id;

	private String description;

	private String pageLink;

	private Permission permission;

	private Routines routines;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPageLink() {
		return pageLink;
	}

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Routines getRoutines() {
		return routines;
	}

	public void setRoutines(Routines routines) {
		this.routines = routines;
	}


}
