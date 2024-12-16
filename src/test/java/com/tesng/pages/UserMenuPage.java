package com.tesng.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.testng.base.BasePage;

public class UserMenuPage extends BasePage{
	
	@FindBy(id="userNavButton")
	WebElement userMenuButton;
	
	@FindBy(linkText = "My Profile")
	WebElement myProfileLink;
	
	@FindBy(linkText = "My Settings")
	WebElement mySettingsLink;
	
	@FindBy(linkText ="Developer Console")
	WebElement devConsoleLink;
	
	@FindBy(linkText = "Switch to Lightning Experience")
	WebElement lightningExpLink;
	
	@FindBy(linkText = "Logout")
	WebElement logOutButton;

	public UserMenuPage(WebDriver driver) {
		super(driver);
	}
	
	public void userMenuDropDown() {
		userMenuButton.click();
	}
	
	

}
