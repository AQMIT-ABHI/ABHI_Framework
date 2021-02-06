package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
//import com.google.common.base.Predicate;

import constants.PropertyConfigs;
import testRunner.TestEngine;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.SetUpWebdriver;
import util.WaitTime;


public class PolicyEndorsement extends GenericMethods {

	@FindBy(xpath="//i[@id='roleIcon']")
	private WebElement roleCLICK;

	@FindBy(xpath="(//p[contains(text(),'Policy Management')])[1]")
	private WebElement PolicyManagement;

	@FindBy(xpath="//input[@id='Policy No.']")
	private WebElement PolicyNoSearch;

	@FindBy(xpath="//button[@id='Search']")
	private WebElement SearchButton;

	@FindBy(xpath="//button[@id='polChngID']")
	private WebElement policychange;

	@FindBy(xpath= "//select[@id='Type of Endorsement']")
	private WebElement endorsementtype;

	@FindBy(xpath= "//input[@id='Effective Date']")
	private WebElement EffectiveDate;


	@FindBy(xpath= "//select[@id='Induced By']")
	private WebElement inducedby;

	@FindBy(xpath= "//select[@id='Request Type']")
	private WebElement requesttype;

	@FindBy(xpath= "//button[@id='btnPrcd']")
	private WebElement proceedbtn;

	@FindBy(xpath= "//a[@title='Basic Detail']/i")
	private WebElement basicdetails;

	@FindBy(xpath="//button[@id='Nominee']")
	private WebElement nomineeDeyailsBTN;

	@FindBy(xpath="//input[@id='Nominee Contact Number']")
	private WebElement nomineecontactNo;

	//Nominee Save 
	@FindBy(xpath="//button[@id='SaveBtn']")
	private WebElement nomineesaveBTN;

	@FindBy(xpath="//button[@id='CloseBtn']")
	private WebElement closeBTN;


	//Ok
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement okBTN3;

	@FindBy(xpath="//a[@title='Requirements']/i")
	private WebElement requirementbtn;


	//Continue basic details
	@FindBy(xpath="//button[@id='btncontinue']")
	private WebElement continueBTN1;

	//Show Requirement on Requirements page
	@FindBy(xpath="//img[@title='Show Requirement'][1]")
	private WebElement showrequirement1;

	//Selection Dropdown 3
	//@FindBy(xpath="//div[contains(text(),'Aadhar Card')]//following::select[1]")

	@FindBy(xpath = "//div[contains(text(),'Others')]//following::select[1]")
	private WebElement Optional3;

	// Upload Requirement A
	//(xpath = "//div[contains(text(),'Others')]//following::img[3]")
	//@FindBy(xpath = "//div[contains(text(),'Aadhar Card')]//following::img[3]")

	@FindBy(xpath = "//div[contains(text(),'Others')]//following::img[3]")
	private WebElement uploadrequirementA;

	// Choose File
	@FindBy(xpath = "//input[@type='file']")
	private WebElement choosefile;

	// Upload File
	@FindBy(xpath = "//button[@title='Upload']")
	private WebElement upload;

	// Ok Button Click
	@FindBy(xpath = "//button[@class='btn btn-default']")
	private WebElement OK;


	// Save
	@FindBy(xpath = "//button[@id='SaveRequire']")
	private WebElement saverequire;

	// Continue Button Requirement page
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueButton;

	// Save
	@FindBy(xpath = "//button[@name='Submit']")
	private WebElement submit;

	@FindBy(xpath="//input[@id='Nominee Name0']")
	private WebElement nomineeName;

	@FindBy(xpath="//input[@id='Nominee Date of Birth0']")
	private WebElement nomineeDateofbirth;


	@FindBy(xpath="//select[@id='Relationship']")
	private WebElement relationshipwithproposer;


	@FindBy(xpath="//select[@name='Gender0']")
	private WebElement nomineegender;

	//Endorsement Number
	@FindBy(xpath="//label[@id='Number']")
	private WebElement EndorsementNumber;

	//Member icon
	@FindBy(xpath="//a[@title='Member Info']/i")
	private WebElement membericon;

	@FindBy(xpath="//label[@ng-model='clmGridData.strParameterValue']")
	private WebElement memberCode;

	@FindBy(xpath="//button[@id='AddBtn']")
	private WebElement AddButton;

	@FindBy(xpath="//select[@id='Title']")
	private WebElement title;


	//First Name
	@FindBy(xpath="//input[@id='First Name']")
	private WebElement firstname;

	//First Name
	@FindBy(xpath="//input[@id='Policy-holder First name']")
	private WebElement PolicyHolderfirstname;

	@FindBy(xpath="//select[@id='Gender']")
	private WebElement gender;

	@FindBy(xpath="//input[@id='Date of Birth']")
	private WebElement MemberDateofbirth;

	@FindBy(xpath = "//input[@id='Mobile Number']")
	private WebElement mobileNumber;

	@FindBy(xpath = "//input[@id='Height (Feet)']")
	private WebElement heightfeet;

	@FindBy(xpath = "//input[@id='Weight (in kgs)']")
	private WebElement weightinKG;

	@FindBy(xpath = "//select[@id='Nationality']")
	private WebElement nationality;

	@FindBy(xpath = "//input[@id='countryof residence']")
	private WebElement countryofResidence;

	@FindBy(xpath = "//input[@id='occupation']")
	private WebElement occupation;

	@FindBy(xpath = "//select[@id='Applicable Sum Insured']")
	private WebElement SumInsured;

	@FindBy(xpath = "//select[@id='Deductible_Amount']")
	private WebElement Deductible;

	@FindBy(xpath = "//select[@id='Room Category']")
	private WebElement RoomCategory;

	@FindBy(xpath = "//select[@id='Is Chronic Disease ?']")
	private WebElement Ischronic;

	@FindBy(xpath = "//select[@id='HNI Customer']")
	private WebElement hniCustomer;

	@FindBy(xpath = "//select[@id='CEO Club Advisor Customer']")
	private WebElement CEOClubAdvisorCustomer;

	@FindBy(xpath = "//select[@id='Priority Customer']")
	private WebElement priorityCustomer;

	@FindBy(xpath = "//select[@id='Sensitive Customer']")
	private WebElement sensitiveCustomerr;

	@FindBy(xpath = "//select[@id='Opted zone']")
	private WebElement Optedzone;

	@FindBy(xpath = "//input[@id='WhatsApp Number']")
	private WebElement whatsappnumber;

	@FindBy(xpath = "//button[@id='SaveButton']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//button[@id='SaveBtn']")
	private WebElement loanAccsaveBTN;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement Okbutton;

	//Requirements icon
	@FindBy(xpath="//a[@name='Requirements']/i")
	private WebElement requirementsIcon;

