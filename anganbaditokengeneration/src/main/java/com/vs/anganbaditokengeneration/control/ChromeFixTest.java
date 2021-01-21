package com.vs.anganbaditokengeneration.control;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class ChromeFixTest {

	public static void main(String[] args) {
		ChromeDriver driver = null;
		
		System.setProperty("webdriver.chrome.driver", "sr/cmain/resources/chromedriver1.exe");
		try {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			chromeOptions.addArguments("start-maximized");
			chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			ChromeDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver(chromeOptions);
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			 
			driver.navigate().to("http://164.100.251.19/AanganPublic/GetToken.aspx");
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error-----driver");
		}
	}

}
