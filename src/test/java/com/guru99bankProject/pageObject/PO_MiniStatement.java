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

public class PO_MiniStatement extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();
	public PO_HomePage hp;

	//CUSTRUCTOR CREATION
	public PO_MiniStatement(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
		hp = new PO_HomePage(driver);
	}

	// =========START========HOME PAGE OBJECTS=============//

	
	// TO MINI STATEMENT
	public PO_HomePage miniStatement(String accountNumber)
			throws InterruptedException {
		logger.info("Method called:" + "miniStatement");

		ruae.setAccountNumber(accountNumber);
		ruae.clickOnBtnSubmit();
		Thread.sleep(2000);
		driver.navigate().back();
		wait.until(ExpectedConditions.elementToBeClickable(hp.btnLogout));

		return new PO_HomePage(driver);
	}
}
