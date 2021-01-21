package com.vs.anganbaditokengeneration.threads;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test2  implements Runnable{
	
	List<String> holder;
	WebDriver driver;
	
	
	public Test2(WebDriver driver, List<String> holder) {
		super();
		this.driver = driver;
		this.holder = holder;
	}


	@Override
	public void run() {
		System.out.println("==="+Thread.currentThread().getName()+"in T22");
		
		while(holder.isEmpty())
		{
			String str = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtCaptha'][contains(@id,'txtCaptha')]")).getAttribute("value");
			
			if(StringUtils.isNotBlank(str))
			{
				holder.add(str);
			}
		}
		System.out.println("==="+Thread.currentThread().getName()+"in T33");
		if(!holder.isEmpty())
		{
			notifyAll();
		}
		System.out.println("==="+Thread.currentThread().getName()+"in T44");
	}

}
