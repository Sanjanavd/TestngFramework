package com.tesng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testng.base.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "Login")
	WebElement login;
	
	@FindBy(name="rememberUn")
	WebElement rememberMe;
	
	@FindBy(id="forgot_password_link")
	WebElement forgorPassword;
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUserName(String name) {
		waitforElement(username);
		username.sendKeys(name);
	}

	public void enterPassword(String pwd) {
		// waitforElement(password);
		password.sendKeys(pwd);
	}
	
	public void rememberMeCheckBox() {
		waitforElement(rememberMe);
		rememberMe.click();
	}

	public void clickLogin() {
		login.click();
	}
	
	public void clickforgotPassword() {
		waitforElement(forgorPassword);
		forgorPassword.click();
	}

}
