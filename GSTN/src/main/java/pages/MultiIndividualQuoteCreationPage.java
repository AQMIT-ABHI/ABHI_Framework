package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import javax.annotation.Nullable;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;
//import com.google.common.base.Predicate;

import constants.PropertyConfigs;
import junit.framework.Assert;
import testRunner.TestEngine;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.SetUpWebdriver;
import util.WaitTime;

public class MultiIndividualQuoteCreationPage extends GenericMethods {
	
	
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
	
	@FindBy(xpath="(//div[@class='lobicon ng-scope']/a)[1]")
	private WebElement intermediarysearch;
	
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
	
	@FindBy(xpath="//select[@id='Employee Discount']")
	private WebElement employeediscount;

	@FindBy(xpath="//input[@id='Proposer Pin Code']")
	private WebElement pincode;

	@FindBy(xpath="//input[@id='Number of Members']")
	private WebElement membernumbers;
	
	@FindBy(xpath="//input[@id='Proposer Email ID']")
	private WebElement emailid;
	
//	@FindBy(xpath="(//input[@id='Member Name']//preceding::select[1])[1]")
//	private WebElement SI;
	
	@FindBy(xpath="(//input[@id='Member Name'])[1]")
	private WebElement membername;
	
//	@FindBy(xpath="(//input[@id='Member Name']//following::select[3])[1]")
//	private WebElement deductible;
	
	@FindBy(xpath="(//input[@id='Date of Birth'])[1]")
	private WebElement dob;
	
	@FindBy(xpath="(//input[@id='Date of Birth']//following::select[1])[1]")
	private WebElement gender;
	
	@FindBy(xpath="(//input[@id='Date of Birth']//following::select[2])[1]")
	private WebElement relation;
	
//	@FindBy(xpath="(//input[@id='Date of Birth']//following::select[3])[1]")
//	private WebElement room;
	
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
	
	//HCB
	@FindBy(xpath="//input[@name='HSCB']")
	private WebElement hcbCheckbox ;
	
	@FindBy(xpath="//input[@name='WMCP']")
	//Co-Pay Waiver
	private WebElement wmpcpCheckbox ;
	
	//maternity express
	@FindBy(xpath="//input[@name='MTEX']")
	private WebElement mtexCheckbox ;
	
	@FindBy(xpath="//select[@name='Applicable Sum Insured']")
	private WebElement opdeDropDown;
	
	
	@FindBy(xpath="(//b[contains(text(),'HSCB - Hospital Cash Benefit')]//following::select[1])[1]")
	private WebElement hcbDropDown;
	
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
	
	//POS Active assure covers
	
		@FindBy(xpath="(//input[@name='AHB'])[1]")
		private WebElement AHBchkbox ;
		
		@FindBy(xpath="(//input[@name='ANRU'])[1]")
		private WebElement ANRUchkbox ;
		
		@FindBy(xpath="(//input[@name='CHB'])[1]")
		private WebElement CHBchkbox ;
		
		@FindBy(xpath="(//input[@name='RIPW'])[1]")
		private WebElement RIPWchkbox ;
		
		@FindBy(xpath="(//input[@name='SNCB'])[1]")
		private WebElement SNCBchkbox ;
		
		@FindBy(xpath="(//input[@name='URSI'])[1]")
		private WebElement URSIchkbox ;
		
		//Affiliated Employee Discount
		@FindBy(xpath="//select[@id='Affiliate employee discount']")
		private WebElement affiliatedEMPdiscount;
		
		
		//Active Secure POS & Non POSCovers
		
		//ACCDCheckbox
		@FindBy(xpath="//input[@name='ACCD']")
		private WebElement ACCDCheckbox;
		
		//ACCDDropDown
		@FindBy(xpath="(//b[contains(text(),'ACCD - Accidental Death Cover (AD)')]//following::select[1])[1]")
		private WebElement ACCDDropDown;
		
		//AMECheckbox
		@FindBy(xpath="//input[@name='ACME']")
		private WebElement AMECheckbox;
		
		//EMICheckbox
		@FindBy(xpath="//input[@name='EMIP']")
		private WebElement EMICheckbox;
		
		//EMIDropDown
		@FindBy(xpath="(//b[contains(text(),'EMIP - EMI Protect')]//following::select[1])[1]")
		private WebElement EMIDropDown;
		
		//LoanCheckbox
		@FindBy(xpath="//input[@name='LOPC']")
		private WebElement LoanCheckbox;
		
		//LoanDropDown
		@FindBy(xpath="(//b[contains(text(),'LOPC - Loan Protect')]//following::select[1])[1]")
		private WebElement LoanDropDown;
		
		//WEASCheckbox
		@FindBy(xpath="//input[@name='WEAS']")
		private WebElement WEASCheckbox;
		
		//CICheckbox
		@FindBy(xpath="//input[@name='CIL']")
		private WebElement CICheckbox;
		
		//CIDropDown
		@FindBy(xpath="(//b[contains(text(),'CIL - Critical Illness')]//following::select[1])[1]")
		private WebElement CIDropDown;
		
		//SEOCheckbox
		@FindBy(xpath="//input[@name='SCOP']")
		private WebElement SEOCheckbox;
		
		//WCCheckbox
		@FindBy(xpath="//input[@name='WLI']")
		private WebElement WCCheckbox;
		
		//ADSBCheckbox
		@FindBy(xpath="//input[@name='ADSB']")
		private WebElement ADSBCheckbox;
		
		//APHCCheckbox
		@FindBy(xpath="//input[@name='APHC']")
		private WebElement APHCCheckbox;
		
		//BBBFCheckbox
		@FindBy(xpath="//input[@name='BBBF']")
		private WebElement BBBFCheckbox;
		
		//BBBFDropDown
		@FindBy(xpath="(//b[contains(text(),'BBBF - Broken Bones Benefit')]//following::select[1])[1]")
		private WebElement BBBFDropDown;
		
		//BNBECheckbox
		@FindBy(xpath="//input[@name='BNBE']")
		private WebElement BNBECheckbox;
		
		//BBBFDropDown
		@FindBy(xpath="(//b[contains(text(),'BNBE - Burn Benefit')]//following::select[1])[1]")
		private WebElement BNBEDropDown;
		
		//COBECheckbox
		@FindBy(xpath="//input[@name='COBE']")
		private WebElement COBECheckbox;
		
