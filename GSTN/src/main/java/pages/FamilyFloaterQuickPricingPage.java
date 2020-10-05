package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.hpsf.NoFormatIDException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import junit.framework.Assert;
import testRunner.TestEngine;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.SetUpWebdriver;

import java.util.ArrayList; 
import util.WaitTime;

public class FamilyFloaterQuickPricingPage extends CustomAssert {
	
	@FindBy(xpath="//select[@id=\"pProduct\"]")
	private WebElement Product;
	
	@FindBy(xpath="//a[contains(text(),'Proceed')]")
	private WebElement proceedBTN;
	
	@FindBy(xpath="//select[@id='Source Code']")
	private WebElement sourcecode;
	
	@FindBy(xpath="//select[@id='Type of Business']")
	private WebElement businesstype;
	
	@FindBy(xpath="//input[@id='Producer Code']")
	private WebElement intermediarycodeField;
	
	@FindBy(xpath="//select[@id='Policy Tenure']")
	private WebElement policytenure;
	
	@FindBy(xpath="//select[@id='Premium Frequency']")
	private WebElement premiumFrequency;
	
	@FindBy(xpath="//select[@id='Plan Type']")
	private WebElement covertype;
	
	@FindBy(xpath="//select[@id='Plan']")
	private WebElement plantype;
	
	@FindBy(xpath="//select[@id='Sub Plan Type']")
	private WebElement subplantype;
	
	@FindBy(xpath="//select[@id='Applicable Sum Insured']")
	private WebElement SI;
	
	@FindBy(xpath="//input[@id='familysize']")
	private WebElement FamilySize;
	
	@FindBy(xpath="//input[@id='Number of Members']")
	private WebElement noOFmembers;
	
	@FindBy(xpath="(//input[@id='Member Name']//following::select[1])[1]")
	private WebElement zone;
	
	@FindBy(xpath="(//input[@id='Member Name']//following::select[3])[1]")
	private WebElement deductible;
	
	@FindBy(xpath="(//input[@id='Date of Birth']//following::select[3])[1]")
	private WebElement room;
	
	//Co-Pay Waiver
	@FindBy(xpath="//input[@name='WMCP']")
	private WebElement wmpcpCheckbox ;
	
	@FindBy(xpath="//input[@id='Age']")
	private WebElement AgeValue;
	
	@FindBy(xpath="(//input[@id='Age']")
	private WebElement AgeValue1;
	
	@FindBy(xpath="//select[@id='Employee Discount']")
	private WebElement employeediscount;

	@FindBy(xpath="//input[@id='Proposer Pin Code']")
	private WebElement pincode;

	@FindBy(xpath="//input[@id='Number of Members']")
	private WebElement membernumbers;
	
	@FindBy(xpath="//input[@id='Proposer Email ID']")
	private WebElement emailid;
	
	@FindBy(xpath="//button[@id='btnCalcPrem']")
	private WebElement calpremBTN;
	
	
	//PremiumCalculation Gettexts
	@FindBy(xpath="(//b[contains(text(),'Net Premium before Discount')]//following::div/div/b)[1]")
	private WebElement netpremiumbefore;
	
	@FindBy(xpath="(//b[contains(text(),'Net Premium before Discount')]//following::div/div/b)[3]")
	private WebElement Discount;
	
	@FindBy(xpath="(//b[contains(text(),'Net Premium before Discount')]//following::div/div/b)[5]")
	private WebElement netpremiumafter;
	
	@FindBy(xpath="(//b[contains(text(),'Net Premium before Discount')]//following::div/div/b)[7]")
	private WebElement loading;
	
	@FindBy(xpath="(//b[contains(text(),'Net Premium before Discount')]//following::div/div/b)[9]")
	private WebElement netpremiumafterloading;
	
	
	@FindBy(xpath="(//b[contains(text(),'Net Premium before Discount')]//following::div/div/b)[11]")
	private WebElement taxamountElement;
	
	@FindBy(xpath="(//b[contains(text(),'Net Premium before Discount')]//following::div/div/b)[13]")
	private WebElement premiuminclusiveofTAX ;
	
	//OPDE
	@FindBy(xpath="//input[@name='OPDE']")
	private WebElement opdeCheckbox ;
	
	
	@FindBy(xpath="//select[@name='Applicable Sum Insured']")
	private WebElement opdeDropDown;
	
	
	//save btn
	@FindBy(xpath="//button[@id='btnSave']")
	private WebElement saveBTN;
	
	//Ok Save
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement saveokBTN;
	
	
	//reference  Number
	@FindBy(xpath="//div[contains(text(),'Quotation Saved Successfully')]")
	private WebElement refno;
	
	//reference Number2
	@FindBy(xpath="//label[contains(text(),'Reference Number')]//following::label[1]")
	private WebElement refno2;
	
	@FindBy(xpath="(//div[@class='lobicon ng-scope']/a)[1]")
	private WebElement intermediarysearch;
	
	//HCB
	@FindBy(xpath="//input[@name='HSCB']")
	private WebElement hcbCheckbox ;
	
	@FindBy(xpath="(//b[contains(text(),'HSCB - Hospital Cash Benefit')]//following::select[1])[1]")
	private WebElement hcbDropDown;
	
