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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import constants.PropertyConfigs;
import util.ConfigReader;
import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.WaitTime;

public class NSTPFamily_Flow extends GenericMethods {

	// Questionnaire tab
	@FindBy(xpath = "//md-tab-item[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple']//span[@class='ng-scope'][contains(text(),'Questionnaire')]")
	private WebElement Questionnairetab;

	// Questions
	@FindBy(xpath = "//md-tab-content[@id='tab-content-0']//tr[18]//td[2]/following::input[1]")
	private WebElement PolioQuest;

	@FindBy(xpath = "//md-tab-content[@id='tab-content-0']//tr[18]//td[2]/following::textarea[1]")
	private WebElement PolioTextBox;

	@FindBy(xpath = "//td[contains(text(),'Is any of the persons proposed to be insured under')]/following::input[1]")
	private WebElement OtherthanvitaminpillsQuest;

	@FindBy(xpath = "//td[contains(text(),'Is any of the persons proposed to be insured under')]/following::textarea[1]")
	private WebElement OtherthanvitaminpillsTextbox;

	@FindBy(xpath = "//md-tab-content[@id='tab-content-0']//tr[20]//td[2]/following::input[1]")
	private WebElement BloodtestsQuest;

	@FindBy(xpath = "//md-tab-content[@id='tab-content-0']//tr[20]//td[2]/following::textarea[1]")
	private WebElement BloodtestsTextbox;

	@FindBy(xpath = "//md-tab-content[@id='tab-content-0']//tr[21]//td[2]/following::input[1]")
	private WebElement SurgeryQuest;

	@FindBy(xpath = "//md-tab-content[@id='tab-content-0']//tr[21]//td[2]/following::textarea[1]")
	private WebElement SurgeryTextbox;

	@FindBy(xpath = "//td[contains(text(),'Has any of the persons proposed to be insured Suff')]/following::input[1]")
	private WebElement viralfeverQuest;

	@FindBy(xpath = "//td[contains(text(),'Has any of the persons proposed to be insured Suff')]/following::textarea[1]")
	private WebElement viralfeverTextbox;

	@FindBy(xpath = "//td[contains(text(),'Any of the insured persons is pregnant? If yes, pl')]/following::input[1]")
	private WebElement dateofdeliveryQuest;

	@FindBy(xpath = "//td[contains(text(),'Any of the insured persons is pregnant? If yes, pl')]/following::textarea[1]")
	private WebElement dateofdeliveryTextbox;

	@FindBy(xpath = "//td[contains(text(),'Whether there is diabetes, hypertension or any oth')]/following::input[1]")
	private WebElement earlierpregnancyQuest;

	@FindBy(xpath = "//td[contains(text(),'Whether there is diabetes, hypertension or any oth')]/following::textarea[1]")
	private WebElement earlierpregnancyTextbox;

	@FindBy(xpath = "//td[contains(text(),'Smoke or consume tobacco in any form, or alcohol')]/following::input[1]")
	private WebElement PersonalHabbitsQuest;
	
	@FindBy(xpath = "//td[contains(text(),'Smoke or consume tobacco in any form, or alcohol')]/following::textarea[1]")
	private WebElement PersonalHabbitsTextbox;
	
	@FindBy(xpath = "//div[contains(text(),'Cigarettes per day')]/following::input[1]")
	private WebElement CigarettesPerDayTextbox;
	
	@FindBy(xpath = "//div[contains(text(),'insured smokes')]/following::input[1]")
	private WebElement NoOfyrsSmokeTextbox;
	
	@FindBy(xpath = "//div[contains(text(),'Amount per day')]/following::input[1]")
	private WebElement TobaccoPerDayTextbox;
	
	@FindBy(xpath = "//div[contains(text(),'Number of years for which the proposed to be insured consumes tobacco')]/following::input[1]")
	private WebElement NoOfyrsTobaccoTextbox;
	
	@FindBy(xpath = "//div[contains(text(),'Number of units')]/following::input[1]")
	private WebElement WeeklyAlcoholTextbox;
	
	@FindBy(xpath = "//div[contains(text(),'Number of years for which the proposed to be insured consumes alcohol')]/following::input[1]")
	private WebElement NoOfyrsAlcoholTextbox;
	
	
	@FindBy(xpath = "//label[@id='Sub-Status']")
	private WebElement RuleEngineStatus;

	@FindBy(xpath = "//input[@id='pUserName']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='textfield2']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='textfield4']")
	private WebElement role;

	@FindBy(xpath = "//strong[contains(text(),'LOGIN')]")
	private WebElement loginBTN;

	@FindBy(xpath = "//i[@id='roleIcon']")
	private WebElement roleCLICK;

	@FindBy(xpath = "(//p[contains(text(),'Policy Management')])[1]")
	private WebElement PolicyManagement;

	@FindBy(xpath = "//input[@id='Policy No.']")
	private WebElement QuoteNoSearch;

	@FindBy(xpath = "//button[@id='Search']")
	private WebElement SearchButton;

	@FindBy(xpath = "//label[@ng-model='clmGridData.strParameterValue']")
	private WebElement memberCode;

	@FindBy(xpath = "//input[@id='Mobile Number']")
	private WebElement mobileNumber;

	@FindBy(xpath = "//input[@id='Height of the Insured (in cms)']")
	private WebElement heightCm;

	@FindBy(xpath = "//input[@id='Weight (in kgs)']")
	private WebElement weightinKG;

	@FindBy(xpath = "//input[@id='BMI']")
	private WebElement bmi;

	@FindBy(xpath = "//select[@id='Nationality']")
	private WebElement nationality;

	@FindBy(xpath = "//input[@id='country of residence']")
	private WebElement countryofResidence;

	@FindBy(xpath = "//input[@id='occupation']")
	private WebElement occupation;

	@FindBy(xpath = "//select[@id='Applicable Sum Insured']")
	private WebElement sumInsured;

	@FindBy(xpath = "//select[@id='Room Category']")
	private WebElement roomCategory;

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

	@FindBy(xpath = "//input[@id='Policy-holder ZIP Code']")
	private WebElement Pincode;

	@FindBy(xpath = "//input[@id='Policy-holder City']")
	private WebElement city;

	@FindBy(xpath = "//input[@id='District Name']")
	private WebElement districtName;

	@FindBy(xpath = "//input[@id='Policy-holder Province']")
	private WebElement state;

