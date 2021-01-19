package pages;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
import testRunner.TestEngine;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.SetUpWebdriver;
import util.WaitTime;

public class NSTPindividualFlow extends GenericMethods{
	
	@FindBy(xpath="//i[@id='roleIcon']")
	private WebElement roleCLICK;
	
	@FindBy(xpath="(//p[contains(text(),'Policy Management')])[1]")
	private WebElement PolicyManagement;
	
	@FindBy(xpath="//input[@id='Policy No.']")
	private WebElement QuoteNoSearch;
	
	@FindBy(xpath="//button[@id='Search']")
	private WebElement SearchButton;
	
	@FindBy(xpath="//label[@ng-model='clmGridData.strParameterValue']")
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
	
	@FindBy(xpath="//button[@id='sendQCBtn']")
	private WebElement SubmitButton;
	
	
	@FindBy(xpath="//button[@id='issuePolicyBtn']")
	private WebElement issuepolicy;
	
	//Member icon
	@FindBy(xpath="//a[@title='Member Info']/i")
	private WebElement membericon;
	
	@FindBy(xpath="//select[@id='Manual Underwriting Required?']")
	private WebElement ManualUnderwriting;
	
	
	//Policy Number
	@FindBy(xpath="//label[@id='Number']")
	private WebElement policynumber;
	
	//Questionnaire tab
	@FindBy(xpath="//md-tab-item[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple']//span[@class='ng-scope'][contains(text(),'Questionnaire')]")
	private WebElement Questionnairetab;
	
	//Questions
	@FindBy(xpath="//md-tab-content[@id='tab-content-0']//tr[18]//td[2]/following::input[1]")
	private WebElement PolioQuest;
	
	@FindBy(xpath="//md-tab-content[@id='tab-content-0']//tr[18]//td[2]/following::textarea[1]")
	private WebElement PolioTextBox;
	
	@FindBy(xpath="//td[contains(text(),'Is any of the persons proposed to be insured under')]/following::input[1]")
	private WebElement OtherthanvitaminpillsQuest;
	
	@FindBy(xpath="//td[contains(text(),'Is any of the persons proposed to be insured under')]/following::textarea[1]")
	private WebElement OtherthanvitaminpillsTextbox;
	
	@FindBy(xpath="//md-tab-content[@id='tab-content-0']//tr[20]//td[2]/following::input[1]")
	private WebElement BloodtestsQuest;
	
	@FindBy(xpath="//md-tab-content[@id='tab-content-0']//tr[20]//td[2]/following::textarea[1]")
	private WebElement BloodtestsTextbox;
	
	@FindBy(xpath="//md-tab-content[@id='tab-content-0']//tr[21]//td[2]/following::input[1]")
	private WebElement SurgeryQuest;
	
	@FindBy(xpath="//md-tab-content[@id='tab-content-0']//tr[21]//td[2]/following::textarea[1]")
	private WebElement SurgeryTextbox;
	
	@FindBy(xpath="//td[contains(text(),'Has any of the persons proposed to be insured Suff')]/following::input[1]")
	private WebElement viralfeverQuest;
	
	@FindBy(xpath="//td[contains(text(),'Has any of the persons proposed to be insured Suff')]/following::textarea[1]")
	private WebElement viralfeverTextbox;
	
	@FindBy(xpath="//td[contains(text(),'Any of the insured persons is pregnant? If yes, pl')]/following::input[1]")
	private WebElement dateofdeliveryQuest;
	
	@FindBy(xpath="//td[contains(text(),'Any of the insured persons is pregnant? If yes, pl')]/following::textarea[1]")
	private WebElement dateofdeliveryTextbox;
	
	@FindBy(xpath="//td[contains(text(),'Whether there is diabetes, hypertension or any oth')]/following::input[1]")
	private WebElement earlierpregnancyQuest;
	
	@FindBy(xpath="//td[contains(text(),'Whether there is diabetes, hypertension or any oth')]/following::textarea[1]")
	private WebElement earlierpregnancyTextbox;
	
	@FindBy(xpath="//label[@id='Sub-Status']")
	private WebElement ReferToUWRStatus;
	
	 //Requirements icon
		@FindBy(xpath="//a[@name='Requirements']/i")
		private WebElement requirementsIcon;
		
		
	//Show Requirement on Requirements page
	   @FindBy(xpath="(//img[@title='Show Requirement'])[1]")
	   private WebElement showrequirement1;
	
	   
	
	   //Selection Dropdown 1
	   @FindBy(xpath="//div[contains(text(),'ID Proof')]//following::select[2]")
	   private WebElement Optional1;
	   
	   
	   //Selection Dropdown 2
	   @FindBy(xpath="//div[contains(text(),'AddressProof')]//following::select[2]")
	   private WebElement Optional2;
	   
	   
	   //Selection Dropdown 3
	   @FindBy(xpath="//div[contains(text(),'Passport')]//following::select[2]")
	   private WebElement Optional3;   
	   
	   
	   //Selection Dropdown 4
	   @FindBy(xpath="//div[contains(text(),'Declaration for Staying in India')]//following::select[2]")
	   private WebElement Optional4;  
	   
	   
	   //Selection Dropdown 5
	   @FindBy(xpath="//div[contains(text(),'Health Declaration Form')]//following::select[2]")
	   private WebElement Optional5;  
	   
