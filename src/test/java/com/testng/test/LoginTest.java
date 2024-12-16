package com.testng.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tesng.pages.LoginPage;
import com.testng.base.BaseTest;
import com.testng.utilities.ScreenshotUtilities;

public class LoginTest extends BaseTest {
	WebDriver driver;
	LoginPage loginPage;
	ScreenshotUtilities screenShot = new ScreenshotUtilities();

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = getDriver();
		loginPage = new LoginPage(driver);
	}

	@Test
	public void noPassword() throws IOException {
		loginPage.enterUserName(properties.getProperties("name"));
		loginPage.clickLogin();
		String ActualMessage = driver.findElement(By.xpath("//div[contains(text(),'Please enter your password.')]"))
				.getText();
		String ExpectedMessage = "Please enter your password.";
		Assert.assertEquals(ActualMessage, ExpectedMessage);
	}

	@Test
	public void successfullLogin() throws IOException, InterruptedException {
		loginPage.enterUserName(properties.getProperties("name"));
		loginPage.enterPassword(properties.getProperties("pwd"));
		loginPage.clickLogin();
		Thread.sleep(3000);
		String ActualPageTitle = driver.getTitle();
		String ExpectedPageTitle = "Home Page ~ Salesforce - Developer Edition";

		Assert.assertEquals(ActualPageTitle, ExpectedPageTitle);
	}

	@Test
	public void checkrememberMe() throws IOException, InterruptedException {
		loginPage.enterUserName(properties.getProperties("name"));
		loginPage.enterPassword(properties.getProperties("pwd"));
		loginPage.rememberMeCheckBox();
		loginPage.clickLogin();
		Thread.sleep(3000);
		String ActualPageTitle = driver.getTitle();
		String ExpectedPageTitle = "Home Page ~ Salesforce - Developer Edition";

		Assert.assertEquals(ActualPageTitle, ExpectedPageTitle);
	}

	@Test
	public void forgotPassword() throws InterruptedException {
		loginPage.clickforgotPassword();
		Thread.sleep(2000);
		String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password')]")).getText();
		String expectedText = "Forgot Your Password";

		Assert.assertEquals(actualText, expectedText);
	}

	@Test
	public void invalidCredentials() throws IOException, InterruptedException {
		loginPage.enterUserName(properties.getProperties("invalidName"));
		loginPage.enterPassword(properties.getProperties("invalidPwd"));
		loginPage.clickLogin();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed(), "TEst");

	}

	@AfterMethod
	public void tearDown() {
		//screenShot.takeScreenShot(driver);
		closeBrowser();
	}

}
