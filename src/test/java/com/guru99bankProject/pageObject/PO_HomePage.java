package com.guru99bankProject.pageObject;

import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.guru99bankProject.ReUseAble.PageObject.ReUseAbleElement;

public class PO_HomePage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	// HOMEPAGE CONSTRUCTOR CREATION
	public PO_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// =========START========HOME PAGE OBJECTS=============//
	@FindBy(xpath = "//a[normalize-space()='Manager']")
	@CacheLookup
	WebElement menuManager;

	public void clickOnMenuManager() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(menuManager));
		Thread.sleep(300);
		// jsExecutor.executeScript("window.scrollBy(0, 100)");
		menuManager.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuManager");
	}

	@FindBy(xpath = "//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement menuNewCustomer;

	public void clickOnMenuNewCustomer() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(menuNewCustomer));
		Thread.sleep(300);
		// jsExecutor.executeScript("window.scrollBy(0, 100)");
		menuNewCustomer.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuNewCustomer");
	}

	@FindBy(xpath = "//a[normalize-space()='Edit Customer']")
	@CacheLookup
	WebElement menuEditCustomer;

	public void clickOnMenuEditCustomer() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(menuEditCustomer));
		Thread.sleep(300);
		// jsExecutor.executeScript("window.scrollBy(0, 100)");
		menuEditCustomer.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuEditCustomer");
	}

	@FindBy(xpath = "//a[normalize-space()='Delete Customer']")
	@CacheLookup
	WebElement menuDeleteCustomer;

	public void clickOnMenuDeleteCustomer() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(menuDeleteCustomer));
		Thread.sleep(300);
		// jsExecutor.executeScript("window.scrollBy(0, 100)");
		menuDeleteCustomer.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuDeleteCustomer");
	}

	@FindBy(xpath = "//a[text()='New Account']")
	@CacheLookup
	WebElement menuNewAccount;

	public void clickOnMenuNewAccount() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(menuNewAccount));
		Thread.sleep(300);
		// jsExecutor.executeScript("window.scrollBy(0, 100)");
		menuNewAccount.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuNewAccount");
	}

	@FindBy(xpath = "//a[normalize-space()='Edit Account']")
	@CacheLookup
	WebElement menuEditAccount;

	public void clickOnMenuEditAccount() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(menuEditAccount));
		Thread.sleep(300);
		// jsExecutor.executeScript("window.scrollBy(0, 100)");
		menuEditAccount.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuEditAccount");
	}

	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	@CacheLookup
	WebElement menuDeleteAccount;

	public void clickOnMenuDeleteAccount() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(menuDeleteAccount));
		Thread.sleep(300);
		// jsExecutor.executeScript("window.scrollBy(0, 100)");
		menuDeleteAccount.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuDeleteAccount");
	}

	@FindBy(xpath = "//a[normalize-space()='Customised Statement']")
	@CacheLookup
	WebElement menuCustomisedStatement;

	public void clickOnMenuCustomisedStatement() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(menuCustomisedStatement));
		Thread.sleep(300);
		// jsExecutor.executeScript("window.scrollBy(0, 100)");
		menuCustomisedStatement.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuCustomisedStatement");
	}

	@FindBy(xpath = "//a[normalize-space()='Mini Statement']")
	@CacheLookup
	WebElement menuMiniStatement;

	public void clickOnMenuMiniStatement() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(menuMiniStatement));
		Thread.sleep(300);
		// jsExecutor.executeScript("window.scrollBy(0, 100)");
		menuMiniStatement.click();
		Thread.sleep(2000);
		logger.info("Clicked on the menuMiniStatement");
	}

	@FindBy(xpath = "//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement btnLogout;

	public void clickOnLogoutButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
		Thread.sleep(300);
		jsExecutor.executeScript("window.scrollBy(0, 100)");
		btnLogout.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Logout button ");
	}
	// =========END========HOME PAGE OBJECTS=============//

	// TO TEST THE MENU TABS
	public PO_HomePage BankMenuTabsTesting() throws InterruptedException {
		logger.info("Method called: BankMenuTabsTesting");
		clickOnMenuManager();
		clickOnMenuNewCustomer();
		clickOnMenuEditCustomer();
		clickOnMenuDeleteCustomer();
		clickOnMenuCustomisedStatement();
		clickOnMenuMiniStatement();
		clickOnMenuNewAccount();
		clickOnMenuEditAccount();
		clickOnMenuDeleteAccount();

		return new PO_HomePage(driver);
	}

	// TO LOGOUT
	public PO_LoginPage UserLogout() throws InterruptedException {
		logger.info("Method called: Logout");
		try {

			clickOnLogoutButton();
			Thread.sleep(500);
			if (driver.switchTo().alert().getText().contains("You Have Succesfully Logged Out!!")) {
				driver.switchTo().alert().accept();
				softAssert.assertTrue(true);
				logger.info("... LOGOUT DONE ...");
			} else {
				softAssert.assertTrue(false);
				logger.info("!!! LOGOUT FAILEED !!!");
			}
		} catch (Exception e) {
			logger.info("Logout Exception: " + e.getMessage());
			softAssert.assertTrue(false, "After logout it lookin for [Steps To Generate Access] text");
		}
		softAssert.assertAll();
		return new PO_LoginPage(driver);

	}

}
