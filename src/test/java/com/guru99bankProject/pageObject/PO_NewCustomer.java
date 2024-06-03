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

public class PO_NewCustomer extends ReUseAbleElement {

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
	public PO_NewCustomer(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);
		hp = new PO_HomePage(driver);
	}

	// =========START========HOME PAGE OBJECTS=============//

	// TO ADD CUSTOMER NAME
	@FindBy(xpath = "//input[@name='name']")
	@CacheLookup
	WebElement f_customerName;

	public void setCustomerName(String customerName) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_customerName));
		f_customerName.sendKeys(Keys.CONTROL, "a");
		f_customerName.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_customerName.sendKeys(customerName);
		logger.info("Enteterd customerName");
		Thread.sleep(200);
	}

	// TO SELECT THE GENDER MALE
	@FindBy(xpath = "(//input[@name='rad1'])[1]")
	@CacheLookup
	WebElement r_genderMale;

	public void selectGenderMale() throws InterruptedException {
		r_genderMale.click();
		logger.info("clicked male");
		Thread.sleep(200);
	}

	// TO SELECT THE GENDER FEMALE
	@FindBy(xpath = "(//input[@name='rad1'])[2]")
	@CacheLookup
	WebElement r_genderFemale;

	public void selectGenderFemale() throws InterruptedException {
		r_genderFemale.click();
		logger.info("clicked female");
	}

	// TO ADD THE DATE
	@FindBy(xpath = "//input[@id='dob']")
	@CacheLookup
	WebElement f_date;

	public void setDate(String date) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_date));
		f_date.sendKeys(Keys.CONTROL, "a");
		f_date.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_date.sendKeys(date);
		logger.info("Enteterd f_date");
		Thread.sleep(200);
	}

	// TO ADD THE ADDRESS
	@FindBy(xpath = "//textarea[@name='addr']")
	@CacheLookup
	WebElement f_address;

	public void setAddress(String address) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_address));
		f_address.sendKeys(Keys.CONTROL, "a");
		f_address.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_address.sendKeys(address);
		logger.info("Enteterd address");
		Thread.sleep(200);
	}

	// TO ADD THE CITY
	@FindBy(xpath = "//input[@name='city']")
	@CacheLookup
	WebElement f_city;

	public void setCity(String city) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_city));
		f_city.sendKeys(Keys.CONTROL, "a");
		f_city.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_city.sendKeys(city);
		logger.info("Enteterd city");
		Thread.sleep(200);
	}

	// TO ADD THE STATE
	@FindBy(xpath = "//input[@name='state']")
	@CacheLookup
	WebElement f_state;

	public void setState(String state) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_state));
		f_state.sendKeys(Keys.CONTROL, "a");
		f_state.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_state.sendKeys(state);
		logger.info("Enteterd state");
		Thread.sleep(200);
	}

	// TO ADD THE PINCODE
	@FindBy(xpath = "//input[@name='pinno']")
	@CacheLookup
	WebElement f_pincode;

	public void setPincode(String pincode) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_pincode));
		f_pincode.sendKeys(Keys.CONTROL, "a");
		f_pincode.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_pincode.sendKeys(pincode);
		logger.info("Enteterd pincode");
		Thread.sleep(200);
	}

	// TO ADD THE PHONENUMBER
	@FindBy(xpath = "//input[@name='telephoneno']")
	@CacheLookup
	WebElement f_phonenumber;

	public void setPhoneNumber(String phonenumber) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_phonenumber));
		f_phonenumber.sendKeys(Keys.CONTROL, "a");
		f_phonenumber.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_phonenumber.sendKeys(phonenumber);
		logger.info("Enteterd phonenumber");
		Thread.sleep(200);
	}

	// TO ADD THE EMAIL
	@FindBy(xpath = "//input[@name='emailid']")
	@CacheLookup
	WebElement f_emailId;

	public void setEmailId(String emaiId) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(f_emailId));
		f_emailId.sendKeys(Keys.CONTROL, "a");
		f_emailId.sendKeys(Keys.DELETE);
		Thread.sleep(200);
		f_emailId.sendKeys(emaiId);
		logger.info("Enteterd emaiId");
		Thread.sleep(200);
	}

	// TO ADD THE SUBMIT
	@FindBy(xpath = "//input[@name='sub']")
	@CacheLookup
	WebElement btn_submit;

	public void clickOnBtnSubmit() throws InterruptedException {
		btn_submit.click();
		logger.info("clicked Submit");
		Thread.sleep(200);
	}
	
	//TO ADD NEW CUSTOMER
	public PO_HomePage addNewCustomer(String name, String gender, String dob, String address, String city, String state, String pin, String phoneNumber, String email) throws InterruptedException {
		logger.info("Method called:"+"addNewCustomer");
		setCustomerName(name);

		if(gender == "male"){
			selectGenderMale();
		}else if(gender == "female"){
			selectGenderFemale();
		}
		
		setDate(dob);
		setAddress(address);
		setCity(city);
		setState(state);
		setPincode(pin);
		setPhoneNumber(phoneNumber);
		setEmailId(email);
		
		clickOnBtnSubmit();
		Thread.sleep(2000);
		driver.navigate().back();
		wait.until(ExpectedConditions.elementToBeClickable(hp.btnLogout));
		
		return new PO_HomePage(driver);
	}
}
