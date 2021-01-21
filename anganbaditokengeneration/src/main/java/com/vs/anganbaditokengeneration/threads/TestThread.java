package com.vs.anganbaditokengeneration.threads;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class TestThread implements ExpectedCondition<String>{

	@Override
	public String apply(WebDriver input) {
		
	 return input.findElement(By.xpath("//input[@name='ctl00$MainContent$txtCaptha'][contains(@id,'txtCaptha')]")).getAttribute("Value");
		
	}}
