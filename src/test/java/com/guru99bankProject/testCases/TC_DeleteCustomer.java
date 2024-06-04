package com.guru99bankProject.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.guru99bankProject.pageObject.PO_DeleteCustomer;
import com.guru99bankProject.pageObject.PO_HomePage;

public class TC_DeleteCustomer extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_DeleteCustomer() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public PO_DeleteCustomer dc;
	public Faker faker = new Faker();
	public SoftAssert softAssert = new SoftAssert();

	String customerId = "mngr574561";

	// TO DELETE CUSTOMER
	@Test(priority = 1)
	public void test_DeleteNewCustomer() throws InterruptedException {
		dc = callMeBeforePerformAnyAction();
		hp = dc.deleteCustomer(customerId);
	}

	// CALL ME IN EVERY @TEST METHODS
	public PO_DeleteCustomer callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver); // LOGIN DONE FROM THE BASE CLASS THAT'S WHY IT IS NECCESARY TO CATCH THE DRIVER	AND PAGE OBJECTS
		hp.clickOnMenuEditCustomer(); // MOVE THE DRIVER ON THE HOME PAGE
		Thread.sleep(2000); // DRIVER WAIT FOR 2 SECONDS
		return new PO_DeleteCustomer(driver); // TO MEMBERSHIP PAGE OBJECTS

	}
}
