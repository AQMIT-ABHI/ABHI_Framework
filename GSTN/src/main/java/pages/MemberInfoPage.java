package pages;

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

public class  MemberInfoPage extends GenericMethods {

	@FindBy(xpath="//label[@ng-model='clmGridData.strParameterValue']")
	private WebElement memberCode;

	@FindBy(xpath="//input[@id='Mobile Number']")
	private WebElement mobileNumber;

	@FindBy(xpath="//input[@id='Height (Feet)']")
	private WebElement heightfeet;

	@FindBy(xpath="//input[@id='Weight (in kgs)']")
	private WebElement weightinKG;

	@FindBy(xpath="//input[@id='BMI']")
	private WebElement bmi;

	@FindBy(xpath="//select[@id='Nationality']")
	private WebElement nationality;

	@FindBy(xpath="//input[@id='countryof residence']")
	private WebElement countryofResidence;

	@FindBy(xpath="//select[@id='Occupation']")
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

	@FindBy(xpath="//td[contains(text(),'Proposer Details Capture')]/following-sibling::td/select[1]")
	private WebElement ProposerDetailsCapture;

	@FindBy(xpath="//td[contains(text(),'Product Details Capture')]/following-sibling::td/select[1]")
	private WebElement ProducDetailsCapture;

	@FindBy(xpath="//td[contains(text(),'Plan Details Capture')]/following-sibling::td/select[1]")
	private WebElement PlanDetailsCapture;

	@FindBy(xpath="//td[contains(text(),'Member Details Capture')]/following-sibling::td/select[1]")
	private WebElement MemberDetailsCapture;

	@FindBy(xpath="//td[contains(text(),'Previous Insurance Details Capture')]/following-sibling::td/select[1]")
	private WebElement PreviousInsuranceDetailsCapture;

	@FindBy(xpath="//td[contains(text(),'Health Details Capture')]/following-sibling::td/select[1]")
	private WebElement HealthDetailsCapture;

	@FindBy(xpath="//td[contains(text(),'Chronic Disease Completed')]/following-sibling::td/select[1]")
	private WebElement ChronicDiseaseCompleted;

	@FindBy(xpath="//td[contains(text(),'Nominee Details')]/following-sibling::td/select[1]")
	private WebElement NomineeDetails;

	@FindBy(xpath="//td[contains(text(),'Customer Signature')]/following-sibling::td/select[1]")
	private WebElement CustomerSignature;


	@FindBy(xpath="//button[contains(text(),'Save')]")
	private WebElement savebtn;

	//Credit account code
	@FindBy(xpath = "//input[@id='CrAccountCodeLookup']")
	private WebElement creditaccount;
	
	//Credit account search
	@FindBy(xpath="//a[@id='accsearch']//span[contains(text(),'Search')]")
	private WebElement creditsearch;
	
	//Credit account name
	@FindBy(xpath="(//a[@name='firstFocus'])[7]")
	private WebElement creditname;

	
	//Follow Up
	@FindBy(xpath="(//a[@name='Follow-up'])[2]")
	private WebElement FollowUp;

	@FindBy(xpath="//button[@id='btncontinue']")
	private WebElement continuebtn;

	//Member code Continue
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	private WebElement continue1;


	//Inward Completed Status
	@FindBy(xpath="//label[@id='Sub-Status']")
	private WebElement InwardCompleted;

	// Narration
	@FindBy(xpath = "//input[@name='Narration']")
	private WebElement narration;

	// Save Button
	@FindBy(xpath = "//span[@id='SaveSpan']")
	private WebElement saveBTN;

	// Post Button
	@FindBy(xpath = "//span[contains(text(),'Post')]")
	private WebElement postBTN;

	// To be collected
	@FindBy(xpath = "//input[@id='ptbCollected']")
	private WebElement tobeCollected;

	// Instrument amount
	@FindBy(xpath = "//input[@name='pInstrumentAmt']")
	private WebElement instrumentamount;

