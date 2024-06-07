package com.guru99bankProject.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.guru99bankProject.pageObject.PO_HomePage;
import com.guru99bankProject.pageObject.PO_MiniStatement;

public class TC_MiniStatement extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_MiniStatement() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public PO_MiniStatement ms;
	public Faker faker = new Faker();
	public SoftAssert softAssert = new SoftAssert();

	String accountNumber = "123456";
	
	//TO MINI STATEMENT
	@Test(priority = 1)
	public void test_MiniStatement() throws InterruptedException {
		ms = callMeBeforePerformAnyAction();
		hp = ms.miniStatement(accountNumber);
	}

	// CALL ME IN EVERY @TEST METHODS
	public PO_MiniStatement callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver); // LOGIN DONE FROM THE BASE CLASS THAT'S WHY IT IS NECCESARY TO CATCH THE DRIVER	AND PAGE OBJECTS
		hp.clickOnMenuMiniStatement();
		Thread.sleep(2000); // DRIVER WAIT FOR 2 SECONDS
		return new PO_MiniStatement(driver); // TO MEMBERSHIP PAGE OBJECTS

	}
}
