package com.vs.anganbaditokengeneration.selenium;

import com.vs.anganbaditokengeneration.enums.AttributeType;

public class Attribute {
	
	private AttributeType type;
	
	private String xpath;
	
	private Boolean isMethodCall;
	
	private String methodName;

	public Attribute(AttributeType type, String xpath) {
		super();
		this.type = type;
		this.xpath = xpath;
		this.isMethodCall = Boolean.FALSE;
	}

	public Attribute(AttributeType type, String xpath, String methodName) {
		super();
		this.type = type;
		this.xpath = xpath;
		this.methodName = methodName;
		this.isMethodCall = Boolean.TRUE;
	}

	public AttributeType getType() {
		return type;
	}

	public void setType(AttributeType type) {
		this.type = type;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public Boolean getIsMethodCall() {
		return isMethodCall;
	}

	public void setIsMethodCall(Boolean isMethodCall) {
		this.isMethodCall = isMethodCall;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	

}
