package pages;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class OtherUserLogin extends GenericMethods {

	
	@FindBy(xpath="//input[@id='pUserName']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='textfield2']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='textfield4']")
	private WebElement role;
	
	@FindBy(xpath="//strong[contains(text(),'LOGIN')]")
	private WebElement loginBTN;
	
	@FindBy(xpath="//i[@id='roleIcon']")
	private WebElement roleCLICK;
	
	@FindBy(xpath="(//p[contains(text(),'Policy Management')])[1]")
	private WebElement PolicyManagement;
	
	@FindBy(xpath="//input[@id='Policy No.']")
	private WebElement QuoteNoSearch;
	
	@FindBy(xpath="//button[@id='Search']")
	private WebElement SearchButton;
	
	@FindBy(xpath="//label[@id='Serial No']")
	private WebElement memberCode;

	@FindBy(xpath="//input[@id='Mobile Number']")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@id='Height (Feet)']")
	private WebElement heightfeet;
	
	@FindBy(xpath="//input[@id='Height of the Insured (in cms)']")
	private WebElement heightCm;
	
	@FindBy(xpath="//input[@id='Weight (in kgs)']")
	private WebElement weightinKG;
	
	@FindBy(xpath="//input[@id='BMI']")
	private WebElement bmi;
	
	@FindBy(xpath="//select[@id='Nationality']")
	private WebElement nationality;
	
	@FindBy(xpath="//input[@id='countryof residence']")
	private WebElement countryofResidence;
	
	@FindBy(xpath = "//input[@id='occupation']")
	private WebElement occupation;
	
	@FindBy(xpath="//select[@id='Applicable Sum Insured']")
	private WebElement sumInsured;
	
	@FindBy(xpath="//select[@id='Room Category']")
	private WebElement roomCategory;
	
	@FindBy(xpath="//select[@id='Is Chronic Disease ?']")
	private WebElement Ischronic;
	
	@FindBy(xpath="//select[@id='HNI Customer']")
	private WebElement hniCustomer;
	
	@FindBy(xpath="//select[@id='CEO Club Advisor Customer']")
	private WebElement CEOClubAdvisorCustomer;
	
	@FindBy(xpath="//select[@id='Priority Customer']")
	private WebElement priorityCustomer;
	
	@FindBy(xpath="//select[@id='Sensitive Customer']")
	private WebElement sensitiveCustomerr;
	
	@FindBy(xpath="//input[@id='Policy-holder ZIP Code']")
	private WebElement Pincode;
	
	@FindBy(xpath="//input[@id='Policy-holder City']")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='District Name']")
	private WebElement districtName;
	
	@FindBy(xpath="//input[@id='Policy-holder Province']")
	private WebElement state;
	
	@FindBy(xpath="//select[@id='Zone']")
	private WebElement zone;
	
	
	@FindBy(xpath="//select[@id='Opted zone']")
	private WebElement Optedzone;
	
	@FindBy(xpath="(//a[@name='Policy Summary'])[2]")
	private WebElement policysummary;
	
	@FindBy(xpath="//button[@id='Submit']")
	private WebElement subbtn;
	
	@FindBy(xpath="//button[@id='moreInfo']")
	private WebElement subbtn3;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	private WebElement Continue;
	
	@FindBy(xpath="//button[@id='SaveButton']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement Okbutton;
	
	@FindBy(xpath="//button[@id='DataEntry1Completed']")
	private WebElement DataEntry1;
	
	@FindBy(xpath="//button[@title='Accept QC']")
	private WebElement AcceptQC;
	
	//Confirm
	@FindBy(xpath = "//button[@id='confirm1']")
	private WebElement Confirm;
	
	@FindBy(xpath="//button[@id='issuePolicyBtn']")
	private WebElement issuepolicy;
	
	//Member icon
	@FindBy(xpath="//a[@title='Member Info']/i")
	private WebElement membericon;
	
	
	//Policy Number
	@FindBy(xpath="//label[@id='Number']")
	private WebElement policynumber;
	
	
	//Close
	@FindBy(xpath="//button[@id='CloseButton']")
	private WebElement closebutton;
	
	//Calculate Premium button
	   @FindBy(xpath="//button[@id='CalPrmBtn']")
	   private WebElement CalPrmBtn;
	
	
	//Requirements icon
			@FindBy(xpath="//a[@name='Requirements']/i")
			private WebElement requirementsIcon;
			
			
		//Show Requirement on Requirements page
		   @FindBy(xpath="(//img[@title='Show Requirement'])[1]")
		   private WebElement showrequirement1;
		
		   
		   //Selection Dropdown 1
		   @FindBy(xpath="//div[contains(text(),'ID Proof')]//following::select[1]")
		   private WebElement Optional1;
		   
		   
		   //Selection Dropdown 2
		   @FindBy(xpath="//div[contains(text(),'Address Proof')]//following::select[1]")
		   private WebElement Optional2;
		   
		   
		   //Selection Dropdown 3
		   @FindBy(xpath="//div[contains(text(),'Passport')]//following::select[1]")
		   private WebElement Optional3;  
		   
		   
		   //Selection Dropdown 4
		   @FindBy(xpath="//div[contains(text(),'Declaration for Staying in India')]//following::select[1]")
		   private WebElement Optional4;  
		   
		   
		   //Selection Dropdown 5
		   @FindBy(xpath="//div[contains(text(),'Health Declaration Form')]//following::select[1]")
		   private WebElement Optional5;  
		   
		  //Save
		   @FindBy(xpath="//button[@id='SaveRequire']")
		   private WebElement saverequire; 
		   
		   
		 //Ok Button Click
		   @FindBy(xpath="//button[@class='btn btn-default']")
		   private WebElement OK; 
		   
		   @FindBy(xpath = "//select[@id='Sensitive Customer']")
		private WebElement sensitiveCustomer;
	
	
	//Follow Up
		@FindBy(xpath="(//a[@name='Follow-up'])[2]")
		private WebElement FollowUp;
		
		@FindBy(xpath="//button[@id='btncontinue']")
		private WebElement continuebtn;
	
		
		@FindBy(xpath="//label[@id='Sub-Status']")
		private WebElement DataEntryCompleted;
	
		
	
		
		
	//QU2020421200063700000
	
	 WebDriverWait wait;
		public OtherUserLogin(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			wait=new WebDriverWait(driver, 30);	
		}
		
	public void fillAndSubmitNewTCSLogin(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		Reporter.log("<B>Login To Application</B>");
		
		//BOPS to COPS
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
		
		Thread.sleep(WaitTime.medium);
		switchtodefaultframe(driver);
		switchtoframe(driver,"display");
		Thread.sleep(WaitTime.low);
		click(membericon,"Member Icon");
		Thread.sleep(WaitTime.medium);
		switchtoframe(driver,"containerFrame");
		Thread.sleep(WaitTime.medium);
        click(memberCode, "Member Code");
        Thread.sleep(WaitTime.medium);
        switchtoframe(driver,"memberiframe0");
        
      if(dataRow.getProperty("PolicyHolderIsMember").equalsIgnoreCase("No"))
      {
        Thread.sleep(WaitTime.medium);
		clearAndSenKeys(mobileNumber, dataRow.getProperty("Mobile Number"), "Mobile No");
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(nationality,dataRow.getProperty("Nationality"), "Nationality");
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(sensitiveCustomer, dataRow.getProperty("SensitiveCustomer"), "sensitive Customerr");
		Thread.sleep(WaitTime.medium);
		
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(priorityCustomer, dataRow.getProperty("PriorityCustomer"), "Priority Customer");
		Thread.sleep(WaitTime.medium);
	}
        
        Thread.sleep(WaitTime.medium);
		clearAndSenKeys(heightCm,dataRow.getProperty("HeightCm"),"Height in Cm");
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(WaitTime.low);
		clearAndSenKeys(weightinKG,dataRow.getProperty("WeightInKG"),"Weight In KG");
		Thread.sleep(WaitTime.low);
		weightinKG.sendKeys(Keys.TAB);
		
		Thread.sleep(WaitTime.low);
		HashMap<String, Integer> BtnPress1 = new HashMap<String, Integer>();
		BtnPress1.put("Self Employed", 1);
		Thread.sleep(WaitTime.medium); 
		clearAndSenKeys(occupation,dataRow.getProperty("Occupation"), "Occupation");
		Thread.sleep(WaitTime.medium);
		for(String key: BtnPress1.keySet()){
			if(key.equalsIgnoreCase(dataRow.getProperty("Occupation")))
			{
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='occupation']"))));
			Thread.sleep(WaitTime.veryHigh);
			driver.findElement(By.xpath("//span[contains(text(),'"+key+"')]")).click();
		    }
		}
		
		
		//Click on Chronic
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
				
		if(dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)"))
		{		
		Thread.sleep(WaitTime.medium);
	    selectFromDropdownByVisibleText(Optedzone,dataRow.getProperty("Zone"),"Zone");
		Thread.sleep(WaitTime.medium);
		}
	
		
		//Save & Ok
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		click(SaveButton,"Save");
		Thread.sleep(WaitTime.medium);
		click(Okbutton,"Ok Button");
		Thread.sleep(WaitTime.medium);
		
		//Policy Summary
		switchtodefaultframe(driver);
		switchtoframe(driver,"display");
		Thread.sleep(WaitTime.medium);
		click(policysummary, "Policy Summary");
		switchtoframe(driver,"containerFrame");
		Thread.sleep(WaitTime.medium);
		
		Thread.sleep(WaitTime.high);
		click(CalPrmBtn,"Calculate Premium button");
		Thread.sleep(WaitTime.high);
		
		//Policy Summary
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		click(DataEntry1,"DataEntry 1 Completed");
		Thread.sleep(WaitTime.medium);
		
		//Data Entry1 Completed for all scrutiny cases
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_UP);
		String dataentry=DataEntryCompleted.getText();
		Reporter.log("----------");
		Reporter.log("For all Scrutiny cases "+dataentry);
		Reporter.log("---------");
		
		Thread.sleep(WaitTime.medium);
		click(CalPrmBtn,"Calculate Premium button");
		Thread.sleep(WaitTime.veryHigh);
		
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		click(AcceptQC,"Accept QC");
		Thread.sleep(WaitTime.veryHigh);
		
		//Confirm
		click(Confirm,"Confirm Button");
		Thread.sleep(WaitTime.veryHigh);
		
		//Printing Policy Number
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_UP);
		String policyno=policynumber.getText();
		Reporter.log("----------");
		Reporter.log("Policy Number for this case is "+policyno);
		Reporter.log("---------");
		
		//Policy Summary
		click(Continue,"Continue");
		Thread.sleep(WaitTime.medium);
		
		//Payment Cycle
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		click(Continue,"Continue");
		Thread.sleep(WaitTime.medium);
		
		
		//Follow Up
			switchtodefaultframe(driver);
			switchtoframe(driver,"display");
			Thread.sleep(WaitTime.medium);
			click(FollowUp,"Follow Up");
			Thread.sleep(WaitTime.medium);
			switchtoframe(driver,"containerFrame");
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		
		
	}

	public void fillOtherUserLogin(WebDriver driver, String testCaseName, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		fillAndSubmitNewTCSLogin(driver, testCaseName, workbook, conn, stepGroup, customAssert);
		
	}	
}