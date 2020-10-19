package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

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

public class Finalize extends GenericMethods{

	//Finalize Button
	@FindBy(xpath="//button[@id='btnFinalize']")
	private WebElement finalizeBTN;
	
	
	//Policy Holder Code
	@FindBy(xpath="(//a[@id='createParty']/i)[1]")
	private WebElement policyholderCD;
	
	
	//Policy Holder Code
		@FindBy(xpath="(//a[@id='createParty']/i)[2]")
		private WebElement policyholderCDsearch;
	
	
	//Title
	@FindBy(xpath="//select[@id='Title']")
	private WebElement title;
	
	
	//First Name
	@FindBy(xpath="//input[@id='First Name']")
	private WebElement firstname;
	
	
	//Gender
	@FindBy(xpath="//select[@id='Gender']")
	private WebElement gender;
	
	
	//Date OF Birth
	@FindBy(xpath="//input[@id='Date of Birth']")
	private WebElement dateofbirth;
	
	
	//Nationality
	@FindBy(xpath="//select[@id='Nationality']")
	private WebElement nationality;
	
	
	//Country of Residence
	@FindBy(xpath="//select[@id='Country of Residence']")
	private WebElement countryofresidence;
	
	
	//HNI Customer
	@FindBy(xpath="//select[@id='HNI Customer']")
	private WebElement HNIcustomer;
	
	
	//CEOclub Advisor
	@FindBy(xpath="//select[@id='CEO Club Advisor Customer']")
	private WebElement CEOclubadvisor;
	
	
	//Priority customer
	@FindBy(xpath="//select[@id='Priority Customer']")
	private WebElement prioritycustomer;
	
	
	//Sensitive Customer
	@FindBy(xpath="//select[@id='Sensitive Customer']")
	private WebElement sensitivecustomer;
	
	
	//GST 
	@FindBy(xpath="//select[@id='GST Registration Type']")
	private WebElement GSTregistrationtype;
	
	
	//Whatsapp Number
	@FindBy(xpath="//input[@id='WhatsApp Number']")
	private WebElement whatsappnumber;
	
	
	//Mailing Radiobutton
	@FindBy(xpath="//input[@value='Y']")
	private WebElement mailing;
	
	
	//Save Button
	@FindBy(xpath="//button[@id='Save']")
	private WebElement saveBTN;
	
	
	//Ok Button
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okBTN;
	
	
	//Click Multicolor icon
	@FindBy(xpath="//img[@class='circle_img multi-address ng-scope']")
	private WebElement MulticolorIcon;
	
	
	//Click Permanent Contact
	@FindBy(xpath="//img[@class='circle_img']")
	private WebElement PermanentContact;
	
	
	//Fill Address Line 1
	@FindBy(xpath="//input[@id='Address Pty 1']")
	private WebElement AddressLine1;
	
	
	//Fill Address Line 2
	@FindBy(xpath="//input[@id='Address Pty 2']")
	private WebElement AddressLine2;
	
	
	//Fill Pincode
	@FindBy(xpath="//input[@id='Zip CodeParty']")
	private WebElement Pincode;
	
	
	//Fill City
	@FindBy(xpath="//input[@id='City1']")
	private WebElement City;	
	
	
	//Fill State
	@FindBy(xpath="//input[@id='Emirates/State']")
	private WebElement State;
	
	
	//Fill Country
	@FindBy(xpath="//input[@id='Country1']")
	private WebElement Country;
	
	
	//Fill District
	@FindBy(xpath="//input[@id='District']")
	private WebElement District;

	
	//Fill Landline Number
	@FindBy(xpath="//input[@id='Landline NumberP']")
	private WebElement Landline;
		
		
	//Fill Mobile number
	@FindBy(xpath="//input[@id='Mobile Number']")
	private WebElement Mobile;
		
		
	//Fill Email ID
	@FindBy(xpath="//input[@id='{objQuestion.strParameterName}}']")
	private WebElement Email;
	
	
	//Click Save button
	@FindBy(xpath="//button[@class='mat-custom-btn ng-scope']")
	private WebElement Save1;
	
	
	//Activate client
	@FindBy(xpath="//button[@id='Back']")
	private WebElement activateclient;
	
	
	//Ok Button
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okBTN1;
	
	
	//Policy Holder Member
	@FindBy(xpath="//select[@ng-model='isPolHolMember']")
	private WebElement policyholdermember;
	
	
	//Convert Detail Quote
	@FindBy(xpath="//input[@id='btnConverToDQ']")
	private WebElement convertdetailquote;
	
	
	//Ok Button
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okBTN2;
	
	//Bank Account Detail
	@FindBy(xpath="//button[@id='Bank Account Details']")
	private WebElement bankaccountdetails;
	
	@FindBy(xpath="//input[@id='Bank A/C No0']")
	private WebElement accountNo;
	
	@FindBy(xpath="//input[@id='Confirm Account Number0']")
	private WebElement confirmaccountNo;
	
