package com.guru99bankProject.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.guru99bankProject.pageObject.PO_HomePage;
import com.guru99bankProject.pageObject.PO_NewCustomer;

public class TC_AddNewCustomer extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_AddNewCustomer() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public PO_NewCustomer nc;
	public Faker faker = new Faker();
	public SoftAssert softAssert = new SoftAssert();

	String name = "Jenil";
	String gender = "male";
	String dob = "15/05/2000";
	String address = "123 new street";
	String city = "surat";
	String state = "gujarat";
	String pin = "784564";
	String phoneNumber = "7894561230";
	String email = "abc@yopmaili.com";

	// TO ADD NEW CUSTOMER
	@Test(priority = 1)
	public void test_AddNewCustomer() throws InterruptedException {
		nc = callMeBeforePerformAnyAction();
		hp = nc.addNewCustomer(name, gender, dob, address, city, state, pin, phoneNumber, email);
	}

	// CALL ME IN EVERY @TEST METHODS EXCEPT
	public PO_NewCustomer callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver); // LOGIN DONE FROM THE BASE CLASS THAT'S WHY IT IS NECCESARY TO CATCH THE DRIVER	AND PAGE OBJECTS
		hp.clickOnMenuNewCustomer(); // MOVE THE DRIVER ON THE HOME PAGE
		Thread.sleep(2000); // DRIVER WAIT FOR 2 SECONDS
		return new PO_NewCustomer(driver); // TO MEMBERSHIP PAGE OBJECTS

	}
}
