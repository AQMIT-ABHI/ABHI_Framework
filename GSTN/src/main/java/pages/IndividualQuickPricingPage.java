package pages;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.remote.server.handler.MaximizeWindow;
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
import util.WaitTime;



//ANMOL 11-06-2020


public class IndividualQuickPricingPage extends GenericMethods {
	
	
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
	
	@FindBy(xpath="(//input[@id='Member Name']//preceding::select[1])[1]")
	private WebElement SI;
	
	@FindBy(xpath="(//input[@id='Member Name'])[1]")
	private WebElement membername;
	
	@FindBy(xpath="(//input[@id='Member Name']//following::select[1])[1]")
	private WebElement zone;
	
	@FindBy(xpath="(//input[@id='Member Name']//following::select[3])[1]")
	private WebElement deductible;
	
	@FindBy(xpath="(//input[@id='Date of Birth'])[1]")
	private WebElement dob;
	
	@FindBy(xpath="(//input[@id='Date of Birth']//following::select[1])[1]")
	private WebElement gender;
	
	@FindBy(xpath="(//input[@id='Date of Birth']//following::select[2])[1]")
	private WebElement relation;
	
	@FindBy(xpath="(//input[@id='Date of Birth']//following::select[3])[1]")
	private WebElement room;
	
	
	@FindBy(xpath="//input[@id='Age']")
	private WebElement AgeValue;
	
	
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
	
	
	//Co-Pay Waiver
	@FindBy(xpath="//input[@name='WMCP']")
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
	
	//Affiliated Employee Discount
	@FindBy(xpath="//select[@id='Affiliate employee discount']")
	private WebElement affiliatedEMPdiscount;
	
