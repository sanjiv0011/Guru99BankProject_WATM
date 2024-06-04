package com.guru99bankProject.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.guru99bankProject.pageObject.PO_HomePage;
import com.guru99bankProject.pageObject.PO_NewAccount;

public class TC_AddNewAccount extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_AddNewAccount() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public PO_NewAccount na;
	public Faker faker = new Faker();
	public SoftAssert softAssert = new SoftAssert();

	String customerId = "mngr574561";
	String initialDeposites = "25000";
	String accountType = "savings";//saving | current
	
	// TO ADD NEW CUSTOMER
	@Test(priority = 1)
	public void test_AddNewCustomer() throws InterruptedException {
		na = callMeBeforePerformAnyAction();
		hp = na.addNewAccount(customerId, accountType, initialDeposites);
	}

	// CALL ME IN EVERY @TEST METHODS EXCEPT
	public PO_NewAccount callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver); // LOGIN DONE FROM THE BASE CLASS THAT'S WHY IT IS NECCESARY TO CATCH THE DRIVER	AND PAGE OBJECTS
		hp.clickOnMenuDeleteAccount();
		hp.clickOnMenuNewAccount(); // MOVE THE DRIVER ON THE HOME PAGE
		Thread.sleep(2000); // DRIVER WAIT FOR 2 SECONDS
		return new PO_NewAccount(driver); // TO MEMBERSHIP PAGE OBJECTS

	}
}