	// Source of Collection
	@FindBy(xpath = "//select[@id='pSourceOfCollection']")
	private WebElement sourceofCollection;

	// Source of Collection
		@FindBy(xpath = "//select[@id='pApprover']")
		private WebElement Systemsourcedropdown;
		
		//Reason for Backdate
		@FindBy(xpath = "//select[@id='ReasonforBackdate']")
		private WebElement Reasonforbackdate;	
		
		
		//	Deposit Bank Type
		@FindBy(xpath = "//select[@id='DepositBankType']")
		private WebElement 	depositbanktype;
		
		//Online/Offline Indicator
			@FindBy(xpath = "//select[@name='Online/OfflineIndicator ']")
			private WebElement 	OnlineOfflineIndicator;
		
			// Get Total
			@FindBy(xpath = "//div[@id='btn']//span[contains(text(),'Get Total')]")
			private WebElement gettotal;
		
	// Collection Mode
	@FindBy(xpath = "//select[@id='CollectionMode']")
	private WebElement mode;

	// Txn amount
	@FindBy(xpath = "//input[@id='CollectionAmount']")
	private WebElement taxamount;

	//Create Collection btn
	@FindBy(xpath = "//button[@id='createColBtn']")
	private WebElement createcollectionbtn;

	//Generate Collection Receipt
	@FindBy(xpath = "//a[@id='BtnPrintSpan']")
	private WebElement GenerateCollectionReceipt;
	
