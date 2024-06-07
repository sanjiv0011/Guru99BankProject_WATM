package com.guru99bankProject.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.guru99bankProject.pageObject.PO_HomePage;
import com.guru99bankProject.pageObject.PO_CustomizedStatement;

public class TC_CustomizedStatement extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_CustomizedStatement() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public PO_CustomizedStatement cs;
	public Faker faker = new Faker();
	public SoftAssert softAssert = new SoftAssert();

	String accountNumber = "123456";
	String toDate = "10-05-2024";
	String fromDate = "10-05-2023";
	String amountLimit = "25000";
	String numberOfTransactions = "100";
	
	//TO MINI STATEMENT
	@Test(priority = 1)
	public void test_MiniStatement() throws InterruptedException {
		cs = callMeBeforePerformAnyAction();
		hp = cs.customizedStatement(accountNumber, toDate, fromDate, amountLimit, numberOfTransactions);
	}

	// CALL ME IN EVERY @TEST METHODS
	public PO_CustomizedStatement callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver); // LOGIN DONE FROM THE BASE CLASS THAT'S WHY IT IS NECCESARY TO CATCH THE DRIVER	AND PAGE OBJECTS
		hp.clickOnMenuCustomisedStatement();
		Thread.sleep(2000); // DRIVER WAIT FOR 2 SECONDS
		return new PO_CustomizedStatement(driver); // TO MEMBERSHIP PAGE OBJECTS

	}
}