	//maternity express
	@FindBy(xpath="//input[@name='MTEX']")
	private WebElement mtexCheckbox ;
	
	
	
	
    WebDriverWait wait;
	public FamilyFloaterQuickPricingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
	}

	
	
	public void fillAddQuote(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{	
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook,sheetName , testCaseName,stepGroup);
		Reporter.log("<B>Traverse To CommonPage</B>");

		switchtoframe(driver, "display");    
		selectFromDropdownByVisibleText(Product, dataRow.getProperty("Product"),"Product");
		click(proceedBTN, "ProceedButton");
		String parentWindow = driver.getWindowHandle();
		
		//EnteringQuoteDetails
				wait.until(ExpectedConditions.elementToBeClickable(intermediarycodeField));
				clearAndSenKeys(intermediarycodeField,dataRow.getProperty("IntermediaryCode"),"InterMediaryCode ");				
				click(intermediarysearch, " search ");
				switchToWindow(driver);				
				driver.findElement(By.xpath("//a[contains(text(),'"+dataRow.getProperty("IntermediaryCode")+"')]")).click();
				driver.switchTo().window(parentWindow);
				System.out.println(parentWindow);
				switchtoframe(driver, "display");  
		
		Thread.sleep(WaitTime.low);
		policytenure.sendKeys(Keys.END);
		selectFromDropdownByVisibleText(policytenure, dataRow.getProperty("Policy Tenure"),"Policy Tenure");
		Thread.sleep(WaitTime.low);
		
		selectFromDropdownByVisibleText(premiumFrequency, dataRow.getProperty("Premium Frequency"),"Premium Frequency");
		
		selectFromDropdownByVisibleText(covertype, dataRow.getProperty("Cover Type"),"Cover Type");
		Thread.sleep(WaitTime.low);
		
		wait.until(ExpectedConditions.elementToBeClickable(SI));
		Thread.sleep(WaitTime.low);
		
		selectFromDropdownByVisibleText(plantype, dataRow.getProperty("Plan"),"Plan Type");
		Thread.sleep(WaitTime.low);
		
		selectFromDropdownByVisibleText(subplantype, dataRow.getProperty("SubPlan"),"SubPlan Type");
		
		selectFromDropdownByVisibleText(SI, dataRow.getProperty("SumInsured")," SumInsured ");
		Thread.sleep(WaitTime.low);
		
		//Active Health--Rahul
		if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health")) {
		
		HashMap<String, Integer> BtnPress = new HashMap<String, Integer>();
		BtnPress.put("Self + Spouse", 28);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3", 7);
		BtnPress.put("Self + Kid1 + Father-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Father + Mother", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Mother + Mother-in-law", 1);
		BtnPress.put("Kid1 + Kid2 + Kid3", 0);
		BtnPress.put("Self",0 );
		BtnPress.put("Kid1 + Kid2 + Kid3 + Father + Mother + Father-in-law + Mother-in-law",0 );
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Mother",2 );
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Father-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Kid3", 7);
		BtnPress.put("Self + Father + Mother", 1);
		BtnPress.put("Self + Spouse + Father + Mother", 1);
		BtnPress.put("Self + Father + Father-in-law", 2);
		BtnPress.put("Self + Spouse + Father + Father-in-law", 2);
		BtnPress.put("Self + Mother + Father-in-law", 2);
		BtnPress.put("Self + Spouse + Mother + Father-in-law", 2);
		BtnPress.put("Self + Father + Mother + Father-in-law", 2);
		BtnPress.put("Self + Spouse + Father + Mother + Father-in-law", 2);
		BtnPress.put("Self + Father + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Father + Mother-in-law",1 );
		BtnPress.put("Self + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Father + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Father + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Father + Father-in-law",2 );
		BtnPress.put("Self + Spouse + Kid1 + Father + Father-in-law", 2);
		BtnPress.put("Self + Kid1 + Mother + Father-in-law", 2);
		BtnPress.put("Self + Spouse + Kid1 + Mother + Father-in-law", 2);
		BtnPress.put("Self + Kid1 + Father + Mother + Father-in-law",2 );
		BtnPress.put("Self + Spouse + Kid1 + Father + Mother + Father-in-law", 1);
		BtnPress.put("Self + Kid1 + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Father + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Father + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Father + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Father + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Father + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Father + Father-in-law + Mother-in-law",1 );
		BtnPress.put("Self + Kid1 + Mother + Father-in-law + Mother-in-law",1 );
		BtnPress.put("Self + Spouse + Kid1 + Mother + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Father + Mother + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Father-in-law",1 );
		BtnPress.put("Self + Kid1 + Kid2 + Father + Father-in-law",2 );
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Father + Father-in-law", 2);
		BtnPress.put("Self + Kid1 + Kid2 + Mother + Father-in-law",1 );
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Mother + Father-in-law", 2);
		BtnPress.put("Self + Kid1 + Kid2 + Father + Mother + Father-in-law", 2);
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Father + Mother + Father-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Father + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Father + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Father + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Father + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Father-in-law + Mother-in-law",1 );
		BtnPress.put("Self + Kid1 + Kid2 + Father + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Father + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Mother + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Mother + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Father + Mother + Father-in-law + Mother-in-law",1 );
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Father", 4);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Mother", 2);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Father-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Father + Father-in-law", 2);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Mother + Father-in-law",2 );
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Father + Mother + Father-in-law", 2);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Mother-in-law",1 );
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Father + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Father + Mother + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Kid1 + Kid2 + Kid3 + Father + Father-in-law + Mother-in-law",1 );
		BtnPress.put("Self + Spouse + Kid1",21	 );
		BtnPress.put("Self + Spouse + Mother", 2);
		BtnPress.put("Spouse + Father",1 );
		BtnPress.put("Spouse + Father + Father-in-law", 1);
		BtnPress.put("Spouse + Father + Mother", 1);
		BtnPress.put("Spouse + Father + Mother + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Spouse + Father-in-law", 1);
		BtnPress.put("Spouse + Kid1 + Kid2", 2);
		BtnPress.put("Spouse + Mother", 1);
		BtnPress.put("Spouse + Mother + Father-in-law", 1);
		BtnPress.put("Spouse + Mother-in-law",1 );
		BtnPress.put("Self + Kid1 + Father", 4);
		BtnPress.put("Self + Spouse + Kid1 + Kid2 + Kid3 + Mother + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Father-in-law", 1);
		BtnPress.put("Self + Spouse + Kid1 + Mother", 2);
		BtnPress.put("Self + Spouse + Father", 4);
		BtnPress.put("Self + Spouse + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Father + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Father + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Mother + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Mother + Father-in-law + Mother-in-law",1 );
		BtnPress.put("Self + Father + Mother + Father-in-law + Mother-in-law", 1);
		BtnPress.put("Self + Spouse + Father + Mother + Father-in-law + Mother-in-law",1 );
		BtnPress.put("Self + Kid1", 21);
		BtnPress.put("Self + Kid1 + Kid2", 14);
		BtnPress.put("Self + Spouse + Kid1 + Kid2", 14);
		
		
	
		Thread.sleep(WaitTime.low);
		clearAndSenKeys(FamilySize, dataRow.getProperty("FamilySize"), "Family-Size");
		Thread.sleep(WaitTime.low);
		
		for(String key: BtnPress.keySet()){
			if(key.equalsIgnoreCase(dataRow.getProperty("FamilySize")))
			{
				int btnpressed = BtnPress.get(dataRow.getProperty("FamilySize"));
				
				for(int x = 0 ; x<btnpressed;x++)
				{
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='familysize']"))));
					driver.findElement(By.xpath("//input[@id='familysize']")).sendKeys(Keys.ARROW_DOWN);
				}
				driver.findElement(By.xpath("//input[@id='familysize']")).sendKeys(Keys.ENTER);				
				driver.findElement(By.xpath("//input[@id='familysize']")).sendKeys(Keys.TAB);	
		        
		    }
		}
			
		List<WebElement> element = driver.findElements(By.xpath("//span[@md-highlight-text='searchText']"));
		
		
		  for (int j = 0; j < element.size(); j++) {
		        String temp = element.get(j).getText();
		        if (temp.equals(dataRow.getProperty("FamilySize"))) {
		            element.get(j).click();             
		            break;
		        }
		  }
				
	
		
		wait.until(ExpectedConditions.elementToBeClickable(plantype));
		selectFromDropdownByVisibleText(employeediscount, dataRow.getProperty("EmployeeDiscount"),"EmployeeDiscount");

		clearAndSenKeys(pincode,dataRow.getProperty("PinCode"),  "PinCode ");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		
		
		String noOfmembers = noOFmembers.getAttribute("value");
		int membersno = Integer.parseInt(noOfmembers);
	
		HashMap<String, String> genderlist = new HashMap<>(); 
		genderlist.put("Self","Male");
		genderlist.put("Spouse","Male");
		genderlist.put("Kid1","Male");
		genderlist.put("Kid2","Male");
		genderlist.put("Kid3","Male");
		genderlist.put("Father","Male");
		genderlist.put("Mother","Female");
		genderlist.put("Father-in-law","Male");
		genderlist.put("Mother-in-law","Female");
		
		//Random String Generator
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(20);
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		
		
		
		
		String Family = dataRow.getProperty("FamilySize");
		String Family1 = Family.replace(" ", "");
		ArrayList<String> myList = new ArrayList<String>(Arrays.asList(Family1.split("\\+")));

		
		//member details
		
		if (zone.isEnabled())
		{
		selectFromDropdownByVisibleText(zone, dataRow.getProperty("Zone"),"Zone ");
		}
		
		selectFromDropdownByVisibleText(deductible, dataRow.getProperty("Deductible")," Dedcutible ");
		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(room, dataRow.getProperty("RoomCategory")," Room Category ");
		Thread.sleep(WaitTime.low);
		
		
		
		
		for (int x = 0;x<myList.size();x++)
		{
			int y = x+1;
			
			WebElement MemberName = driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]"));
			WebElement dob = driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]"));
			WebElement gender = driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]"));
			WebElement relationship = driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]"));
			WebElement AgeValue1 = driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]"));
			
			
			
			if (myList.get(x).equalsIgnoreCase("Self"))
			{
				clearAndSenKeys(MemberName , getRandomString() ," Name ");
				
				
				//Age & DOB
				 DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
				 Date obj = new Date();
				 String acurrdate=dfor.format(obj);
				 
				 
				if (dataRow.getProperty("SelfDOB").equalsIgnoreCase("<1"))
				{
					 clearAndSenKeys(AgeValue,"0","Age");
					 String CollectAge=AgeValue.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate=acurrdate.replaceAll(date3, yearStr);
			         clearAndSenKeys(dob,actualdate,"Date of Birth");
			         dob.sendKeys(Keys.TAB);
			         AgeValue.sendKeys(Keys.TAB);
			} 
			         
				else
				{
		        	//Date Calculation
		        	 clearAndSenKeys(AgeValue,dataRow.getProperty("SelfDOB"),"Age");
		        	 String CollectAge=AgeValue.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate=acurrdate.replaceAll(date3, yearStr);			        
			         clearAndSenKeys(dob,actualdate,"Date of Birth");
			         dob.sendKeys(Keys.TAB);
			         AgeValue.sendKeys(Keys.TAB);
			         
				}
		
				
				//Gender
				
				if(dataRow.getProperty("Gender").equalsIgnoreCase("Male")) {
				 selectFromDropdownByVisibleText(gender, "Male"," Gender ");			
				}
				else {
					selectFromDropdownByVisibleText(gender, "Female"," Gender ");					
				}
							
				selectFromDropdownByVisibleText(relationship,"Self"," Relationship ");										
			}

            else if (myList.get(x).equalsIgnoreCase("Spouse")) {            			
				clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")) , getRandomString() ," Name ");				
				
				//Age & DOB
				DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
				Date obj = new Date();
				String acurrdate=dfor.format(obj);
				 
				 
				if (dataRow.getProperty("SpouseDOB").equalsIgnoreCase("<1"))
				{
					 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),"0","Age");					
					 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate1=acurrdate.replaceAll(date3, yearStr);			         
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate1,"Date of Birth");
			         Thread.sleep(WaitTime.low);
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			} 
			         
				else
				{
		        	//Date Calculation
		        	 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),dataRow.getProperty("SpouseDOB"),"Age");		        	 
		        	 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate1=acurrdate.replaceAll(date3, yearStr);		        
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate1,"Date of Birth");			       
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			         
				}
				
				//Gender
				
				if(dataRow.getProperty("Gender").equalsIgnoreCase("Male")) {
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")), "Female"," Gender ");				
					}
				else {
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")), "Male"," Gender ");				
					}
							
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),"Spouse"," Relationship ");			
            	
			}
          else if (myList.get(x).equalsIgnoreCase("Kid1")) {				
				clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")) , getRandomString() ," Name ");		
				
				//Age & DOB
				DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
				 Date obj = new Date();
				 String acurrdate=dfor.format(obj);
				 
				 
				if (dataRow.getProperty("Kid1DOB").equalsIgnoreCase("<1"))
				{
					 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),"0","Age");				
					 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate2=acurrdate.replaceAll(date3, yearStr);			         
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate2,"Date of Birth");			        
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			} 
			         
				else
				{
		        	//Date Calculation
		        	 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),dataRow.getProperty("Kid1DOB"),"Age");		        	
		        	 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate2=acurrdate.replaceAll(date3, yearStr);		         
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate2,"Date of Birth");			        
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			         
				}
											
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")), "Male"," Gender ");								
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),"Son"," Relationship ");			

			}
          else if (myList.get(x).equalsIgnoreCase("Kid2")) {			
				clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")) , getRandomString() ," Name ");
		
				
				//Age & DOB
				DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
				 Date obj = new Date();
				 String acurrdate=dfor.format(obj);
				 
				 
				if (dataRow.getProperty("Kid2DOB").equalsIgnoreCase("<1"))
				{
					 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),"0","Age");				
					 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate3=acurrdate.replaceAll(date3, yearStr);			        
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate3,"Date of Birth");		        
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			} 
			         
				else
				{
		        	//Date Calculation
		        	 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),dataRow.getProperty("Kid2DOB"),"Age");		        	
		        	 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate3=acurrdate.replaceAll(date3, yearStr);		         
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate3,"Date of Birth");		        
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			         
				}
							
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")), "Male"," Gender ");

				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),"Son"," Relationship ");
			
        	  
          }
          else if (myList.get(x).equalsIgnoreCase("Kid3")) {
    
				clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")) , getRandomString() ," Name ");
	
				//Age & DOB
				DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
				 Date obj = new Date();
				 String acurrdate=dfor.format(obj);
				 
				 
				if (dataRow.getProperty("Kid3DOB").equalsIgnoreCase("<1"))
				{
					 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),"0","Age");					
					 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate4=acurrdate.replaceAll(date3, yearStr);			       
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate4,"Date of Birth");		         
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			} 
			         
				else
				{
		        	//Date Calculation
		        	 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),dataRow.getProperty("Kid3DOB"),"Age");		        	
		        	 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate4=acurrdate.replaceAll(date3, yearStr);			        
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate4,"Date of Birth");			        
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			         
				}
								
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")), "Male"," Gender ");											
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),"Son"," Relationship ");

          }
          else if (myList.get(x).equalsIgnoreCase("Father")) {
				clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")) , getRandomString() ," Name ");
			
				//Age & DOB
				DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
				 Date obj = new Date();
				 String acurrdate=dfor.format(obj);
				 
				 
				if (dataRow.getProperty("FatherDOB").equalsIgnoreCase("<1"))
				{
					 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),"0","Age");					 
					 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate5=acurrdate.replaceAll(date3, yearStr);			        
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate5,"Date of Birth");			        
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
		    	} 
			         
				else
				{
		        	//Date Calculation
		        	 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),dataRow.getProperty("FatherDOB"),"Age");	        	
		        	 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate5=acurrdate.replaceAll(date3, yearStr);		   
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate5,"Date of Birth");			         
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			         
				}
						
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")), "Male"," Gender ");		
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),"Father"," Relationship ");
				
          }
          else if (myList.get(x).equalsIgnoreCase("Mother")) {	
  
				clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")) , getRandomString() ," Name ");

				//Age & DOB
				DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
				 Date obj = new Date();
				 String acurrdate=dfor.format(obj);
				 
				 
				if (dataRow.getProperty("MotherDOB").equalsIgnoreCase("<1"))
				{
					 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),"0","Age");				
					 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate6=acurrdate.replaceAll(date3, yearStr);		         
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate6,"Date of Birth");			        
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
		    	} 
			         
				else
				{
		        	//Date Calculation
		        	 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),dataRow.getProperty("MotherDOB"),"Age");		        	
		        	 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate6=acurrdate.replaceAll(date3, yearStr);			        
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate6,"Date of Birth");			       
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			         
				}
		
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")), "Female"," Gender ");				
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),"Mother"," Relationship ");
		
          }
          else if (myList.get(x).equalsIgnoreCase("Father-in-law")) {
				clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")) , getRandomString() ," Name ");			
				

				//Age & DOB
				 DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
				 Date obj = new Date();
				 String acurrdate=dfor.format(obj);
				 
				 
				if (dataRow.getProperty("FILDOB").equalsIgnoreCase("<1"))
				{
					 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),"0","Age");					
					 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate7=acurrdate.replaceAll(date3, yearStr);			        
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate7,"Date of Birth");			        
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
		    	} 
			         
				else
				{
		        	//Date Calculation
		        	 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),dataRow.getProperty("FILDOB"),"Age");		        	
		        	 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate7=acurrdate.replaceAll(date3, yearStr);		        
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate7,"Date of Birth");			      
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
				}

				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")), "Male"," Gender ");

				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),"Father-in-Law"," Relationship ");
		
          	}	
          else if (myList.get(x).equalsIgnoreCase("Mother-in-law")) {

				clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")) , getRandomString() ," Name ");
		
				//Age & DOB
				 DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
				 Date obj = new Date();
				 String acurrdate=dfor.format(obj);
				 
				 
				if (dataRow.getProperty("MILDOB").equalsIgnoreCase("<1"))
				{
					 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),"0","Age");		
					 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate8=acurrdate.replaceAll(date3, yearStr);			       
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate8,"Date of Birth");			        
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
		    	} 
			         
				else
				{
		        	//Date Calculation
		        	 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),dataRow.getProperty("MILDOB"),"Age");		        
		        	 String CollectAge=AgeValue1.getAttribute("value");
					 String[] arrofstr=acurrdate.split("/",3);
			         String date3=arrofstr[2];
				     int calactual= Integer.parseInt(date3);
				     int ageCal=Integer.parseInt(CollectAge);
				     int year=calactual-ageCal;
			         String yearStr=String.valueOf(year);
			         String actualdate8=acurrdate.replaceAll(date3, yearStr);		        
			         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate8,"Date of Birth");			      
			         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
			         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
			         
				}

				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")), "Female"," Gender");
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),"Mother-in-Law"," Relationship");
			
          	}	
		
		}
		

		click(calpremBTN, "Calculate Premium Button");
		Thread.sleep(WaitTime.low);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnSave']")));
		Reporter.log("");
		Reporter.log("<B> -------------------------------------------</B>");
		Reporter.log("<B>  OPD not applied </B>");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText());
		Reporter.log("<B> Discount:-  </B>"+Discount.getText());
		Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
		Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
		Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"+netpremiumafterloading.getText());
		Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText());
		Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"+premiuminclusiveofTAX.getText());
		Reporter.log("<B> -------------------------------------------</B>");
		
		
		click(saveBTN," SaveButton ");
		click(saveokBTN, "Ok ");
	
		
		String QuoteNo = refno2.getText();
		setQuoteNo(QuoteNo);
		ConfigReader.getInstance().StoreValueToConfig("Quote_No", QuoteNo, "Quote generated");
		
		Reporter.log("<B> Quotation:- </B> "+refno2.getText());
		Reporter.log("                     ");
		Reporter.log("---------------------");
		
		
		

		//Assert Quote Details
		
		  String netpremiumbeforeval = netpremiumbefore.getText().toString().replace("₹ ", "").replace(",", ""); 
		  int netpremiumbeforevalNO = (int) Float.parseFloat(netpremiumbeforeval); 
		  int netpremiumbeforevalNOSheet = (int)Float.parseFloat(dataRow.getProperty("NetPremiumBeforeDiscouunt(BeforeOPD)").replace(",", ""));
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		  verifyAssert(Math.round(netpremiumbeforevalNO),Math.round(netpremiumbeforevalNOSheet), "Expected value NetPremium");
		  //Assert.assertEquals("Expected value",Math.round(netpremiumbeforevalNO), Math.round(netpremiumbeforevalNOSheet));
		
		
		//ELSE-IF Waiver of Mandatory Co-payment 
		
		if(dataRow.getProperty("Co-Pay Waiver").equalsIgnoreCase("Yes"))
		{
			
			click(wmpcpCheckbox," Hospital Cash Benefit checkBOX");

			click(calpremBTN, "Calculate Premium Button");

			//click on OK Quote button
			boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
			if (okBTN == true) {
				click(saveokBTN,"OK");
			}
			
		
			
			Reporter.log("");
			Reporter.log("<B> -------------------------------------------</B>");
			Reporter.log("<B>After Co-Pay Added</B>");
			Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText());
			Reporter.log("<B> Discount:-  </B>"+Discount.getText());
			Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
			Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
			Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"+netpremiumafterloading.getText());
			Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText());
			Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"+premiuminclusiveofTAX.getText());
			Reporter.log("<B> -------------------------------------------</B>");
			
			
		}
		
	}
		
		//Arogya sanjivni-- Rahul
				if(dataRow.getProperty("Product").equalsIgnoreCase("Arogya Sanjeevani Policy, Aditya Birla Health Insurance Co. Limited")) {
					
					clearAndSenKeys(membernumbers,dataRow.getProperty("NoOfMembers"),  "No Of Members ");
					membernumbers.sendKeys(Keys.TAB);					
					
					int MemSize = Integer.parseInt(dataRow.getProperty("NoOfMembers"));
									
					wait.until(ExpectedConditions.elementToBeClickable(plantype));
					Thread.sleep(WaitTime.low);
					selectFromDropdownByVisibleText(employeediscount, dataRow.getProperty("EmployeeDiscount"),"EmployeeDiscount");					
					Thread.sleep(WaitTime.low);
					
					clearAndSenKeys(pincode,dataRow.getProperty("PinCode"),  "PinCode ");
					Thread.sleep(WaitTime.low);
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
					Thread.sleep(WaitTime.low);
					
					//Random String Generator
					char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
					StringBuilder sb = new StringBuilder(20);
					Random random = new Random();
					for (int i = 0; i < 4; i++) {
					    char c = chars[random.nextInt(chars.length)];
					    sb.append(c);
					}
					
					
					String Family = dataRow.getProperty("Relation");
//					String Family1 = Family.replace(" ", "");
					ArrayList<String> Relationlist = new ArrayList<String>(Arrays.asList(Family.split("\\+")));
					
//					String SIval = dataRow.getProperty("SumInsured");
//					String SI1val = SIval.replace(" ", "");
//					ArrayList<String> SumInsuredList = new ArrayList<String>(Arrays.asList(SI1val.split("\\+")));
					
					String zoneval = dataRow.getProperty("Zone");
					String zoneval1 = zoneval.replace(" ", "");
					ArrayList<String> zonelist = new ArrayList<String>(Arrays.asList(zoneval.split("\\+")));
					
					
					String deductval = dataRow.getProperty("Deductible");
					String deductval1= deductval.replace(" ", "");
					ArrayList<String> deductlist = new ArrayList<String>(Arrays.asList(deductval1.split("\\+")));
					
				
					String ageval = dataRow.getProperty("Age");
					String ageval1= ageval.replace(" ", "");
					ArrayList<String> agelist = new ArrayList<String>(Arrays.asList(ageval1.split("\\+")));
					
					String genderval = dataRow.getProperty("Gender");
					String genderval1= genderval.replace(" ", "");
					ArrayList<String> genderlist = new ArrayList<String>(Arrays.asList(genderval1.split("\\+")));
					
					String roomval = dataRow.getProperty("RoomCategory");
					//String roomval1= roomval.replace(" ", "");
					ArrayList<String> roomlist = new ArrayList<String>(Arrays.asList(roomval.split("\\+")));
							
					Thread.sleep(WaitTime.low);
					selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[3])[1]")),roomlist.get(0)," Room ");
					Thread.sleep(WaitTime.low);
					
					HashMap<String, String> NamesList = new HashMap<>(); 
					NamesList.put("Self","Tom");
					NamesList.put("Spouse","Emily");
					NamesList.put("Brother","Jacob");
					NamesList.put("Brother-in-law","Olivier");
					NamesList.put("Sister","Isabella");
					NamesList.put("Sister-in-law","Sophie");
					NamesList.put("Son","Archie");
					NamesList.put("Son-in-law","Alexander");
					NamesList.put("Son","Archie");
					NamesList.put("Son","Archie");
					NamesList.put("Son","Archie");
					
					
					NamesList.put("Kid1","Harry");
					NamesList.put("Kid2","Jacl");
					NamesList.put("Kid3","Thomas");
					NamesList.put("Father","Noah");
					NamesList.put("Mother","Female");
					NamesList.put("Father-in-law","George");
					NamesList.put("Mother-in-law","Olivia");
					
					ArrayList<String> Names = new ArrayList<String>();
					Names.add("Self");
					Names.add("Spouse");
					Names.add("Brother");
					Names.add("Brother-in-law");
					Names.add("Sister");
					Names.add("Sister-in-law");
					Names.add("Father");
					Names.add("Father-in-law");
					Names.add("Mother");
					Names.add("Mother-in-law");
					Names.add("Son");
					Names.add("Son-in-law");
					Names.add("Granddaughter");
					Names.add("Grandfather");
					Names.add("Grandmother");
					Names.add("Grandson");
					Names.add("Nephew");
					Names.add("Niece");
					Names.add("Daughter");
					Names.add("Daughter-in-law");
					Names.add("Dependant Child");
					
					
					//Member Details
					for (int x = 0;x<MemSize;x++)
						{
							int y = x+1;
							
							
							WebElement MemberName = driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]"));
							WebElement dob = driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]"));
							WebElement gender = driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]"));
							WebElement relationship = driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]"));
							WebElement SI = driver.findElement(By.xpath("(//input[@id='Member Name']//preceding::select[1])["+y+"]"));
							WebElement zone = driver.findElement(By.xpath("(//input[@id='Member Name']//following::select[1])["+y+"]"));
							WebElement deduct = driver.findElement(By.xpath("(//input[@id='Member Name']//following::select[3])["+y+"]"));
							WebElement room = driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[3])["+y+"]"));
							
                    Thread.sleep(WaitTime.low);
					clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")), getRandomString(), "Member ");
					Thread.sleep(WaitTime.low);
					selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Member Name']//following::select[3])["+y+"]")),deductlist.get(x)," deductlist ");

					 DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
					 Date obj = new Date();
					 String acurrdate=dfor.format(obj);
					 
					 if (dataRow.getProperty("Age").equalsIgnoreCase("<1"))
						{
							 clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),"0","Age");									
							 String CollectAge=driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).getAttribute("value");
							 String[] arrofstr=acurrdate.split("/",3);
					         String date3=arrofstr[2];
						     int calactual= Integer.parseInt(date3);
						     int ageCal=Integer.parseInt(CollectAge);
						     int year=calactual-ageCal;
					         String yearStr=String.valueOf(year);
					         String actualdate=acurrdate.replaceAll(date3, yearStr);							        
					         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate,"Date of Birth");								         
					         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
					         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
					} 
					         
						else
						{
				        	//Date Calculation
							 clearAndSenKeysStale(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),agelist.get(x),"Age");							        	
				        	 String CollectAge=driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).getAttribute("value");
							 String[] arrofstr=acurrdate.split("/",3);
					         String date3=arrofstr[2];
						     int calactual= Integer.parseInt(date3);
						     int ageCal=Integer.parseInt(CollectAge);
						     int year=calactual-ageCal;
					         String yearStr=String.valueOf(year);
					         String actualdate=acurrdate.replaceAll(date3, yearStr);								    
					         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate,"Date of Birth");								      
					         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
					         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
					         
						}
					

					selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")),genderlist.get(x)," Gender ");

					//Relationship

					selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),Relationlist.get(x)," Relationship ");

			}

					SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
					click(calpremBTN, "Calculate Premium Button");
					Thread.sleep(WaitTime.low);
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnSave']")));
					click(saveBTN," SaveButton ");				
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
					SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
					click(saveokBTN, "Ok ");			
					
					String QuoteNo = refno2.getText();
					setQuoteNo(QuoteNo);
					ConfigReader.getInstance().StoreValueToConfig("Quote_No", QuoteNo, "Quote generated");
					
					Reporter.log("<B> Quotation:- </B> "+refno2.getText());
					Reporter.log("                     ");
					Reporter.log("---------------------");
					
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
					
					Reporter.log("");
					Reporter.log("<B> -------------------------------------------</B>");
					Reporter.log("<B>  No covers Attached </B>");
					Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText());
					Reporter.log("<B> Discount:-  </B>"+Discount.getText());
					Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
					Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
					Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"+netpremiumafterloading.getText());
					Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText());
					Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"+premiuminclusiveofTAX.getText());
					Reporter.log("<B> -------------------------------------------</B>");
					
