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


public class PO_HomePage extends ReUseAbleElement{
	
	//CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();
	
	//HOMEPAGE CONSTRUCTOR CREATION
	public PO_HomePage(WebDriver driver) {	
		super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}
	
	
	
	//=========START========HOME PAGE OBJECTS=============//
	
	@FindBy(xpath = "//p[normalize-space()='Dashboard']")
	@CacheLookup
	WebElement textDashboard;
	
	
	@FindBy(xpath = "//p[@class='MuiTypography-root text-base font-semibold MuiTypography-body1']")
	@CacheLookup
	WebElement btnUserName;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement btnLogout;

	//=========END========HOME PAGE OBJECTS=============//
	
	
	//=========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//
	
	public boolean verifyDashboard() throws InterruptedException {
		boolean bol = textDashboard.isDisplayed();
		Thread.sleep(2000);
		logger.info("Checked is Dashboard displayed: "+bol);
		return bol;	
	}

	
	public void clickOnUserNameButton() throws InterruptedException {
		btnUserName.click();
		Thread.sleep(500);
		logger.info("Clicked on the User name text ");
	}
	
	public void clickOnLogoutButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnLogout));
		Thread.sleep(300);
		jsExecutor.executeScript("window.scrollBy(0, 100)");
		btnLogout.click();
		Thread.sleep(2000);
		logger.info("Clicked on the Logout button ");
	}

	//=========END========ACTION METHODS FOR HOME PAGE OBJECTS=============//
	
		
	// TO LOGOUT
	public PO_LoginPage UserLogout() throws InterruptedException
	{	logger.info("Method called: Logout");
		try {
			
			clickOnLogoutButton();
			Thread.sleep(500);
			if(driver.switchTo().alert().getText().contains("You Have Succesfully Logged Out!!")){
				softAssert.assertTrue(true);
				logger.info("... LOGOUT DONE ...");
			}else{
				softAssert.assertTrue(false);
				logger.info("!!! LOGOUT FAILEED !!!");
			}
		}catch(Exception e) {
			logger.info("Logout Exception: "+e.getMessage());
			softAssert.assertTrue(false,"After logout it lookin for [Steps To Generate Access] text");
		}
		softAssert.assertAll();
		return new PO_LoginPage(driver);
		
	}
	
}
