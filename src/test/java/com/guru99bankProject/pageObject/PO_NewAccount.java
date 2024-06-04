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

public class PO_NewAccount extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();
	public PO_HomePage hp;

	// NEW CUSTOMER CUSTRUCTOR CREATION
	public PO_NewAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
		hp = new PO_HomePage(driver);
	}

	// =========START========HOME PAGE OBJECTS=============//

	// CUSTOMER DEPOSITES
	@FindBy(xpath = "//input[@name='inideposit']")
	@CacheLookup
	WebElement f_initialDeposite;

	public void setInitialDeposite(String initialDeposites) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_initialDeposite));
		f_initialDeposite.sendKeys(Keys.CONTROL, "a");
		f_initialDeposite.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_initialDeposite.sendKeys(initialDeposites);
		logger.info("Enteterd initialDeposite");
		Thread.sleep(200);
	}

	// TO SELECT THE ACCOUNT TYPE
	@FindBy(xpath = "//select[@name='selaccount']")
	@CacheLookup
	WebElement i_accountType;

	public boolean clickOnIconAccountType() throws InterruptedException {
		i_accountType.click();
		logger.info("clicked accountType");
		Thread.sleep(200);
		return true;
	}

	// TO SELECT THE ACCOUNT TYPE
	@FindBy(xpath = "// select[@name='selaccount']//option")
	@CacheLookup
	List<WebElement> l_accountType;
	public void selectAccountType(String accountType) throws InterruptedException {
		Boolean flag = false;
		if(clickOnIconAccountType()) {
			for(WebElement accType : l_accountType) {
				if(accType.getText().equals(accountType)) {
					accType.click();
					flag = true;
				}
			}
			if(!flag) {
				logger.info("Account type not found");
			}
		}
		Thread.sleep(200);
	}
	
	
	// SUBMIT BUTTON
	@FindBy(xpath = "//input[@name='button2']")
	@CacheLookup
	WebElement btn_submit2;

	public void clickOnBtnSubmit2() throws InterruptedException {
		btn_submit2.click();
		logger.info("clicked Submit2");
		Thread.sleep(200);
	}

	// TO ADD NEW CUSTOMER
	public PO_HomePage addNewAccount(String customerId, String accountType, String initialDeposites)
			throws InterruptedException {
		logger.info("Method called:" + "addNewAccount");

		ruae.setCustomerId(customerId);
		selectAccountType(accountType);
		setInitialDeposite(initialDeposites);
		clickOnBtnSubmit2();
		Thread.sleep(2000);
		driver.navigate().back();
		wait.until(ExpectedConditions.elementToBeClickable(hp.btnLogout));

		return new PO_HomePage(driver);
	}
}
