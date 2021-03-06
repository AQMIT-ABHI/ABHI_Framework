package pages;


import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;
import util.LoginUserFromSyncMap;
import util.MapOfUserIDAssignedToAllocation;
import util.WaitTime;

public class TCSlogin extends GenericMethods {
	
	@FindBy(xpath="//input[@id='pUserName']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='textfield2']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='textfield4']")
	private WebElement role;
	
	@FindBy(xpath="//strong[contains(text(),'LOGIN')]")
	private WebElement loginBTN;
	
	@FindBy(xpath="//label[contains(text(),'GSTIN')]/parent::div/following-sibling::div/p-autocomplete/span/input")
	private WebElement GSTIN;
	
	@FindBy(xpath="//select[@id='finyear']")
	private WebElement FinancialYear;
	
	@FindBy(xpath="//select[@id='taxper']")
	private WebElement TaxPayerPeriod;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Submit;
	
    WebDriverWait wait;
	public TCSlogin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
	}
	
	public void fillAndSubmitNewTCSLogin(WebDriver driver,String testCaseName, XSSFWorkbook workbook,Connection conn,String stepGroup,CustomAssert customAssert) throws Exception
	{
		Properties dataRow = ExcelRead.readRowDataInProperties(workbook, "TCS_LoginPage", testCaseName,stepGroup);
		Reporter.log("<B>Login To Application</B>");
		
		switchtoframe(driver, "display");

		
		String user=LoginUserFromSyncMap.userIDForLogin(MapOfUserIDAssignedToAllocation.listOfUserIDForExecution,testCaseName);
        System.out.println("");
        System.out.println("Below details are from login Page::");
        System.out.println(user+" USER ID sent for login.");
        System.out.println("At the time of login using USER ID: "+user+" Updated MAP shows as below:");
        System.out.println("Status wise MAP::"+MapOfUserIDAssignedToAllocation.listOfUserIDForExecution.toString());
		
		clearAndSenKeys(username,user, "UserName");
		clearAndSenKeys(password,dataRow.getProperty("Password"), "Password");
		Thread.sleep(WaitTime.low);
		//clearAndSenKeys(role, dataRow.getProperty("Role"), "Role");
		click(loginBTN, "Login Button");
//		Thread.sleep(WaitTime.low);
		switchtodefaultframe(driver);
		

		
	}

}
