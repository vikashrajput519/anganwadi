package com.vs.anganbaditokengeneration.enums;

public enum ConfigEnums {
	
	// Chrome Properties
	CHROME_VERSION("87.0.4280.141"),
	WINDOW_STYLE("start-maximized"),
	AUTOMATION_TYPE("start-maximized"),
	SANDBOX("--no-sandbox"),
	INFOBARS("--disable-infobars"),
	USAGE("--disable-dev-shm-usage"),
	NAVIGATION("--disable-browser-side-navigation"),
	GPU("--disable-gpu"),
	
	// Window Property 
	HEADLESS("java.awt.headless"),
	FALSE("false"),
	
	
	// Token URLS:
	//http://icdsonline.bih.nic.in/AANGAN/Main.aspx
	// http://164.100.251.19/AanganPublic/GetToken.aspx
	TOKEN_URL("http://164.100.251.19/AanganPublic/GetToken.aspx");
	
	private String configMessage;
	
	private ConfigEnums(String configMessage) 
	{
		this.configMessage = configMessage;
	}

	public String getConfigMessage() {
		return configMessage;
	}

}
