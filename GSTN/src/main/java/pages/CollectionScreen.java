package pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
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

public class CollectionScreen extends GenericMethods {

	// Get Total
	@FindBy(xpath = "//div[@id='btn']//a[@class='mat-custom-btn']")
	private WebElement gettotal;

	// To be collected
	@FindBy(xpath = "//input[@id='ptbCollected']")
	private WebElement tobeCollected;

	// Instrument amount
	@FindBy(xpath = "//input[@name='pInstrumentAmt']")
	private WebElement instrumentamount;

	// Source of Collection
	@FindBy(xpath = "//select[@id='pSourceOfCollection']")
	private WebElement sourceofCollection;

	// Collection Mode
	@FindBy(xpath = "//select[@id='CollectionMode']")
	private WebElement mode;

	// Txn amount
	@FindBy(xpath = "//input[@id='CollectionAmount']")
	private WebElement taxamount;

	// Sub Code
	@FindBy(xpath = "//input[@id='SubCode']")
	private WebElement subcode;

	// Sub Code Search
	@FindBy(xpath = "//input[@id='SubCodeLookup']")
	private WebElement subcodesearch;

	// Subcode Value
	@FindBy(xpath = "(//a[@name='firstFocus'])[2]")
	private WebElement subcodevalue;

	// Narration
	@FindBy(xpath = "//textarea[@id='Narration']")
	private WebElement narration;

	// Save Button
	@FindBy(xpath = "//span[@id='SaveSpan']")
	private WebElement saveBTN;

	// Post Button
	@FindBy(xpath = "//span[contains(text(),'Post')]")
	private WebElement postBTN;

	// Continue Button Collection
	@FindBy(xpath = "//span[contains(text(),'Continue')]")
	private WebElement continueBTN;

	// Continue Button Agent Details
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continuebutton;

	// Show Requirement on Requirements page
	@FindBy(xpath = "//img[@title='Show Requirement']")
	private WebElement showrequirement;

	// Upload Requirement A
	@FindBy(xpath = "(//img[@title='Upload Requirement'])[1]")
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

	// Upload Requirement B
	@FindBy(xpath = "(//img[@title='Upload Requirement'])[2]")
	private WebElement uploadrequirementB;
	
	// Upload Requirement C
		@FindBy(xpath = "(//img[@title='Upload Requirement'])[3]")
		private WebElement uploadrequirementC;
		
		// Upload Requirement D
		@FindBy(xpath = "(//img[@title='Upload Requirement'])[4]")
		private WebElement uploadrequirementD;
		
		// Upload Requirement E
		@FindBy(xpath = "(//img[@title='Upload Requirement'])[5]")
		private WebElement uploadrequirementE;
		
		// Upload Requirement F
		@FindBy(xpath = "(//img[@title='Upload Requirement'])[6]")
		private WebElement uploadrequirementF;

	// Save
	@FindBy(xpath = "//button[@id='SaveRequire']")
	private WebElement saverequire;

	// Continue Button Requirement page
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueButton;

	WebDriverWait wait;

	public CollectionScreen(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void fillcollectionscreen(WebDriver driver, String testCaseName, XSSFWorkbook workbook, Connection conn,String stepGroup, CustomAssert customAssert) throws Exception {
		String sheetName = ConfigReader.getInstance().getValue(PropertyConfigs.TestSheet);
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, sheetName, testCaseName, stepGroup);
		Reporter.log("<B>Traverse To CommonPage</B>");

		// Get Total
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
//		Thread.sleep(WaitTime.high);
//		click(gettotal, "Get Total");
//		Thread.sleep(WaitTime.medium);
//
//		// To be Collected & Instrument amount
//		String Collectamount = tobeCollected.getAttribute("value");
//		Thread.sleep(WaitTime.medium);
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_UP);
//		instrumentamount.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//		Thread.sleep(WaitTime.medium);
//		driver.findElement(By.xpath("//input[@name='pInstrumentAmt']")).sendKeys(Collectamount);
//		Thread.sleep(WaitTime.low);
//
//		// Source of Collection
//		Thread.sleep(WaitTime.medium);
//		selectFromDropdownByVisibleText(sourceofCollection, dataRow.getProperty("Source of Collection"),"Source of Collection");
//		Thread.sleep(WaitTime.medium);
//
//		// Collection Mode
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
//		Thread.sleep(WaitTime.medium);
//		selectFromDropdownByVisibleText(mode, dataRow.getProperty("Mode"), "Collection Mode");
//		Thread.sleep(WaitTime.high);
//
//		// Txn Amount
//		Thread.sleep(WaitTime.low);
//		clearAndSenKeys(taxamount, Collectamount, "Txn Amount");
//		Thread.sleep(WaitTime.medium);
//
//		// Sub Code
//		// Sub Code Search
		String parentWindow = driver.getWindowHandle();
//		wait.until(ExpectedConditions.elementToBeClickable(subcode));
//		Thread.sleep(WaitTime.medium);
//		click(subcodesearch, " search ");
//		Thread.sleep(WaitTime.medium);
//		switchToWindow(driver);
//		Thread.sleep(WaitTime.medium);
//		click(subcodevalue, "SubCode Value");
//		Thread.sleep(WaitTime.medium);
//		driver.switchTo().window(parentWindow);
//		switchtodefaultframe(driver);
//		Thread.sleep(WaitTime.medium);
//		switchtoframe(driver, "display");
//		Thread.sleep(WaitTime.medium);
//		switchtoframe(driver, "containerFrame");
//
//		// Narration
//		Thread.sleep(WaitTime.medium);
//		clearAndSenKeys(narration, dataRow.getProperty("Narration"), "Narration");
//		Thread.sleep(WaitTime.medium);
//		
//		// Save button
//		driver.findElement(By.xpath("//textarea[@id='Narration']")).sendKeys(Keys.PAGE_DOWN);
//		click(saveBTN, "Save Button");
//		Thread.sleep(WaitTime.medium);
//		// String parentWindow = driver.getWindowHandle();
//
//		// Post Button
//		Thread.sleep(WaitTime.medium);
//		driver.findElement(By.xpath("//textarea[@id='Narration']")).sendKeys(Keys.PAGE_DOWN);
//		click(postBTN, "Post Button");
//		Thread.sleep(WaitTime.medium);

