package br.com.appnovo.dto;

import br.com.appnovo.model.Appconfig;

public class AppconfigDTO {
	private String theme;
	private String inputStyle;
	private boolean ripple;
	private boolean dark;
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
	
	public AppconfigDTO(String theme, String inputStyle, boolean ripple, boolean dark) {
		super();
		this.theme = theme;
		this.inputStyle = inputStyle;
		this.ripple = ripple;
		this.dark = dark;
	}
	
	public AppconfigDTO(Appconfig appConfig) {
		this.theme = appConfig.getTheme();
		this.inputStyle = appConfig.getInputstyle();
		this.ripple = appConfig.isRipple();
		this.dark = appConfig.isDark();
	}	
}
