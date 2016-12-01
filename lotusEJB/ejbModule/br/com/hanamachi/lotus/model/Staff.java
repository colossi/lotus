package br.com.hanamachi.lotus.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Staff {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;

	private String nick;

	@Temporal(value=TemporalType.DATE)
	private Date dateOfBirth;

	private String momName;

	private String dadName;

	private String facebook;

	private String skype;

	private String helpType;

	private String availableTime;

	private String tshirtSize;

	private boolean tshirtReceived;

	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	private Natural natural = new Natural();
	
	@ManyToMany(cascade={CascadeType.ALL})
	private List<Group> group = new ArrayList<Group>();

	@OneToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	private Login login = new Login();

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMomName() {
		return momName;
	}

	public void setMomName(String momName) {
		this.momName = momName;
	}

	public String getDadName() {
		return dadName;
	}

	public void setDadName(String dadName) {
		this.dadName = dadName;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getHelpType() {
		return helpType;
	}

	public void setHelpType(String helpType) {
		this.helpType = helpType;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public String getTshirtSize() {
		return tshirtSize;
	}

	public void setTshirtSize(String tshirtSize) {
		this.tshirtSize = tshirtSize;
	}

	public boolean isTshirtReceived() {
		return tshirtReceived;
	}

	public void setTshirtReceived(boolean tshirtReceived) {
		this.tshirtReceived = tshirtReceived;
	}

	public Natural getNatural() {
		return natural;
	}

	public void setNatural(Natural natural) {
		this.natural = natural;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	public List<Group> getGroup() {
		return group;
	}

	public void setGroup(List<Group> group) {
		this.group = group;
	}
	

}