	@FindBy(xpath="(//span[contains(text(),'PPN Discount')]//following::select)[8]")
	private WebElement PPNDiscount;
	
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
	
	
    WebDriverWait wait;
	public IndividualQuickPricingPage(WebDriver driver) {
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
		
		Thread.sleep(WaitTime.high);
		policytenure.sendKeys(Keys.END);
		Thread.sleep(WaitTime.low);
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
		
		Thread.sleep(WaitTime.low);
		
		if(dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4220)")||dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4227)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4219)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4226)"))
		{
		selectFromDropdownByVisibleText(affiliatedEMPdiscount, dataRow.getProperty("AffiliatedEMPDiscount"),"Affiliated Employee Discount");
		Thread.sleep(WaitTime.low);
		}
		
		Thread.sleep(WaitTime.low);
		clearAndSenKeys(pincode,dataRow.getProperty("PinCode"),  "PinCode ");
		
		Thread.sleep(WaitTime.low);
		clearAndSenKeys(membernumbers,dataRow.getProperty("NoOfMembers"),  "No Of Members ");
		
		Thread.sleep(WaitTime.medium);
		membernumbers.sendKeys(Keys.TAB);
		
		Thread.sleep(WaitTime.medium);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		
		//Member Details
		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(SI, dataRow.getProperty("SumInsured"),"Sum Insured");
		Thread.sleep(WaitTime.medium);
		
		
		clearAndSenKeys(membername, getRandomString(),"Member Name");
		Thread.sleep(WaitTime.low);
		
		if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)")||dataRow.getProperty("Product").equalsIgnoreCase("Arogya Sanjeevani Policy (4225)"))
		{
		selectFromDropdownByVisibleText(zone, dataRow.getProperty("Zone"),"Zone ");
		Thread.sleep(WaitTime.low);
		
		selectFromDropdownByVisibleText(deductible, dataRow.getProperty("Deductible")," Dedcutible ");
		Thread.sleep(WaitTime.low);
		}
		
	
		//Age & DOB //Date Calculation
		 DateFormat dfor = new SimpleDateFormat("dd/MM/yyyy");
		 Date obj = new Date();
		 String acurrdate=dfor.format(obj);
		 
		 
		if (dataRow.getProperty("Age").equalsIgnoreCase("<1"))
		{
			Thread.sleep(WaitTime.low);
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
			 Thread.sleep(WaitTime.low);
        	 clearAndSenKeys(AgeValue,dataRow.getProperty("Age"),"Age");
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
		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(gender, dataRow.getProperty("Gender")," Gender ");

		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(relation, dataRow.getProperty("Relationship")," Relationship ");
		Thread.sleep(WaitTime.medium);
		
		if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)")||dataRow.getProperty("Product").equalsIgnoreCase("Arogya Sanjeevani Policy (4225)"))
		{
		selectFromDropdownByVisibleText(room, dataRow.getProperty("RoomCategory")," Room Category ");
		Thread.sleep(WaitTime.medium);
		}
		
		//PPN Discount
		if(dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4227)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4226)"))
		{
			Thread.sleep(WaitTime.medium);
			selectFromDropdownByVisibleText(PPNDiscount, dataRow.getProperty("PPN Discount"), "PPN Discount");
		}
	
		
		//click on Chronic
		if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)"))
		{
		if (dataRow.getProperty("IsChronic").equalsIgnoreCase("Yes"))
		{
		String Chronic = dataRow.getProperty("Chronic");
		ArrayList Chroniclist= new ArrayList(Arrays.asList(Chronic.split(",")));
		for(int i =0;i<Chroniclist.size();i++)
		{
		WebElement Chronicclick = driver.findElement(By.xpath("(//option[contains(text(),'"+Chroniclist.get(i)+"')])[1]"));

		clickWithoutJavaScript(Chronicclick, " Chronic ");
		Reporter.log(" as "+Chroniclist.get(i));
		  }
	  }
  }
		
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		click(calpremBTN, "Calculate Premium Button");
		Thread.sleep(WaitTime.low);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnSave']")));
		Reporter.log("");
		Reporter.log("<B> -------------------------------------------</B>");
		Reporter.log("<B>  OPD not applied </B>");
		Reporter.log("<B> NetPremiumBefore Value:-  </B>"+ netpremiumbefore.getText());
		Reporter.log("<B> Discount:-  </B>"+Discount.getText());
		Reporter.log("<B> NetPremiumAfter Value:-  </B>"+netpremiumafter.getText());
		Reporter.log("<B> Loading Value:-  </B>"+loading.getText());
		Reporter.log("<B> NetPremiumAfter Loading Value:-  </B>"+netpremiumafterloading.getText());
		Reporter.log("<B> Tax Amount Element Value:-  </B>"+taxamountElement.getText());
		Reporter.log("<B> Premium Inclusive of Tax Value Value:-  </B>"+premiuminclusiveofTAX.getText());
		Reporter.log("<B> -------------------------------------------</B>");
		
		
		click(saveBTN," SaveButton ");
		Thread.sleep(WaitTime.medium);
		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'OK')]")));
		click(saveokBTN, "Ok ");
		Thread.sleep(WaitTime.low);
		
		String QuoteNo = refno2.getText();
		setQuoteNo(QuoteNo);
		
		Reporter.log("<B> Quotation:- </B> "+refno2.getText());
		Reporter.log("                     ");
		Reporter.log("---------------------");
		
		
		//Assert Quote Details
		if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)")||dataRow.getProperty("Product").equalsIgnoreCase("Arogya Sanjeevani Policy (4225)"))
		{
		 String netpremiumbeforeval = netpremiumbefore.getText().toString().replace("₹ ", "").replace(",", "");
		 Assert.assertEquals("Expected value",netpremiumbeforeval, dataRow.getProperty("NetPremiumBeforeDiscouunt(BeforeOPD)").replace(",",""));
		 
		}
		
		if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)"))
		{
		//ELSE-IF Waiver of Mandatory Co-payment 
		if(dataRow.getProperty("Co-Pay Waiver").equalsIgnoreCase("Yes"))
		{
			click(wmpcpCheckbox," Hospital Cash Benefit checkBOX");
			click(calpremBTN, "Calculate Premium Button");
			Thread.sleep(WaitTime.low);
			WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
			
			//click on OK Quote button
			boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
			if (okBTN == true) {
				click(saveokBTN,"OK");
			}
			
		}
		

		
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
		

		
		//ELSE-IF Maternity Expenses
	
		if(dataRow.getProperty("MaternityExpense").equalsIgnoreCase("Yes"))
		{
			
			click(mtexCheckbox," Maternity Expense checkBOX");
			//click on OK Quote button
			boolean okBTN = driver.findElements(By.xpath("//button[contains(text(),'OK')]")).size() !=0;
			if (okBTN == true) {
				click(saveokBTN,"OK");
			}
			
			
			click(calpremBTN, "Calculate Premium Button");
			Thread.sleep(WaitTime.medium);
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
		
    }
		
		
		//Accidental Hospitalization Booster
		if(dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4220)")||dataRow.getProperty("Product").equalsIgnoreCase("POS Activ Assure (4227)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4219)")||dataRow.getProperty("Product").equalsIgnoreCase("Activ Assure (4226)"))	
		{
			if(dataRow.getProperty("Accidental Hospitalization Booster").equalsIgnoreCase("Yes"))
			{
				
				click(AHBchkbox," Accidental Hospitalization Booster");
				Thread.sleep(WaitTime.medium);
				Thread.sleep(5000);
				
				}
				
					
			//IF AnyRoomUpgrade 
			Thread.sleep(WaitTime.medium);
			if(dataRow.getProperty("AnyRoomUpgrade").equalsIgnoreCase("Yes"))
			{
				
				click(ANRUchkbox,"AnyRoomUpgrade checkBOX");
				Thread.sleep(5000);
//				WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));
					
			}		
			
			//IF Cancer Hospitalization Booster
			Thread.sleep(WaitTime.medium);
			if(dataRow.getProperty("CancerHospitalizationBooster").equalsIgnoreCase("Yes"))
			{
				
				click(CHBchkbox,"CancerHospitalizationBooster checkBOX");
				Thread.sleep(5000);
//				WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));	
					
			}		
			
			//IF Reduction in PED Waiting Period
			Thread.sleep(WaitTime.medium);
			if(dataRow.getProperty("ReductioninPEDWaitingPeriod").equalsIgnoreCase("Yes"))
			{
				
				click(RIPWchkbox,"ReductioninPEDWaitingPeriod checkBOX");
				Thread.sleep(5000);
//				WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));	
					
			}	
			
			//IF Super NCB
			Thread.sleep(WaitTime.medium);
			if(dataRow.getProperty("SuperNCB").equalsIgnoreCase("Yes"))
			{
				
				click(SNCBchkbox,"SuperNCB checkBOX");
				Thread.sleep(5000);
//				WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));	
			}	
			
			
			//IF Unlimited Reload of Sum Insured
			Thread.sleep(WaitTime.medium);
			if(dataRow.getProperty("UnlimitedReloadofSumInsured").equalsIgnoreCase("Yes"))
			{
				
				click(URSIchkbox,"UnlimitedReloadofSumInsured checkBOX");
				Thread.sleep(5000);
//				WebElement saveBTN1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave")));	

			}
			
			
			click(calpremBTN, "Calculate Premium Button");
			Thread.sleep(WaitTime.medium);
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
			Assert.assertEquals("Expected value",netpremiumbeforeval, dataRow.getProperty("NetPremiumBeforeDiscouunt(BeforeOPD)").replace(",",""));
			
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
		//Assert.assertEquals(netpremiumafterloadingval, dataRow.getProperty("NetPremiumAfterDiscount(AfterOPD)").replace(",", ""));
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

