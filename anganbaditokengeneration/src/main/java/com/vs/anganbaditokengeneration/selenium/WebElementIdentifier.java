package com.vs.anganbaditokengeneration.selenium;

import java.util.Optional;

public class WebElementIdentifier {
	
	private String name;
	private String xpath;
	private Optional<String> value;
	
	public WebElementIdentifier(String name, String xpath, Optional<String> value) {
		super();
		this.name = name;
		this.xpath = xpath;
		this.value = value;
	}
	
	public WebElementIdentifier(String name, String xpath) {
		super();
		this.name = name;
		this.xpath = xpath;
		this.value = Optional.empty();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public Optional<String> getValue() {
		return value;
	}

	public void setValue(Optional<String> value) {
		this.value = value;
	}

	
}