		// Continue Button Collection
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(WaitTime.medium);
		wait.until(ExpectedConditions.elementToBeClickable(continueBTN));
		click(continueBTN, "Continue Button");
		Thread.sleep(WaitTime.medium);

		// Continue Button Agent Details
		Thread.sleep(WaitTime.medium);
		click(continuebutton, "Continue Button");
		Thread.sleep(WaitTime.medium);

		// Requirement Page
		// Start
		// For Proposer

		// Show Requirements
		Thread.sleep(WaitTime.medium);
		click(showrequirement, "Show Requirement");
		Thread.sleep(WaitTime.medium);

		// Upload Requirement A

		Thread.sleep(WaitTime.medium);
		click(uploadrequirementA, "Upload Document of BanK");
		Thread.sleep(WaitTime.medium);
		switchToWindow(driver);
		Thread.sleep(WaitTime.low);

		// Choose File 1
		Thread.sleep(WaitTime.high);
		click(choosefile, "Choose File");
		Thread.sleep(WaitTime.medium);
		choosefile.sendKeys("D:\\code.txt");
		Thread.sleep(WaitTime.high);

		// Upload File 1
		Thread.sleep(WaitTime.medium);
		click(upload, "File Uploaded");
		Thread.sleep(WaitTime.medium);
		driver.switchTo().window(parentWindow);
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame");

		// Ok Button

		Thread.sleep(WaitTime.medium);
        click(OK, "File Uploaded Successfully"); 
        Thread.sleep(WaitTime.high);
        
		// Upload Requirement B
        Thread.sleep(WaitTime.medium);
		click(uploadrequirementB, "Upload Document of Proposal form");
		Thread.sleep(WaitTime.veryHigh);
		switchToWindow(driver);
		Thread.sleep(WaitTime.medium);

		// Choose File 2
		Thread.sleep(WaitTime.veryHigh);
		click(choosefile, "Choose File");
		Thread.sleep(WaitTime.veryHigh);
		choosefile.sendKeys("D:\\code.txt");
		Thread.sleep(WaitTime.veryHigh);

		// Upload File 2
		Thread.sleep(WaitTime.medium);
		click(upload, "File Uploaded");
		Thread.sleep(WaitTime.medium);
		driver.switchTo().window(parentWindow);
		switchtodefaultframe(driver);
		switchtoframe(driver, "display");
		switchtoframe(driver, "containerFrame");
		// Ok Button

		Thread.sleep(WaitTime.high);
		click(OK, "File Uploaded Successfully"); 
		Thread.sleep(WaitTime.medium);
		