	@FindBy(xpath = "//select[@id='Zone']")
	private WebElement zone;

	@FindBy(xpath = "//select[@id='Opted zone']")
	private WebElement Optedzone;

	@FindBy(xpath = "(//a[@name='Policy Summary'])[2]")
	private WebElement policysummary;

	@FindBy(xpath = "//button[@id='Submit']")
	private WebElement subbtn;

	@FindBy(xpath = "//button[@id='moreInfo']")
	private WebElement subbtn3;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement Continue;

	@FindBy(xpath = "//button[@id='SaveButton']")
	private WebElement SaveButton;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement Okbutton;

	@FindBy(xpath = "//button[@id='DataEntry1Completed']")
	private WebElement DataEntry1;

	@FindBy(xpath = "//button[@id='sendQCBtn']")
	private WebElement SubmitButton;

	@FindBy(xpath = "//button[@id='issuePolicyBtn']")
	private WebElement issuepolicy;

	// Member icon
	@FindBy(xpath = "//a[@title='Member Info']/i")
	private WebElement membericon;

	// Policy Number
	@FindBy(xpath = "//label[@id='Number']")
	private WebElement policynumber;

	// Close
	@FindBy(xpath = "//button[@id='CloseButton']")
	private WebElement closebutton;

	// Follow Up
	@FindBy(xpath = "(//a[@name='Follow-up'])[2]")
	private WebElement FollowUp;

	@FindBy(xpath = "//button[@id='btncontinue']")
	private WebElement continuebtn;

	@FindBy(xpath = "//label[@id='Sub-Status']")
	private WebElement DataEntryCompleted;

	// Requirements icon
	@FindBy(xpath = "//a[@name='Requirements']/i")
	private WebElement requirementsIcon;

	// Selection Dropdown 1
	@FindBy(xpath = "//div[contains(text(),'ID Proof')]//following::select[2]")
	private WebElement Optional1;

	// Selection Dropdown 2
	@FindBy(xpath = "//div[contains(text(),'AddressProof')]//following::select[2]")
	private WebElement Optional2;

	// Selection Dropdown 3
	@FindBy(xpath = "//div[contains(text(),'Passport')]//following::select[2]")
	private WebElement Optional3;

	// Selection Dropdown 4
	@FindBy(xpath = "//div[contains(text(),'Declaration for Staying in India')]//following::select[2]")
	private WebElement Optional4;

	// Selection Dropdown 5
	@FindBy(xpath = "//div[contains(text(),'Health Declaration Form')]//following::select[2]")
	private WebElement Optional5;

	// Save
	@FindBy(xpath = "//button[@id='SaveRequire']")
	private WebElement saverequire;

	// Ok Button Click
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement OK;

	@FindBy(xpath = "//select[@id='Manual Underwriting Required?']")
	private WebElement ManualUnderwriting;

	// Policy Number
	@FindBy(xpath = "//label[contains(text(),'Quote/Policy Number')]//following::label[1]")
	private WebElement QuoteNumber;

	WebDriverWait wait;

