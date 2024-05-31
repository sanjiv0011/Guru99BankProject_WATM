package com.guru99bankProject.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.guru99bankProject.pageObject.PO_HomePage;
import com.guru99bankProject.pageObject.PO_LoginPage;

public class TC_Home extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Home() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_HomePage hp;
	public PO_LoginPage lp;
	public Faker faker  = new Faker();
	public SoftAssert softAssert = new SoftAssert();
	
	String cardHolderName = faker.name().fullName();
	String expiary = "34/45";
	String CCVcode = "546";
	String zipCode = "564665";
	
	//TO CHECK HOME PAGE ELEMENT
	@Test(priority = 1)
	public void test_HomePageElement() throws InterruptedException {
		hp = new PO_HomePage(driver);
		hp.checkClickActionOnHomePageElement();
	}

	//TO CHENGE THE CARD DETAILS
	//@Test(priority = 2)
	public void test_ChangeCardDetails() throws InterruptedException {
		hp = new PO_HomePage(driver);
		hp.changeCardDetails(cardHolderName,expiary,CCVcode,zipCode);
	}

}