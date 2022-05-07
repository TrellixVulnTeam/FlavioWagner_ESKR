package br.com.appnovo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Appconfig.findAll", query="SELECT a FROM Appconfig a")
public class Appconfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private String theme;
	private String inputstyle;
	private boolean ripple;
	private boolean dark;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getInputstyle() {
		return inputstyle;
	}
	public void setInputstyle(String inputstyle) {
		this.inputstyle = inputstyle;
	}
	public boolean isRipple() {
		return ripple;
	}
	public void setRipple(boolean ripple) {
		this.ripple = ripple;
	}
	public boolean isDark() {
		return dark;
	}
	public void setDark(boolean dark) {
		this.dark = dark;
	}

	public Appconfig() {		
	}

}
