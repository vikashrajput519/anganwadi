package com.vs.anganbaditokengeneration.service;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.WebDriver;

public interface ConfigService {
	
	WebDriver getDriver();
	
	PDDocument getPdfDocument(String pdfPath);

}