	@FindBy(xpath="//input[@id='pifsccode']")
	private WebElement ifsccode;
	
	@FindBy(xpath="//select[@name='Bank Account Type0']")
	private WebElement bankaccounttype;
	
	//Bank Detail Save btn
	@FindBy(xpath="//button[@id='SaveBtn']")
	private WebElement savebtn;
	
	@FindBy(xpath="//a[@id='openLookUp IFSC Code']//img")
	private WebElement ifsciconbtn;
	
	@FindBy(xpath="//span[contains(text(),'Search')]")
	private WebElement searchifscbtn;
	
	@FindBy(xpath="//a[@name='firstFocus']")
	private WebElement ifcselectbtn;
	
	@FindBy(xpath="//button[@id='CloseBtn']")
	private WebElement closebtn;
	
	@FindBy(xpath="//input[@id='IFSC Code']")
	private WebElement IFSCCode;
	
	//reference  Number
		@FindBy(xpath="//div[contains(text(),'Quotation Saved Successfully')]")
		private WebElement refno;
		
	//reference Number2
		@FindBy(xpath="//label[contains(text(),'Reference Number')]//following::label[1]")
		private WebElement refno2;
	
	
	
	
	    WebDriverWait wait;
	    public Finalize(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
	}
	
	
	//finalize method
	public void fillfinalize(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{	
		
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		Reporter.log("<B>Traverse To CommonPage</B>");

		
		//String winHandleBefore = driver.getWindowHandle();
		switchtoframe(driver, "display");    
		click(finalizeBTN, "FinalizeButton");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

		
		//Entering Policy Holder Details
		wait.until(ExpectedConditions.elementToBeClickable(policyholderCD));
		Thread.sleep(WaitTime.low);
		click(policyholderCD, "PolicyHolderCD");
		switchToWindow(driver);
		Thread.sleep(4000);

		
		
		
		//selectFromDropdownByVisibleText(title,dataRow.getProperty("Title"),"Title");
		
		//Title
		if(dataRow.getProperty("Gender").equalsIgnoreCase("Male")) {
			Thread.sleep(WaitTime.medium);
			selectFromDropdownByVisibleText(title,"Mr.","Title");
		}
		else {
			selectFromDropdownByVisibleText(title,"Ms.","Title");
			Thread.sleep(WaitTime.low);
		}
		
		
		
		//First Name
		clearAndSenKeys(firstname,getRandomString(),"First Name" );
		Thread.sleep(WaitTime.medium);
		
		//Gender
		selectFromDropdownByVisibleText(gender,dataRow.getProperty("Gender"),"Gender");
		Thread.sleep(WaitTime.low);
		
		
		//Date Of Birth
		     DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
		     Date obj = new Date();
		     String acurrdate=dfor.format(obj);
			 String CollectAge= dataRow.getProperty("Age");
			 String[] arrofstr=acurrdate.split("/",3);
	         String date3=arrofstr[2];
		     int calactual= Integer.parseInt(date3);
		     int ageCal=Integer.parseInt(CollectAge);
		     int year=calactual-ageCal;
	         String yearStr=String.valueOf(year);
	         String actualdate1=acurrdate.replaceAll(date3, yearStr);
	         Thread.sleep(WaitTime.medium);
	         clearAndSenKeys(dateofbirth,actualdate1,"Date of Birth");
	         Thread.sleep(WaitTime.low);
	         dateofbirth.sendKeys(Keys.TAB);
	
		
		
		
		//Nationality
//		Thread.sleep(WaitTime.medium);
//		selectFromDropdownByVisibleText(nationality,dataRow.getProperty("Nationality"),"Nationality");
		//Thread.sleep(WaitTime.low);
		
	    
		//Country of Residence
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(countryofresidence,dataRow.getProperty("Country of Residence"),"Country of Residence");
		//Thread.sleep(WaitTime.low);
		
		//27-08-2020
		
		
		
		
		
		//HNI Customer
		
//		Thread.sleep(WaitTime.medium);
//		selectFromDropdownByVisibleText(HNIcustomer, "No","HNI Customer");
		//Thread.sleep(WaitTime.low);
		
		
		//CEO Club Advisor Customer
//		Thread.sleep(WaitTime.medium);
//		selectFromDropdownByVisibleText(CEOclubadvisor, "No","CEO Club Advisor Customer");
		//Thread.sleep(WaitTime.low);
		
		
		//Priority Customer
//		Thread.sleep(WaitTime.medium);
//		selectFromDropdownByVisibleText(prioritycustomer, "No","Priority Customer");
		//Thread.sleep(WaitTime.low);
		
		
		//Sensitive Customer
//		Thread.sleep(WaitTime.medium);
//		selectFromDropdownByVisibleText(sensitivecustomer, "No","Sensitive Customer");
//		Thread.sleep(WaitTime.low);
		
		
		//GST
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(GSTregistrationtype,dataRow.getProperty("GST Registration Type"),"GST Registration Type");
		Thread.sleep(WaitTime.low);
		
		
		//Whatsapp Number
		Thread.sleep(WaitTime.low);
		clearAndSenKeys(whatsappnumber,dataRow.getProperty("WhatsApp Number"),"WhatsApp Number" );
		
		
		//IstheMailing Radiobutton   Doubt
		Thread.sleep(WaitTime.low);
		click(mailing,"IstheMailing");
		Thread.sleep(3000);
		
		
		//Save Button
		click(saveBTN,"Save");
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK']")));
		click(okBTN, "OK");
		Thread.sleep(3000);

		
		//click Multicolor icon
		click(MulticolorIcon,"Multicolor Icon");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		Thread.sleep(2000);
		
		
		//Click Permanent Contact
		click(PermanentContact,"Permanent Contact");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		
		
		//Fill Address line 1
		Thread.sleep(3000);
		clearAndSenKeys(AddressLine1,dataRow.getProperty("Address Line 1"),"Address Line 1");
		
		
		//Fill Address line 2
		Thread.sleep(3000);
		clearAndSenKeys(AddressLine2,dataRow.getProperty("Address Line 2"),"Address Line 2");
		
		
		//Fill Pincode
		Thread.sleep(3000);
		clearAndSenKeys(Pincode,dataRow.getProperty("PinCode"),"Pincode");
		Pincode.sendKeys(Keys.TAB);
		
		
		//Landline Number
		Thread.sleep(3000);
		clearAndSenKeys(Landline,dataRow.getProperty("Landline Number"),"Landline number");
		
		
		//Mobile Number
		Thread.sleep(3000);
		clearAndSenKeys(Mobile,dataRow.getProperty("Mobile Number"),"Mobile Number");
		
		
		//Fill Email ID
		Thread.sleep(3000);
		clearAndSenKeys(Email,dataRow.getProperty("Email ID"),"Email ID");
		
		
		//Click Save Button
		Thread.sleep(3000);
		click(Save1,"Save Button");
		
		
		//Click OK Button
		Thread.sleep(3000);
		click(okBTN,"OK");
		Thread.sleep(3000);
		
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_UP);
		
		 //Party Create Window
		String ChildWindow1=driver.getWindowHandle();
		
		
		Thread.sleep(3000);
		click(bankaccountdetails,"bankaccountdetail");
		switchToWindow(driver);
		Thread.sleep(4000);
			 		
		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(accountNo,dataRow.getProperty("AccountNo"),"Account No");
		Thread.sleep(WaitTime.low);
				
		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(confirmaccountNo,dataRow.getProperty("ConformAccountNo"),"ConformAccount No");
		Thread.sleep(WaitTime.low);
				
		
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(bankaccounttype,dataRow.getProperty("AccountType"),"account Type");
		Thread.sleep(WaitTime.low);
		
		//Bank Account Window
		String ChildWindow2=driver.getWindowHandle();
		
		Thread.sleep(WaitTime.low);
		click(ifsciconbtn,"Iconbtn");
		switchToWindow(driver);
				
				
		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(ifsccode,dataRow.getProperty("IFSCcode"),"IFSC Code");
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(WaitTime.low);
		click(searchifscbtn,"IFSCsearchbtn");
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(WaitTime.low);
		click(ifcselectbtn,"IFSCselectbtn");
	
		
		Thread.sleep(WaitTime.medium);
       driver.switchTo().window(ChildWindow2);
//		confirmaccountNo.sendKeys(Keys.TAB);
//		IFSCCode.sendKeys(Keys.TAB);
//		ifsciconbtn.sendKeys(Keys.TAB);
		
//		Thread.sleep(WaitTime.medium);
//		selectFromDropdownByVisibleText(bankaccounttype,dataRow.getProperty("AccountType"),"account Type");
//		Thread.sleep(WaitTime.low);
				
		Thread.sleep(WaitTime.low);
		click(savebtn,"Savebtn");
				
		Thread.sleep(3000);
		click(okBTN,"OK");
		Thread.sleep(2000);
		
	// close btn on ifsc code 	
		Thread.sleep(WaitTime.low);
		click(closebtn,"Closebtn");
		Thread.sleep(3000);

		driver.switchTo().window(ChildWindow1);
		
		//Activate Client
		Thread.sleep(3000);
		click(activateclient,"Activate Client");
		Thread.sleep(3000);
		
		
		//Is Policy Holder a Member
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		switchtoframe(driver, "display");  
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(policyholdermember,dataRow.getProperty("PolicyHolderIsMember"),"IsPolicyHolderMember");
		Thread.sleep(WaitTime.low);
		
		
		//Convert Detail Quote
		Thread.sleep(3000);
		click(convertdetailquote,"ConvertDetailQuote");
		Thread.sleep(3000);
		click(okBTN2, "OK");
		Thread.sleep(3000);
		
		//switchtoframe(driver, "display");    
		//switchtodefaultframe(driver);
		
		}     	
	
	public void fillFinalize(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		fillfinalize(driver, testCaseName, workbook, conn, stepGroup, customAssert);
}
		
}