	//Fill Address Line 1
	@FindBy(xpath="//input[@id='Address Pty 1']")
	private WebElement AddressLine1;


	//Fill Address Line 2
	@FindBy(xpath="//input[@id='Address Pty 2']")
	private WebElement AddressLine2;


	@FindBy(xpath="//input[@id='Address Pty 3']")
	private WebElement AddressLine3;
	
	//Fill Pincode
	@FindBy(xpath="//input[@id='Zip CodeParty']")
	private WebElement Pincode;

	//Fill Landline Number
	@FindBy(xpath="//input[@id='Landline NumberP']")
	private WebElement Landline;

	//Fill Email ID
	@FindBy(xpath="//input[@id='Email ID']")
	private WebElement EmailID;

	//Select type of address
	@FindBy(xpath="//select[@id='Select Type of Address']")
	private WebElement TypeOfAddress;

	// Save
	@FindBy(xpath = "//button[@id='Save']")
	private WebElement Save;


	// payment icon
	@FindBy(xpath = "//a[@title='Payment Details']/i")
	private WebElement paymenticon;

	@FindBy(xpath="//a[@id='6']//i[contains(@class,'fa-credit-card')]")	
	private WebElement paymentscreen;

	@FindBy(xpath="//select[@id='Payment Mode']")
	private WebElement paymentMode;

	@FindBy(xpath="//select[@id='Payment Frequency']")
	private WebElement paymentFrequency;

	@FindBy(xpath="//select[@id='Auto-Debit Flag']")
	private WebElement autoDebitflag;


	@FindBy(xpath="//input[@id='Name of Account Holder']")
	private WebElement NameOfHolder;


	@FindBy(xpath="//input[@id='Account Number']")
	private WebElement accountNo;

	@FindBy(xpath="//input[@id='Bank IFSC Code']")
	private WebElement Ifsccode;


	@FindBy(xpath="//select[@id='Account Type']")
	private WebElement accountType;

	@FindBy(xpath="//input[@name='Bank City']")
	private WebElement bankCity;

	@FindBy(xpath="//button[@id='SaveButton']")
	private WebElement saveBTN;

	@FindBy(xpath="//input[@id='Name of the Bank']")
	private WebElement Bankname;

	@FindBy(xpath="//input[@id='Branch Name OUT']")
	private WebElement Bankbranch;

	@FindBy(xpath="//input[@id='MICR Code']")
	private WebElement MICRcode;

	@FindBy(xpath="//select[@id='Premium Frequency']")
	private WebElement PremiumFrequency;

	@FindBy(xpath = "//button[@id='Save']")
	private WebElement PaymentFreqSave;


	@FindBy(xpath = "//select[@id='Do you have any EIA account No ?']")
	private WebElement DoyouhaveEIA;

	@FindBy(xpath = "//select[@id='Apply for EIA Account']")
	private WebElement ApplyEIA;

	@FindBy(xpath = "//input[@id='EIA Account Number']")
	private WebElement EIANumber;

	@FindBy(xpath = "//select[@id='EIA Account With']")
	private WebElement EIAAccountwith;

	@FindBy(xpath = "//select[@id='Type of Account']")
	private WebElement Typeofaccount;


	//Pravina
	@FindBy(xpath = "//td//input[@class='ng-pristine ng-untouched ng-valid ng-empty']")
	private WebElement ListOfMemberCheckbox;

	@FindBy(xpath = "//button[@id='Loan']")
	private WebElement loanButton;

	@FindBy(xpath = "//input[@id='Loan Account Number0']")
	private WebElement loanAccountNumber;

	@FindBy(xpath = "//button[@id='CloseBtn']")
	private WebElement closeButton;

	@FindBy(xpath = "//button[@id='CloseButton']")
	private WebElement close1Button;

	@FindBy(xpath = "//button[@class='btn btn-default'][contains(text(),'OK')]")
	private WebElement errorOk;

	@FindBy(xpath = "//button[@id='Accept_QC']")
	private WebElement acceptQC;

	@FindBy(xpath="//label[@id='Status']")
	private WebElement EndorsementStatus;

	@FindBy(xpath="//label[@id='Member Code']")
	private WebElement EndorsementMemberCode;

	@FindBy(xpath="//select[@id='Member Substatus']")
	private WebElement memberSubStatus;

	@FindBy(xpath="//select[@name='Source of Endorsement']")
	private WebElement sourceOfEndorsemet;

	@FindBy(xpath="//a[@title='Policy Summary']")
	private WebElement policySummeryTab;

	@FindBy(xpath="//input[@id='Last Name 1']")
	private WebElement middlename;
	
	
	@FindBy(xpath="//input[@id='Last Name 2']")
	private WebElement lastname;
	
	@FindBy(xpath="//div[@class='radio-inline ng-binding ng-scope']//input[@type='radio'][@value='Y']")
	private WebElement isMemberAddSameAsthatProposer;
	
	@FindBy(xpath="//button[@id='ID Details']")
	private WebElement IDDetailsButton;
	
	@FindBy(xpath="//select[@name='ID Type0']")
	private WebElement idTypeDropdown;
	
	@FindBy(xpath="//input[@name='ID Number0']")
	private WebElement idNumber;
	
	@FindBy(xpath="//input[@id='CKYC Reference Number']")
	private WebElement ckycNumber;
	
	@FindBy(xpath="//md-tab-item[@aria-controls='tab-content-1']")
	private WebElement secondMemberCode;
	
	@FindBy(xpath="//input[@name='Address of Nominee0']")
	private WebElement addressofNominee;
	
	
	@FindBy(xpath="//input[@name='Appointee Name0']")
	private WebElement appointeeName;
	
	@FindBy(xpath="//input[@name='Nominee %0']")
	private WebElement nomineePercentage;
	
	@FindBy(xpath="//input[@id='Policy-holder Last Name (1)']")
	private WebElement middlenamepoliciHolder;
	
	@FindBy(xpath="//input[@id='Policy-holder Last Name (2)']")
	private WebElement lastnamepolicyHolder;
	
	@FindBy(xpath="//select[@id='Policy-holder Gender']")
	private WebElement genderpolicyHolder;
	
	
	
	WebDriverWait wait;
	public PolicyEndorsement(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
	}

	public void fillEndorsement(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName,stepGroup);
		Reporter.log("<B>Login To Application</B>");

		//Endorsement
		switchtodefaultframe(driver);
		switchtoframe(driver, "head");
		Thread.sleep(2000);
		//COPS Role
		if(dataRow.getProperty("Role").equalsIgnoreCase("COPS"))
		{
			click(roleCLICK,"Role Click");	
			click(driver.findElement(By.xpath("//div[contains(text(),'COPS')]")),"Selected Role as COPS");
		}

