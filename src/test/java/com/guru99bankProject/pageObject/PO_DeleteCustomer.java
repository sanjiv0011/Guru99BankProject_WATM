package com.guru99bankProject.pageObject;

import java.time.Duration;

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

public class PO_DeleteCustomer extends ReUseAbleElement {

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
	public PO_DeleteCustomer(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
		hp = new PO_HomePage(driver);
	}

	// =========START========HOME PAGE OBJECTS=============//

//	//CUSTOMER ID
//	@FindBy(xpath = "//input[@name='cusid']")
//	@CacheLookup
//	WebElement f_customerId;
//
//	public void setCustomerId(String customerId) throws InterruptedException {
//		wait.until(ExpectedConditions.elementToBeClickable(f_customerId));
//		f_customerId.sendKeys(Keys.CONTROL, "a");
//		f_customerId.sendKeys(Keys.DELETE);
//		Thread.sleep(200);
//		f_customerId.sendKeys(customerId);
//		logger.info("Enteterd customerId");
//		Thread.sleep(200);
//	}
//
//	
//	//SUBMIT BUTTON
//	@FindBy(xpath = "//input[@name='AccSubmit']")
//	@CacheLookup
//	WebElement btn_submit;
//
//	public void clickOnBtnSubmit() throws InterruptedException {
//		btn_submit.click();
//		logger.info("clicked Submit");
//		Thread.sleep(200);
//	}
	
	//TO ADD NEW CUSTOMER
	public PO_HomePage deleteCustomer(String customerId) throws InterruptedException {
		logger.info("Method called:"+"deleteCustomer");
		
		ruae.setCustomerId(customerId);
		ruae.clickOnBtnSubmit();
		Thread.sleep(2000);
		driver.navigate().back();
		return new PO_HomePage(driver);
	}
}