		//TTDBCheckbox
		@FindBy(xpath="//input[@name='TTDB']")
		private WebElement TTDBCheckbox;
		
		//CANCCheckbox
		@FindBy(xpath="//input[@name='CANC']")
		private WebElement CANCCheckbox;
		
		//CANCDropDown
		@FindBy(xpath="(//b[contains(text(),'CANC - Cancer Cover')]//following::select[1])[1]")
		private WebElement CANCDropDown;
		
		//SCANCheckbox
		@FindBy(xpath="//input[@name='SCAN']")
		private WebElement SCANCheckbox;
		
		//DCBCCheckbox
		@FindBy(xpath="//input[@name='DCBC']")
		private WebElement DCBCCheckbox;
		
		//DCBCDropDown
		@FindBy(xpath="(//b[contains(text(),'DCBC - Daily cash Benefit (DCB)')]//following::select[1])[1]")
		private WebElement DCBCDropDown;

	
	
    WebDriverWait wait;
	public MultiIndividualQuoteCreationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 40);	
	}

	public void fillAddQuote(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{	
		
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		Reporter.log("<B>Traverse To CommonPage</B>");

		Thread.sleep(WaitTime.medium);
		switchtoframe(driver, "display"); 
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(Product, dataRow.getProperty("Product"),"Product");
		Thread.sleep(WaitTime.medium);
		click(proceedBTN, "ProceedButton");
		Thread.sleep(WaitTime.medium);
		String parentWindow = driver.getWindowHandle();
		
		//EnteringQuoteDetails
		Thread.sleep(WaitTime.medium);
		wait.until(ExpectedConditions.elementToBeClickable(intermediarycodeField));
		clearAndSenKeys(intermediarycodeField,dataRow.getProperty("IntermediaryCode"),"InterMediaryCode ");
		click(intermediarysearch, " search ");
		switchToWindow(driver);
		driver.findElement(By.xpath("//a[contains(text(),'"+dataRow.getProperty("IntermediaryCode")+"')]")).click();
		driver.switchTo().window(parentWindow);
		
		
		switchtoframe(driver, "display");  
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(policytenure, dataRow.getProperty("Policy Tenure"),"Policy Tenure");
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(premiumFrequency, dataRow.getProperty("Premium Frequency"),"Premium Frequency");
		
		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(covertype, dataRow.getProperty("Cover Type"),"Cover Type");
		Thread.sleep(WaitTime.low);
		
		wait.until(ExpectedConditions.elementToBeClickable(plantype));
		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(plantype, dataRow.getProperty("Plan"),"Plan Type");
		Thread.sleep(WaitTime.low);
		
		selectFromDropdownByVisibleText(subplantype, dataRow.getProperty("SubPlan"),"SubPlan Type");
		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(employeediscount, dataRow.getProperty("EmployeeDiscount"),"EmployeeDiscount");
		Thread.sleep(WaitTime.low);
		
		if(dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4220)")||dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4227)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4219)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4226)")||dataRow.getProperty("Product").equalsIgnoreCase("Global Health Secure - As Is (4222)")||dataRow.getProperty("Product").equalsIgnoreCase("Global Health Secure - Revised (5222)"))
		{
		selectFromDropdownByVisibleText(affiliatedEMPdiscount, dataRow.getProperty("AffiliatedEMPDiscount"),"Affiliated Employee Discount");
		Thread.sleep(WaitTime.medium);
		}

		clearAndSenKeys(pincode,dataRow.getProperty("PinCode"),  "PinCode ");
		Thread.sleep(WaitTime.medium);
		
		clearAndSenKeys(membernumbers,dataRow.getProperty("NoOfMembers"),  "No Of Members ");
		Thread.sleep(WaitTime.medium);
		membernumbers.sendKeys(Keys.TAB);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		
		int MemSize = Integer.parseInt(dataRow.getProperty("NoOfMembers"));
		
		
		//Random String Generator
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(20);
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		//String name = sb.toString();
		
		String Family = dataRow.getProperty("Relation");
		//String Family1 = Family.replace(" ", "");
		ArrayList<String> Relationlist = new ArrayList<String>(Arrays.asList(Family.split("\\+")));
		
		String ageval = dataRow.getProperty("Age");
		String ageval1= ageval.replace(" ", "");
		ArrayList<String> agelist = new ArrayList<String>(Arrays.asList(ageval1.split("\\+")));
		
		String genderval = dataRow.getProperty("Gender");
		String genderval1= genderval.replace(" ", "");
		ArrayList<String> genderlist = new ArrayList<String>(Arrays.asList(genderval1.split("\\+")));
		
		
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
			WebElement deduct = driver.findElement(By.xpath("(//input[@id='Member Name']//following::select[2])["+y+"]"));
			WebElement room = driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[3])["+y+"]"));
			
			
			if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)")||dataRow.getProperty("Product").equalsIgnoreCase("Arogya Sanjeevani Policy (4225)")||dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4220)")||dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4227)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4219)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4226)")||dataRow.getProperty("Product").equalsIgnoreCase("Global Health Secure - As Is (4222)")||dataRow.getProperty("Product").equalsIgnoreCase("Global Health Secure - Revised (5222)"))
			{
				String SIval = dataRow.getProperty("SumInsured");
				String SI1val = SIval.replace(" ", "");
				ArrayList<String> SumInsuredList = new ArrayList<String>(Arrays.asList(SI1val.split("\\+")));
				
			    Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Member Name']//preceding::select[1])["+y+"]")),SumInsuredList.get(x)," SumInsured ");
				Thread.sleep(WaitTime.medium);
			}
				
			    Thread.sleep(WaitTime.low);
				clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")), getRandomString(), "Member Name");
				Thread.sleep(WaitTime.medium);
				
				if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)"))
				{
				   //Zone 
					Thread.sleep(WaitTime.medium); 
					String zoneval =dataRow.getProperty("Zone"); 
					String zoneval1 = zoneval.replace(" ", "");
					ArrayList<String> zonelist = new ArrayList<String>(Arrays.asList(zoneval.split("\\+")));
					Thread.sleep(WaitTime.medium);
					  
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Member Name']//following::select[1])["+y+"]")),zonelist.get(x)," Zone "); 
				Thread.sleep(WaitTime.medium);
				
				//Deductible
				String deductval = dataRow.getProperty("Deductible");
				String deductval1= deductval.replace(" ", "");
				ArrayList<String> deductlist = new ArrayList<String>(Arrays.asList(deductval1.split("\\+")));
				
				Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Member Name']//following::select[2])["+y+"]")),deductlist.get(x)," Deductible ");
				Thread.sleep(WaitTime.low);
				}	
				

				 DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
				 Date obj = new Date();
				 String acurrdate=dfor.format(obj);
				 
				 if(agelist.get(x).equalsIgnoreCase("<1")||agelist.get(x).equalsIgnoreCase("0"))
					{
						// clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),"0","Age");
						 String CollectAge=agelist.get(x);
						 String[] arrofstr=acurrdate.split("/",3);
				         String date3=arrofstr[2];
					     int calactual= Integer.parseInt(date3);
					     int ageCal=Integer.parseInt(CollectAge);
					     int year=calactual-ageCal;
				         String yearStr=String.valueOf(year);
				         String actualdate=acurrdate.replaceAll(date3, yearStr);
				         Thread.sleep(WaitTime.low);
				         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate,"Date of Birth");
				         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
				        // driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
				} 
				         
					else
					{
			        	//Date Calculation
						// clearAndSenKeysStale(driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")),agelist.get(x),"Age");
			        	 String CollectAge=agelist.get(x);
						 String[] arrofstr=acurrdate.split("/",3);
				         String date3=arrofstr[2];
					     int calactual= Integer.parseInt(date3);
					     int ageCal=Integer.parseInt(CollectAge);
					     int year=calactual-ageCal;
				         String yearStr=String.valueOf(year);
				         String actualdate=acurrdate.replaceAll(date3, yearStr);
				         Thread.sleep(WaitTime.low);
				         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate,"Date of Birth");
				         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
				         //driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
				         
					}
				
				
				 Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")),genderlist.get(x)," Gender ");
				//Relationship
				
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),Relationlist.get(x)," Relationship ");
				 Thread.sleep(WaitTime.medium);
				 
				//Room Category
				if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)"))
				{
				String roomval = dataRow.getProperty("RoomCategory");
				//String roomval1= roomval.replace(" ", "");
				ArrayList<String> roomlist = new ArrayList<String>(Arrays.asList(roomval.split("\\+")));
				
				Thread.sleep(WaitTime.low); 
			   selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[3])["+y+"]")),roomlist.get(x)," Room ");
			   Thread.sleep(WaitTime.low);
				}
				
				//click on Chronic
				if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)"))
				{
					String ischronicval = dataRow.getProperty("IsChronic");
					String ischronicval1= ischronicval.replace(" ", "");
					ArrayList<String> ischroniclist = new ArrayList<String>(Arrays.asList(ischronicval1.split("\\+")));
					
					String chronicval = dataRow.getProperty("Chronic");
					//String chronicval1= chronicval;
					ArrayList<String> chroniclist = new ArrayList<String>(Arrays.asList(chronicval.split("\\+")));
				
				if (ischroniclist.get(x).equalsIgnoreCase("Yes"))
				{
				String Chronic = chroniclist.get(x);
				String na = "n/a";
				
				if(Chronic != na) {
				ArrayList Chroniclist= new ArrayList(Arrays.asList(Chronic.split(",")));
				for(int i =0;i<Chroniclist.size();i++)
				{
				WebElement Chronicclick = driver.findElement(By.xpath("(//option[contains(text(),'"+Chroniclist.get(i)+"')])["+y+"]"));

				clickWithoutJavaScript(Chronicclick, " Chronic ");
				Reporter.log(" as "+Chroniclist.get(i));
				}
			}
		}
	}
				
		 if(dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4227)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4226)"))
			{
					String PPNDiscount = dataRow.getProperty("PPN Discount");
					String PPNDiscountt = PPNDiscount.replace(" ", "");
					ArrayList<String> PPNDiscounttt = new ArrayList<String>(Arrays.asList(PPNDiscountt.split("\\+")));
						
				   Thread.sleep(WaitTime.low);
				   selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[4])["+y+"]")),PPNDiscounttt.get(x)," PPN Discount ");
				   Thread.sleep(WaitTime.low);
			}
		 
		 
		 //Nature of Duty & Risk Class
		 if(dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Secure (6000)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Secure (5000)"))
			{
			 
				 WebElement natureofduty=driver.findElement(By.xpath("(//input[@id='natureofdutyrowIndex'])["+y+"]"));
				// WebElement RiskClass=driver.findElement(By.xpath("(//input[@id='Age']//following::select[3])["+y+"]"));

				 String NatureOf = dataRow.getProperty("NatureOfDuty");
				 //String NatureOf = Nature.replace(" ", "");
				 ArrayList<String> NatureOfdutylist = new ArrayList<String>(Arrays.asList(NatureOf.split("\\+")));
					
				    HashMap<String, Integer> BtnPress1 = new HashMap<String, Integer>();
					BtnPress1.put("CASHIER", 1);
					BtnPress1.put("CARPENTER", 1);
					BtnPress1.put("Cargo-Staff", 1);
					
					Thread.sleep(WaitTime.medium); 
					clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='natureofdutyrowIndex'])["+y+"]")),NatureOfdutylist.get(x), "Nature of Duty");
					Thread.sleep(WaitTime.low);
					for(String key: BtnPress1.keySet()){
						if(key.equalsIgnoreCase(NatureOfdutylist.get(x)))
						{
//						wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//input[@id='natureofdutyrowIndex'])["+y+"]"))));
						Thread.sleep(8000);
						driver.findElement(By.xpath("(//span[contains(text(),'"+key+"')])")).click();
					    }
					}	
					
				
				//Risk Class
				//String Riskclass = dataRow.getProperty("RiskClass");
				//String riskclass = Riskclass.replace(" ", "");
				//ArrayList<String> Riskclasslist = new ArrayList<String>(Arrays.asList(Riskclass.split("\\+")));
				 
				Thread.sleep(WaitTime.low);
				//selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Age']//following::select[3])["+y+"]")),Riskclasslist.get(x)," Risk Class ");
				//Thread.sleep(WaitTime.low);
		
			}
		 
		 
		 if(dataRow.getProperty("Product").equalsIgnoreCase("Global Health Secure - As Is (4222)")||dataRow.getProperty("Product").equalsIgnoreCase("Global Health Secure - Revised (5222)"))
			{
			   WebElement PEDWaitPeriod=driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[3])["+y+"]"));
			 
			  String PED = dataRow.getProperty("PEDWaitingPeriod");
			  //String PED1= PED.replace(" ", "");
			  ArrayList<String> PEDlist = new ArrayList<String>(Arrays.asList(PED.split("\\+")));
				
				Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[3])["+y+"]")),PEDlist.get(x)," PED Waiting Period ");
				Thread.sleep(WaitTime.medium);
			}
		 
		//End For Loop
		} 
		
		
		Thread.sleep(WaitTime.high);	
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		click(calpremBTN, "Calculate Premium Button");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)")||dataRow.getProperty("Product").equalsIgnoreCase("Arogya Sanjeevani Policy (4225)")||dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4220)")||dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4227)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4219)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4226)")||dataRow.getProperty("Product").equalsIgnoreCase("Global Health Secure - As Is (4222)")||dataRow.getProperty("Product").equalsIgnoreCase("Global Health Secure - Revised (5222)"))
		{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnSave']")));
		click(saveBTN," SaveButton ");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		click(saveokBTN, "Ok ");
		Thread.sleep(2000);
		
		String QuoteNo = refno2.getText();
		setQuoteNo(QuoteNo);
		ConfigReader.getInstance().StoreValueToConfig("Quote_No", QuoteNo, "Quote No Generated");
		
		Reporter.log("<B> Quotation:- </B> "+refno2.getText());
		Reporter.log("                     ");
		Reporter.log("---------------------");
		
		}
		
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		
		//CO-Pay Wavier
      if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)"))
		{
		String isCoPay = dataRow.getProperty("Co-Pay Waiver");
		String isCoPay1= isCoPay.replace(" ", "");
		ArrayList<String> isCoPaylist= new ArrayList<String>(Arrays.asList(isCoPay1.split("\\+")));
		
		Thread.sleep(WaitTime.medium);
		for (int x = 0;x<isCoPaylist.size();x++)
		{
		if(isCoPaylist.get(x).equalsIgnoreCase("Yes"))
		{
			int y = x+1;
			
			click(driver.findElement(By.xpath("(//input[@name='WMCP'])["+y+"]"))," Hospital Cash Benefit checkBOX");
			Thread.sleep(WaitTime.medium);
			
			click(calpremBTN, "Calculate Premium Button");
			Thread.sleep(WaitTime.medium);
			
			boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
			if (okBTN == true) {
				click(saveokBTN,"OK");
			}
		}
	}	
		
		
		//IF OPD applicable
		String isOPD = dataRow.getProperty("OPDapplicable");
		String isOPD1= isOPD.replace(" ", "");
		ArrayList<String> isOPDlist= new ArrayList<String>(Arrays.asList(isOPD1.split("\\+")));
		
		String OPDval = dataRow.getProperty("OPDsi");
		String OPDval1= OPDval.replace(" ", "");
		ArrayList<String> OPDvallist= new ArrayList<String>(Arrays.asList(OPDval1.split("\\+")));
		
		Thread.sleep(WaitTime.medium);
		for (int x = 0;x<isOPDlist.size();x++)
		{
		if(isOPDlist.get(x).equalsIgnoreCase("Yes"))
		{
			int y = x+1;
			Thread.sleep(WaitTime.medium);
			click(driver.findElement(By.xpath("(//input[@name='OPDE'])["+y+"]")),"OPDE checkBOX");
			
			
			boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
			
			if (okBTN == true) {
				click(saveokBTN,"OK");
			}
			
			Thread.sleep(WaitTime.medium);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='Applicable Sum Insured'])["+y+"]")));	
			selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//select[@id='Applicable Sum Insured'])["+y+"]")), OPDvallist.get(x)," OPD Expenses SumInsured ");
			Thread.sleep(WaitTime.medium);
		
			click(calpremBTN, "Calculate Premium Button");
			Thread.sleep(15000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));	
		}		
		}	
		

		//IF HOSPITAL CSH BENEFIT IS APPLICABLE
		String isHCB = dataRow.getProperty("HospitalCashBenefit");
		String isHCB1= isHCB.replace(" ", "");
		ArrayList<String> isHCBlist= new ArrayList<String>(Arrays.asList(isHCB1.split("\\+")));
		
		String isHCBval = dataRow.getProperty("HCBsi");
		String isHCBval1= isHCBval.replace(" ", "");
		ArrayList<String> isHCBvallist= new ArrayList<String>(Arrays.asList(isHCBval1.split("\\+")));
		
		Thread.sleep(WaitTime.medium);
		for (int x = 0;x<isHCBlist.size();x++)
		{
		if(isHCBlist.get(x).equalsIgnoreCase("Yes"))
		{
			int y = x+1;
			
			click(driver.findElement(By.xpath("(//input[@name='HSCB'])["+y+"]"))," Hospital Cash Benefit checkBOX");
			Thread.sleep(35000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'HSCB - Hospital Cash Benefit')]//following::select[1])["+y+"]")));	
			selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//b[contains(text(),'HSCB - Hospital Cash Benefit')]//following::select[1])["+y+"]")),isHCBvallist.get(x) ," Hospital Cash Benefit  Expenses");
			Thread.sleep(WaitTime.medium);
			
			click(calpremBTN, "Calculate Premium Button");
			Thread.sleep(15000);
			WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));	
		}
		}
	
		
		//ELSE-IF MaternityExpense
		String ismaternity = dataRow.getProperty("MaternityExpense");
		String ismaternity1= ismaternity.replace(" ", "");
		ArrayList<String> ismaternitylist= new ArrayList<String>(Arrays.asList(ismaternity1.split("\\+")));
		
		Thread.sleep(WaitTime.medium);
		for(int x = 0;x<ismaternitylist.size();x++)
		{
		if(ismaternitylist.get(x).equalsIgnoreCase("Yes"))
		{
			int y = x+1;
			Thread.sleep(WaitTime.medium);
			click(driver.findElement(By.xpath("(//input[@name='MTEX'])["+y+"]"))," Maternity Expense checkBOX");
		
			
			click(calpremBTN,"Calculate Premium");
			
			boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
			
			if (okBTN == true) {
				click(saveokBTN,"OK");
			}
		}	
	 }
   }
		
		
		if(dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4220)")||dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4227)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4219)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4226)"))
		{
		
		//ELSE-IF ReductioninPEDWaitingPeriod
				String RIPEDwaiting = dataRow.getProperty("ReductioninPEDWaitingPeriod");
				String RIPEDwaitingPeriod= RIPEDwaiting.replace(" ", "");
				ArrayList<String> RIPEDwaitingPeriodlist= new ArrayList<String>(Arrays.asList(RIPEDwaitingPeriod.split("\\+")));
				
				for(int x = 0;x<RIPEDwaitingPeriodlist.size();x++)
				{
				if(RIPEDwaitingPeriodlist.get(x).equalsIgnoreCase("Yes"))
				{
					int y = x+1;
					click(driver.findElement(By.xpath("(//input[@name='RIPW'])["+y+"]"))," ReductioninPEDWaitingPeriod");
					Thread.sleep(WaitTime.low);
				}
				
			}
				
				
				//ELSE-IF Accidental Hospitalization Booster
				String AHB = dataRow.getProperty("Accidental Hospitalization Booster");
				String AHBT= AHB.replace(" ", "");
				ArrayList<String> AHBTR= new ArrayList<String>(Arrays.asList(AHBT.split("\\+")));
				
				for(int x = 0;x<AHBTR.size();x++)
				{
				if(AHBTR.get(x).equalsIgnoreCase("Yes"))
				{
					int y = x+1;
					click(driver.findElement(By.xpath("(//input[@name='AHB'])["+y+"]"))," Accidental Hospitalization Booster");
					Thread.sleep(WaitTime.low);
				}
				
			  }
				
				
				//ELSE-IF CancerHospitalizationBooster
						String CHB = dataRow.getProperty("CancerHospitalizationBooster");
						String CHBT= CHB.replace(" ", "");
						ArrayList<String> CHBTR= new ArrayList<String>(Arrays.asList(CHBT.split("\\+")));
						
						for(int x = 0;x<CHBTR.size();x++)
						{
						if(CHBTR.get(x).equalsIgnoreCase("Yes"))
						{
							int y = x+1;
							click(driver.findElement(By.xpath("(//input[@name='CHB'])["+y+"]"))," CancerHospitalizationBooster");
							Thread.sleep(WaitTime.low);
						}
						
					  }
						
						
						//ELSE-IF UnlimitedReloadofSumInsured
						String URS = dataRow.getProperty("UnlimitedReloadofSumInsured");
						String URST= URS.replace(" ", "");
						ArrayList<String> URSTR= new ArrayList<String>(Arrays.asList(URST.split("\\+")));
						
						for(int x = 0;x<URSTR.size();x++)
						{
						if(URSTR.get(x).equalsIgnoreCase("Yes"))
						{
							int y = x+1;
							click(driver.findElement(By.xpath("(//input[@name='URSI'])["+y+"]"))," UnlimitedReloadofSumInsured");
							Thread.sleep(WaitTime.low);
						}
						
					  }		
				
						
						//ELSE-IF SuperNCB
						String SuperNCB = dataRow.getProperty("SuperNCB");
						String SuperNCBB= SuperNCB.replace(" ", "");
						ArrayList<String> SuperNCBBT= new ArrayList<String>(Arrays.asList(SuperNCBB.split("\\+")));
						
						for(int x = 0;x<SuperNCBBT.size();x++)
						{
						if(SuperNCBBT.get(x).equalsIgnoreCase("Yes"))
						{
							int y = x+1;
							click(driver.findElement(By.xpath("(//input[@name='SNCB'])["+y+"]"))," SuperNCB");
							Thread.sleep(WaitTime.low);
						}
						
					  }		
						
						
						//ELSE-IF AnyRoomUpgrade
						String ARU = dataRow.getProperty("AnyRoomUpgrade");
						String ARUP= ARU.replace(" ", "");
						ArrayList<String> ARUPD= new ArrayList<String>(Arrays.asList(ARUP.split("\\+")));
						
						for(int x = 0;x<ARUPD.size();x++)
						{
						if(ARUPD.get(x).equalsIgnoreCase("Yes"))
						{
							int y = x+1;
							click(driver.findElement(By.xpath("(//input[@name='ANRU'])["+y+"]"))," AnyRoomUpgrade");
							Thread.sleep(WaitTime.low);
						}
						
					  }		
						
		            
				       click(calpremBTN, "Calculate Premium Button");
				       Thread.sleep(WaitTime.medium);
				       WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
				       click(saveBTN," SaveButton ");
				       Thread.sleep(WaitTime.medium);
				       SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
				       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
				       click(saveokBTN, "Ok ");
				       Thread.sleep(WaitTime.low);
                   }
		
		
		//Active Secure POS & Non POS Covers
		if(dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Secure (6000)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Secure (5000)"))
		 {
			//Accidental Death Cover
			String AC = dataRow.getProperty("AcciDeathCover");
			String ACCD= AC.replace(" ", "");
			ArrayList<String> ACCDlist= new ArrayList<String>(Arrays.asList(ACCD.split("\\+")));
			
			String ACCDval = dataRow.getProperty("ACCDsi");
			String ACCDval1= ACCDval.replace(" ", "");
			ArrayList<String> ACCDvallist= new ArrayList<String>(Arrays.asList(ACCDval1.split("\\+")));


			for (int x = 0;x<ACCDlist.size();x++)
			{
			if(ACCDlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				Thread.sleep(WaitTime.medium);
				click(driver.findElement(By.xpath("(//input[@name='ACCD'])["+y+"]")),"ACCD checkBOX");
				boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
				
				if (okBTN == true) {
					click(saveokBTN,"OK");
				}
				
				Thread.sleep(WaitTime.medium);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'ACCD - Accidental Death Cover (AD)')]//following::select[1])["+y+"]")));	
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//b[contains(text(),'ACCD - Accidental Death Cover (AD)')]//following::select[1])["+y+"]")), ACCDvallist.get(x)," ACCD SumInsured ");
				Thread.sleep(WaitTime.medium);
				/*
				 * click(calpremBTN, "Calculate Premium Button"); Thread.sleep(WaitTime.low);
				 * wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
				 * 
				 * Reporter.log("");
				 * Reporter.log("<B> -------------------------------------------</B>");
				 * Reporter.log("<B>After ACCD calculated</B>");
				 * Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText())
				 * ; Reporter.log("<B> Discount:-  </B>"+Discount.getText());
				 * Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
				 * Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
				 * Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"
				 * +netpremiumafterloading.getText());
				 * Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText(
				 * )); Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"
				 * +premiuminclusiveofTAX.getText());
				 * Reporter.log("<B> -------------------------------------------</B>");
				 */
			}		
		}	
			
			
			//Accidental Medical Expenses
			String AME = dataRow.getProperty("AcciMedicalExp");
			String AME1= AME.replace(" ", "");
			ArrayList<String> AMElist= new ArrayList<String>(Arrays.asList(AME1.split("\\+")));
			
			
			for(int x = 0;x<AMElist.size();x++)
			{
			if(AMElist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='ACME'])["+y+"]"))," AME checkBOX");
				Thread.sleep(WaitTime.medium);
				
				  //click(calpremBTN,"Calculate Premium");
				 // Thread.sleep(WaitTime.low);
					/*
					 * boolean okBTN =
					 * driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
					 * 
					 * if (okBTN == true) { click(saveokBTN,"OK");
					 * 
					 * }
					 */
			}	
		}
			
			
			//EMI Protect
			String EMI = dataRow.getProperty("EMIProtect");
			String EMI1= EMI.replace(" ", "");
			ArrayList<String> EMIlist= new ArrayList<String>(Arrays.asList(EMI1.split("\\+")));
			
			String EMIval = dataRow.getProperty("EMIsi");
			String EMIval1= EMIval.replace(" ", "");
			ArrayList<String> EMIvallist= new ArrayList<String>(Arrays.asList(EMIval1.split("\\+")));
				
			for (int x = 0;x<EMIlist.size();x++)
			{
			if(EMIlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='EMIP'])["+y+"]"))," EMI checkBOX");
				Thread.sleep(WaitTime.low);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'EMIP - EMI Protect')]//following::select[1])["+y+"]")));	
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//b[contains(text(),'EMIP - EMI Protect')]//following::select[1])["+y+"]")),EMIvallist.get(x) ,"EMI Protect");
				Thread.sleep(WaitTime.medium);
				/*
				 * click(calpremBTN, "Calculate Premium Button");
				 * 
				 * WebElement saveBTN1 =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
				 * 
				 * Reporter.log("");
				 * Reporter.log("<B> -------------------------------------------</B>");
				 * Reporter.log("<B>After EMIProtect calculated</B>");
				 * Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText())
				 * ; Reporter.log("<B> Discount:-  </B>"+Discount.getText());
				 * Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
				 * Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
				 * Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"
				 * +netpremiumafterloading.getText());
				 * Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText(
				 * )); Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"
				 * +premiuminclusiveofTAX.getText());
				 * Reporter.log("<B> -------------------------------------------</B>");
				 */
			}
			}
			
			//Loan Protect
			String loan = dataRow.getProperty("LoanProtect");
			String loan1= loan.replace(" ", "");
			ArrayList<String> loanlist= new ArrayList<String>(Arrays.asList(loan1.split("\\+")));
			
			String loanval = dataRow.getProperty("Loansi");
			String loanval1= loanval.replace(" ", "");
			ArrayList<String> loanvallist= new ArrayList<String>(Arrays.asList(loanval1.split("\\+")));
				
			for (int x = 0;x<loanlist.size();x++)
			{
			if(loanlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='LOPC'])["+y+"]"))," Loan checkBOX");
				Thread.sleep(WaitTime.low);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'LOPC - Loan Protect')]//following::select[1])["+y+"]")));	
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//b[contains(text(),'LOPC - Loan Protect')]//following::select[1])["+y+"]")),loanvallist.get(x) ,"Loan Protect");
				Thread.sleep(WaitTime.medium);
				/*
				 * click(calpremBTN, "Calculate Premium Button");
				 * 
				 * WebElement saveBTN1 =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
				 * 
				 * Reporter.log("");
				 * Reporter.log("<B> -------------------------------------------</B>");
				 * Reporter.log("<B>After LoanProtect calculated</B>");
				 * Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText())
				 * ; Reporter.log("<B> Discount:-  </B>"+Discount.getText());
				 * Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
				 * Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
				 * Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"
				 * +netpremiumafterloading.getText());
				 * Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText(
				 * )); Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"
				 * +premiuminclusiveofTAX.getText());
				 * Reporter.log("<B> -------------------------------------------</B>");
				 */
			}
		}	
			
			
			//World-Wide Emergency Assistance
			String WEAS = dataRow.getProperty("WEAS");
			String WEAS1= WEAS.replace(" ", "");
			ArrayList<String> WEASlist= new ArrayList<String>(Arrays.asList(WEAS1.split("\\+")));
			
			for(int x = 0;x<WEASlist.size();x++)
			{
			if(WEASlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='WEAS'])["+y+"]")),"WEAS checkBOX");
				//click(calpremBTN,"Calculate Premium");
				Thread.sleep(WaitTime.medium);
				/*
				 * boolean okBTN =
				 * driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
				 * 
				 * if (okBTN == true) { click(saveokBTN,"OK"); }
				 */
			}	
		}
			
			
			//Critical Illness
			String CI = dataRow.getProperty("Criticalillness");
			String CI1= CI.replace(" ", "");
			ArrayList<String> CIlist= new ArrayList<String>(Arrays.asList(CI1.split("\\+")));
			
			String CIval = dataRow.getProperty("CIsi");
			String CIval1= CIval.replace(" ", "");
			ArrayList<String> CIvallist= new ArrayList<String>(Arrays.asList(CIval1.split("\\+")));
				
			for (int x = 0;x<CIlist.size();x++)
			{
			if(CIlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				Thread.sleep(WaitTime.medium);
				click(driver.findElement(By.xpath("(//input[@name='CIL'])["+y+"]"))," CI checkBOX");
				Thread.sleep(WaitTime.medium);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'CIL - Critical Illness')]//following::select[1])["+y+"]")));	
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//b[contains(text(),'CIL - Critical Illness')]//following::select[1])["+y+"]")),CIvallist.get(x) ,"Critical Illness");
				Thread.sleep(WaitTime.medium);
				
				/*
				 * click(calpremBTN, "Calculate Premium Button"); Thread.sleep(WaitTime.low);
				 * WebElement saveBTN1 =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
				 * 
				 * Reporter.log("");
				 * Reporter.log("<B> -------------------------------------------</B>");
				 * Reporter.log("<B>After CI calculated</B>");
				 * Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText())
				 * ; Reporter.log("<B> Discount:-  </B>"+Discount.getText());
				 * Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
				 * Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
				 * Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"
				 * +netpremiumafterloading.getText());
				 * Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText(
				 * )); Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"
				 * +premiuminclusiveofTAX.getText());
				 * Reporter.log("<B> -------------------------------------------</B>");
				 */
			}
		}		

			
			//Second E Opinion
			String SEO = dataRow.getProperty("SecondEOpinion");
			String SEO1= SEO.replace(" ", "");
			ArrayList<String> SEOlist= new ArrayList<String>(Arrays.asList(SEO1.split("\\+")));
			
			for(int x = 0;x<SEOlist.size();x++)
			{
			if(SEOlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				Thread.sleep(WaitTime.medium);
				click(driver.findElement(By.xpath("(//input[@name='SCOP'])["+y+"]")),"SEO checkBOX");
				//click(calpremBTN,"Calculate Premium");
				Thread.sleep(WaitTime.medium);
				/*
				 * boolean okBTN =
				 * driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
				 * 
				 * if (okBTN == true) { click(saveokBTN,"OK"); }
				 */
			}	
		}
			
			
			//Wellness Coach
			String WIL = dataRow.getProperty("WellnessCoach");
			String WIL1= WIL.replace(" ", "");
			ArrayList<String> WILlist= new ArrayList<String>(Arrays.asList(WIL1.split("\\+")));
			
			for(int x = 0;x<WILlist.size();x++)
			{
			if(WILlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				Thread.sleep(WaitTime.medium);
				click(driver.findElement(By.xpath("(//input[@name='WLI'])["+y+"]")),"WIL checkBOX");
				//click(calpremBTN,"Calculate Premium");
				Thread.sleep(WaitTime.medium);
				/*
				 * boolean okBTN =
				 * driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
				 * 
				 * if (okBTN == true) { click(saveokBTN,"OK"); }
				 */
			}	
		}
			
			
			//Adventure Sports Cover
			String ADS = dataRow.getProperty("AdventureSports");
			String ADS1= ADS.replace(" ", "");
			ArrayList<String> ADSlist= new ArrayList<String>(Arrays.asList(ADS1.split("\\+")));
			
			for(int x = 0;x<ADSlist.size();x++)
			{
			if(ADSlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='ADSB'])["+y+"]")),"ADS checkBOX");
				//click(calpremBTN,"Calculate Premium");
				Thread.sleep(WaitTime.medium);
				/*
				 * boolean okBTN =
				 * driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
				 * 
				 * if (okBTN == true) { click(saveokBTN,"OK"); }
				 */
			}	
		}
			
			
			//Accidental In-patient Hosp Cover
			String AHC = dataRow.getProperty("AcciHospCover");
			String AHC1= AHC.replace(" ", "");
			ArrayList<String> AHClist= new ArrayList<String>(Arrays.asList(AHC1.split("\\+")));
			
			for(int x = 0;x<AHClist.size();x++)
			{
			if(AHClist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='APHC'])["+y+"]")),"AHC checkBOX");
				//click(calpremBTN,"Calculate Premium");
				Thread.sleep(WaitTime.medium);
				/*
				 * boolean okBTN =
				 * driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
				 * 
				 * if (okBTN == true) { click(saveokBTN,"OK"); }
				 */
			}	
		}
			
			
			//Broken Bones Benefit
			String BBB = dataRow.getProperty("BroknBoneBenefit");
			String BBB1= BBB.replace(" ", "");
			ArrayList<String> BBBlist= new ArrayList<String>(Arrays.asList(BBB1.split("\\+")));
			
			String BBBval = dataRow.getProperty("BBBFsi");
			String BBBval1= BBBval.replace(" ", "");
			ArrayList<String> BBBvallist= new ArrayList<String>(Arrays.asList(BBBval1.split("\\+")));
				
			for (int x = 0;x<BBBlist.size();x++)
			{
			if(BBBlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='BBBF'])["+y+"]"))," BBBF checkBOX");
				Thread.sleep(WaitTime.medium);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'BBBF - Broken Bones Benefit')]//following::select[1])["+y+"]")));	
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//b[contains(text(),'BBBF - Broken Bones Benefit')]//following::select[1])["+y+"]")),BBBvallist.get(x) ,"Broken Bone Benefit");
				Thread.sleep(WaitTime.medium);
				/*
				 * click(calpremBTN, "Calculate Premium Button");
				 * 
				 * WebElement saveBTN1 =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
				 * 
				 * Reporter.log("");
				 * Reporter.log("<B> -------------------------------------------</B>");
				 * Reporter.log("<B>After BBB calculated</B>");
				 * Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText())
				 * ; Reporter.log("<B> Discount:-  </B>"+Discount.getText());
				 * Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
				 * Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
				 * Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"
				 * +netpremiumafterloading.getText());
				 * Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText(
				 * )); Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"
				 * +premiuminclusiveofTAX.getText());
				 * Reporter.log("<B> -------------------------------------------</B>");
				 */
			}
		}	
			
			
			//Burn Benefit
			String BNBE = dataRow.getProperty("BurnBenefit");
			String BNBE1= BNBE.replace(" ", "");
			ArrayList<String> BNBElist= new ArrayList<String>(Arrays.asList(BNBE1.split("\\+")));
			
			String BNBEval = dataRow.getProperty("BNBEsi");
			String BNBEval1= BNBEval.replace(" ", "");
			ArrayList<String> BNBEvallist= new ArrayList<String>(Arrays.asList(BNBEval1.split("\\+")));
				
			for (int x = 0;x<BNBElist.size();x++)
			{
			if(BNBElist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='BNBE'])["+y+"]"))," BNBE checkBOX");
				Thread.sleep(WaitTime.medium);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'BNBE - Burn Benefit')]//following::select[1])["+y+"]")));	
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//b[contains(text(),'BNBE - Burn Benefit')]//following::select[1])["+y+"]")),BNBEvallist.get(x) ,"Burn Benefit");
				Thread.sleep(WaitTime.medium);
				/*
				 * click(calpremBTN, "Calculate Premium Button");
				 * 
				 * WebElement saveBTN1 =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
				 * 
				 * Reporter.log("");
				 * Reporter.log("<B> -------------------------------------------</B>");
				 * Reporter.log("<B>After BNBE calculated</B>");
				 * Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText())
				 * ; Reporter.log("<B> Discount:-  </B>"+Discount.getText());
				 * Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
				 * Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
				 * Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"
				 * +netpremiumafterloading.getText());
				 * Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText(
				 * )); Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"
				 * +premiuminclusiveofTAX.getText());
				 * Reporter.log("<B> -------------------------------------------</B>");
				 */
			}
		}
			
			
			//Coma Benefit
			String CB = dataRow.getProperty("ComaBenefit");
			String CB1= CB.replace(" ", "");
			ArrayList<String> CBlist= new ArrayList<String>(Arrays.asList(CB1.split("\\+")));
			
			for(int x = 0;x<CBlist.size();x++)
			{
			if(CBlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='COBE'])["+y+"]")),"CB checkBOX");
				//click(calpremBTN,"Calculate Premium");
				Thread.sleep(WaitTime.medium);
				/*
				 * boolean okBTN =
				 * driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
				 * 
				 * if (okBTN == true) { click(saveokBTN,"OK"); }
				 */
			}	
		}
			
			
			//Temporary Total Disablement
			String TTD = dataRow.getProperty("TempTDB");
			String TTD1= TTD.replace(" ", "");
			ArrayList<String> TTDlist= new ArrayList<String>(Arrays.asList(TTD1.split("\\+")));
			
			for(int x = 0;x<TTDlist.size();x++)
			{
			if(TTDlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='TTDB'])["+y+"]")),"TTD checkBOX");
				click(calpremBTN,"Calculate Premium");
				Thread.sleep(WaitTime.low);
				boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
				
				if (okBTN == true) {
					click(saveokBTN,"OK");
				}
			}	
		}
			
			
			//Cancer Cover
			String CC = dataRow.getProperty("CancerCover");
			String CC1= CC.replace(" ", "");
			ArrayList<String> CClist= new ArrayList<String>(Arrays.asList(CC1.split("\\+")));
			
			String CCval = dataRow.getProperty("CANCsi");
			String CCval1= CCval.replace(" ", "");
			ArrayList<String> CCvallist= new ArrayList<String>(Arrays.asList(CCval1.split("\\+")));
				
			for (int x = 0;x<CClist.size();x++)
			{
			if(CClist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='CANC'])["+y+"]"))," CANC checkBOX");
				Thread.sleep(WaitTime.medium);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'CANC - Cancer Cover')]//following::select[1])["+y+"]")));	
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//b[contains(text(),'CANC - Cancer Cover')]//following::select[1])["+y+"]")),CCvallist.get(x) ,"Cancer Cover");
				Thread.sleep(WaitTime.medium);
				/*
				 * click(calpremBTN, "Calculate Premium Button");
				 * 
				 * WebElement saveBTN1 =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
				 * 
				 * Reporter.log("");
				 * Reporter.log("<B> -------------------------------------------</B>");
				 * Reporter.log("<B>After CANC calculated</B>");
				 * Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText())
				 * ; Reporter.log("<B> Discount:-  </B>"+Discount.getText());
				 * Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
				 * Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
				 * Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"
				 * +netpremiumafterloading.getText());
				 * Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText(
				 * )); Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"
				 * +premiuminclusiveofTAX.getText());
				 * Reporter.log("<B> -------------------------------------------</B>");
				 */
			}
		}
			
			
			//Scan Second E Opinion
			String Scan = dataRow.getProperty("SCANOpinion");
			String Scan1= Scan.replace(" ", "");
			ArrayList<String> Scanlist= new ArrayList<String>(Arrays.asList(Scan1.split("\\+")));
			
			for(int x = 0;x<Scanlist.size();x++)
			{
			if(Scanlist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='SCAN'])["+y+"]")),"SCAN CheckBOX");
				//click(calpremBTN,"Calculate Premium");
				Thread.sleep(WaitTime.medium);
				/*
				 * boolean okBTN =
				 * driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
				 * 
				 * if (okBTN == true) { click(saveokBTN,"OK"); }
				 */
			}	
		}
			
			
			//Daily Cash Benefit
			String DC = dataRow.getProperty("DailyCashBenef");
			String DC1= DC.replace(" ", "");
			ArrayList<String> DClist= new ArrayList<String>(Arrays.asList(DC1.split("\\+")));
			
			String DCval = dataRow.getProperty("DCBCsi");
			String DCval1= DCval.replace(" ", "");
			ArrayList<String> DCvallist= new ArrayList<String>(Arrays.asList(DCval1.split("\\+")));
				
			for (int x = 0;x<DClist.size();x++)
			{
			if(DClist.get(x).equalsIgnoreCase("Yes"))
			{
				int y = x+1;
				click(driver.findElement(By.xpath("(//input[@name='DCBC'])["+y+"]"))," DCB checkBOX");
				Thread.sleep(WaitTime.medium);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'DCBC - Daily cash Benefit (DCB)')]//following::select[1])["+y+"]")));	
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//b[contains(text(),'DCBC - Daily cash Benefit (DCB)')]//following::select[1])["+y+"]")),DCvallist.get(x) ,"Daily Cash Benefit");
				Thread.sleep(WaitTime.medium);
				/*
				 * click(calpremBTN, "Calculate Premium Button");
				 * 
				 * WebElement saveBTN1 =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
				 * 
				 * Reporter.log("");
				 * Reporter.log("<B> -------------------------------------------</B>");
				 * Reporter.log("<B>After DCB calculated</B>");
				 * Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText())
				 * ; Reporter.log("<B> Discount:-  </B>"+Discount.getText());
				 * Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
				 * Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
				 * Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"
				 * +netpremiumafterloading.getText());
				 * Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText(
				 * )); Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"
				 * +premiuminclusiveofTAX.getText());
				 * Reporter.log("<B> -------------------------------------------</B>");
				 */
			}
		}
		
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		click(calpremBTN, "Calculate Premium Button");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnSave']")));
		click(saveBTN," SaveButton ");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		click(saveokBTN, "Ok ");
		Thread.sleep(2000);
		
		String QuoteNo = refno2.getText();
		setQuoteNo(QuoteNo);
		ConfigReader.getInstance().StoreValueToConfig("Quote_No", QuoteNo, "Quote No Generated");
		
		Reporter.log("<B> Quotation:- </B> "+refno2.getText());
		Reporter.log("                     ");
		Reporter.log("---------------------");
		
		System.out.println("Complete");
		
		//Covers End
		 }
		
	    switchtodefaultframe(driver);
	}
	
		public void fillQuote(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
		{
			fillAddQuote(driver, testCaseName, workbook, conn, stepGroup, customAssert);
	}
}