package br.com.appnovo.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the appconfig database table.
 * 
 */
@Entity
@NamedQuery(name="Appconfig.findAll", query="SELECT a FROM Appconfig a")
public class Appconfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean dark;

	@Column(name="input_style")
	private String inputStyle;

	private Boolean ripple;

	private String theme;

	public Appconfig() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDark() {
		return this.dark;
	}

	public void setDark(Boolean dark) {
		this.dark = dark;
	}

	public String getInputStyle() {
		return this.inputStyle;
	}

	public void setInputStyle(String inputStyle) {
		this.inputStyle = inputStyle;
	}

	public Boolean getRipple() {
		return this.ripple;
	}

	public void setRipple(Boolean ripple) {
		this.ripple = ripple;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

}