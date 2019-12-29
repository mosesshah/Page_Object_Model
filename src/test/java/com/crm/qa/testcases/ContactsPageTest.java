package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
	    contactsPage = new ContactsPage();
	    loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickOnContactsLink();
	}
		
		@Test(priority=1)
		public void verifyContactsLabelTest() {
			Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
		}
		
		@Test(priority=2)
		public void selectSingleContactsByNameTest() {
			
			contactsPage.selectContactsByName("Katrina Jade");
			
		}
		
		@Test(priority=3)
		public void selectMutipleContactsByNameTest() {
			
			contactsPage.selectContactsByName("Lena Paul");
			contactsPage.selectContactsByName("Katrina Jade");
			contactsPage.selectContactsByName("Tom Peter");
		}
		
		
		@DataProvider
		public Object[][] getCRMTestData() {
		Object data[][]	= TestUtil.getTestData(sheetName);
		return data;
		}
		
		
		@Test(priority=4, dataProvider = "getCRMTestData")
		public void validateCreateNewContactTest(String title, String firstName, String surName, String company) {
			
			homePage.clickOnNewContactLink();
			//contactsPage.createNewContact("Mr.", "Shavaiz", "Safdar", "Google");
			
			contactsPage.createNewContact(title, firstName, surName, company);
			
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
	}
	
	

