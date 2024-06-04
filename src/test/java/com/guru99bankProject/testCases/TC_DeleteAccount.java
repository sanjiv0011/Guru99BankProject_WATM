package com.guru99bankProject.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.guru99bankProject.pageObject.PO_HomePage;
import com.guru99bankProject.pageObject.PO_DeleteAccount;

public class TC_DeleteAccount extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_DeleteAccount() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public PO_DeleteAccount de;
	public Faker faker = new Faker();
	public SoftAssert softAssert = new SoftAssert();

	String accountNumber = "123456";
	
	//TO DELETE ACCOUNT NUMBER
	@Test(priority = 1)
	public void test_DeleteAccount() throws InterruptedException {
		de = callMeBeforePerformAnyAction();
		hp = de.deleteAccount(accountNumber);
	}

	// CALL ME IN EVERY @TEST METHODS
	public PO_DeleteAccount callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver); // LOGIN DONE FROM THE BASE CLASS THAT'S WHY IT IS NECCESARY TO CATCH THE DRIVER	AND PAGE OBJECTS
		hp.clickOnMenuDeleteAccount();
		Thread.sleep(2000); // DRIVER WAIT FOR 2 SECONDS
		return new PO_DeleteAccount(driver); // TO MEMBERSHIP PAGE OBJECTS

	}
}
