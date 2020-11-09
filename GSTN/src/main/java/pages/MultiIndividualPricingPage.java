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

public class MultiIndividualPricingPage extends GenericMethods {
	
	
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
	
	
	@FindBy(xpath="")
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
	
	//Affiliated Employee Discount
	@FindBy(xpath="//select[@id='Affiliate employee discount']")
	private WebElement affiliatedEMPdiscount;
	
	
    WebDriverWait wait;
	public MultiIndividualPricingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 40);	
	}

	public void fillAddQuote(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{	
		
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
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
		

		switchtoframe(driver, "display");  
		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(policytenure, dataRow.getProperty("Policy Tenure"),"Policy Tenure");
		Thread.sleep(WaitTime.low);
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
		
		if(dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4220)")||dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4227)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4219)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4226)"))
		{
		selectFromDropdownByVisibleText(affiliatedEMPdiscount, dataRow.getProperty("AffiliatedEMPDiscount"),"Affiliated Employee Discount");
		Thread.sleep(WaitTime.low);
		}

		clearAndSenKeys(pincode,dataRow.getProperty("PinCode"),  "PinCode ");
		Thread.sleep(WaitTime.low);
		
		clearAndSenKeys(membernumbers,dataRow.getProperty("NoOfMembers"),  "No Of Members ");
		Thread.sleep(WaitTime.low);
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
		
		String SIval = dataRow.getProperty("SumInsured");
		String SI1val = SIval.replace(" ", "");
		ArrayList<String> SumInsuredList = new ArrayList<String>(Arrays.asList(SI1val.split("\\+")));
		
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
			WebElement deduct = driver.findElement(By.xpath("(//input[@id='Member Name']//following::select[3])["+y+"]"));
			WebElement room = driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[3])["+y+"]"));
			
			    Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Member Name']//preceding::select[1])["+y+"]")),SumInsuredList.get(x)," SumInsured ");
				Thread.sleep(WaitTime.medium);
				
				clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Member Name'])["+y+"]")), getRandomString(), "Member ");
				Thread.sleep(WaitTime.low);
				
				if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)")||dataRow.getProperty("Product").equalsIgnoreCase("Arogya Sanjeevani Policy (4225)"))
				{
					//Zone
					String zoneval = dataRow.getProperty("Zone");
					//String zoneval1 = zoneval.replace(" ", "");
					ArrayList<String> zonelist = new ArrayList<String>(Arrays.asList(zoneval.split("\\+")));
					Thread.sleep(WaitTime.low);
					
				selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//input[@id='Member Name']//following::select[1])["+y+"]")),zonelist.get(x)," Zone ");
				Thread.sleep(WaitTime.low);
				
				//Deductible
				String deductval = dataRow.getProperty("Deductible");
				String deductval1= deductval.replace(" ", "");
				ArrayList<String> deductlist = new ArrayList<String>(Arrays.asList(deductval1.split("\\+")));
				
				Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Member Name']//following::select[3])["+y+"]")),deductlist.get(x)," Deductible ");
				Thread.sleep(WaitTime.low);
				}
			
				
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
				         Thread.sleep(WaitTime.low);
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
				         Thread.sleep(WaitTime.low);
				         clearAndSenKeys(driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")),actualdate,"Date of Birth");
				         driver.findElement(By.xpath("(//input[@id='Date of Birth'])["+y+"]")).sendKeys(Keys.TAB);
				         driver.findElement(By.xpath("(//input[@id='Age'])["+y+"]")).sendKeys(Keys.TAB);
				         
					}
				
				
				 Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[1])["+y+"]")),genderlist.get(x)," Gender ");
				//Relationship
				
				Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleTextStale(driver.findElement(By.xpath("(//input[@id='Date of Birth']//following::select[2])["+y+"]")),Relationlist.get(x)," Relationship ");
				 Thread.sleep(WaitTime.low);
				 
				//Room Category
				if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)")||dataRow.getProperty("Product").equalsIgnoreCase("Arogya Sanjeevani Policy (4225)"))
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
		}
			
		if(dataRow.getProperty("TestCase").equalsIgnoreCase("QuoteCreation"))
		{
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		}
		
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		click(calpremBTN, "Calculate Premium Button");
		Thread.sleep(WaitTime.low);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnSave']")));
		Thread.sleep(WaitTime.low);
		click(saveBTN," SaveButton ");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
		if(dataRow.getProperty("TestCase").equalsIgnoreCase("QuoteCreation"))
		{
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		}
		
		Thread.sleep(WaitTime.low);
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		click(saveokBTN, "Ok ");
		Thread.sleep(WaitTime.low);
		
		//Get Quote Number
		String QuoteNo = refno2.getText();
		Thread.sleep(WaitTime.low);
		setQuoteNo(QuoteNo);
		ConfigReader.getInstance().StoreValueToConfig("Quote_No", QuoteNo, "Quote No Generated");
		Thread.sleep(WaitTime.low);
		
		Reporter.log("<B> Quotation:- </B> "+refno2.getText());
		Reporter.log("                     ");
		Reporter.log("---------------------");
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		if(dataRow.getProperty("TestCase").equalsIgnoreCase("Calculation"))
		{
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
		}
		
		
		//Assert Quote Details
		if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)")||dataRow.getProperty("Product").equalsIgnoreCase("Arogya Sanjeevani Policy (4225)"))
		{
	  String netpremiumbeforeval = netpremiumbefore.getText().toString().replace("₹ ", "").replace(",", "");
     Assert.assertEquals("Expected value",netpremiumbeforeval, dataRow.getProperty("NetPremiumBeforeDiscouunt(BeforeOPD)").replace(",", ""));
		}
		
		//CO-Pay Wavier
		if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)"))
		{
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
			Thread.sleep(WaitTime.low);
			
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
		
		
		for (int x = 0;x<isOPDlist.size();x++)
		{
		if(isOPDlist.get(x).equalsIgnoreCase("Yes"))
		{
			int y = x+1;
			click(driver.findElement(By.xpath("(//input[@name='OPDE'])["+y+"]")),"OPDE checkBOX");
			boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
			
			if (okBTN == true) {
				click(saveokBTN,"OK");
			}
			
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='Applicable Sum Insured'])["+y+"]")));	
			selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//select[@name='Applicable Sum Insured'])["+y+"]")), OPDvallist.get(x)," OPD Expenses SumInsured ");
			
			click(calpremBTN, "Calculate Premium Button");
			Thread.sleep(WaitTime.low);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));	
			
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
		}	
		
		
		
		//IF HOSPITAL CSH BENEFIT IS APPLICABLE
		String isHCB = dataRow.getProperty("HospitalCashBenefit");
		String isHCB1= isHCB.replace(" ", "");
		ArrayList<String> isHCBlist= new ArrayList<String>(Arrays.asList(isHCB1.split("\\+")));
		
		String isHCBval = dataRow.getProperty("HCBsi");
		String isHCBval1= isHCBval.replace(" ", "");
		ArrayList<String> isHCBvallist= new ArrayList<String>(Arrays.asList(isHCBval1.split("\\+")));
		
		
		for (int x = 0;x<isHCBlist.size();x++)
		{
		if(isHCBlist.get(x).equalsIgnoreCase("Yes"))
		{
			int y = x+1;
			click(driver.findElement(By.xpath("(//input[@name='HSCB'])["+y+"]"))," Hospital Cash Benefit checkBOX");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'HSCB - Hospital Cash Benefit')]//following::select[1])["+y+"]")));	
			selectFromDropdownByVisibleText(driver.findElement(By.xpath("(//b[contains(text(),'HSCB - Hospital Cash Benefit')]//following::select[1])["+y+"]")),isHCBvallist.get(x) ," Hospital Cash Benefit  Expenses");
			
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
		}
		
		
		
		//ELSE-IF MaternityExpense
		String ismaternity = dataRow.getProperty("MaternityExpense");
		String ismaternity1= ismaternity.replace(" ", "");
		ArrayList<String> ismaternitylist= new ArrayList<String>(Arrays.asList(ismaternity1.split("\\+")));
		
		
		for(int x = 0;x<ismaternitylist.size();x++)
		{
		if(ismaternitylist.get(x).equalsIgnoreCase("Yes"))
		{
			int y = x+1;
			click(driver.findElement(By.xpath("(//input[@name='MTEX'])["+y+"]"))," Maternity Expense checkBOX");
			
			click(calpremBTN,"");
			Thread.sleep(WaitTime.low);
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
			
				Thread.sleep(3000);
				click(calpremBTN, "Calculate Premium Button");
				Thread.sleep(2000);
				WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
				
				Reporter.log("");
				Reporter.log("<B> -------------------------------------------</B>");
				Reporter.log("<B>After all covers</B>");
				Reporter.log("<B> NetPremiumBefore Value:-  </B>"+netpremiumbefore.getText());
				Reporter.log("<B> Discount:-  </B>"+Discount.getText());
				Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
				Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
				Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"+netpremiumafterloading.getText());
				Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText());
				Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"+premiuminclusiveofTAX.getText());
				Reporter.log("<B> -------------------------------------------</B>");
				
				 String netpremiumbeforeval = netpremiumbefore.getText().toString().replace("₹ ", "").replace(",", "");
			     Assert.assertEquals("Expected value",netpremiumbeforeval, dataRow.getProperty("NetPremiumBeforeDiscouunt(BeforeOPD)").replace(",", ""));
		}
		
		String premiumbeforeOPD = netpremiumafter.getText().toString().replace("₹ ","").replace(",", ""); 
		Assert.assertEquals(premiumbeforeOPD,dataRow.getProperty("NetPremiumAfterDiscount(BeforeOPD)").replace(",", ""));
		
		//switchtodefaultframe(driver);
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
		Assert.assertEquals(netpremiumbeforeval, dataRow.getProperty("NetPremiumBeforeDiscouunt(BeforeOPD)").replace(",", ""));
		Assert.assertEquals(netpremiumafterval, dataRow.getProperty("NetPremiumAfterDiscount(BeforeOPD)").replace(",", ""));
	//	Assert.assertEquals(netpremiumafterloadingval, dataRow.getProperty("NetPremiumAfterDiscount(AfterOPD)").replace(",", ""));
		Assert.assertEquals(taxamountElementval, dataRow.getProperty("GST").replace(",", ""));
		Assert.assertEquals(premiuminclusiveofTAXval, dataRow.getProperty("Total Premium").replace(",", ""));
		
		
		System.out.println("-------------Execution Complete-----------");
		switchtodefaultframe(driver);
		
		
	}
	
		public void fillQuote(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
		{
			fillAddQuote(driver, testCaseName, workbook, conn, stepGroup, customAssert);
			AssertQuote(driver, testCaseName, workbook, conn, stepGroup, customAssert);
			
			
		}
}
