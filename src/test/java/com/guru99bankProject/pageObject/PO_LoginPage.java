package com.guru99bankProject.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class PO_LoginPage extends ReUseAbleElement {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();
	
	public  PO_LoginPage(WebDriver driver)
	{   super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(30));
		action = new Actions(driver);
	}

	// to find page elements
	@FindBy(xpath = "//input[@name='uid']")
	@CacheLookup
	WebElement fieldUserId;
	
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement fieldPassword;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	@CacheLookup
	WebElement btnsubmit;
	
	@FindBy(xpath = "//*[text()='Edit Customer']")
	@CacheLookup
	WebElement tabDashboard;

	
	//TO SET THE USERNAME/EMAIL AND WAIT TILL IS IS NOT APPERS MAX WAIT TIME(30 SECONDS)
	public void setUserName(String userId) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(fieldUserId));
		fieldUserId.sendKeys(Keys.CONTROL,"a");
		fieldUserId.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		fieldUserId.sendKeys(userId);
		logger.info("Enteterd userId");
		Thread.sleep(200);
	}
	
	//TO SET THE PASSWORD
	public void setTextpassword(String password) throws InterruptedException {
		fieldPassword.sendKeys(Keys.CONTROL,"a");
		fieldPassword.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		fieldPassword.sendKeys(password);
		logger.info("Entered password");
		Thread.sleep(200);
	}

	//TO CLICK ON THE SUBMIT BUTTON
	public void clickBtnsubmit() throws InterruptedException {
		btnsubmit.click();
		logger.info("clicke on login submit button");
		Thread.sleep(200);
	}
	
	//FOR USER LOGIN
	public PO_HomePage Login(String userId,String userPassword) throws InterruptedException {
		try {
			logger.info("Method called Login: Login");
			setUserName(userId);
			setTextpassword(userPassword);
			clickBtnsubmit();
			
			try {
				if(driver.getPageSource().contains("Edit Customer")) {
					softAssert.assertTrue(true);
					logger.info("...LOGIN DONE...");
				} else {
					softAssert.assertTrue(false);
					logger.info("!!!LOGIN FAILED!!!");
				}
			}catch(Exception e) {
				logger.info("Login exception message: "+e.getMessage());
				softAssert.assertEquals(driver.getPageSource().contains("Welcome"),"To check the login");
			}
		}catch(Exception e) {}
		
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}
	
}
