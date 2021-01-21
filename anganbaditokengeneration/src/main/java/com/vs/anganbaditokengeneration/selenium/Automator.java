package com.vs.anganbaditokengeneration.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class Automator {

	private WebDriver driver = null;

	public Automator() {
		super();
	}
	
	public void navigate(final String url)
	{
		this.driver.navigate().to(url);
	}
	
	private WebElement getWebElement(WebElementIdentifier webElementIdentifier)
	{
		return driver.findElement(By.xpath(webElementIdentifier.getXpath()));
	}
	
	public void execute(WebElementIdentifier webElementIdentifier)
	{
		try {
			
			WebElement webElement = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(getWebElement(webElementIdentifier)));
			
			if(webElementIdentifier.getValue().isPresent())
			{
				webElement.sendKeys(webElementIdentifier.getValue().get());
				System.out.println(webElementIdentifier.getName()+"-----------"+webElementIdentifier.getValue().get());
			}
			else {
				webElement.click();
				System.out.println(webElementIdentifier.getName());
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String readLabelText(WebElementIdentifier webElementIdentifier)
	{
		try {
			return getWebElement(webElementIdentifier).getText();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void sendTabKey(WebElementIdentifier webElementIdentifier)
	{
		WebElement webElement = getWebElement(webElementIdentifier);
		webElement.sendKeys(Keys.TAB);
	}
}
