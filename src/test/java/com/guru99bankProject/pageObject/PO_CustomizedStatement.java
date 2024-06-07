package com.guru99bankProject.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.guru99bankProject.ReUseAble.PageObject.ReUseAbleElement;

public class PO_CustomizedStatement extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();
	public PO_HomePage hp;

	// CUSTRUCTOR CREATION
	public PO_CustomizedStatement(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
		hp = new PO_HomePage(driver);
	}

	// =========START========HOME PAGE OBJECTS=============//

	// TO DATE
	@FindBy(xpath = "//input[@name='tdate']")
	@CacheLookup
	WebElement f_fromDate;

	public void setFromDate(String fromDate) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_fromDate));
		f_fromDate.sendKeys(Keys.CONTROL, "a");
		f_fromDate.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_fromDate.sendKeys(fromDate);
		logger.info("Enteterd fromDate");
		Thread.sleep(200);
	}

	// FROM DATE
	@FindBy(xpath = "//input[@name='fdate']")
	@CacheLookup
	WebElement f_toDate;

	public void setAccountNumber(String toDate) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_toDate));
		f_toDate.sendKeys(Keys.CONTROL, "a");
		f_toDate.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_toDate.sendKeys(toDate);
		logger.info("Enteterd toDate");
		Thread.sleep(200);
	}

	// Lower amount limit
	@FindBy(xpath = "//input[@name='loweramt']")
	@CacheLookup
	WebElement f_lowerAmountLimit;

	public void setAmountLimit(String amountLimit) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_lowerAmountLimit));
		f_lowerAmountLimit.sendKeys(Keys.CONTROL, "a");
		f_lowerAmountLimit.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_lowerAmountLimit.sendKeys(amountLimit);
		logger.info("Enteterd f_lowerAmountLimit");
		Thread.sleep(200);
	}

	//NUMBER OF TRANSACTIONS
	@FindBy(xpath = "//input[@name='tranno']")
	@CacheLookup
	WebElement f_numberOfTransactions;

	public void setNumberOfTransactions(String numberOfTransactions) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_numberOfTransactions));
		f_numberOfTransactions.sendKeys(Keys.CONTROL, "a");
		f_numberOfTransactions.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_numberOfTransactions.sendKeys(numberOfTransactions);
		logger.info("Enteterd numberOfTransactions");
		Thread.sleep(200);
	}

	// TO MINI STATEMENT
	public PO_HomePage customizedStatement(String accountNumber, String toDate, String fromDate, String amountLimit, String numberOfTransactions) throws InterruptedException {
		logger.info("Method called:" + "customizedStatement");

		ruae.setAccountNumber(accountNumber);
		setFromDate(fromDate);
		setAccountNumber(toDate);
		setAmountLimit(amountLimit);
		setNumberOfTransactions(numberOfTransactions);
		ruae.clickOnBtnSubmit();
		Thread.sleep(2000);
		driver.navigate().back();
		wait.until(ExpectedConditions.elementToBeClickable(hp.btnLogout));

		return new PO_HomePage(driver);
	}
}
