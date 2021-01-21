package com.vs.anganbaditokengeneration.threads;

import java.util.concurrent.Callable;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CaptchaValueCheckerThread implements Callable<String>{
	
	private String txtValue;
	private WebDriver driver;

	public CaptchaValueCheckerThread(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	 @Override
	 public String call() throws Exception
	 {
		 while(true)
		 {
			 String captchValue = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtCaptha'][contains(@id,'txtCaptha')]")).getAttribute("value");
			 
			 if(StringUtils.isBlank(captchValue))
			 {
				 try {
					 synchronized (captchValue) {
						 wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 }
			 
			 txtValue = captchValue;
			 notifyAll();
			 break;
			 
		 }
		 
		 return txtValue;
	 }


}
