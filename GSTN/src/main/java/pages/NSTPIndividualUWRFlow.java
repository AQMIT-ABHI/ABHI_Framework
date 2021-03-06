package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.WaitTime;

public class NSTPIndividualUWRFlow extends QuoteSearchPage{
	
	@FindBy(xpath="//i[@id='roleIcon']")
	private WebElement roleCLICK;
	
	@FindBy(xpath="(//p[contains(text(),'Policy Management')])[1]")
	private WebElement PolicyManagement;
	
	@FindBy(xpath="//input[@id='Policy No.']")
	private WebElement QuoteNoSearch;
	
	@FindBy(xpath="//button[@id='Search']")
	private WebElement SearchButton;
	
	//Member Level Action
		@FindBy(xpath="//button[@id='btnFWA']")
		private WebElement MemberLevelAction;
		
		
	//Decision
		@FindBy(xpath="//select[@id='Decision_1']")
		private WebElement decision;
		
	//Save
 		@FindBy(xpath="//button[@id='btnSave']")
 		private WebElement Save;
 	
 	//IssuePolicy
 		@FindBy(xpath="//button[@id='issuePolicyBtn']")
 		private WebElement issuepolicy;
 		
 		//Policy Number
 		@FindBy(xpath="//label[@id='Number']")
 		private WebElement policynumber;
 		
 		

	WebDriverWait wait;
	public NSTPIndividualUWRFlow(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
		}
	
	public void fillNSTPUWRInfo(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
	   Reporter.log("<B>Traverse To CommonPage</B>");
	   
	 //COPS to UWR
	 		switchtodefaultframe(driver);
	 		switchtoframe(driver, "head");
	 		
	 		click(roleCLICK,"Role Click");	
	 		
	 		click(driver.findElement(By.xpath("//div[contains(text(),'UWR')]")),"Selected Role as UWR");
	 		
	 		Thread.sleep(2000);
	 		
	 		switchtodefaultframe(driver);
	 		switchtoframe(driver, "display");
	 		click(PolicyManagement,"Policy Management tab");
	 		
	 		Thread.sleep(4000);
	 		clearAndSenKeys(QuoteNoSearch,getQuoteNo(testCaseName),"Quote No Input");
	 		Thread.sleep(4000);
	 		
	 		click(SearchButton, "search");
	 		
	 		driver.findElement(By.xpath("//input[@id='Policy No.']")).sendKeys(Keys.PAGE_DOWN);
	 		Thread.sleep(2000);
	 		click(driver.findElement(By.xpath("//a[contains(text(),'"+getQuoteNo(testCaseName)+"')]")),"Quote no");
	 		
	 		String parentWindow = driver.getWindowHandle();
	 		Thread.sleep(2000);
	 		switchtodefaultframe(driver);
			switchtoframe(driver,"display");
			switchtoframe(driver, "containerFrame");
	 		click(MemberLevelAction,"Member Level Action");
	 		switchToWindow(driver);
	 		Thread.sleep(2000);
	 		
	 		if(dataRow.getProperty("Policy Type").equalsIgnoreCase("Family Floater")) 
	 		{
	 			String MemDecision=dataRow.getProperty("Decision_UWR");
	 			String MemDecision2 = MemDecision.replace(" ", "");
	 			ArrayList<String> myList1 = new ArrayList<String>(Arrays.asList(MemDecision2.split("\\+")));

	 			for (int x = 0; x < myList1.size(); x++) 
	 			{
	 				int y = x + 1;
	 				//Select Decision

	 				WebElement Decision=driver.findElement(By.xpath("(//select[@id='Decision_1'])["+y+"]"));
	 				selectFromDropdownByVisibleText(Decision,myList1.get(x),"Decision");
	 				Thread.sleep(2000);
	 			}

	 		}
	 		else {
	 		selectFromDropdownByVisibleText(decision,dataRow.getProperty("Decision_UWR"),"Decision");
	 		Thread.sleep(2000);
	 		}
	 		//Save
	 		click(Save,"Save");
	 		driver.switchTo().window(parentWindow);
	 		Thread.sleep(2000);
	 		
	 	String SubStatus=driver.findElement(By.xpath("//label[contains(text(),'Sub-Status')]/following::label[1]")).getAttribute("value");
	 	
	 	//UWR - Counter Offer
	 	
	 	if(SubStatus.equalsIgnoreCase("Counter Offer")) {
	 		switchtodefaultframe(driver);
	 		switchtoframe(driver, "head");
	 		
	 		click(roleCLICK,"Role Click");	
	 		
	 		click(driver.findElement(By.xpath("//div[contains(text(),'BOPS')]")),"Selected Role as BOPS");
	 		searchQuote(driver,testCaseName);
	 		
	 	}
	 		//UWR to COPS
	 		switchtodefaultframe(driver);
	 		switchtoframe(driver, "head");
	 		
	 		click(roleCLICK,"Role Click");	
	 		
	 		click(driver.findElement(By.xpath("//div[contains(text(),'COPS')]")),"Selected Role as COPS");
	 		
	 		Thread.sleep(2000);
	 		
	 		switchtodefaultframe(driver);
	 		switchtoframe(driver, "display");
	 		click(PolicyManagement,"Policy Management tab");
	 		
	 		Thread.sleep(4000);
	 		clearAndSenKeys(QuoteNoSearch,getQuoteNo(testCaseName),"Quote No Input");
	 		Thread.sleep(4000);
	 		
	 		click(SearchButton, "search");
	 		
	 		driver.findElement(By.xpath("//input[@id='Policy No.']")).sendKeys(Keys.PAGE_DOWN);
	 		Thread.sleep(2000);
	 		click(driver.findElement(By.xpath("//a[contains(text(),'"+getQuoteNo(testCaseName)+"')]")),"Quote no");
	 		
	 		Thread.sleep(WaitTime.low);
	 		switchtodefaultframe(driver);
	 		Thread.sleep(2000);
	 		switchtoframe(driver,"display");
	 		Thread.sleep(2000);
	 		switchtoframe(driver,"containerFrame");
	 		Thread.sleep(2000);
	 		
	 		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(WaitTime.low);
			click(issuepolicy,"Issue Policy");
			Thread.sleep(WaitTime.low);
	 		
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_UP);
			String policyno=policynumber.getText();
			Reporter.log("----------");
			Reporter.log("Policy Number for this case is "+policyno);
			Reporter.log("---------");
	 		
		
	}
	
	public void NSTPIndiviUWRDetails(WebDriver driver, String testCaseName, XSSFWorkbook workbook, Connection conn,String stepGroup, CustomAssert customAssert) throws Exception {
		
		fillNSTPUWRInfo(driver, testCaseName, workbook, conn, stepGroup, customAssert);
	}
	
	
}

