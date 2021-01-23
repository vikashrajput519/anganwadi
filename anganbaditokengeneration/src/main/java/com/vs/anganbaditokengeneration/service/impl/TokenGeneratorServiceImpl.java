package com.vs.anganbaditokengeneration.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.anganbaditokengeneration.LabharthiDto;
import com.vs.anganbaditokengeneration.enums.ConfigEnums;
import com.vs.anganbaditokengeneration.login.LoginDetails;
import com.vs.anganbaditokengeneration.service.ConfigService;
import com.vs.anganbaditokengeneration.service.TokenGeneratorService;

@Service
public class TokenGeneratorServiceImpl implements TokenGeneratorService {

	@Autowired
	private ConfigService configService;
	
	private Set<LabharthiDto> labharthiDtoRepository = new HashSet<>();

	@Override
	public void generateLabharthiDetailsFromPortal(LoginDetails loginDetails) {

		WebDriver webDriver = configService.getDriver();
		
		List<LabharthiDto> labharthiDtoList = new ArrayList<>();

		if (null != webDriver) {
			webDriver.get(ConfigEnums.TOKEN_URL.getConfigMessage());

			webDriver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtAadhar'][contains(@id,'txtAadhar')]"))
					.sendKeys(loginDetails.getAadharNumber());

			webDriver.findElement(By.xpath("//input[@name='ctl00$MainContent$txt_Mobile'][contains(@id,'Mobile')]"))
					.sendKeys(loginDetails.getMobileNumber());

			webDriver
					.findElement(
							By.xpath("//input[@name='ctl00$MainContent$txtPassword'][contains(@id,'txtPassword')]"))
					.sendKeys(loginDetails.getPasswrod());
			
			
			WebElement webElementCaptchaTxt = webDriver.findElement(By.xpath("//input[contains(@id,'ctl00_MainContent_txtCaptha')]"));
			new Actions(webDriver).moveToElement(webElementCaptchaTxt).click().perform();

			
			WebDriverWait wait = new WebDriverWait(webDriver, 50000);

			Boolean element = wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(
							By.xpath("//input[@name='ctl00$MainContent$txtCaptha'][contains(@id,'txtCaptha')]"))
							.getAttribute("value").length() == 4;
				}
			});

			if (element) {
				webDriver.findElement(By.xpath("//input[@type='submit'][contains(@id,'btnLogin')]")).click();
			}

			WebElement table = null;
			
			try {
				table = webDriver.findElement(By.xpath("/html/body/form/div[4]/div[3]/div/div/table"));
			}catch(Exception e)
			{
				webDriver.close();
				webDriver.quit();
			}
			
			if(null == table)
			{
				return ;
			}

			System.out.println("TokenGeneratorServiceImpl Service -> "+Thread.currentThread().getName());
			// Now get all the TR elements from the table
			List<WebElement> allRows = table.findElements(By.tagName("tr"));

			// And iterate over them, getting the cells
			for (WebElement row : allRows) {

				List<WebElement> cells = row.findElements(By.tagName("td"));
				LabharthiDto labharthiDto = new LabharthiDto();

				if (cells.isEmpty())
					continue;

				// Getting and Setting Kendra Id
				WebElement cellKendraId = cells.get(1);

				labharthiDto.setKendraId(cellKendraId.getText());

				WebElement cellKendraParents = cells.get(2);

				String[] parents = cellKendraParents.getText().split("\n");

				labharthiDto.setNameOfMother(parents[0]);

				labharthiDto.setNameOfFather(parents[1]);

				// Getting and Setting Aadhar Ifc Account
				WebElement cellAadharIfcAccount = cells.get(3);

				String[] aadharIfcAccountStr = cellAadharIfcAccount.getText().split("\n");

				labharthiDto.setAadharNum(aadharIfcAccountStr[0]);

				labharthiDto.setIfcCode(aadharIfcAccountStr[1]);

				labharthiDto.setAccountNum(aadharIfcAccountStr[2]);

				// Getting and Setting Type Cat Age
				WebElement cellTypeCatAge = cells.get(4);

				String[] typeCatAge = cellTypeCatAge.getText().split("\n");
				
				if(typeCatAge.length == 1)
				{
					labharthiDto.setLabhartiType(typeCatAge[0]);
				}
				
				if(typeCatAge.length == 2)
				{
					labharthiDto.setCategory(typeCatAge[1]);
				}

				if(typeCatAge.length == 3)
				{
					labharthiDto.setAgeInMonths(typeCatAge[2]);
				}

				// Getting and Setting name Gender Year
				WebElement cellNameGenderYear = cells.get(5);

				String[] nameGenderYear = cellNameGenderYear.getText().split("\n");
				
				if(nameGenderYear.length == 1)
				{
					labharthiDto.setBenificeryName(nameGenderYear[0]);
				}

				if(nameGenderYear.length == 2)
				{
					labharthiDto.setGender(nameGenderYear[1]);
				}

				if(nameGenderYear.length == 3)
				{
					labharthiDto.setYearOfBirth(nameGenderYear[2]);
				}

				// Getting and Setting BenId Token
				WebElement cellBenIdToken = cells.get(6);

				String[] benIdToken = cellBenIdToken.getText().split("\n");

				labharthiDto.setBenId(benIdToken[0]);

				labharthiDto.setTokenId(benIdToken[1]);

				labharthiDtoList.add(labharthiDto);
			}
			
			webDriver.close();
			webDriver.quit();
		}

		labharthiDtoRepository.addAll(labharthiDtoList);
	}

	public ConfigService getConfigService() {
		return configService;
	}

	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}

	public Set<LabharthiDto> getLabharthiDtoRepository() {
		return labharthiDtoRepository;
	}

	public void setLabharthiDtoRepository(Set<LabharthiDto> labharthiDtoRepository) {
		this.labharthiDtoRepository = labharthiDtoRepository;
	}
	
	
}