		//BOPS Role
		if(dataRow.getProperty("Role").equalsIgnoreCase("BOPS"))
		{
			click(roleCLICK,"Role Click");	
			click(driver.findElement(By.xpath("//div[contains(text(),'BOPS')]")),"Selected Role as BOPS");
		}

		//UWR Role
		if(dataRow.getProperty("Role").equalsIgnoreCase("UWR"))
		{
			click(roleCLICK,"Role Click");	
			click(driver.findElement(By.xpath("//div[contains(text(),'UWR')]")),"Selected Role as UWR");
		}

		Thread.sleep(WaitTime.medium);
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		click(PolicyManagement,"Policy Management tab");

		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(PolicyNoSearch,dataRow.getProperty("Policy No"),"Quote No Input");
		Thread.sleep(WaitTime.medium);
		click(SearchButton, "search");

		//Check status of Policy against endorsement
		if(dataRow.getProperty("Status").equalsIgnoreCase("Active Policy"))
		{
			Reporter.log("Active Policy");
			Reporter.log("--------------");
		}

		if(dataRow.getProperty("Status").equalsIgnoreCase("Active Policy"))
		{
			Reporter.log("Cancelled Policy");
			Reporter.log("--------------");
		}

		if(dataRow.getProperty("Status").equalsIgnoreCase("Active Policy"))
		{
			Reporter.log("Expired Policy");
			Reporter.log("--------------");
		}

