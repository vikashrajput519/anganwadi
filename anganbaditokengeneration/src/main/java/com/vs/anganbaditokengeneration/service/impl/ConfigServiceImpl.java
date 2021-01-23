package com.vs.anganbaditokengeneration.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import com.vs.anganbaditokengeneration.enums.ConfigEnums;
import com.vs.anganbaditokengeneration.service.ConfigService;

import io.github.bonigarcia.wdm.WebDriverManager;

@Service
public class ConfigServiceImpl implements ConfigService{

	@Override
	public WebDriver getDriver() {
		
		WebDriver driver = null;
		WebDriverManager.chromedriver().browserVersion(ConfigEnums.CHROME_VERSION.getConfigMessage()).setup();
		
		//WebDriverManager.firefoxdriver().browserVersion("84.0.2").setup();
		
		
		  ChromeOptions chromeOptions = new ChromeOptions();
		  
		  chromeOptions.addArguments("--start-maximized");
		  chromeOptions.addArguments("--disable-web-security");
		  chromeOptions.addArguments("--no-proxy-server");
		  chromeOptions.addArguments("no-sandbox");

		  Map<String, Object> prefs = new HashMap<>();
		  prefs.put("credentials_enable_service", false);
		  prefs.put("profile.password_manager_enabled", false);

		  chromeOptions.setExperimentalOption("prefs", prefs);
		  
		driver = new ChromeDriver(chromeOptions);
		
		//driver = new FirefoxDriver();
		
		return driver;
	}

	@Override
	public PDDocument getPdfDocument(String pdfPath) {
		
		File file = new File(pdfPath);
		
		PDDocument document = null;
		try {
			document = PDDocument.load(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return !document.isEncrypted() ? document : null;
		
	}
	
	

}
