package com.guru99bankProject.Main.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.guru99bankProject.Main.pageObject.PO_Main_HomePage;
import com.guru99bankProject.pageObject.PO_HomePage;
import com.guru99bankProject.pageObject.PO_LoginPage;
import com.guru99bankProject.testCases.BaseClass;

public class TC_Main_Home extends BaseClass{
	//HOME PAGE CONSTRUCTOR
	public TC_Main_Home() {
		super();
	}
	
	//CONSTRUCTOR DECLARATION
	public PO_LoginPage lp;
	public PO_HomePage hp;
	public Faker faker  = new Faker();
	public PO_Main_HomePage m_hp;
	
	//TO MAIN HOME PAGE TAB TESTING
	@Test(priority = 1)
	public void test_Main_HomePageTabTesting() throws InterruptedException {
		m_hp = new PO_Main_HomePage(driver);
		hp = m_hp.mainHomePageTesting();
		logger.info(hp);
	}
}