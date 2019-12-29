package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Factory/Object Repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Up')]")
	WebElement signUpbtn;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmLogo;
	
	
	// Initialising the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}
	
}