	  //Save
	   @FindBy(xpath="//button[@id='SaveRequire']")
	   private WebElement saverequire; 
	   
	   
	 //Ok Button Click
	   @FindBy(xpath="//button[@class='btn btn-default']")
	   private WebElement OK; 
	   
	// Policy Number
		@FindBy(xpath = "//label[contains(text(),'Quote/Policy Number')]//following::label[1]")
		private WebElement QuoteNumber;
	   
		//Calculate Premium button
		   @FindBy(xpath="//button[@id='CalPrmBtn']")
		   private WebElement CalPrmBtn;
	
	WebDriverWait wait;
	public NSTPindividualFlow(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
		}
	
	
	
	public void fillNSTPinfo(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
        Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
	   Reporter.log("<B>Traverse To CommonPage</B>");
	   
	   
	   
	 //BOPS to COPS
		switchtodefaultframe(driver);
		switchtoframe(driver, "head");
		
		click(roleCLICK,"Role Click");	
		
		click(driver.findElement(By.xpath("//div[contains(text(),'COPS')]")),"Selected Role as COPS");
		
		Thread.sleep(1000);
		
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
		switchtoframe(driver,"display");
		Thread.sleep(WaitTime.low);
		click(membericon,"Member Icon");
		Thread.sleep(WaitTime.medium);
		switchtoframe(driver,"containerFrame");
		Thread.sleep(WaitTime.low);
	    click(memberCode, "Member Code");
	    switchtoframe(driver,"memberiframe0");
	  
		/*
		 * Thread.sleep(WaitTime.medium);
		 * clearAndSenKeys(heightfeet,dataRow.getProperty("HeightFeet"),"Height Feet");
		 * Thread.sleep(WaitTime.low);
		 */
		
	    Thread.sleep(WaitTime.medium);
		clearAndSenKeys(heightCm,dataRow.getProperty("HeightCm"),"Height in Cm");
		Thread.sleep(WaitTime.low);
		
		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(weightinKG,dataRow.getProperty("WeightInKG"),"Weight In KG");
		Thread.sleep(WaitTime.low);
		weightinKG.sendKeys(Keys.TAB);
		
		HashMap<String, Integer> BtnPress1 = new HashMap<String, Integer>();
		BtnPress1.put("Self Employed", 1);
		Thread.sleep(WaitTime.medium); 
		clearAndSenKeys(occupation,dataRow.getProperty("Occupation"), "Occupation");
		Thread.sleep(WaitTime.low);
		for(String key: BtnPress1.keySet()){
			if(key.equalsIgnoreCase(dataRow.getProperty("Occupation")))
			{
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='occupation']"))));
				Thread.sleep(WaitTime.veryHigh);
				driver.findElement(By.xpath("//span[contains(text(),'"+key+"')]")).click();
		    }
		}
		
//		Thread.sleep(WaitTime.medium);
//		selectFromDropdownByVisibleText(ManualUnderwriting,dataRow.getProperty("Manual_UWR"),"Manual Underwriting");
//		Thread.sleep(WaitTime.low);
		
		
		Thread.sleep(WaitTime.high);
	   selectFromDropdownByVisibleText(Optedzone,dataRow.getProperty("Zone"),"Zone");
		Thread.sleep(WaitTime.low);
		
		
		
