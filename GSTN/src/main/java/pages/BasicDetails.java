package pages;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.WaitTime;

public class BasicDetails extends GenericMethods{
	
	//Application number 1
	@FindBy(xpath="//input[@id='Application Number entry 1']")
	private WebElement applicationnumber1;
	
	//Confirm Application Number
	@FindBy(xpath="//input[@id='Application Number entry 2']")
	private WebElement applicationnumber2;
	
	//Go Green
	@FindBy(xpath="//select[@id='Go Green']")
	private WebElement gogreen;
	
	//Channel
	@FindBy(xpath="//select[@id='NB Channel']")
	private WebElement Channel;
	
	//Intermediary code
	@FindBy(xpath="//input[@id='Producer Code']")
	private WebElement intermediarycodeField;
	
	//Intermediary search
	@FindBy(xpath="//a[@id='openLookUp Producer Code']/i[1]")
	private WebElement intermediarycodesearch;
	
	//Intermediary Name
	@FindBy(xpath="//input[@id='Intermediary Name']")
	private WebElement intermediaryname;
	
	//nomeeni details
	
	@FindBy(xpath="//button[@id='Nominee']")
	private WebElement nomineeDeyailsBTN;
	
	
	@FindBy(xpath="//input[@id='Nominee Name0']")
	private WebElement nomineeName;
	
	@FindBy(xpath="//input[@id='Nominee Date of Birth0']")
	private WebElement nomineeDateofbirth;
	
	
	@FindBy(xpath="//select[@name='Relationship with Proposer0']")
	private WebElement relationshipwithproposer;
	
	
	@FindBy(xpath="//select[@name='Gender0']")
	private WebElement nomineegender;
	
	@FindBy(xpath="//input[@id='Nominee Contact Number']")
	private WebElement nomineecontactNo;
	
	//Nominee Save 
	@FindBy(xpath="//button[@id='SaveBtn']")
	private WebElement nomineesaveBTN;
	
	@FindBy(xpath="//button[@id='CloseBtn']")
	private WebElement closeBTN;
	
	//Whatsapp Number
	@FindBy(xpath="//input[@id='WhatsApp Number']")
	private WebElement whatsappnumber;
	
	//Save 
	@FindBy(xpath="//button[@id='Save']")
	private WebElement saveBTN;
	
	//Ok
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okBTN3;
	
	//Continue basic details
	@FindBy(xpath="//button[@id='btncontinue']")
	private WebElement continueBTN1;
	
	//Continue policy relations
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	private WebElement continueBTN2;
	
	//Payer Xpaths
	@FindBy(xpath="(//input[@name='Is proposer also the Payer ?'])[1]")
	private WebElement ProposerAlsoAPayer;
	
	@FindBy(xpath="//input[@id='Payer_Pay']")
	private WebElement PayerPartycode;
	
	@FindBy(xpath="//a[@id='openLookUp Payer_Pay']//i")
	private WebElement SearchPayer;
	
	@FindBy(xpath="//input[@id='relationshipwith proposer']")
	private WebElement PayerRltnWithProposer;
	
	
	WebDriverWait wait;
	public BasicDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
		}
		
	
	//Basic Details Method	
	public void fillbasicdetails(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
	
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
	   Reporter.log("<B>Traverse To CommonPage</B>");
	   
	    Thread.sleep(WaitTime.high);
		String unique = getuniqueApplicationNo();
	    //Application number 1
		Thread.sleep(WaitTime.medium);
		switchtoframe(driver, "containerFrame"); 
		Thread.sleep(WaitTime.high);
		clearAndSenKeys(applicationnumber1,unique,"Application Number Entry 1" );
		
		
		//Confirm Application Number
		Thread.sleep(WaitTime.low);
		clearAndSenKeys(applicationnumber2,unique,"Confirm Application Number" );
		Thread.sleep(WaitTime.low);
		
		//Go green
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(gogreen,dataRow.getProperty("Go Green"),"Go Green");
		
		//Channel
		//Thread.sleep(WaitTime.medium);
		//selectFromDropdownByVisibleText(Channel,dataRow.getProperty("Channel"),"Channel");
		//Thread.sleep(WaitTime.low);
		
		//Intermediary code
		//wait.until(ExpectedConditions.elementToBeClickable(intermediarycodeField));
		String parentWindow = driver.getWindowHandle();
		clearAndSenKeys(intermediarycodeField,dataRow.getProperty("IntermediaryCode"),"InterMediaryCode ");
		Thread.sleep(WaitTime.low);
		click(intermediarycodesearch, "Search");
		switchToWindow(driver);
		Thread.sleep(4000);
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'"+dataRow.getProperty("IntermediaryCode")+"')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'"+dataRow.getProperty("IntermediaryCode")+"')]")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
 		switchtodefaultframe(driver);
 		switchtoframe(driver, "display"); 
 		switchtoframe(driver, "containerFrame");
		
		
		//Intermediary Name