		//Endorsement
		driver.findElement(By.xpath("//input[@id='Policy No.']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		click(driver.findElement(By.xpath("//a[contains(text(),'"+dataRow.getProperty("Policy No")+"')]")),"Click on Policy Number");
		Thread.sleep(2000);
		String parentWindow1 = driver.getWindowHandle();
		Thread.sleep(WaitTime.low);
		switchtodefaultframe(driver);
		switchtoframe(driver,"display");
		Thread.sleep(WaitTime.low);
		switchtoframe(driver,"containerFrame");
		Thread.sleep(WaitTime.low);
		click(policychange,"Member Icon");
		Thread.sleep(WaitTime.medium);
		switchToWindow(driver);

		//Select Endorsement Type

		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(endorsementtype,dataRow.getProperty("Endorsement type"),"Selection Optional");

		Thread.sleep(WaitTime.low);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDateTime now = LocalDateTime.now();  
		String ModDate=dtf.format(now);
		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(EffectiveDate, ModDate, "Effective Date");	
		EffectiveDate.sendKeys(Keys.TAB);

		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(inducedby,dataRow.getProperty("InducedBy"),"Selection Optional");


		Thread.sleep(WaitTime.low);
		selectFromDropdownByVisibleText(requesttype,dataRow.getProperty("RequestType"),"Selection Optional");
		Thread.sleep(WaitTime.medium);

		selectFromDropdownByVisibleText(sourceOfEndorsemet,dataRow.getProperty("SourceOfEndorsement"),"Source of Endorsement select");
		Thread.sleep(WaitTime.high);


		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Nominee Details"))
		{
			click(ListOfMemberCheckbox, "List Of Member Selcection");
		}


		Thread.sleep(WaitTime.low);

		click(proceedbtn,"Proccedbtn");
		Thread.sleep(WaitTime.medium);
		driver.switchTo().window(parentWindow1);
		switchtodefaultframe(driver);
		switchtoframe(driver,"display");
		Thread.sleep(WaitTime.low);

		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Nominee Details")&&dataRow.getProperty("Policy").equalsIgnoreCase("Individual")
			||dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Nominee Details")&&dataRow.getProperty("Policy").equalsIgnoreCase("Family Floater"))
		{

			click(basicdetails,"Basic Details");
			Thread.sleep(WaitTime.medium);
			switchtoframe(driver, "containerFrame");

			//Click Nominee Details Button
			Thread.sleep(WaitTime.medium);
			click(nomineeDeyailsBTN,"NomineeDetailsBtn");
			Thread.sleep(WaitTime.medium);
			switchToWindow(driver);

			Thread.sleep(WaitTime.low);
			//Nominee Contact Number
			if(!dataRow.getProperty("NomineeContactNo").isEmpty())
			{
				nomineecontactNo.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(nomineecontactNo,dataRow.getProperty("NomineeContactNo"),"Nominee Contact No");
				//SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
			}

			Thread.sleep(WaitTime.low);
			//Nominee Name
			if(!dataRow.getProperty("NomineeName").isEmpty())
			{
				nomineeName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(nomineeName,dataRow.getProperty("NomineeName"),"Nominee Name ");
				SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
			}

			Thread.sleep(WaitTime.low);
			//Nominee DOB
			if(!dataRow.getProperty("DateOfbirth").isEmpty())
			{
				nomineeDateofbirth.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(nomineeDateofbirth,dataRow.getProperty("DateOfbirth"),"nominee Date Of birth ");
				nomineeDateofbirth.sendKeys(Keys.TAB);
				SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
			}

			Thread.sleep(WaitTime.low);
			//Nominee Relationship
			if(!dataRow.getProperty("RelationshipWithProposer").isEmpty())
			{
				relationshipwithproposer.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleText(relationshipwithproposer,dataRow.getProperty("RelationshipWithProposer"),"Relationship With Proposer");
				SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
			}

			Thread.sleep(WaitTime.low);
			//Nominee Gender
			if(!dataRow.getProperty("Gender").isEmpty())
			{
				nomineegender.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleText(nomineegender,dataRow.getProperty("Gender"),"Nominee Gender");
				SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));
			}
			
			if(!dataRow.getProperty("AddressofNominee").isEmpty())
			{
				
				clearAndSenKeys(addressofNominee,dataRow.getProperty("AddressofNominee"),"Address of Nominee");
	
			}
			
			if(!dataRow.getProperty("AppointeeName").isEmpty())
			{
				
				clearAndSenKeys(appointeeName,dataRow.getProperty("AppointeeName"),"Appointee Name");
	
			}
			
			if(!dataRow.getProperty("Nominee%").isEmpty())
			{
				
				clearAndSenKeys(nomineePercentage,dataRow.getProperty("Nominee%"),"Nominee%");
	
			}


			Thread.sleep(WaitTime.low);
			//Nominee Save
			click(nomineesaveBTN," Nominee Save");
			Thread.sleep(WaitTime.medium);

			//Nominee Save OK
			click(okBTN3, "Ok ");
			Thread.sleep(WaitTime.medium);

			//Nominee Close
			click(closeBTN,"Close btn");
			Thread.sleep(WaitTime.medium);
			driver.switchTo().window(parentWindow1);
			switchtodefaultframe(driver);
			switchtoframe(driver, "display"); 
			switchtoframe(driver, "containerFrame");

			//Continue
			click(continueBTN1, "Continue");
			Thread.sleep(WaitTime.medium);


		}


		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Member Details")
				&&dataRow.getProperty("Policy").equalsIgnoreCase("Individual"))
		{

			click(membericon,"Member Icon");
			Thread.sleep(WaitTime.low);
			switchtoframe(driver,"containerFrame");
			Thread.sleep(WaitTime.low);
			click(memberCode, "Member Code");
			switchtoframe(driver,"memberiframe0");

			//First Name
			if(!dataRow.getProperty("Firstname").isEmpty())
			{
				clearAndSenKeys(firstname,getRandomString(),"First Name" );
				Thread.sleep(WaitTime.medium);
			}

			if(!dataRow.getProperty("MiddleName").isEmpty())
			{
				clearAndSenKeys(middlename,getRandomString(),"Middle Name" );
				Thread.sleep(WaitTime.medium);
			}
	
			if(!dataRow.getProperty("LastName").isEmpty())
			{
				clearAndSenKeys(lastname,getRandomString(),"Last Name" );
				Thread.sleep(WaitTime.medium);
			}
			
			relationshipwithproposer.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(WaitTime.low);
			selectFromDropdownByVisibleText(relationshipwithproposer,dataRow.getProperty("RelationshipWithProposer"),"Relationship With Proposer");

			
			if(!dataRow.getProperty("Address Line 1").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(AddressLine1,dataRow.getProperty("Address Line 1"),"Address Line 1");
			}

			//Fill Address line 2
			if(!dataRow.getProperty("Address Line 2").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(AddressLine2,dataRow.getProperty("Address Line 2"),"Address Line 2");
			}
			
			if(!dataRow.getProperty("Address Line 3").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(AddressLine3,dataRow.getProperty("Address Line 3"),"Address Line 3");
			}
			
			//Mobile Number
			if(!dataRow.getProperty("Mobile Number").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(mobileNumber, dataRow.getProperty("Mobile Number"), "Mobile No");
				Thread.sleep(WaitTime.low);
			}
			
			if(!dataRow.getProperty("WhatsappNumber").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(whatsappnumber,dataRow.getProperty("WhatsappNumber"), "Whatsapp Number");
				Thread.sleep(WaitTime.low);
			}


			//Height
			if(!dataRow.getProperty("HeightFeet").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(heightfeet, dataRow.getProperty("HeightFeet"), "Height Feet");
				Thread.sleep(WaitTime.low);
			}

			//Weight
			if(!dataRow.getProperty("WeightInKG").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(weightinKG, dataRow.getProperty("WeightInKG"), "Weight In KG");
				Thread.sleep(WaitTime.low);
				weightinKG.sendKeys(Keys.TAB);
			}

			//Nationality
			if(!dataRow.getProperty("Nationality").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(nationality,dataRow.getProperty("Nationality"), "Nationality");
				Thread.sleep(WaitTime.low);
			}

			//Country
			if(!dataRow.getProperty("Country of Residence").isEmpty())
			{
				Thread.sleep(WaitTime.medium); 
				clearAndSenKeys(countryofResidence,dataRow.getProperty("Country of Residence"), "Country of Residence");
				Thread.sleep(WaitTime.high);
				Thread.sleep(WaitTime.low);
				click(driver.findElement(By.xpath("//span[contains(text(),'"+dataRow.getProperty("Country of Residence")+"')]")),"Clicked on country");
			}


			//Occupation
			Thread.sleep(WaitTime.low);				
			if(!dataRow.getProperty("Occupation").isEmpty())
			{
				Thread.sleep(WaitTime.medium); 
				clearAndSenKeys(occupation,dataRow.getProperty("Occupation"), "Occupation");
				Thread.sleep(WaitTime.high);
				Thread.sleep(WaitTime.low);
				click(driver.findElement(By.xpath("//span[contains(text(),'"+dataRow.getProperty("Occupation")+"')]")),"Clicked on Occupation");
			}
			
			
			if(!dataRow.getProperty("isMemberAddSameAsProposer").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				selectRadioButton(isMemberAddSameAsthatProposer, "Is Member Address Same As Proposer");
				//click(driver.findElement(By.xpath("//span[contains(text(),'"+dataRow.getProperty("Occupation")+"')]")),"Clicked on Occupation");
			}
			
			if(!dataRow.getProperty("PinCode").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(Pincode,dataRow.getProperty("PinCode"),"Pincode");
				Pincode.sendKeys(Keys.TAB);
			}
			
			
			{
				click(IDDetailsButton, "ID Details Button");
				switchToWindow(driver);
				selectFromDropdownByVisibleText(idTypeDropdown, dataRow.getProperty("IDType"), "ID Type");
			}
			
			if(!dataRow.getProperty("IDNumber").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(idNumber,dataRow.getProperty("IDNumber"),"ID Number");
				click(SaveButton, "Save");
			
			}
			
			if(!dataRow.getProperty("CKYCNumber").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(ckycNumber,dataRow.getProperty("CKYCNumber"),"CKYC Number");
			
			}

			//Save & OK
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			click(SaveButton, "Save");
			Thread.sleep(WaitTime.medium);
			click(Okbutton, "Ok Button");
			Thread.sleep(WaitTime.medium);

			//Requirement
			switchtodefaultframe(driver);
			switchtoframe(driver,"display");
			Thread.sleep(WaitTime.low);
			click(requirementsIcon,"Click Requirement Icon");
			Thread.sleep(WaitTime.low); 
			switchtoframe(driver, "containerFrame");
			//				if(!dataRow.getProperty("Name").isEmpty());

		}


		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Policy Holder Details")&&dataRow.getProperty("Policy").equalsIgnoreCase("Individual")
				||dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Policy Holder Details")&&dataRow.getProperty("Policy").equalsIgnoreCase("Family Floater"))
		{

			click(basicdetails,"Basic Details");
			Thread.sleep(WaitTime.medium);
			switchtoframe(driver, "containerFrame");

			if(!dataRow.getProperty("Firstname").isEmpty())
			{
				clearAndSenKeys(PolicyHolderfirstname,getRandomString(),"First Name" );
				Thread.sleep(WaitTime.medium);
			}

			if(!dataRow.getProperty("MiddleName").isEmpty())
			{
				clearAndSenKeys(middlenamepoliciHolder,dataRow.getProperty("MiddleName"),"Middle Name" );
				Thread.sleep(WaitTime.medium);
			}
	
			if(!dataRow.getProperty("LastName").isEmpty())
			{
				clearAndSenKeys(lastnamepolicyHolder,dataRow.getProperty("LastName"),"Last Name" );
				Thread.sleep(WaitTime.medium);
			}
			if(!dataRow.getProperty("Title").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(title,dataRow.getProperty("Title"), "Title");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("Gender").isEmpty())
			{
			selectFromDropdownByVisibleText(genderpolicyHolder,dataRow.getProperty("Gender"),"Gender");
			}
			//Occupation
			Thread.sleep(WaitTime.low);				
			if(!dataRow.getProperty("Occupation").isEmpty())
			{
				Thread.sleep(WaitTime.medium); 
				clearAndSenKeys(occupation,dataRow.getProperty("Occupation"), "Occupation");
				Thread.sleep(WaitTime.high);
				Thread.sleep(WaitTime.low);
				click(driver.findElement(By.xpath("//span[contains(text(),'"+dataRow.getProperty("Occupation")+"')]")),"Clicked on Occupation");
			}

			//Nationality
			if(!dataRow.getProperty("Nationality").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(nationality,dataRow.getProperty("Nationality"), "Nationality");
				Thread.sleep(WaitTime.low);
			}

			//WhatsAppNumber
			if(!dataRow.getProperty("WhatsappNumber").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(whatsappnumber,dataRow.getProperty("WhatsappNumber"), "Whatsapp Number");
				Thread.sleep(WaitTime.low);
			}

			//Type of Address
			if(!dataRow.getProperty("TypeOfAddress").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(TypeOfAddress,dataRow.getProperty("TypeOfAddress"), "Type Of Address");
			}


			//Fill Address line 1
			if(!dataRow.getProperty("Address Line 1").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(AddressLine1,dataRow.getProperty("Address Line 1"),"Address Line 1");
			}

			//Fill Address line 2
			if(!dataRow.getProperty("Address Line 2").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(AddressLine2,dataRow.getProperty("Address Line 2"),"Address Line 2");
			}

			//Fill Pincode
			if(!dataRow.getProperty("PinCode").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(Pincode,dataRow.getProperty("PinCode"),"Pincode");
				Pincode.sendKeys(Keys.TAB);
			}

			//Landline Number
			if(!dataRow.getProperty("Landline Number").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(Landline,dataRow.getProperty("Landline Number"),"Landline number");
			}

			//Mobile Number
			if(!dataRow.getProperty("Mobile Number").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(mobileNumber,dataRow.getProperty("Mobile Number"),"Mobile Number");
			}

			//Fill Email ID
			if(!dataRow.getProperty("Email ID").isEmpty())
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(EmailID,dataRow.getProperty("Email ID"),"Email ID");
			}

			Thread.sleep(WaitTime.low);
			click(Save,"Save Button");
			Thread.sleep(WaitTime.medium);
			click(Okbutton, "Ok Button");
			Thread.sleep(WaitTime.medium);

			//Continue
			click(continueBTN1, "Continue");
			Thread.sleep(WaitTime.medium);

		}

		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Addition of Member"))
		{

			click(membericon,"Member Icon");
			Thread.sleep(WaitTime.low);
			switchtoframe(driver,"containerFrame");
			Thread.sleep(WaitTime.low);
			click(AddButton, "Add Button");
			Thread.sleep(WaitTime.low);
			switchToWindow(driver);


			selectFromDropdownByVisibleText(title,dataRow.getProperty("Title"),"Title");



			Thread.sleep(WaitTime.low);
			clearAndSenKeys(firstname,getRandomString(),"First Name" );


			selectFromDropdownByVisibleText(gender,dataRow.getProperty("Gender"),"Gender");

			clearAndSenKeys(MemberDateofbirth,dataRow.getProperty("DateOfbirth"),"Date Of birth ");
			MemberDateofbirth.sendKeys(Keys.TAB);


			relationshipwithproposer.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(WaitTime.low);
			selectFromDropdownByVisibleText(relationshipwithproposer,dataRow.getProperty("RelationshipWithProposer"),"Relationship With Proposer");


			//Mobile Number

			Thread.sleep(WaitTime.medium);
			clearAndSenKeys(mobileNumber, dataRow.getProperty("Mobile Number"), "Mobile No");
			Thread.sleep(WaitTime.low);


			//Height

			Thread.sleep(WaitTime.medium);
			clearAndSenKeys(heightfeet, dataRow.getProperty("HeightFeet"), "Height Feet");
			Thread.sleep(WaitTime.low);


			//Weight

			Thread.sleep(WaitTime.medium);
			clearAndSenKeys(weightinKG, dataRow.getProperty("WeightInKG"), "Weight In KG");
			Thread.sleep(WaitTime.low);
			weightinKG.sendKeys(Keys.TAB);


			//Nationality

			Thread.sleep(WaitTime.medium);
			selectFromDropdownByVisibleText(nationality,dataRow.getProperty("Nationality"), "Nationality");
			Thread.sleep(WaitTime.low);


			//Country

			Thread.sleep(WaitTime.medium); 
			clearAndSenKeys(countryofResidence,dataRow.getProperty("Country of Residence"), "Country of Residence");
			Thread.sleep(WaitTime.high);
			Thread.sleep(WaitTime.low);
			click(driver.findElement(By.xpath("//span[contains(text(),'"+dataRow.getProperty("Country of Residence")+"')]")),"Clicked on country");



			//Occupation
			Thread.sleep(WaitTime.low);				

			Thread.sleep(WaitTime.medium); 
			clearAndSenKeys(occupation,dataRow.getProperty("Occupation"), "Occupation");
			Thread.sleep(WaitTime.high);
			Thread.sleep(WaitTime.low);
			click(driver.findElement(By.xpath("//span[contains(text(),'"+dataRow.getProperty("Occupation")+"')]")),"Clicked on Occupation");


			Thread.sleep(WaitTime.low);
			selectFromDropdownByVisibleText(SumInsured, dataRow.getProperty("SumInsured"), "Sum Insured");

			Thread.sleep(WaitTime.low);
			selectFromDropdownByVisibleText(Deductible, dataRow.getProperty("Deductible"), "Deductible");

			Thread.sleep(WaitTime.low);
			selectFromDropdownByVisibleText(RoomCategory, dataRow.getProperty("RoomCategory"), "Room Category");

			Thread.sleep(WaitTime.medium);
			selectFromDropdownByVisibleText(hniCustomer, "No", "hni Customer");
			Thread.sleep(WaitTime.low);

			Thread.sleep(WaitTime.medium);
			selectFromDropdownByVisibleText(CEOClubAdvisorCustomer, "No", "CEO Club Advisor Customerr");
			Thread.sleep(WaitTime.low);

			Thread.sleep(WaitTime.medium);
			selectFromDropdownByVisibleText(priorityCustomer, "No", "Priority Customer");
			Thread.sleep(WaitTime.low);

			Thread.sleep(WaitTime.medium);
			selectFromDropdownByVisibleText(sensitiveCustomerr, "No", "sensitive Customerr");
			Thread.sleep(WaitTime.low);

			Thread.sleep(WaitTime.medium);
			selectFromDropdownByVisibleText(Optedzone,dataRow.getProperty("optedzone"),"Opted Zone"); 

			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			click(SaveButton, "Save");
			Thread.sleep(WaitTime.medium);
			click(Okbutton, "Ok Button");
			Thread.sleep(WaitTime.low);

		}

		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Bank Details"))
		{
			click(paymenticon,"Payment Icon");
			Thread.sleep(WaitTime.medium);
			switchtoframe(driver, "containerFrame");
			Thread.sleep(WaitTime.low);

			if(!dataRow.getProperty("PaymentMode").isEmpty())
			{
				selectFromDropdownByVisibleText(paymentMode,dataRow.getProperty("PaymentMode"),"Payment Mode");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("PaymentFrequency").isEmpty())
			{
				//Payment Frequency
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(paymentFrequency,dataRow.getProperty("PaymentFrequency"),"Payent Frequency");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("AutoDebitFlag").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(autoDebitflag,dataRow.getProperty("AutoDebitFlag"),"Auto Debit Flag");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("AccountHolderName").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(NameOfHolder,getRandomString(),"Name Of Holder");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("BankName").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(Bankname,dataRow.getProperty("BankName"),"Name Of Bank");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("BankBranch").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(Bankbranch,dataRow.getProperty("BankBranch"),"Name Of Bank");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("MICRCode").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(MICRcode,dataRow.getProperty("MICRCode"),"Name Of Bank");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("AccountNo.").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(accountNo,dataRow.getProperty("AccountNo."),"Account No");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("IFSCCode").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(Ifsccode,dataRow.getProperty("IFSCCode"),"IFSC Code");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("AccountType").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(accountType,dataRow.getProperty("AccountType"),"Account Type");
				Thread.sleep(WaitTime.low);
			}

			if(!dataRow.getProperty("BankCity").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(bankCity,dataRow.getProperty("BankCity"),"Bank City");
				Thread.sleep(WaitTime.low);
			}

			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
			Thread.sleep(WaitTime.medium);
			click(saveBTN,"Save");
			Thread.sleep(WaitTime.medium);
			click(Okbutton, "Ok Button");
			Thread.sleep(WaitTime.medium);

			//Continue
			click(continueBTN1, "Continue");
			Thread.sleep(WaitTime.medium);


		}


		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Payment Frequency")&&dataRow.getProperty("Policy").equalsIgnoreCase("Individual")
				||dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Payment Frequency")&&dataRow.getProperty("Policy").equalsIgnoreCase("Family Floater"))
		{
			click(basicdetails,"Basic Details");
			Thread.sleep(WaitTime.medium);
			switchtoframe(driver, "containerFrame");

			if(!dataRow.getProperty("PaymentFrequency").isEmpty())
			{

				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(PremiumFrequency, dataRow.getProperty("PaymentFrequency"), "Premium Frequency");
				Thread.sleep(WaitTime.medium);

			}

			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
			Thread.sleep(WaitTime.medium);
			click(PaymentFreqSave,"Save");
			Thread.sleep(WaitTime.medium);
			click(Okbutton, "Ok Button");
			Thread.sleep(WaitTime.medium);

			//Continue
			click(continueBTN1, "Continue");
			Thread.sleep(WaitTime.medium);
		}


		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in EIA Number")&&dataRow.getProperty("Policy").equalsIgnoreCase("Individual")
				||dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in EIA Number")&&dataRow.getProperty("Policy").equalsIgnoreCase("Family Floater"))
		{

			click(basicdetails,"Basic Details");
			Thread.sleep(WaitTime.medium);
			switchtoframe(driver, "containerFrame");
			if(!dataRow.getProperty("DoYouHaveEIA?").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(DoyouhaveEIA, dataRow.getProperty("DoYouHaveEIA?"), "Do you have EIA Account No.?");
				Thread.sleep(WaitTime.medium);
			}

			if(dataRow.getProperty("DoYouHaveEIA?").equalsIgnoreCase("No"))
			{	
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(ApplyEIA, dataRow.getProperty("ApplyEIA"), "Apply for EIA Account");
				Thread.sleep(WaitTime.medium);
			}

			if(dataRow.getProperty("DoYouHaveEIA?").equalsIgnoreCase("Yes"))
			{
				Thread.sleep(WaitTime.low);
				clearAndSenKeys(EIANumber, dataRow.getProperty("EIAAcountNo."), "EIA Account No.");
				Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleText(EIAAccountwith, dataRow.getProperty("EIAAccountWith"), "EIA Account With");
				Thread.sleep(WaitTime.medium);
				selectFromDropdownByVisibleText(Typeofaccount, dataRow.getProperty("TypeofAccount"), "Type of Account");
				Thread.sleep(WaitTime.low);
			}


			click(Save,"Save Button");
			Thread.sleep(WaitTime.medium);
			click(Okbutton, "Ok Button");
			Thread.sleep(WaitTime.medium);

			//Continue
			click(continueBTN1, "Continue");
			Thread.sleep(WaitTime.medium);

		}

		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Loan Account Number")&&dataRow.getProperty("Policy").equalsIgnoreCase("Individual")
				||dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Loan Account Number")&&dataRow.getProperty("Policy").equalsIgnoreCase("Family Floater"))
		{
			click(membericon,"Member Icon");
			Thread.sleep(WaitTime.low);
			switchtoframe(driver,"containerFrame");
			Thread.sleep(WaitTime.low);
			click(memberCode, "Member Code");
			switchtoframe(driver,"memberiframe0");


			click(loanButton,"Loan Details Button");
			Thread.sleep(WaitTime.medium);
			switchToWindow(driver);

			if(!dataRow.getProperty("LoanAccountNumber").isEmpty())
			{
				Thread.sleep(WaitTime.medium);
				clearAndSenKeys(loanAccountNumber,dataRow.getProperty("LoanAccountNumber"),"Loan Account number");
				Thread.sleep(WaitTime.medium);
			}


			click(loanAccsaveBTN,"Save Button");
			Thread.sleep(WaitTime.medium);
			click(Okbutton, "Ok Button");
			Thread.sleep(WaitTime.medium);
			click(closeButton, "Close Button");
			driver.switchTo().window(parentWindow1);
			Thread.sleep(WaitTime.medium);
			//click(close1Button, "Close Button");

		}
		
		
		
		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Member Details")
				&&dataRow.getProperty("Policy").equalsIgnoreCase("Family Floater"))
			{
//need to be automate 
				click(membericon,"Member Icon");
				Thread.sleep(WaitTime.low);
				switchtoframe(driver,"containerFrame");
				Thread.sleep(WaitTime.low);
				click(memberCode, "Member Code");
				switchtoframe(driver,"memberiframe0");
				Thread.sleep(WaitTime.high);

				//First Name
				if(!dataRow.getProperty("Firstname").isEmpty())
				{
					clearAndSenKeys(firstname,dataRow.getProperty("Firstname"),"First Name" );
					Thread.sleep(WaitTime.medium);
				}

				if(!dataRow.getProperty("MiddleName").isEmpty())
				{
					clearAndSenKeys(middlename,dataRow.getProperty("MiddleName"),"Middle Name" );
					Thread.sleep(WaitTime.medium);
				}
		
				if(!dataRow.getProperty("LastName").isEmpty())
				{
					clearAndSenKeys(lastname,dataRow.getProperty("LastName"),"Last Name" );
					Thread.sleep(WaitTime.medium);
				}
				
				if(!dataRow.getProperty("RelationshipWithProposer").isEmpty())
				{
				//relationshipwithproposer.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				Thread.sleep(WaitTime.low);
				selectFromDropdownByVisibleText(relationshipwithproposer,dataRow.getProperty("RelationshipWithProposer"),"Relationship With Proposer");
				}
				
				if(!dataRow.getProperty("Address Line 1").isEmpty())
				{
					Thread.sleep(WaitTime.low);
					clearAndSenKeys(AddressLine1,dataRow.getProperty("Address Line 1"),"Address Line 1");
				}

				//Fill Address line 2
				if(!dataRow.getProperty("Address Line 2").isEmpty())
				{
					Thread.sleep(WaitTime.low);
					clearAndSenKeys(AddressLine2,dataRow.getProperty("Address Line 2"),"Address Line 2");
				}
				
				if(!dataRow.getProperty("Address Line 3").isEmpty())
				{
					Thread.sleep(WaitTime.low);
					clearAndSenKeys(AddressLine3,dataRow.getProperty("Address Line 3"),"Address Line 3");
				}
				
				//Mobile Number
				if(!dataRow.getProperty("Mobile Number").isEmpty())
				{
					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(mobileNumber, dataRow.getProperty("Mobile Number"), "Mobile No");
					Thread.sleep(WaitTime.low);
				}
				
				if(!dataRow.getProperty("WhatsappNumber").isEmpty())
				{
					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(whatsappnumber,dataRow.getProperty("WhatsappNumber"), "Whatsapp Number");
					Thread.sleep(WaitTime.low);
				}


				//Height
				if(!dataRow.getProperty("HeightFeet").isEmpty())
				{
					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(heightfeet, dataRow.getProperty("HeightFeet"), "Height Feet");
					Thread.sleep(WaitTime.low);
				}

				//Weight
				if(!dataRow.getProperty("WeightInKG").isEmpty())
				{
					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(weightinKG, dataRow.getProperty("WeightInKG"), "Weight In KG");
					Thread.sleep(WaitTime.low);
					weightinKG.sendKeys(Keys.TAB);
				}

				//Nationality
				if(!dataRow.getProperty("Nationality").isEmpty())
				{
					Thread.sleep(WaitTime.medium);
					selectFromDropdownByVisibleText(nationality,dataRow.getProperty("Nationality"), "Nationality");
					Thread.sleep(WaitTime.low);
				}

				//Country
				if(!dataRow.getProperty("Country of Residence").isEmpty())
				{
					Thread.sleep(WaitTime.medium); 
					clearAndSenKeys(countryofResidence,dataRow.getProperty("Country of Residence"), "Country of Residence");
					Thread.sleep(WaitTime.high);
					Thread.sleep(WaitTime.low);
					click(driver.findElement(By.xpath("//span[contains(text(),'"+dataRow.getProperty("Country of Residence")+"')]")),"Clicked on country");
				}


				//Occupation
				Thread.sleep(WaitTime.low);				
				if(!dataRow.getProperty("Occupation").isEmpty())
				{
					Thread.sleep(WaitTime.medium); 
					clearAndSenKeys(occupation,dataRow.getProperty("Occupation"), "Occupation");
					Thread.sleep(WaitTime.high);
					Thread.sleep(WaitTime.low);
					click(driver.findElement(By.xpath("//span[contains(text(),'"+dataRow.getProperty("Occupation")+"')]")),"Clicked on Occupation");
				}
				
				
				if(!dataRow.getProperty("isMemberAddSameAsProposer").isEmpty())
				{
					Thread.sleep(WaitTime.low);
					selectRadioButton(isMemberAddSameAsthatProposer, "Is Member Address Same As Proposer");
					//click(driver.findElement(By.xpath("//span[contains(text(),'"+dataRow.getProperty("Occupation")+"')]")),"Clicked on Occupation");
				}
				
				if(!dataRow.getProperty("PinCode").isEmpty())
				{
					Thread.sleep(WaitTime.low);
					clearAndSenKeys(Pincode,dataRow.getProperty("PinCode"),"Pincode");
					Pincode.sendKeys(Keys.TAB);
				}
				
				if(!dataRow.getProperty("IDType").isEmpty())
				{
					click(IDDetailsButton, "ID Details Button");
					switchToWindow(driver);
					selectFromDropdownByVisibleText(idTypeDropdown, dataRow.getProperty("IDType"), "ID Type");
				}
				
				if(!dataRow.getProperty("IDNumber").isEmpty())
				{
					Thread.sleep(WaitTime.low);
					clearAndSenKeys(idNumber,dataRow.getProperty("IDNumber"),"ID Number");
					click(SaveButton, "Save");
				
				}
				
				if(!dataRow.getProperty("CKYCNumber").isEmpty())
				{
					Thread.sleep(WaitTime.low);
					clearAndSenKeys(ckycNumber,dataRow.getProperty("CKYCNumber"),"CKYC Number");
				
				}

				//Save & OK
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				click(SaveButton, "Save");
				Thread.sleep(WaitTime.medium);
				click(Okbutton, "Ok Button");
				Thread.sleep(WaitTime.medium);
				
				click(secondMemberCode, "Second Member code select");
			
				if(!dataRow.getProperty("SecondMemberFirstname").isEmpty())
				{
					clearAndSenKeys(firstname,getRandomString(),"Second member First Name" );
					Thread.sleep(WaitTime.medium);
				}

				if(!dataRow.getProperty("SecondMemberMiddleName").isEmpty())
				{
					clearAndSenKeys(middlename,getRandomString(),"Middle Name" );
					Thread.sleep(WaitTime.medium);
				}
		
				if(!dataRow.getProperty("SecondMemberLastName").isEmpty())
				{
					clearAndSenKeys(lastname,getRandomString(),"Last Name" );
					Thread.sleep(WaitTime.medium);
				}
				
				
				selectFromDropdownByVisibleText(relationshipwithproposer,dataRow.getProperty("RelationshipWithProposerFoSecondMember"),"Relationship With Proposer for second member");
				
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
				click(SaveButton, "Save");
				Thread.sleep(WaitTime.medium);
				click(Okbutton, "Ok Button");
				Thread.sleep(WaitTime.medium);
				
				//Requirement
				switchtodefaultframe(driver);
				switchtoframe(driver,"display");
				Thread.sleep(WaitTime.low);
				click(requirementsIcon,"Click Requirement Icon");
				Thread.sleep(WaitTime.low); 
				switchtoframe(driver, "containerFrame");
				//				if(!dataRow.getProperty("Name").isEmpty());

			}


		if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Nominee Details")
				||dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification In Member Details")
				||dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in EIA Number")
				||dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Loan Account Number")
				||dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Policy Holder Details")) 
		{ 

			Thread.sleep(WaitTime.medium);
			//Upload Documents
			click(showrequirement1,"Click on Show Requirement");
			Thread.sleep(WaitTime.medium);

			//Select Optional From the dropdown 3
			selectFromDropdownByVisibleText(Optional3,dataRow.getProperty("Optional Status"),"Selection Optional");
			Thread.sleep(WaitTime.medium);

			click(uploadrequirementA, "Upload Document of BanK");
			Thread.sleep(WaitTime.medium);
			switchToWindow(driver);
			Thread.sleep(WaitTime.veryHigh);

			// Choose File 1
			click(choosefile, "Choose File");
			Thread.sleep(WaitTime.medium);
			choosefile.sendKeys("F:\\Document.txt");
			Thread.sleep(WaitTime.high);

			// Upload File 1
			Thread.sleep(WaitTime.medium);
			click(upload, "File Uploaded");
			Thread.sleep(WaitTime.medium);
			driver.switchTo().window(parentWindow1);
			switchtodefaultframe(driver);
			switchtoframe(driver, "display");
			switchtoframe(driver, "containerFrame");
			//SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));

			// Ok Button

			Thread.sleep(WaitTime.medium);
			click(OK, "File Uploaded Successfully");
			Thread.sleep(WaitTime.medium);

			click(saverequire, "Save");
			Thread.sleep(WaitTime.medium);

			//click(errorOk, "Error Ok Button");
			// Ok Button
			
			  click(OK, "Modification Successfully Completed");
			  Thread.sleep(WaitTime.medium);
			 

			// Continue Button
			click(continueButton, "Continue Button");
			Thread.sleep(WaitTime.medium);

			click(submit, "Submit Button");
			Thread.sleep(WaitTime.high);
			SetUpWebdriver.captureScreenShot(driver, TestEngine.excutionFolder+ConfigReader.getInstance().getValue(PropertyConfigs.screenShotFolder),dataRow.getProperty("TCID"));

			String EndorsementNo=EndorsementNumber.getText();
			System.out.println("Endorsment No : "+EndorsementNo);
			Reporter.log("----------");
			Reporter.log("Endorsement No. for this case is "+EndorsementNo);
			Reporter.log("---------");
			ConfigReader.getInstance().StoreValueToConfig("EndorsementNo", EndorsementNo, "Endorsement No generated");

			if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification In Member Details")
					||dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification in Policy Holder Details"))
			{
				click(acceptQC, "Click on Accept QC");
				Thread.sleep(WaitTime.high);
			}


			if(dataRow.getProperty("Endorsement type").equalsIgnoreCase("Modification In Member Details")
					&&dataRow.getProperty("NextRole").equalsIgnoreCase("UWR"))
			{
				String EndorsementNo1=EndorsementNumber.getText();
				System.out.println("Endorsment No : "+EndorsementNo1);

				switchtodefaultframe(driver);
				switchtoframe(driver, "head");

				click(roleCLICK,"Role Click");	
				click(driver.findElement(By.xpath("//div[contains(text(),'UWR')]")),"Selected Role as UWR");

				Thread.sleep(WaitTime.medium);
				switchtodefaultframe(driver);
				switchtoframe(driver, "display");
				click(PolicyManagement,"Policy Management tab");
				Thread.sleep(WaitTime.high);

				/*
				 * clearAndSenKeys(PolicyNoSearch,dataRow.getProperty("Policy No"
				 * ),"Quote No Input"); Thread.sleep(WaitTime.medium); click(SearchButton,
				 * "search");
				 */
				clearAndSenKeys(PolicyNoSearch, EndorsementNo1, "Fetch Endorsement No");
				Thread.sleep(WaitTime.medium);
				click(SearchButton, "search");

				driver.findElement(By.xpath("//input[@id='Policy No.']")).sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(2000);
				click(driver.findElement(By.xpath("//a[contains(text(),'"+dataRow.getProperty("Policy No")+"')]")),"policy no");
				Thread.sleep(2000);
				String parentWindow2 = driver.getWindowHandle();
				Thread.sleep(WaitTime.low);
				switchtodefaultframe(driver);
				switchtoframe(driver,"display");
				Thread.sleep(WaitTime.low);
				switchtoframe(driver,"containerFrame");
				Thread.sleep(WaitTime.low);

				click(EndorsementMemberCode, " Click on Member code");
				
				String parentWindow = driver.getWindowHandle();

				switchToWindow(driver);
				Thread.sleep(WaitTime.low);
				
				
				selectFromDropdownByVisibleText(memberSubStatus,dataRow.getProperty("MemberSubStatus"),"Selection of Member Sub Status");
				click(saveBTN, "Click on Save Button");
				click(Okbutton, "Ok Button");

				driver.close();
				driver.switchTo().window(parentWindow);

				//switchtoframe(driver,"containerFrame");
				//click(policySummeryTab, "Policy Summery");
				/*
				 * switchtodefaultframe(driver); switchtoframe(driver, "head");
				 * 
				 * switchtoframe(driver,"display");
				 */
				Thread.sleep(WaitTime.high);
				switchtoframe(driver,"display");
				switchtoframe(driver,"containerFrame");
				click(membericon,"Member Icon");
				/*
				 * driver.switchTo().defaultContent(); Thread.sleep(WaitTime.low); String
				 * parentWindow3 = driver.getWindowHandle(); Thread.sleep(WaitTime.low);
				 * switchtodefaultframe(driver); switchtoframe(driver,"display");
				 * Thread.sleep(WaitTime.low); switchtoframe(driver,"containerFrame");
				 * Thread.sleep(WaitTime.low);
				 */


			}

			Thread.sleep(2000);
			String endorsementsts=EndorsementStatus.getText();
			System.out.println("Endorsment Status: "+endorsementsts);
			Reporter.log("----------");
			Reporter.log("Endorsement Status Display as:  "+endorsementsts);

			System.out.println("Endorsement Completed");
		}

	}

	public void fillEndorsementFlow(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		fillEndorsement(driver, testCaseName, workbook, conn, stepGroup, customAssert);

	}
}
