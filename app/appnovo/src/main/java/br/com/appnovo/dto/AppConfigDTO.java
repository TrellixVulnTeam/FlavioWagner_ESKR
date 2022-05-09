package br.com.appnovo.dto;

import br.com.appnovo.model.Appconfig;

public class AppConfigDTO {
	private Integer id;
	private String theme;
	private String inputStyle;
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
	public String getInputStyle() {
		return inputStyle;
	}
	public void setInputStyle(String inputStyle) {
		this.inputStyle = inputStyle;
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
	
	public AppConfigDTO(String theme, String inputStyle, boolean ripple, boolean dark) {
		super();
		this.theme = theme;
		this.inputStyle = inputStyle;
		this.ripple = ripple;
		this.dark = dark;
	}
	
	public AppConfigDTO(Appconfig appConfig) {
		this.setId(appConfig.getId());
		this.theme = appConfig.getTheme();
		this.inputStyle = appConfig.getInputStyle();
		this.ripple = appConfig.getRipple();
		this.dark = appConfig.getDark();
	}
}