	public NSTPFamily_Flow(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void fillNSTPFlow(WebDriver driver, String testCaseName, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName, stepGroup);
		Reporter.log("<B>Traverse To CommonPage</B>");

		// BOPS to COPS
		switchtodefaultframe(driver);
		switchtoframe(driver, "head");

		click(roleCLICK, "Role Click");

		click(driver.findElement(By.xpath("//div[contains(text(),'COPS')]")), "Selected Role as COPS");

		Thread.sleep(WaitTime.medium);

		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		click(PolicyManagement, "Policy Management tab");

		Thread.sleep(WaitTime.medium);
		clearAndSenKeys(QuoteNoSearch, getQuoteNo(testCaseName), "Quote No Input");
		Thread.sleep(WaitTime.medium);
		click(SearchButton, "search");
		driver.findElement(By.xpath("//input[@id='Policy No.']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(WaitTime.medium);
		click(driver.findElement(By.xpath("//a[contains(text(),'" + getQuoteNo(testCaseName) + "')]")), "Quote no");
		Thread.sleep(WaitTime.medium);

		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		Thread.sleep(WaitTime.low);
		click(membericon, "Member Icon");
		Thread.sleep(WaitTime.medium);
		switchtoframe(driver, "containerFrame");
		Thread.sleep(WaitTime.medium);

		if (dataRow.getProperty("Product").equalsIgnoreCase("Arogya Sanjeevani Policy (4225)")
				|| dataRow.getProperty("Product").equalsIgnoreCase("Activ Health (4212)")) {

			if (dataRow.getProperty("Policy Type").equalsIgnoreCase("Family Floater")) {

				String NoOfMem = dataRow.getProperty("Relation");
				String NoOfMem2 = NoOfMem.replace(" ", "");
				ArrayList<String> myList1 = new ArrayList<String>(Arrays.asList(NoOfMem2.split("\\+")));

				String height = dataRow.getProperty("HeightCm");
				String heightcm = height.replace(" ", "");
				ArrayList<String> heightinCm = new ArrayList<String>(Arrays.asList(heightcm.split("\\+")));

				String weight = dataRow.getProperty("WeightInKG");
				String weightkg = weight.replace(" ", "");
				ArrayList<String> weightinkg = new ArrayList<String>(Arrays.asList(weightkg.split("\\+")));

				String Occupation = dataRow.getProperty("Occupation");
				ArrayList<String> Occupationli = new ArrayList<String>(Arrays.asList(Occupation.split("\\+")));

				String zoneval = dataRow.getProperty("Zone");
				// String zoneval1 = zoneval.replace(" ", "");
				ArrayList<String> zonelist = new ArrayList<String>(Arrays.asList(zoneval.split("\\+")));
				
				String QuestionarrieFlag = dataRow.getProperty("QuestionnaireConfig");
				ArrayList<String> QuestionarrieList = new ArrayList<String>(Arrays.asList(QuestionarrieFlag.split("\\+")));
				
				String PolioQuestflag = dataRow.getProperty("PolioQuestConfig");
				ArrayList<String> PolioQuestlist = new ArrayList<String>(Arrays.asList(PolioQuestflag.split("\\+")));
				
				String vitaminpillsQuestFlag = dataRow.getProperty("OtherthanvitaminpillsQuestConfig");
				ArrayList<String> vitaminpillsQuestList = new ArrayList<String>(Arrays.asList(vitaminpillsQuestFlag.split("\\+")));
				
				String BloodtestsQuestFlag = dataRow.getProperty("BloodtestsQuestConfig");
				ArrayList<String> BloodtestsQuestList = new ArrayList<String>(Arrays.asList(BloodtestsQuestFlag.split("\\+")));
				
				String SurgeryQuestFlag = dataRow.getProperty("SurgeryQuestConfig");
				ArrayList<String> SurgeryQuestFlagList = new ArrayList<String>(Arrays.asList(SurgeryQuestFlag.split("\\+")));
				
				String viralfeverQuestFlag = dataRow.getProperty("viralfeverQuestConfig");
				ArrayList<String> viralfeverQuestFlagList = new ArrayList<String>(Arrays.asList(viralfeverQuestFlag.split("\\+")));
				
				String dateofdeliveryQuestFlag = dataRow.getProperty("dateofdeliveryQuestConfig");
				ArrayList<String> dateofdeliveryQuestList = new ArrayList<String>(Arrays.asList(dateofdeliveryQuestFlag.split("\\+")));
				
				String earlierpregnancyQuestFlag = dataRow.getProperty("earlierpregnancyQuestConfig");
				ArrayList<String> earlierpregnancyQuestList = new ArrayList<String>(Arrays.asList(earlierpregnancyQuestFlag.split("\\+")));
				
				String PersonalHabbitQuestFlag = dataRow.getProperty("PersonalHabbitQuestConfig");
				ArrayList<String> PersonalHabbitQuestList = new ArrayList<String>(Arrays.asList(PersonalHabbitQuestFlag.split("\\+")));
				
				String PersonalHabbitFlag = dataRow.getProperty("PersonalHabbitTextbox");
				ArrayList<String> PersonalHabbitList = new ArrayList<String>(Arrays.asList(PersonalHabbitFlag.split("\\+")));

				
				for (int x = 0; x < myList1.size(); x++) {
					int y = x + 1;

					WebElement SerialNo = driver
							.findElement(By.xpath("//div[contains(text(),'Serial No')]//following::label[" + y + "]"));

					if (y == 1) {
						Thread.sleep(WaitTime.medium);
						click(SerialNo, "Serial Number clicked");
						switchtoframe(driver, "memberiframe" + x);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(heightCm, heightinCm.get(x), "Height in Cm");
						Thread.sleep(WaitTime.low);

						clearAndSenKeys(weightinKG, weightinkg.get(x), "Weight In KG");
						Thread.sleep(WaitTime.medium);
						weightinKG.sendKeys(Keys.TAB);

						// occupation
						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(occupation, Occupationli.get(x), "Occupation");
						Thread.sleep(WaitTime.veryHigh);
						driver.findElement(By.xpath("//span[contains(text(),'"+Occupationli.get(x)+"')]")).click();

						/*
						 * Thread.sleep(WaitTime.medium);
						 * selectFromDropdownByVisibleText(ManualUnderwriting,dataRow.getProperty(
						 * "Manual_UWR"),"Manual Underwriting"); Thread.sleep(WaitTime.low);
						 */

						if (dataRow.getProperty("IsChronic").equalsIgnoreCase("Yes")) {
							String Chronic = dataRow.getProperty("Chronic");
							ArrayList Chroniclist = new ArrayList(Arrays.asList(Chronic.split(",")));
							for (int i = 0; i < Chroniclist.size(); i++) {
								WebElement Chronicclick = driver.findElement(
										By.xpath("(//option[contains(text(),'" + Chroniclist.get(i) + "')])[1]"));

								clickWithoutJavaScript(Chronicclick, " Chronic ");
								Reporter.log(" as " + Chroniclist.get(i));
							}
						}

						Thread.sleep(WaitTime.medium);
						selectFromDropdownByVisibleText(Optedzone, zonelist.get(x), "Zone");
						Thread.sleep(WaitTime.low);

						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
						click(SaveButton, "Save");
						Thread.sleep(WaitTime.medium);
						click(Okbutton, "Ok Button");
						Thread.sleep(WaitTime.low);

//Questionnaires

						if (QuestionarrieList.get(x).equalsIgnoreCase("Yes")) {

							Thread.sleep(WaitTime.medium);
							click(Questionnairetab, "Questionnaire tab");
							Thread.sleep(WaitTime.low);

							if(PolioQuestlist.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(PolioQuest, "Polio Question RadioButton");
							Thread.sleep(WaitTime.low);
							

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(PolioTextBox, dataRow.getProperty("PolioTextBox"), "Polio TextBox");
							Thread.sleep(WaitTime.low);
							
							}
							
							if(vitaminpillsQuestList.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(OtherthanvitaminpillsQuest, "Otherthanvitaminpills Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(OtherthanvitaminpillsTextbox,dataRow.getProperty("OtherthanvitaminpillsTextbox"),"Other than vitamin pills Textbox");
							Thread.sleep(WaitTime.low);
							}
							
							if(BloodtestsQuestList.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(BloodtestsQuest, "Bloodtests Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(BloodtestsTextbox, dataRow.getProperty("BloodtestsTextbox"),"Bloodtests Textbox");
							Thread.sleep(WaitTime.low);
							}
							
							if(SurgeryQuestFlagList.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(SurgeryQuest, "Surgery Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(SurgeryTextbox, dataRow.getProperty("SurgeryTextbox"), "Surgery Textbox");
							Thread.sleep(WaitTime.low);

							}
							
							if(viralfeverQuestFlagList.get(x).equalsIgnoreCase("Yes")) {
								
							Thread.sleep(WaitTime.medium);
							click(viralfeverQuest, "viralfever Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(viralfeverTextbox, dataRow.getProperty("viralfeverTextbox"),"viralfever Textbox");
							Thread.sleep(WaitTime.low);
							}
							
							if(dateofdeliveryQuestList.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(dateofdeliveryQuest, "dateofdelivery Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(dateofdeliveryTextbox, dataRow.getProperty("dateofdeliveryTextbox"),"date of delivery Textbox");
							Thread.sleep(WaitTime.low);
							}
							
							if(earlierpregnancyQuestList.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(earlierpregnancyQuest, "earlierpregnancy Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(earlierpregnancyTextbox, dataRow.getProperty("earlierpregnancyTextbox"),"earlier pregnancy Textbox");
							Thread.sleep(WaitTime.low);
							}
							
							if(PersonalHabbitQuestList.get(x).equalsIgnoreCase("Yes")) {
								
								Thread.sleep(WaitTime.medium);
								click(PersonalHabbitsQuest, "PersonalHabbits Question RadioButton");
								Thread.sleep(WaitTime.low);
								
								Thread.sleep(WaitTime.medium);
								clearAndSenKeys(PersonalHabbitsTextbox, PersonalHabbitList.get(x) ,"Personal Habbits");
								Thread.sleep(WaitTime.low);
								
								String Smoke_Count = dataRow.getProperty("Smoke_Count");
								ArrayList<String> Smoke_CountList = new ArrayList<String>(Arrays.asList(Smoke_Count.split("\\+")));
								
								String Tobacco_Count = dataRow.getProperty("Tobacco_Count");
								ArrayList<String> Tobacco_CountList = new ArrayList<String>(Arrays.asList(Tobacco_Count.split("\\+")));
								
								String Alcohol_Count = dataRow.getProperty("Alcohol_Count");
								ArrayList<String> Alcohol_CountList = new ArrayList<String>(Arrays.asList(Alcohol_Count.split("\\+")));
								
								Thread.sleep(WaitTime.medium);
								clearAndSenKeys(CigarettesPerDayTextbox, Smoke_CountList.get(x),"Cigarettes PerDay Textbox");
								Thread.sleep(WaitTime.low);
								
								Thread.sleep(WaitTime.medium);
								clearAndSenKeys(TobaccoPerDayTextbox, Tobacco_CountList.get(x),"Tobacco PerDay Textbox");
								Thread.sleep(WaitTime.low);
								
								Thread.sleep(WaitTime.medium);
								clearAndSenKeys(WeeklyAlcoholTextbox, Alcohol_CountList.get(x),"Weekly Alcohol Textbox");
								Thread.sleep(WaitTime.low);
								
							}

							click(SaveButton, "Save");
							Thread.sleep(WaitTime.medium);
							click(Okbutton, "Ok Button");
							Thread.sleep(WaitTime.medium);

						}

						switchtodefaultframe(driver);
						switchtoframe(driver, "display");
						Thread.sleep(WaitTime.medium);
						click(membericon, "Member Icon");
						Thread.sleep(WaitTime.medium);
						switchtoframe(driver, "containerFrame");
						Thread.sleep(WaitTime.low);

					}

					else if (y > 1) {
						Thread.sleep(WaitTime.medium);
						click(driver.findElement(By.xpath("//div[contains(text(),'Serial No')]/following::label[@id='Serial No'][" + y + "]")),"Serial Number clicked");
						switchtoframe(driver, "memberiframe" + x);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(mobileNumber, dataRow.getProperty("Mobile Number"), "Mobile No");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(heightCm, heightinCm.get(x), "Height in Cm");
						Thread.sleep(WaitTime.medium);

						clearAndSenKeys(weightinKG, weightinkg.get(x), "Weight In KG");
						Thread.sleep(WaitTime.medium);
						weightinKG.sendKeys(Keys.TAB);

						Thread.sleep(WaitTime.medium);
						selectFromDropdownByVisibleText(nationality, dataRow.getProperty("Nationality"), "Nationality");
						Thread.sleep(WaitTime.high);

//						clearAndSenKeys(countryofResidence, dataRow.getProperty("Country of Residence"),
//								"Country of Residence");
//						Thread.sleep(WaitTime.veryHigh);
//						click(driver.findElement(By.xpath("//span[contains(text(),'" + dataRow.getProperty("Country of Residence") + "')]")),"Clicked on coutry");
//						Thread.sleep(WaitTime.medium);

						clearAndSenKeys(occupation, Occupationli.get(x), "Occupation");
						Thread.sleep(WaitTime.veryHigh);
						driver.findElement(By.xpath("//span[contains(text(),'"+Occupationli.get(x)+"')]")).click();
						Thread.sleep(WaitTime.medium);

						/*
						 * Thread.sleep(WaitTime.medium);
						 * selectFromDropdownByVisibleText(ManualUnderwriting,dataRow.getProperty(
						 * "Manual_UWR"),"Manual Underwriting"); Thread.sleep(WaitTime.low);
						 */

						if (dataRow.getProperty("IsChronic").equalsIgnoreCase("Yes")) {
							String Chronic = dataRow.getProperty("Chronic");
							ArrayList Chroniclist = new ArrayList(Arrays.asList(Chronic.split(",")));
							for (int i = 0; i < Chroniclist.size(); i++) {
								WebElement Chronicclick = driver.findElement(By.xpath("(//option[contains(text(),'" + Chroniclist.get(i) + "')])[1]"));
								clickWithoutJavaScript(Chronicclick, " Chronic ");
								Reporter.log(" as " + Chroniclist.get(i));
							}
						}

//						Thread.sleep(WaitTime.medium);
//						selectFromDropdownByVisibleText(hniCustomer, "No","Hni Customer");
//						Thread.sleep(WaitTime.low);

//						Thread.sleep(WaitTime.medium);
//						selectFromDropdownByVisibleText(CEOClubAdvisorCustomer, "No","CEO Club Advisor Customer");
//						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						selectFromDropdownByVisibleText(priorityCustomer, "No","Priority Customer");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						selectFromDropdownByVisibleText(sensitiveCustomerr, "No","Sensitive Customer");
						Thread.sleep(WaitTime.low);

						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
						click(SaveButton, "Save");
						Thread.sleep(WaitTime.medium);
						click(Okbutton, "Ok Button");
						Thread.sleep(WaitTime.low);

//Questionnaires

						if (QuestionarrieList.get(x).equalsIgnoreCase("Yes")) {

							Thread.sleep(WaitTime.medium);
							click(Questionnairetab, "Questionnaire tab");
							Thread.sleep(WaitTime.low);

							if(PolioQuestlist.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(PolioQuest, "Polio Question RadioButton");
							Thread.sleep(WaitTime.low);
							

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(PolioTextBox, dataRow.getProperty("PolioTextBox"), "Polio TextBox");
							Thread.sleep(WaitTime.low);
							
							}
							
							if(vitaminpillsQuestList.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(OtherthanvitaminpillsQuest, "Otherthanvitaminpills Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(OtherthanvitaminpillsTextbox,dataRow.getProperty("OtherthanvitaminpillsTextbox"),"Other than vitamin pills Textbox");
							Thread.sleep(WaitTime.low);
							}
							
							if(BloodtestsQuestList.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(BloodtestsQuest, "Bloodtests Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(BloodtestsTextbox, dataRow.getProperty("BloodtestsTextbox"),"Bloodtests Textbox");
							Thread.sleep(WaitTime.low);
							}
							
							if(SurgeryQuestFlagList.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(SurgeryQuest, "Surgery Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(SurgeryTextbox, dataRow.getProperty("SurgeryTextbox"), "Surgery Textbox");
							Thread.sleep(WaitTime.low);

							}
							
							if(viralfeverQuestFlagList.get(x).equalsIgnoreCase("Yes")) {
								
							Thread.sleep(WaitTime.medium);
							click(viralfeverQuest, "viralfever Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(viralfeverTextbox, dataRow.getProperty("viralfeverTextbox"),"viralfever Textbox");
							Thread.sleep(WaitTime.low);
							}
							
							if(dateofdeliveryQuestList.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(dateofdeliveryQuest, "dateofdelivery Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(dateofdeliveryTextbox, dataRow.getProperty("dateofdeliveryTextbox"),"date of delivery Textbox");
							Thread.sleep(WaitTime.low);
							}
							
							if(earlierpregnancyQuestList.get(x).equalsIgnoreCase("Yes")) {
							
							Thread.sleep(WaitTime.medium);
							click(earlierpregnancyQuest, "earlierpregnancy Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(earlierpregnancyTextbox, dataRow.getProperty("earlierpregnancyTextbox"),"earlier pregnancy Textbox");
							Thread.sleep(WaitTime.low);
							}
							
							if(PersonalHabbitList.get(x).equalsIgnoreCase("Yes")) {
								
								Thread.sleep(WaitTime.medium);
								click(PersonalHabbitsQuest, "PersonalHabbits Question RadioButton");
								Thread.sleep(WaitTime.low);
								
								Thread.sleep(WaitTime.medium);
								clearAndSenKeys(PersonalHabbitsTextbox, PersonalHabbitList.get(x) ,"Personal Habbits");
								Thread.sleep(WaitTime.low);
								
								String Smoke_Count = dataRow.getProperty("Smoke_Count");
								ArrayList<String> Smoke_CountList = new ArrayList<String>(Arrays.asList(Smoke_Count.split("\\+")));
								
								String Tobacco_Count = dataRow.getProperty("Tobacco_Count");
								ArrayList<String> Tobacco_CountList = new ArrayList<String>(Arrays.asList(Tobacco_Count.split("\\+")));
								
								String Alcohol_Count = dataRow.getProperty("Alcohol_Count");
								ArrayList<String> Alcohol_CountList = new ArrayList<String>(Arrays.asList(Alcohol_Count.split("\\+")));
								
								Thread.sleep(WaitTime.medium);
								clearAndSenKeys(CigarettesPerDayTextbox, Smoke_CountList.get(x),"Cigarettes PerDay Textbox");
								Thread.sleep(WaitTime.low);
								
								Thread.sleep(WaitTime.medium);
								clearAndSenKeys(TobaccoPerDayTextbox, Tobacco_CountList.get(x),"Tobacco PerDay Textbox");
								Thread.sleep(WaitTime.low);
								
								Thread.sleep(WaitTime.medium);
								clearAndSenKeys(WeeklyAlcoholTextbox, Alcohol_CountList.get(x),"Weekly Alcohol Textbox");
								Thread.sleep(WaitTime.low);
							}	
							
							
							click(SaveButton, "Save");
							Thread.sleep(WaitTime.medium);
							click(Okbutton, "Ok Button");
							Thread.sleep(WaitTime.low);
						}

						Thread.sleep(WaitTime.low);
						switchtodefaultframe(driver);
						switchtoframe(driver, "display");
						Thread.sleep(WaitTime.low);
						click(membericon, "Member Icon");
						Thread.sleep(WaitTime.medium);
						switchtoframe(driver, "containerFrame");
						Thread.sleep(WaitTime.low);

					}
				}
			}

			if (dataRow.getProperty("Policy Type").equalsIgnoreCase("Multi-Individual")) {

				String NoOfMem = dataRow.getProperty("Relation");
				String NoOfMem2 = NoOfMem.replace(" ", "");
				ArrayList<String> myList1 = new ArrayList<String>(Arrays.asList(NoOfMem2.split("\\+")));

				String height = dataRow.getProperty("HeightCm");
				String heightcm = height.replace(" ", "");
				ArrayList<String> heightinCm = new ArrayList<String>(Arrays.asList(heightcm.split("\\+")));

				String weight = dataRow.getProperty("WeightInKG");
				String weightkg = weight.replace(" ", "");
				ArrayList<String> weightinkg = new ArrayList<String>(Arrays.asList(weightkg.split("\\+")));

				String Occupation = dataRow.getProperty("Occupation");
				ArrayList<String> Occupationli = new ArrayList<String>(Arrays.asList(Occupation.split("\\+")));

				String zoneval = dataRow.getProperty("Zone");
				// String zoneval1 = zoneval.replace(" ", "");
				ArrayList<String> zonelist = new ArrayList<String>(Arrays.asList(zoneval.split("\\+")));

				for (int x = 0; x < myList1.size(); x++) {
					int y = x + 1;

					WebElement SerialNo = driver
							.findElement(By.xpath("//div[contains(text(),'Serial No')]//following::label[" + y + "]"));

					if (y == 1) {
						
						Thread.sleep(WaitTime.medium);
						click(SerialNo, "Serial Number clicked");
						switchtoframe(driver, "memberiframe" + x);
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(heightCm, heightinCm.get(x), "Height in Cm");
						Thread.sleep(WaitTime.medium);

						clearAndSenKeys(weightinKG, weightinkg.get(x), "Weight In KG");
						Thread.sleep(WaitTime.medium);
						weightinKG.sendKeys(Keys.TAB);

						// occupation
						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(occupation, Occupationli.get(x), "Occupation");
						Thread.sleep(WaitTime.veryHigh);
						driver.findElement(By.xpath("//span[contains(text(),'" + Occupationli.get(x) + "')]")).click();

						/*
						 * Thread.sleep(WaitTime.medium);
						 * selectFromDropdownByVisibleText(ManualUnderwriting,dataRow.getProperty(
						 * "Manual_UWR"),"Manual Underwriting"); Thread.sleep(WaitTime.low);
						 */

						if (dataRow.getProperty("IsChronic").equalsIgnoreCase("Yes")) {
							String Chronic = dataRow.getProperty("Chronic");
							ArrayList Chroniclist = new ArrayList(Arrays.asList(Chronic.split(",")));
							for (int i = 0; i < Chroniclist.size(); i++) {
								WebElement Chronicclick = driver.findElement(
										By.xpath("(//option[contains(text(),'" + Chroniclist.get(i) + "')])[1]"));
								clickWithoutJavaScript(Chronicclick, " Chronic ");
								Reporter.log(" as " + Chroniclist.get(i));
							}
						}

						Thread.sleep(WaitTime.medium);
						selectFromDropdownByVisibleText(Optedzone, zonelist.get(x), "Zone");
						Thread.sleep(WaitTime.low);

						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
						  click(SaveButton, "Save"); 
						  Thread.sleep(WaitTime.medium); 
						  click(Okbutton,"Ok Button"); 
						  Thread.sleep(WaitTime.medium);
						 

//Questionnaires

						if (dataRow.getProperty("QuestionnaireConfig").equalsIgnoreCase("Yes")) {

							Thread.sleep(WaitTime.medium);
							click(Questionnairetab, "Questionnaire tab");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							click(PolioQuest, "Polio Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(PolioTextBox, dataRow.getProperty("PolioTextBox"), "Polio TextBox");
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
							clearAndSenKeys(BloodtestsTextbox, dataRow.getProperty("BloodtestsTextbox"),"Bloodtests Textbox");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							click(SurgeryQuest, "Surgery Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(SurgeryTextbox, dataRow.getProperty("SurgeryTextbox"), "Surgery Textbox");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							click(viralfeverQuest, "viralfever Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(viralfeverTextbox, dataRow.getProperty("viralfeverTextbox"),"viralfever Textbox");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							click(dateofdeliveryQuest, "dateofdelivery Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(dateofdeliveryTextbox, dataRow.getProperty("dateofdeliveryTextbox"),"date of delivery Textbox");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							click(earlierpregnancyQuest, "earlierpregnancy Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(earlierpregnancyTextbox, dataRow.getProperty("earlierpregnancyTextbox"),"earlier pregnancy Textbox");
							Thread.sleep(WaitTime.low);
							
							click(SaveButton, "Save");
							Thread.sleep(WaitTime.medium);
							click(Okbutton, "Ok Button");
							Thread.sleep(WaitTime.medium);

						}

						switchtodefaultframe(driver);
						switchtoframe(driver, "display");
						Thread.sleep(WaitTime.low);
						click(membericon, "Member Icon");
						Thread.sleep(WaitTime.medium);
						switchtoframe(driver, "containerFrame");
						Thread.sleep(WaitTime.low);

					}

					else if (y > 1) {
						Thread.sleep(WaitTime.medium);
						click(driver.findElement(By.xpath("//div[contains(text(),'Serial No')]/following::label[@id='Serial No'][" + y + "]")),"Serial Number clicked");
						switchtoframe(driver, "memberiframe" + x);
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(mobileNumber, dataRow.getProperty("Mobile Number"), "Mobile No");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(heightCm, heightinCm.get(x), "Height in Cm");
						Thread.sleep(WaitTime.low);

						clearAndSenKeys(weightinKG, weightinkg.get(x), "Weight In KG");
						Thread.sleep(WaitTime.low);
						weightinKG.sendKeys(Keys.TAB);

						Thread.sleep(WaitTime.medium);
						selectFromDropdownByVisibleText(nationality, dataRow.getProperty("Nationality"), "Nationality");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(countryofResidence, dataRow.getProperty("Country of Residence"),
								"Country of Residence");
						Thread.sleep(WaitTime.veryHigh);
						click(driver.findElement(By.xpath("//span[contains(text(),'" + dataRow.getProperty("Country of Residence") + "')]")),"Clicked on coutry");

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(occupation, Occupationli.get(x), "Occupation");
						Thread.sleep(WaitTime.veryHigh);
						driver.findElement(By.xpath("//span[contains(text(),'" + Occupationli.get(x) + "')]")).click();
						Thread.sleep(WaitTime.medium);

						/*
						 * selectFromDropdownByVisibleText(ManualUnderwriting,dataRow.getProperty(
						 * "Manual_UWR"),"Manual Underwriting"); Thread.sleep(WaitTime.low);
						 */

						if (dataRow.getProperty("IsChronic").equalsIgnoreCase("Yes")) {
							String Chronic = dataRow.getProperty("Chronic");
							ArrayList Chroniclist = new ArrayList(Arrays.asList(Chronic.split(",")));
							for (int i = 0; i < Chroniclist.size(); i++) {
								WebElement Chronicclick = driver.findElement(By.xpath("(//option[contains(text(),'" + Chroniclist.get(i) + "')])[1]"));
								clickWithoutJavaScript(Chronicclick, " Chronic ");
								Reporter.log(" as " + Chroniclist.get(i));
							}
						}

//						Thread.sleep(WaitTime.medium);
//						selectFromDropdownByVisibleText(hniCustomer, "No","Hni Customer");
//						Thread.sleep(WaitTime.low);

//						Thread.sleep(WaitTime.medium);
//						selectFromDropdownByVisibleText(CEOClubAdvisorCustomer, "No","CEO Club Advisor Customer");
//						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						selectFromDropdownByVisibleText(priorityCustomer, "No","Priority Customer");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						selectFromDropdownByVisibleText(sensitiveCustomerr, "No","Sensitive Customer");
						Thread.sleep(WaitTime.low);
						
//						Thread.sleep(WaitTime.medium);
//						selectFromDropdownByVisibleText(Optedzone, zonelist.get(x), "Zone");
//						Thread.sleep(WaitTime.medium);

						((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
						
						  click(SaveButton, "Save"); 
						  Thread.sleep(WaitTime.medium); 
						  click(Okbutton,"Ok Button"); 
						  Thread.sleep(WaitTime.medium);
						 

//Questionnaires

						if (dataRow.getProperty("QuestionnaireConfig").equalsIgnoreCase("Yes")) {

							Thread.sleep(WaitTime.medium);
							click(Questionnairetab, "Questionnaire tab");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							click(PolioQuest, "Polio Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(PolioTextBox, dataRow.getProperty("PolioTextBox"), "Polio TextBox");
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
							clearAndSenKeys(BloodtestsTextbox, dataRow.getProperty("BloodtestsTextbox"),"Bloodtests Textbox");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							click(SurgeryQuest, "Surgery Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(SurgeryTextbox, dataRow.getProperty("SurgeryTextbox"), "Surgery Textbox");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							click(viralfeverQuest, "viralfever Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(viralfeverTextbox, dataRow.getProperty("viralfeverTextbox"),"viralfever Textbox");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							click(dateofdeliveryQuest, "dateofdelivery Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(dateofdeliveryTextbox, dataRow.getProperty("dateofdeliveryTextbox"),"date of delivery Textbox");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							click(earlierpregnancyQuest, "earlierpregnancy Question RadioButton");
							Thread.sleep(WaitTime.low);

							Thread.sleep(WaitTime.medium);
							clearAndSenKeys(earlierpregnancyTextbox, dataRow.getProperty("earlierpregnancyTextbox"),"earlier pregnancy Textbox");
							Thread.sleep(WaitTime.low);
							
							click(SaveButton, "Save");
							Thread.sleep(WaitTime.medium);
							click(Okbutton, "Ok Button");
							Thread.sleep(WaitTime.low);
						}

						
						Thread.sleep(WaitTime.low);
						switchtodefaultframe(driver);
						switchtoframe(driver, "display");
						Thread.sleep(WaitTime.low);
						click(membericon, "Member Icon");
						Thread.sleep(WaitTime.medium);
						switchtoframe(driver, "containerFrame");
						Thread.sleep(WaitTime.low);

					}

				}
			}
		}

		// Else Product

		else {
			String Family1 = dataRow.getProperty("FamilySize");
			String Family2 = Family1.replace(" ", "");
			ArrayList<String> myList1 = new ArrayList<String>(Arrays.asList(Family2.split("\\+")));

			for (int x = 0; x < myList1.size(); x++) {
				int y = x + 1;

				WebElement SerialNo = driver.findElement(By.xpath("//div[contains(text(),'Serial No')]//following::label[" + y + "]"));

				if (y == 1) {
					Thread.sleep(WaitTime.medium);
					click(SerialNo, "Serial Number clicked");
					switchtoframe(driver, "memberiframe" + x);
					Thread.sleep(WaitTime.low);

					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(heightCm, dataRow.getProperty("HeightCm"), "Height in Cm");
					Thread.sleep(WaitTime.low);

					clearAndSenKeys(weightinKG, dataRow.getProperty("WeightInKG"), "Weight In KG");
					Thread.sleep(WaitTime.low);
					weightinKG.sendKeys(Keys.TAB);

					HashMap<String, Integer> BtnPress1 = new HashMap<String, Integer>();
					BtnPress1.put("Self Employed", 1);
					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(occupation, dataRow.getProperty("Occupation"), "Occupation");
					Thread.sleep(WaitTime.low);
					for (String key : BtnPress1.keySet()) {
						if (key.equalsIgnoreCase(dataRow.getProperty("Occupation"))) {
							// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='occupation']"))));
							Thread.sleep(WaitTime.veryHigh);
							driver.findElement(By.xpath("//span[contains(text(),'" + key + "')]")).click();
						}
					}

					if (dataRow.getProperty("IsChronic").equalsIgnoreCase("Yes")) {
						String Chronic = dataRow.getProperty("Chronic");
						ArrayList Chroniclist = new ArrayList(Arrays.asList(Chronic.split(",")));
						for (int i = 0; i < Chroniclist.size(); i++) {
							WebElement Chronicclick = driver.findElement(
									By.xpath("(//option[contains(text(),'" + Chroniclist.get(i) + "')])[1]"));

							clickWithoutJavaScript(Chronicclick, " Chronic ");
							Reporter.log(" as " + Chroniclist.get(i));
						}
					}

					Thread.sleep(WaitTime.medium);
					selectFromDropdownByVisibleText(Optedzone, dataRow.getProperty("Zone"), "Zone");
					Thread.sleep(WaitTime.low);

					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
					click(SaveButton, "Save");
					Thread.sleep(WaitTime.medium);
					click(Okbutton, "Ok Button");
					Thread.sleep(WaitTime.low);

//Questionnaires

					if (dataRow.getProperty("QuestionnaireConfig") == "Yes") {

						Thread.sleep(WaitTime.medium);
						click(Questionnairetab, "Questionnaire tab");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(PolioQuest, "Polio Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(PolioTextBox, dataRow.getProperty("PolioTextBox"), "Polio TextBox");
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
						clearAndSenKeys(BloodtestsTextbox, dataRow.getProperty("BloodtestsTextbox"),"Bloodtests Textbox");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(SurgeryQuest, "Surgery Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(SurgeryTextbox, dataRow.getProperty("SurgeryTextbox"), "Surgery Textbox");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(viralfeverQuest, "viralfever Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(viralfeverTextbox, dataRow.getProperty("viralfeverTextbox"),"viralfever Textbox");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(dateofdeliveryQuest, "dateofdelivery Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(dateofdeliveryTextbox, dataRow.getProperty("dateofdeliveryTextbox"),"date of delivery Textbox");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(earlierpregnancyQuest, "earlierpregnancy Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(earlierpregnancyTextbox, dataRow.getProperty("earlierpregnancyTextbox"),"earlier pregnancy Textbox");
						Thread.sleep(WaitTime.low);

						click(SaveButton, "Save");
						Thread.sleep(WaitTime.medium);
						click(Okbutton, "Ok Button");
						Thread.sleep(WaitTime.low);

					}

					Thread.sleep(WaitTime.low);
					switchtodefaultframe(driver);
					switchtoframe(driver, "display");
					Thread.sleep(WaitTime.low);
					click(membericon, "Member Icon");
					Thread.sleep(WaitTime.medium);
					switchtoframe(driver, "containerFrame");
					Thread.sleep(WaitTime.low);

				}

				else if (y > 1) {
					Thread.sleep(WaitTime.medium);
					click(driver.findElement(By.xpath("//div[contains(text(),'Serial No')]/following::label[@id='Serial No'][" + y + "]")),"Serial Number clicked");
					switchtoframe(driver, "memberiframe" + x);
					Thread.sleep(WaitTime.low);

					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(mobileNumber, "9890122325", "Mobile No");
					Thread.sleep(WaitTime.low);

					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(heightCm, dataRow.getProperty("HeightCm"), "Height in Cm");
					Thread.sleep(WaitTime.low);

					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(weightinKG, dataRow.getProperty("WeightInKG"), "Weight In KG");
					Thread.sleep(WaitTime.low);
					weightinKG.sendKeys(Keys.TAB);

					Thread.sleep(WaitTime.medium);
					selectFromDropdownByVisibleText(nationality, "Indian", "Nationality");
					Thread.sleep(WaitTime.low);

					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(countryofResidence, "India", "Country of Residence");
					click(driver.findElement(By.xpath("//span[contains(text(),'India')]")), "Clicked on coutry");
					countryofResidence.sendKeys(Keys.ENTER);
					Thread.sleep(WaitTime.low);

					HashMap<String, Integer> BtnPress1 = new HashMap<String, Integer>();
					BtnPress1.put("Self Employed", 1);
					Thread.sleep(WaitTime.medium);
					clearAndSenKeys(occupation, dataRow.getProperty("Occupation"), "Occupation");
					Thread.sleep(WaitTime.low);
					for (String key : BtnPress1.keySet()) {
						if (key.equalsIgnoreCase(dataRow.getProperty("Occupation"))) {
							// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='occupation']"))));
							Thread.sleep(WaitTime.veryHigh);
							driver.findElement(By.xpath("//span[contains(text(),'" + key + "')]")).click();
						}
					}

					if (dataRow.getProperty("IsChronic").equalsIgnoreCase("Yes")) {
						String Chronic = dataRow.getProperty("Chronic");
						ArrayList Chroniclist = new ArrayList(Arrays.asList(Chronic.split(",")));
						for (int i = 0; i < Chroniclist.size(); i++) {
							WebElement Chronicclick = driver.findElement(
									By.xpath("(//option[contains(text(),'" + Chroniclist.get(i) + "')])[1]"));

							clickWithoutJavaScript(Chronicclick, " Chronic ");
							Reporter.log(" as " + Chroniclist.get(i));
						}
					}

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
//							

					/*
					 * Thread.sleep(WaitTime.medium);
					 * selectFromDropdownByVisibleText(Optedzone,dataRow.getProperty("Zone"),"Zone")
					 * ; Thread.sleep(WaitTime.low);
					 */

					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
					click(SaveButton, "Save");
					Thread.sleep(WaitTime.medium);
					click(Okbutton, "Ok Button");
					Thread.sleep(WaitTime.low);

//Questionnaires

					if (dataRow.getProperty("QuestionnaireConfig") == "Yes") {

						Thread.sleep(WaitTime.medium);
						click(Questionnairetab, "Questionnaire tab");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(PolioQuest, "Polio Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(PolioTextBox, dataRow.getProperty("PolioTextBox"), "Polio TextBox");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(OtherthanvitaminpillsQuest,"Otherthanvitaminpills Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(OtherthanvitaminpillsTextbox,dataRow.getProperty("OtherthanvitaminpillsTextbox"),"Other than vitamin pills Textbox");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(BloodtestsQuest, "Bloodtests Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(BloodtestsTextbox, dataRow.getProperty("BloodtestsTextbox"),"Bloodtests Textbox");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(SurgeryQuest, "Surgery Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(SurgeryTextbox, dataRow.getProperty("SurgeryTextbox"), "Surgery Textbox");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(viralfeverQuest, "viralfever Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(viralfeverTextbox, dataRow.getProperty("viralfeverTextbox"),"viralfever Textbox");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(dateofdeliveryQuest, "dateofdelivery Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(dateofdeliveryTextbox, dataRow.getProperty("dateofdeliveryTextbox"),"date of delivery Textbox");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						click(earlierpregnancyQuest, "earlierpregnancy Question RadioButton");
						Thread.sleep(WaitTime.low);

						Thread.sleep(WaitTime.medium);
						clearAndSenKeys(earlierpregnancyTextbox, dataRow.getProperty("earlierpregnancyTextbox"),"earlier pregnancy Textbox");
						Thread.sleep(WaitTime.low);

						click(SaveButton, "Save");
						Thread.sleep(WaitTime.medium);
						click(Okbutton, "Ok Button");
						Thread.sleep(WaitTime.low);

					}

					Thread.sleep(WaitTime.low);
					switchtodefaultframe(driver);
					switchtoframe(driver, "display");
					Thread.sleep(WaitTime.low);
					click(membericon, "Member Icon");
					Thread.sleep(WaitTime.medium);
					switchtoframe(driver, "containerFrame");
					Thread.sleep(WaitTime.low);

				}
			}

			Thread.sleep(WaitTime.low);
			switchtodefaultframe(driver);
			switchtoframe(driver, "display");
			Thread.sleep(WaitTime.low);
			click(membericon, "Member Icon");
			Thread.sleep(WaitTime.medium);
			switchtoframe(driver, "containerFrame");
			Thread.sleep(WaitTime.low);

		}

		// Policy Summary
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		Thread.sleep(WaitTime.medium);
		click(policysummary, "Policy Summary");
		switchtoframe(driver, "containerFrame");
		Thread.sleep(WaitTime.low);

		// Policy Summary
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(WaitTime.low);
		click(DataEntry1, "DataEntry 1 Complteted");
		Thread.sleep(WaitTime.low);

		// Data Entry1 Completed for all scrutiny cases
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_UP);
		String dataentry = DataEntryCompleted.getText();
		Reporter.log("----------");
		Reporter.log("For all Scrutiny cases " + dataentry);
		Reporter.log("---------");

		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(WaitTime.low);
		click(SubmitButton, "Accept QC Button");
		Thread.sleep(WaitTime.low);

		String SubStatusUWR = RuleEngineStatus.getText();
		String quoteno = QuoteNumber.getText();
		Reporter.log("----------");
		Reporter.log("Quote No. " + quoteno);
		Reporter.log("Status changed to " + SubStatusUWR);
		Reporter.log("---------");
	}

	
	public void NSTPfamilyDetails(WebDriver driver, String testCaseName, XSSFWorkbook workbook, Connection conn,
			String stepGroup, CustomAssert customAssert) throws Exception {

		fillNSTPFlow(driver, testCaseName, workbook, conn, stepGroup, customAssert);
	}
}
