package com.guru99bankProject.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.guru99bankProject.pageObject.PO_EditCustomer;
import com.guru99bankProject.pageObject.PO_HomePage;

public class TC_EditCustomer extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_EditCustomer() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public PO_EditCustomer ec;
	public Faker faker = new Faker();
	public SoftAssert softAssert = new SoftAssert();

	String customerId = "mngr574561";

	// TO EIDT NEW CUSTOMER
	@Test(priority = 1)
	public void test_EditCustomer() throws InterruptedException {
		ec = callMeBeforePerformAnyAction();
		hp = ec.editCustomer(customerId);
	}

	// CALL ME IN EVERY @TEST METHODS
	public PO_EditCustomer callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver); // LOGIN DONE FROM THE BASE CLASS THAT'S WHY IT IS NECCESARY TO CATCH THE DRIVER	AND PAGE OBJECTS
		hp.clickOnMenuEditCustomer(); // MOVE THE DRIVER ON THE HOME PAGE
		Thread.sleep(2000); // DRIVER WAIT FOR 2 SECONDS
		return new PO_EditCustomer(driver); // TO MEMBERSHIP PAGE OBJECTS

	}
}
