package br.com.hanamachi.lotus.model;

public class Permission {

	private Long nivel;

	private String description;

	private Routines routines;

	private Staff staff;

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