		//Proprietorship declaration form
		if(dataRow.getProperty("ProposerAlsoAPayer").equalsIgnoreCase("No"))
 		{
 		//Upload Requirement C
			 Thread.sleep(WaitTime.medium);
				click(uploadrequirementC, "Upload Document of Proprietorship");
				Thread.sleep(WaitTime.veryHigh);
				switchToWindow(driver);
				Thread.sleep(WaitTime.medium);

				// Choose File 3
				Thread.sleep(WaitTime.veryHigh);
				click(choosefile, "Choose File");
				Thread.sleep(WaitTime.veryHigh);
				choosefile.sendKeys("D:\\code.txt");
				Thread.sleep(WaitTime.veryHigh);

				// Upload File 3
				Thread.sleep(WaitTime.medium);
				click(upload, "File Uploaded");
				Thread.sleep(WaitTime.medium);
				driver.switchTo().window(parentWindow);
				switchtodefaultframe(driver);
				switchtoframe(driver, "display");
				switchtoframe(driver, "containerFrame");
				// Ok Button

				Thread.sleep(WaitTime.high);
				click(OK, "File Uploaded Successfully"); 
				Thread.sleep(WaitTime.medium);
				
		//Upload Requirement D
				 Thread.sleep(WaitTime.medium);
					click(uploadrequirementD, "Upload Document of Partnership");
					Thread.sleep(WaitTime.veryHigh);
					switchToWindow(driver);
					Thread.sleep(WaitTime.medium);

					// Choose File 4
					Thread.sleep(WaitTime.veryHigh);
					click(choosefile, "Choose File");
					Thread.sleep(WaitTime.veryHigh);
					choosefile.sendKeys("D:\\code.txt");
					Thread.sleep(WaitTime.veryHigh);

					// Upload File 4
					Thread.sleep(WaitTime.medium);
					click(upload, "File Uploaded");
					Thread.sleep(WaitTime.medium);
					driver.switchTo().window(parentWindow);
					switchtodefaultframe(driver);
					switchtoframe(driver, "display");
					switchtoframe(driver, "containerFrame");
					// Ok Button

					Thread.sleep(WaitTime.high);
					click(OK, "File Uploaded Successfully"); 
					Thread.sleep(WaitTime.medium);
					
			//Upload Requirement E
					 Thread.sleep(WaitTime.medium);
						click(uploadrequirementE, "Upload Document of Third Party");
						Thread.sleep(WaitTime.veryHigh);
						switchToWindow(driver);
						Thread.sleep(WaitTime.medium);

						// Choose File 5
						Thread.sleep(WaitTime.veryHigh);
						click(choosefile, "Choose File");
						Thread.sleep(WaitTime.veryHigh);
						choosefile.sendKeys("D:\\code.txt");
						Thread.sleep(WaitTime.veryHigh);

						// Upload File 5
						Thread.sleep(WaitTime.medium);
						click(upload, "File Uploaded");
						Thread.sleep(WaitTime.medium);
						driver.switchTo().window(parentWindow);
						switchtodefaultframe(driver);
						switchtoframe(driver, "display");
						switchtoframe(driver, "containerFrame");
						// Ok Button

						Thread.sleep(WaitTime.high);
						click(OK, "File Uploaded Successfully"); 
						Thread.sleep(WaitTime.medium);
			
				//Upload Requirement F
						 Thread.sleep(WaitTime.medium);
							click(uploadrequirementF, "Upload Document of Adversity Medical");
							Thread.sleep(WaitTime.veryHigh);
							switchToWindow(driver);
							Thread.sleep(WaitTime.medium);

							// Choose File 6
							Thread.sleep(WaitTime.veryHigh);
							click(choosefile, "Choose File");
							Thread.sleep(WaitTime.veryHigh);
							choosefile.sendKeys("D:\\code.txt");
							Thread.sleep(WaitTime.veryHigh);

							// Upload File 6
							Thread.sleep(WaitTime.medium);
							click(upload, "File Uploaded");
							Thread.sleep(WaitTime.medium);
							driver.switchTo().window(parentWindow);
							switchtodefaultframe(driver);
							switchtoframe(driver, "display");
							switchtoframe(driver, "containerFrame");
							
							// Ok Button
							Thread.sleep(WaitTime.high);
							click(OK, "File Uploaded Successfully"); 
							Thread.sleep(WaitTime.medium);
 		         }


		// Save
		Thread.sleep(WaitTime.medium);
		click(saverequire, "Save");
		Thread.sleep(WaitTime.medium);

		// Ok Button
		Thread.sleep(WaitTime.medium);
		click(OK, "Modification Successfully Completed");
		Thread.sleep(WaitTime.medium);

		// Continue Button
		Thread.sleep(WaitTime.medium);
		click(continueButton, "Continue Button");
		Thread.sleep(WaitTime.medium);

		// End

	}

	public void FillCollection(WebDriver driver, String testCaseName, XSSFWorkbook workbook, Connection conn,String stepGroup, CustomAssert customAssert) throws Exception 
	{
		fillcollectionscreen(driver, testCaseName, workbook, conn, stepGroup, customAssert);
	}

}