		//Questionnaires
		if(dataRow.getProperty("QuestionnaireConfig").equalsIgnoreCase("Yes"))
		{
		Thread.sleep(WaitTime.medium);
	   click(Questionnairetab, "Questionnaire tab");
	   Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
	   click(PolioQuest, "Polio Question RadioButton");
	   Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
		clearAndSenKeys(PolioTextBox,dataRow.getProperty("PolioTextBox"),"Polio TextBox");
		Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
	   click(OtherthanvitaminpillsQuest, "Otherthanvitaminpills Question RadioButton");
	   Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
		clearAndSenKeys(OtherthanvitaminpillsTextbox,dataRow.getProperty("OtherthanvitaminpillsTextbox"),"Other than vitamin pills Textbox");
		Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
	   click(BloodtestsQuest, "Bloodtests Question RadioButton");
	   Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
		clearAndSenKeys(BloodtestsTextbox,dataRow.getProperty("BloodtestsTextbox"),"Bloodtests Textbox");
		Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
	   click(SurgeryQuest, "Surgery Question RadioButton");
	   Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
		clearAndSenKeys(SurgeryTextbox,dataRow.getProperty("SurgeryTextbox"),"Surgery Textbox");
		Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
	   click(viralfeverQuest, "viralfever Question RadioButton");
	   Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
		clearAndSenKeys(viralfeverTextbox,dataRow.getProperty("viralfeverTextbox"),"viralfever Textbox");
		Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
	   click(dateofdeliveryQuest, "dateofdelivery Question RadioButton");
	   Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
		clearAndSenKeys(dateofdeliveryTextbox,dataRow.getProperty("dateofdeliveryTextbox"),"date of delivery Textbox");
		Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
	   click(earlierpregnancyQuest, "earlierpregnancy Question RadioButton");
	   Thread.sleep(WaitTime.low);
	   
	   Thread.sleep(WaitTime.medium);
		clearAndSenKeys(earlierpregnancyTextbox,dataRow.getProperty("earlierpregnancyTextbox"),"earlier pregnancy Textbox");
		Thread.sleep(WaitTime.low);
		}
		click(SaveButton,"Save");
		Thread.sleep(WaitTime.medium);
		click(Okbutton,"Ok Button");
		Thread.sleep(WaitTime.medium);
		
		
		
		  
		   //COPS Requirement Page
			/*
			 * switchtodefaultframe(driver); switchtoframe(driver, "display");
			 * Thread.sleep(3000); click(requirementsIcon,"Click Requirement Icon");
			 * Thread.sleep(WaitTime.low); switchtoframe(driver, "containerFrame");
			 * Thread.sleep(WaitTime.low);
			 */
	       
	       
		   //Show Requirement on Requirements page
			/*
			 * Thread.sleep(3000); click(showrequirement1,"Click on Show Requirement");
			 * Thread.sleep(WaitTime.low);
			 * 
			 * 
			 * 
			 * //Select Optional From the dropdown 1 Thread.sleep(WaitTime.low);
			 * selectFromDropdownByVisibleText(Optional1,dataRow.
			 * getProperty("Optional Status"),"Selection Optional");
			 * Thread.sleep(WaitTime.medium);
			 * 
			 * 
			 * //Select Optional From the dropdown 2 Thread.sleep(WaitTime.low);
			 * selectFromDropdownByVisibleText(Optional2,dataRow.
			 * getProperty("Optional Status"),"Selection Optional");
			 * Thread.sleep(WaitTime.medium);
			 * 
			 * 
			 * //Select Optional From the dropdown 3 Thread.sleep(WaitTime.low);
			 * selectFromDropdownByVisibleText(Optional3,dataRow.
			 * getProperty("Optional Status"),"Selection Optional");
			 * Thread.sleep(WaitTime.medium);
			 * 
			 * 
			 * //Select Optional From the dropdown 4 Thread.sleep(WaitTime.low);
			 * selectFromDropdownByVisibleText(Optional4,dataRow.
			 * getProperty("Optional Status"),"Selection Optional");
			 * Thread.sleep(WaitTime.medium);
			 * 
			 * 
			 * //Select Optional From the dropdown 5 Thread.sleep(WaitTime.low);
			 * selectFromDropdownByVisibleText(Optional5,dataRow.
			 * getProperty("Optional Status"),"Selection Optional");
			 * Thread.sleep(WaitTime.medium);
			 * 
			 * 
			 * //Save Thread.sleep(3000); click(saverequire,"Save"); Thread.sleep(2000);
			 * 
			 * 
			 * //Ok Button Thread.sleep(3000);
			 * click(OK,"Modification Successfully Completed"); Thread.sleep(2000);
			 * 
			 */
	        //Policy Summary
	        switchtodefaultframe(driver);
	    	switchtoframe(driver,"display");
	    	Thread.sleep(WaitTime.medium);
	    	click(policysummary, "Policy Summary");
	    	switchtoframe(driver,"containerFrame");
	    	Thread.sleep(WaitTime.low);
    	

      		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
      		Thread.sleep(WaitTime.low);
      		click(DataEntry1,"DataEntry 1 Complteted");
      		Thread.sleep(WaitTime.low);
      		
      		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
      		
      		Thread.sleep(WaitTime.medium);
    		click(CalPrmBtn,"Calculate Premium button");
    		Thread.sleep(WaitTime.veryHigh);
      		
      		Thread.sleep(WaitTime.high);
      		click(SubmitButton,"Accept QC");
      		Thread.sleep(WaitTime.high);
      		
      		SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
      		//fetch Refer to UWR
      		
      		String SubStatusUWR=ReferToUWRStatus.getText();
      		String quoteno=QuoteNumber.getText();
      		Reporter.log("----------");
      		Reporter.log("Quote No. "+quoteno);
      		Reporter.log("Status changed to "+SubStatusUWR);
      		Reporter.log("---------");
      		
}
	
     public void NSTPIndiviDetails(WebDriver driver, String testCaseName, XSSFWorkbook workbook, Connection conn, String stepGroup, CustomAssert customAssert) throws Exception {
	
    	 fillNSTPinfo(driver, testCaseName, workbook, conn, stepGroup, customAssert);
	
}
	
}