//		Thread.sleep(WaitTime.low);
//		clearAndSenKeys(intermediaryname, "New Party", "Intermediary Name" );
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		
 		//Whatsapp Number
 		//Thread.sleep(WaitTime.medium);
 		//clearAndSenKeys(whatsappnumber,dataRow.getProperty("WhatsApp Number"),"WhatsApp Number" );
 		
 	// Nominee details	
 		Thread.sleep(3000);
		click(nomineeDeyailsBTN,"NomineeDetailsBtn");
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(2000);
		switchToWindow(driver);
		
		//Ok
		//Thread.sleep(WaitTime.medium);
		//click(okBTN3, "Ok ");
		//Thread.sleep(WaitTime.medium);
 		
		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(nomineeName,getRandomString(),"Nominee Name ");
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(nomineeDateofbirth,dataRow.getProperty("NomineeDateOfbirth"),"nominee Date Of birth ");
		nomineeDateofbirth.sendKeys(Keys.TAB);
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(relationshipwithproposer,dataRow.getProperty("RelationshipWithProposer"),"Relationship With Proposer");
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(nomineegender,dataRow.getProperty("NomineeGender"),"Nominee Gender");
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(nomineecontactNo,dataRow.getProperty("NomineeContactNo"),"Nominee Contact No");
		Thread.sleep(WaitTime.low);
		
		//Save
		Thread.sleep(3000);
		click(nomineesaveBTN," Nominee Save");
		Thread.sleep(3000);
		
		//Ok
		click(okBTN3, "Ok ");
		Thread.sleep(3000);
		
		//close btn
		
		click(closeBTN,"Close btn");
		Thread.sleep(3000);
		driver.switchTo().window(parentWindow);
 		switchtodefaultframe(driver);
 		switchtoframe(driver, "display"); 
 		switchtoframe(driver, "containerFrame");
 		
 		//Payer Flow 05th Feb 2021
 		if(dataRow.getProperty("ProposerAlsoAPayer").equalsIgnoreCase("No"))
 		{
 			click(ProposerAlsoAPayer,"ProposerAlsoAPayer is No");
 			Thread.sleep(WaitTime.medium);
 			clearAndSenKeys(PayerPartycode,dataRow.getProperty("PayerPartyCode"),"PayerPartycode");
 			Thread.sleep(WaitTime.medium);
 			String childwindow = driver.getWindowHandle();
 			click(SearchPayer,"Search Payer");
 			Thread.sleep(WaitTime.low);
 			switchToWindow(driver);
 			click(driver.findElement(By.xpath("//a[contains(text(),'"+dataRow.getProperty("PayerPartyCode")+"')]")), "Payer Party Code");
 			Thread.sleep(WaitTime.medium);
 			driver.switchTo().window(childwindow);
 			switchtodefaultframe(driver);
 	 		switchtoframe(driver, "display"); 
 	 		switchtoframe(driver, "containerFrame");
 			
 			//Payer Relation with Proposer
 			clearAndSenKeys(PayerRltnWithProposer,dataRow.getProperty("PayerRltnWithProposer"),"Payer Relation With Proposer");
 			driver.findElement(By.xpath("(//span[contains(text(),'"+dataRow.getProperty("PayerRltnWithProposer")+"')])[1]")).click();
 			Thread.sleep(WaitTime.medium);
 		}
 		
		
		//Save Button
		Thread.sleep(3000);
		click(saveBTN,"Save");
		Thread.sleep(3000);
		
		//Ok
		click(okBTN3, "Ok ");
		Thread.sleep(3000);
		
		//Continue
		click(continueBTN1, "Continue");
		Thread.sleep(WaitTime.medium);
		 
		
		//Policy Relations
		//Continue Button
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		Thread.sleep(WaitTime.medium);
		click(continueBTN2, "Continue");
		Thread.sleep(WaitTime.high);
		//switchtodefaultframe(driver);
		
}
	public void BasicDetailsMehtod(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		fillbasicdetails(driver, testCaseName, workbook, conn, stepGroup, customAssert);
}
	
}