	WebDriverWait wait;
	public MemberInfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
	}


	public void fillmemberinfo(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{	

		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		Reporter.log("<B>Traverse To CommonPage</B>");



		//        Thread.sleep(WaitTime.medium);
		//        click(memberCode, "Member Code");
		//		switchtoframe(driver,"memberiframe0");

		////		Thread.sleep(WaitTime.medium);
		////	    clearAndSenKeys(mobileNumber,"9890122325","Mobile No");
		////		Thread.sleep(WaitTime.low);

		//		Thread.sleep(WaitTime.medium);
		//		clearAndSenKeys(heightfeet,dataRow.getProperty("HeightFeet"),"Height Feet");
		//		Thread.sleep(WaitTime.low);
		//		
		//		Thread.sleep(WaitTime.medium);
		//		clearAndSenKeys(weightinKG,dataRow.getProperty("WeightInKG"),"Weight In KG");
		//		Thread.sleep(WaitTime.low);
		//		
		//		Thread.sleep(WaitTime.medium);
		//		clearAndSenKeys(bmi,dataRow.getProperty("BMI"),"bmi");
		//		Thread.sleep(WaitTime.low);

		//		Thread.sleep(WaitTime.medium);
		//		selectFromDropdownByVisibleText(nationality,dataRow.getProperty("Nationality"),"Nationality");
		//		Thread.sleep(WaitTime.low);
		//		
		//		Thread.sleep(WaitTime.medium);
		//		clearAndSenKeys(countryofResidence,dataRow.getProperty("countryofResidence"),"Country of Residence");
		//		countryofResidence.sendKeys(Keys.TAB);
		//		Thread.sleep(WaitTime.low);

		//		Thread.sleep(WaitTime.medium);
		//		selectFromDropdownByVisibleText(occupation,dataRow.getProperty("Occupation"),"Occupation");
		//		Thread.sleep(WaitTime.low);
		//		
		//		Thread.sleep(WaitTime.medium);
		//		selectFromDropdownByVisibleText(sumInsured,"200000","Sum Insured");
		//		Thread.sleep(WaitTime.low);

		//		Thread.sleep(WaitTime.medium);
		//		selectFromDropdownByVisibleText(roomCategory,"Single Private","Room Category");
		//		Thread.sleep(WaitTime.low);

		//		Thread.sleep(WaitTime.medium);
		//		clearAndSenKeys(countryofResidence,"India","Country of Residence");
		//		Thread.sleep(WaitTime.low);

		//		Thread.sleep(WaitTime.medium);
		//		selectFromDropdownByVisibleText(Ischronic,dataRow.getProperty("IsChronic"),"Is Chronic");
		//		Thread.sleep(WaitTime.low);

		//		Thread.sleep(WaitTime.medium);
		//		selectFromDropdownByVisibleText(hniCustomer,"No","hni Customer");
		//		Thread.sleep(WaitTime.low);
		//		
		//		Thread.sleep(WaitTime.medium);
		//		selectFromDropdownByVisibleText(CEOClubAdvisorCustomer,"No","CEO Club Advisor Customerr");
		//		Thread.sleep(WaitTime.low);
		//		
		//		Thread.sleep(WaitTime.medium);
		//		selectFromDropdownByVisibleText(priorityCustomer,"No","Priority Customer");
		//		Thread.sleep(WaitTime.low);
		//		
		//		Thread.sleep(WaitTime.medium);
		//		selectFromDropdownByVisibleText(sensitiveCustomerr,"No","sensitive Customerr");
		//		Thread.sleep(WaitTime.low);
		//		
		//		Thread.sleep(WaitTime.medium);
		//		clearAndSenKeys(Pincode,dataRow.getProperty("Pincode"),"pincode");
		//		Pincode.sendKeys(Keys.TAB);
		//	    Thread.sleep(WaitTime.low);

		////		Thread.sleep(WaitTime.medium);
		////		clearAndSenKeys(city,"MUMBAI","City");
		////	    Thread.sleep(WaitTime.low);
		////	
		////	    Thread.sleep(WaitTime.medium);
		////		clearAndSenKeys(districtName,"MUMBAI","District Name");
		////		Thread.sleep(WaitTime.low);
		////	
		////		Thread.sleep(WaitTime.medium);
		////		clearAndSenKeys(state,"MAHARASHTRA","State");
		////		Thread.sleep(WaitTime.low);

		//	    Thread.sleep(WaitTime.medium);
		//	    selectFromDropdownByVisibleText(Optedzone,dataRow.getProperty("Zone"),"Zone");
		//		Thread.sleep(WaitTime.low);

		//Member Info
		Thread.sleep(WaitTime.high);
		click(continue1,"Continue");
		Thread.sleep(WaitTime.high);



		// click on policy summary
		//		switchtodefaultframe(driver);
		//		switchtoframe(driver,"display");
		//		Thread.sleep(WaitTime.medium);
		//		click(policysummary, "Policy Summary");
		//		switchtoframe(driver,"containerFrame");
		//		Thread.sleep(WaitTime.low);

		//policy summary
		//submit 1
		//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		//		click(subbtn, "Submit btn");
		//		Thread.sleep(WaitTime.high);

		//submit 2
		//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);		
			//	click(subbtn, "Submit btn");
		//		Thread.sleep(WaitTime.low);


		//submit 3
		//Thread.sleep(WaitTime.high);
		String parentWindow = driver.getWindowHandle();
		//		Thread.sleep(WaitTime.high);
		//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		//		click(subbtn3, "Submit btn");
		//		Thread.sleep(WaitTime.high);

		
	// Create  Collection Button On Policy summary
		Thread.sleep(WaitTime.medium);
		click(createcollectionbtn, "Create collection btn");
		Thread.sleep(WaitTime.high);
		switchToWindow(driver);
		Thread.sleep(WaitTime.high);

		// To be Collected & Instrument amount
		click(gettotal, "Get Total");
    	Thread.sleep(WaitTime.medium);

		String Collectamount = tobeCollected.getAttribute("value");
		Thread.sleep(WaitTime.medium);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_UP);
		instrumentamount.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(instrumentamount,Collectamount,"Amount");

		// Source of Collection
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(sourceofCollection, dataRow.getProperty("Source of Collection"),"Source of Collection");
		Thread.sleep(WaitTime.medium);

		//System Source
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(Systemsourcedropdown, dataRow.getProperty("System Source"),"System source");
		Thread.sleep(WaitTime.medium);

		
		// Collection Mode
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(mode, dataRow.getProperty("Mode"), "Collection Mode");
		Thread.sleep(WaitTime.high);

		// Txn Amount
		Thread.sleep(WaitTime.low);
		clearAndSenKeys(taxamount, Collectamount, "Txn Amount");
		Thread.sleep(WaitTime.medium);

		//Reason for Backdate
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(Reasonforbackdate, dataRow.getProperty("ReasonforBackdate"),"Reason for Backdate");
		Thread.sleep(WaitTime.medium);
				
		//Deposit Bank Type
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(depositbanktype, dataRow.getProperty("DepositBankType"),"Deposit Bank Type");
		Thread.sleep(WaitTime.medium);
				
		//Online/Offline Indicator
		Thread.sleep(WaitTime.medium);
		selectFromDropdownByVisibleText(OnlineOfflineIndicator, dataRow.getProperty("Online/OfflineIndicator"),"Online/Offline Indicator");
		Thread.sleep(WaitTime.medium);
						
		
		// Sub Code
		// Sub Code Search
	//	String parentWindo = driver.getWindowHandle();
		//wait.until(ExpectedConditions.elementToBeClickable(subcode));
		//Thread.sleep(WaitTime.medium);
		//click(subcodesearch, " search ");
		//Thread.sleep(WaitTime.medium);
		//switchToWindow(driver);
		//Thread.sleep(WaitTime.medium);
		//click(subcodevalue, "SubCode Value");
		//Thread.sleep(WaitTime.medium);
		//driver.switchTo().window(parentWindo);
		//switchtodefaultframe(driver);
		//Thread.sleep(WaitTime.medium);
		//switchtoframe(driver, "display");
		//Thread.sleep(WaitTime.medium);
		//switchtoframe(driver, "containerFrame");
		
		
		//Credit account code search
		/*
		 * String childwindow=driver.getWindowHandle();
		 * click(creditaccount,"Credit Account Code"); Thread.sleep(WaitTime.medium);
		 * switchToWindow(driver); click(creditsearch,"Credit account search");
		 * Thread.sleep(WaitTime.medium); click(creditname,"Credit account name");
		 * driver.switchTo().window(childwindow); Thread.sleep(WaitTime.medium);
		 */

		// Narration
		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(narration, dataRow.getProperty("Narration"), "Narration");
		Thread.sleep(WaitTime.medium);

		// Save button
		driver.findElement(By.xpath("//input[@id='Narration']")).sendKeys(Keys.PAGE_DOWN);
		click(saveBTN, "Save Button");
		Thread.sleep(WaitTime.medium);

		// Post Button
		Thread.sleep(WaitTime.medium);
		driver.findElement(By.xpath("//input[@name='Narration']")).sendKeys(Keys.PAGE_DOWN);
		click(postBTN, "Post Button");
		Thread.sleep(WaitTime.medium);
		
		// Generate Collection Receipt
		Thread.sleep(WaitTime.medium);
		String childwindow1=driver.getWindowHandle();
		click(GenerateCollectionReceipt, "Generate Collection Receipt");
		Thread.sleep(WaitTime.low);
		driver.switchTo().alert().accept();
		Thread.sleep(WaitTime.low);
		switchToWindow(driver);
		driver.close();
		driver.switchTo().window(childwindow1);
		System.out.println("Generate Collection Receipt Successfully");
		Thread.sleep(WaitTime.low);
		
		driver.close();
		Thread.sleep(WaitTime.low);
		driver.switchTo().window(parentWindow);
 		switchtodefaultframe(driver);
 		switchtoframe(driver, "display"); 
 		switchtoframe(driver, "containerFrame");
		
       // Submit Button  On Policy Summary
		Thread.sleep(WaitTime.medium);
		click(subbtn3, "Submit btn");
		Thread.sleep(3000);
		
	// ProposerDetailsCapture
		Thread.sleep(WaitTime.high);
		switchToWindow(driver);
		Thread.sleep(WaitTime.high);

		selectFromDropdownByVisibleText(ProposerDetailsCapture,dataRow.getProperty("ProposerDetailsCaptur"),"Proposer Details Captur");
		Thread.sleep(WaitTime.high);

		//ProducDetailsCapture
		selectFromDropdownByVisibleText(ProducDetailsCapture,dataRow.getProperty("ProducDetailsCapture"),"Produc Details Capture");
		Thread.sleep(WaitTime.medium);

		//PlanDetailsCapture
		selectFromDropdownByVisibleText(PlanDetailsCapture,dataRow.getProperty("PlanDetailsCapture"),"Plan Details Capture");
		Thread.sleep(WaitTime.medium);

		//MemberDetailsCapture
		selectFromDropdownByVisibleText(MemberDetailsCapture,dataRow.getProperty("MemberDetailsCapture"),"Member Details Capture");
		Thread.sleep(WaitTime.medium);

		//PreviousInsuranceDetailsCapture
		selectFromDropdownByVisibleText(PreviousInsuranceDetailsCapture,dataRow.getProperty("PreviousInsuranceDetailsCapture"),"PreviousInsuranceDetailsCapture");
		Thread.sleep(WaitTime.medium);

		//HealthDetailsCapture
		selectFromDropdownByVisibleText(HealthDetailsCapture,dataRow.getProperty("HealthDetailsCapture"),"HealthDetailsCapture");
		Thread.sleep(WaitTime.medium);

		//ChronicDiseaseCompleted
		selectFromDropdownByVisibleText(ChronicDiseaseCompleted,dataRow.getProperty("ChronicDiseaseCompleted"),"Chronic Disease Completed");
		Thread.sleep(WaitTime.medium);


		selectFromDropdownByVisibleText(NomineeDetails,dataRow.getProperty("NomineeDetails"),"Nominee Details");
		Thread.sleep(WaitTime.medium);

		selectFromDropdownByVisibleText(CustomerSignature,dataRow.getProperty("CustomerSignature"),"Customer Signature");
		Thread.sleep(WaitTime.medium);


		//savem button
		click(savebtn,"Submit btn");
		Thread.sleep(WaitTime.medium);
		driver.switchTo().window(parentWindow);
		switchtodefaultframe(driver);
		switchtoframe(driver,"display");
		switchtoframe(driver,"containerFrame");


		//policy summary
		//driver.switchTo().window(parentWindow);
		Thread.sleep(WaitTime.medium);
		click(Continue, "Submit btn");
		Thread.sleep(WaitTime.medium);


		/*
		 * //payment cycle Thread.sleep(WaitTime.medium); click(Continue, "Submit btn");
		 * Thread.sleep(WaitTime.low);
		 * 
		 * 
		 * //Endorsement Thread.sleep(WaitTime.medium); click(continuebtn,
		 * "Continue btn"); Thread.sleep(WaitTime.low);
		 */


		//Follow Up
		//		switchtodefaultframe(driver);
		//		switchtoframe(driver,"display");
		//		Thread.sleep(WaitTime.low);
		//		click(FollowUp,"Follow Up");
		//		Thread.sleep(WaitTime.low);
		//		switchtoframe(driver,"containerFrame");



		//Verify Inward Completed
		Thread.sleep(WaitTime.low);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_UP);
		String inwardcompleted=InwardCompleted.getText();
		Reporter.log("----------");
		Reporter.log("Inward Proposal for this case is "+inwardcompleted);
		Reporter.log("---------");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		//		click(Continue, "Submit btn");
		//		Thread.sleep(WaitTime.low);


		//Communications
		//		Thread.sleep(WaitTime.low);
		//		click(continuebtn, "Continue btn");
		//		Thread.sleep(WaitTime.medium);

	}	



	public void fillMemberInfo(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{	
		fillmemberinfo(driver, testCaseName, workbook, conn, stepGroup, customAssert);

	}

}
