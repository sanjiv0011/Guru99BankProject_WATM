package com.guru99bankProject.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.guru99bankProject.pageObject.PO_HomePage;
import com.guru99bankProject.pageObject.PO_EditAccount;

public class TC_EditAccount extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_EditAccount() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public PO_EditAccount ea;
	public Faker faker = new Faker();
	public SoftAssert softAssert = new SoftAssert();

	String accountNumber = "123456";
	
	//TO EDIT ACCOUNT NUMBER
	@Test(priority = 1)
	public void test_EditAccount() throws InterruptedException {
		ea = callMeBeforePerformAnyAction();
		hp = ea.editAccount(accountNumber);
	}

	// CALL ME IN EVERY @TEST METHODS
	public PO_EditAccount callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver); // LOGIN DONE FROM THE BASE CLASS THAT'S WHY IT IS NECCESARY TO CATCH THE DRIVER	AND PAGE OBJECTS
		hp.clickOnMenuDeleteAccount();
		hp.clickOnMenuEditAccount(); // MOVE THE DRIVER ON THE HOME PAGE
		Thread.sleep(2000); // DRIVER WAIT FOR 2 SECONDS
		return new PO_EditAccount(driver); // TO MEMBERSHIP PAGE OBJECTS

	}
}
