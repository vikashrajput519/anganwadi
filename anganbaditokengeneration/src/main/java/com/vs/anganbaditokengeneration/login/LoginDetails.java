package com.vs.anganbaditokengeneration.login;

public class LoginDetails {
	
	private String aadharNumber;
	
	private String mobileNumber;
	
	private String password;

	public LoginDetails(String aadharNumber, String mobileNumber, String password) {
		super();
		this.aadharNumber = aadharNumber;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPasswrod() {
		return password;
	}

	public void setPasswrod(String password) {
		this.password = password;
	}
	
	

}
