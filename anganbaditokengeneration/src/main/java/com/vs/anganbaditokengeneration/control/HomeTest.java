package com.vs.anganbaditokengeneration.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.vs.anganbaditokengeneration.LabharthiDto;
import com.vs.anganbaditokengeneration.enums.ConfigEnums;
import com.vs.anganbaditokengeneration.window.HomeWindow;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeTest {


	
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
	  
		new HomeTest().test();
	}
	
	
	
	 /* ///==========================================================================
	 * =====================
	 * 
	 * File file = new File("D:\\PROJECT\\Aaganbadi\\PARSHARMA MADHYA.pdf");
	 * 
	 * PDDocument document = PDDocument.load(file); if (!document.isEncrypted()) {
	 * // Instantiate PDFTextStripper class PDFTextStripper pdfStripper = new
	 * PDFTextStripper(); // Retrieving text from PDF document String pdfFileInText
	 * = pdfStripper.getText(document); String lines[] =
	 * pdfFileInText.split("\\r?\\n");
	 * 
	 * 
	 * 
	 * String sentence = "";
	 * 
	 * for (String line : lines) { line = line.trim();
	 * 
	 * if(StringUtils.contains(line, "Mobile")) { continue; }
	 * 
	 * if(!isValidIndianMobile(getLastWord(line))) { sentence = sentence + " " +
	 * line.trim(); line = ""; } if(!StringUtils.contains(line, ".") &&
	 * isValidIndianMobile(getLastWord(line.trim()))) { sentence = sentence + " " +
	 * line.trim(); line = sentence.trim(); sentence = ""; }
	 * 
	 * if(StringUtils.isNoneBlank(line)) { System.out.println(line);
	 * 
	 * String mobileNum = getLastWord(line);
	 * 
	 * line = line.replace(mobileNum, "");
	 * 
	 * String aadharNum = getLastWord(line);
	 * 
	 * System.out.println(aadharNum); }
	 * 
	 * }
	 * 
	 * } // Closing the document document.close();
	 * 
	 * }
	 * 
	 * public static boolean isValidIndianMobile(String mobile) {
	 * 
	 * if (mobile == null || mobile.trim().length() <= 0) { return false; } mobile =
	 * removeAllSpace(mobile);
	 * 
	 * Pattern pattern = Pattern.compile("[1-9][0-9]{9}"); Matcher matcher =
	 * pattern.matcher(mobile); return matcher.matches(); }
	 * 
	 * public static String removeAllSpace(String s) { if (s == null) return "";
	 * return s.replaceAll("\\s", ""); }
	 * 
	 * private static String getLastWord(String line) { return
	 * line.substring(line.lastIndexOf(" ") + 1); }
	 */
	
	
	// Uncomment for Spring
	/*
	 * public void launchTokenGenetor() { homeWindow.initializer(); }
	 */
	
	public void test() throws InterruptedException, ExecutionException
	{
		WebDriver driver = null;
		  WebDriverManager.chromedriver().browserVersion(ConfigEnums.CHROME_VERSION.
		  getConfigMessage()).setup(); 
		  
		  //WebDriverManager.firefoxdriver().browserVersion("84.0.2").setup();
		  
			/*
			 * FirefoxOptions options= new FirefoxOptions();
			 * options.addArguments(ConfigEnums.WINDOW_STYLE.getConfigMessage());
			 */

		  //driver = new FirefoxDriver();
		  //driver.manage().window().maximize();
		  
		  
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments(ConfigEnums.WINDOW_STYLE.getConfigMessage());
		  options.addArguments(ConfigEnums.AUTOMATION_TYPE.getConfigMessage());
		  options.addArguments(ConfigEnums.SANDBOX.getConfigMessage());
		  options.addArguments(ConfigEnums.INFOBARS.getConfigMessage());
		  
		  options.addArguments(ConfigEnums.USAGE.getConfigMessage());
		  options.addArguments(ConfigEnums.NAVIGATION.getConfigMessage());
		  options.addArguments(ConfigEnums.GPU.getConfigMessage());
		  
		  driver = new ChromeDriver(options);
		  
		  driver.get("http://164.100.251.19/AanganPublic/GetToken.aspx");
		  
		  driver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtAadhar'][contains(@id,'txtAadhar')]")).sendKeys("659480898844");
		  
		  driver.findElement(By.xpath("//input[@name='ctl00$MainContent$txt_Mobile'][contains(@id,'Mobile')]")).sendKeys("9955781865");
		  driver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtPassword'][contains(@id,'txtPassword')]")).sendKeys("1234");
		  
		  String str = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$txtCaptha'][contains(@id,'txtCaptha')]")).getAttribute("Value");
		  WebDriverWait wait = new WebDriverWait(driver, 1000);
		  
		  //(driver.findElement()
		  
		  Boolean element = wait.until(new ExpectedCondition<Boolean>() {
			    public Boolean apply(WebDriver d) {
			        return d.findElement(By.xpath("//input[@name='ctl00$MainContent$txtCaptha'][contains(@id,'txtCaptha')]")).getAttribute("value").length() == 4;
			    }
			});
		  
		  if(element)
		  {
			  driver.findElement(By.xpath("//input[@type='submit'][contains(@id,'btnLogin')]")).click();
		  }
		  
		WebElement table = driver.findElement(By.xpath("/html/body/form/div[4]/div[3]/div/div/table")); 

		// Now get all the TR elements from the table 
		List<WebElement> allRows = table.findElements(By.tagName("tr")); 

		List<LabharthiDto> labharthiDtoList = new ArrayList<>();
		// And iterate over them, getting the cells 
		for (WebElement row : allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 
		    LabharthiDto labharthiDto = new LabharthiDto();

		    // Print the contents of each cell
		    
		 // Print the contents of each cell
		    for (WebElement cell : cells) { 
		        System.out.println(cell.getText());
		    }
		    
		    if(cells.isEmpty())
		    	continue;
		    WebElement cellKendraId = cells.get(1);
		    
		    labharthiDto.setKendraId(cellKendraId.getText());
		    
		    WebElement cellKendraParents = cells.get(2);
		    
		    String[] parents = cellKendraParents.getText().split("\n");
		    
		    labharthiDto.setNameOfMother(parents[0]);

		    labharthiDto.setNameOfFather(parents[1]);
		    
		    
		    //==============
		    
		    WebElement cellAadharIfcAccount = cells.get(3);
		    
		    String[] aadharIfcAccountStr = cellAadharIfcAccount.getText().split("\n");
		    
		    labharthiDto.setAadharNum(aadharIfcAccountStr[0]);

		    labharthiDto.setIfcCode(aadharIfcAccountStr[1]);
		    
		    labharthiDto.setAccountNum(aadharIfcAccountStr[2]);
		    
		    
		  //==============
		    
		    WebElement cellTypeCatAge = cells.get(4);
		    
		    String[] typeCatAge = cellTypeCatAge.getText().split("\n");
		    
		    labharthiDto.setLabhartiType(typeCatAge[0]);

		    labharthiDto.setCategory(typeCatAge[1]);
		    
		    labharthiDto.setAgeInMonths(typeCatAge[2]);
		    
		    //==============
		    
		    WebElement cellNameGenderYear= cells.get(5);
		    
		    String[] nameGenderYear = cellNameGenderYear.getText().split("\n");
		    
		    labharthiDto.setBenificeryName(nameGenderYear[0]);

		    labharthiDto.setGender(nameGenderYear[1]);
		    
		    labharthiDto.setYearOfBirth(nameGenderYear[2]);
		    
		    //==============
		    
		    WebElement cellBenIdToken= cells.get(6);
		    
		    String[] benIdToken = cellBenIdToken.getText().split("\n");
		    
		    labharthiDto.setBenId(benIdToken[0]);

		    labharthiDto.setTokenId(benIdToken[1]);
		    
		    labharthiDtoList.add(labharthiDto);
		    
		}
		 
		  labharthiDtoList.forEach(l ->
		  {
			  System.out.println(l.getKendraId()+" ->"+l.getNameOfMother()+" ->"+l.getNameOfFather()+" ->"+l.getAadharNum()+" ->"+l.getIfcCode()+" ->"+l.getAccountNum()+" -> "+l.getLabhartiType()+" -> "+l.getCategory()+" -> "+l.getAgeInMonths()+" -> "+l.getBenificeryName()+" -> "+l.getGender()+" -> "+l.getYearOfBirth()+" -> "+l.getBenId()+" -> "+l.getTokenId());
		  });
	}



}
