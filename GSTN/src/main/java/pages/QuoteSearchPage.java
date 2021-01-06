package pages;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.fillo.Connection;

import util.CustomAssert;
import util.GenericMethods;
import util.WaitTime;

public class QuoteSearchPage extends GenericMethods {
	
	@FindBy(xpath="(//p[contains(text(),'Policy Management')])[1]")
	private WebElement PolicyManagement;
	
	@FindBy(xpath="//input[@id='Policy No.']")
	private WebElement QuoteNoSearch;
	
	@FindBy(xpath="//button[@id='Search']")
	private WebElement SearchButton;
	
	WebDriverWait wait;
	public QuoteSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);	
		}

	public void searchQuote(WebDriver driver,String testCaseName) throws InterruptedException {
	
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
	}
}
