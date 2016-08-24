package br.com.hanamachi.lotus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Permission {

	private Long nivel;

	private String description;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Routines routines;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Staff staff;

	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Group group;

	public Long getNivel() {
		return nivel;
	}

	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Routines getRoutines() {
		return routines;
	}

	public void setRoutines(Routines routines) {
		this.routines = routines;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}


}