//					Assert Quote Details
					String netpremiumbeforeval = netpremiumbefore.getText().toString().replace("₹ ", "");
					Assert.assertEquals("Expected value",netpremiumbeforeval, dataRow.getProperty("NetPremiumBeforeDiscouunt(BeforeOPD)"));
					
					
					//CO-Pay Wavier
					String isCoPay = dataRow.getProperty("Co-Pay Waiver");
					String isCoPay1= isCoPay.replace(" ", "");
					ArrayList<String> isCoPaylist= new ArrayList<String>(Arrays.asList(isCoPay1.split("\\+")));
					
				
					for (int x = 0;x<isCoPaylist.size();x++)
					{
					if(isCoPaylist.get(x).equalsIgnoreCase("Yes"))
					{
						int y = x+1;						
						click(driver.findElement(By.xpath("(//input[@name='WMCP'])["+y+"]"))," Hospital Cash Benefit checkBOX");										
						click(calpremBTN, "Calculate Premium Button");					
						
						boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
						if (okBTN == true) {
							click(saveokBTN,"OK");
						}
						
					}
					}
					
				}
		
		//Assert
		
		  String premiumbeforeOPD = netpremiumafter.getText().toString().replace("₹ ","").replace(",", ""); 
		  int premiumbeforeOPDNO = (int)Float.parseFloat(premiumbeforeOPD); int premiumbeforeOPDNOSheet = (int)
		  Float.parseFloat(dataRow.getProperty("NetPremiumAfterDiscount(BeforeOPD)").replace(",", "")); verifyAssert(premiumbeforeOPDNO,premiumbeforeOPDNOSheet,"NetPremiumAfterDiscount(BeforeOPD)");
		  verifyAssert(premiumbeforeOPDNO,premiumbeforeOPDNOSheet,"NetPremiumAfterDiscount(B/eforeOPD)");
		

		
		
		//IF opd 
		
		if(dataRow.getProperty("OPDapplicable").equalsIgnoreCase("Yes"))
		{	
			click(opdeCheckbox,"OPDE checkBOX");
			//click on OK Quote button
			boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
			if (okBTN == true) {
				click(saveokBTN,"OK");
			}
			selectFromDropdownByVisibleText(opdeDropDown, dataRow.getProperty("OPDsi")," OPD Expenses SumInsured ");
			
			click(calpremBTN, "Calculate Premium Button");
			Thread.sleep(WaitTime.low);
			WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));	
			
			Reporter.log("");
			Reporter.log("<B> -------------------------------------------</B>");
			Reporter.log("<B>After OPD calculated</B>");
			Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText());
			Reporter.log("<B> Discount:-  </B>"+Discount.getText());
			Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
			Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
			Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"+netpremiumafterloading.getText());
			Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText());
			Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"+premiuminclusiveofTAX.getText());
			Reporter.log("<B> -------------------------------------------</B>");
				
		}		
		
		
		//ELSE-IF HOSPITAL CASH BENEFIT 
		
		if(dataRow.getProperty("HospitalCashBenefit").equalsIgnoreCase("Yes"))
		{
			click(hcbCheckbox," Hospital Cash Benefit checkBOX");
			//click on OK Quote button
			boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
			if (okBTN == true) {
				click(saveokBTN,"OK");
			}
			
			selectFromDropdownByVisibleText(hcbDropDown, dataRow.getProperty("HCBsi")," Hospital Cash Benefit  Expenses");			
			
			click(calpremBTN, "Calculate Premium Button");
			Thread.sleep(WaitTime.low);
			WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));	
			
			Reporter.log("");
			Reporter.log("<B> -------------------------------------------</B>");
			Reporter.log("<B>After Hospital Cash Benefit calculated</B>");
			Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText());
			Reporter.log("<B> Discount:-  </B>"+Discount.getText());
			Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
			Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
			Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"+netpremiumafterloading.getText());
			Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText());
			Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"+premiuminclusiveofTAX.getText());
			Reporter.log("<B> -------------------------------------------</B>");
				
		}
		

		
		//ELSE-IF MaternityExpense
		if(dataRow.getProperty("MaternityExpense").equalsIgnoreCase("Yes"))
		{			
			click(mtexCheckbox," Maternity Expense checkBOX");
			
			//click on OK Quote button
			boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
			if (okBTN == true) {
				click(saveokBTN,"OK");
			}
			
					
	        click(calpremBTN, "Calculate Premium Button");
	        Thread.sleep(WaitTime.low);
			WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));	
			
			Reporter.log("");
			Reporter.log("<B> -------------------------------------------</B>");
			Reporter.log("<B>After Maternity calculated</B>");
			Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText());
			Reporter.log("<B> Discount:-  </B>"+Discount.getText());
			Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
			Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
		    Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"+netpremiumafterloading.getText());
		    Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText());
	        Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"+premiuminclusiveofTAX.getText());
			Reporter.log("<B> -------------------------------------------</B>");
				
		}
		switchtodefaultframe(driver);
	}
		
	
	
	@SuppressWarnings("deprecation")
	public void AssertQuote(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook,sheetName, testCaseName,stepGroup);

		//Values of Premium Calculation	
		String netpremiumbeforeval = netpremiumbefore.getText().toString().replace("₹ ", "").replace(",", "");
		String discountval = Discount.getText().toString().replace("₹ ", "").replace(",", "");
		String netpremiumafterval = netpremiumafter.getText().toString().replace("₹ ", "").replace(",", "");
		String loadingval = loading.getText().toString().replace("₹ ", "").replace(",", "");
		String netpremiumafterloadingval = netpremiumafterloading.getText().toString().replace("₹ ", "").replace(",", "");
		String taxamountElementval = taxamountElement.getText().toString().replace("₹ ", "").replace(",", "");
		String premiuminclusiveofTAXval = premiuminclusiveofTAX.getText().toString().replace("₹ ", "").replace(",", "");
		

		
		
		//after OPD assert
		int netpremiumaftervalNO = (int) Float.parseFloat(netpremiumafterval);	
		int netpremiumaftervalNOSheet = (int) Float.parseFloat(dataRow.getProperty("NetPremiumAfterDiscount(AfterOPD)").replace(",", ""));	
		verifyAssert(netpremiumaftervalNO, netpremiumaftervalNOSheet,"NetPremiumAfterDiscount(After Covers)");
		//Assert.assertEquals(netpremiumafterloadingval, dataRow.getProperty("NetPremiumAfterLoading(AfterOPD)"));
		
		int taxamountElementvalNO = (int) Float.parseFloat(taxamountElementval);	
		int taxamountElementvalNOSheet = (int) Float.parseFloat(dataRow.getProperty("GST").replace(",", ""));		
		verifyAssert(taxamountElementvalNO, taxamountElementvalNOSheet," GST ");
		
		
		
		int premiuminclusiveofTAXvalNO = (int) Float.parseFloat(premiuminclusiveofTAXval);	
		int premiuminclusiveofTAXvalNOSheet = (int) Float.parseFloat(dataRow.getProperty("Total Premium").replace(",", ""));	
		verifyAssert(premiuminclusiveofTAXvalNO,premiuminclusiveofTAXvalNOSheet,"Total Premium");
		
		System.out.println("-------------Execution Complete-----------");
		switchtodefaultframe(driver);
		
		
	}
	
		public void fillFamilyQuote(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
		{
			fillAddQuote(driver, testCaseName, workbook, conn, stepGroup, customAssert);
			AssertQuote(driver, testCaseName, workbook, conn, stepGroup, customAssert);
			
			
		}

}

