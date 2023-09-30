package com.chrzescijanksaRandka.qa.testScenarios;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.chrzescijanska.randka.pages.AccountPage;
import com.chrzescijanska.randka.pages.HomePage;
import com.chrzescijanska.randka.pages.LoginPage;
import com.chrzescijanskaRandka.qa.base.Base;

public class LoginTest extends Base {
	LoginPage loginPage;

	LoginTest() {
		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.naviageToLoginPage();
		
		
	}
		@AfterMethod
		 public void tearDown() {
			//driver.quit();
		
	}
		@Test(priority=1)
		public void verifyLoggingIntoTheApplicationUsingValidCredentials() {
			//AccountPage accountPage = new AccountPage(driver);
		loginPage.clickOnFirstLoginButton();
			loginPage.login(dataProp.getProperty("validEmail"),dataProp.getProperty("validPassword"));
			AccountPage accountPage = new AccountPage(driver);
			Assert.assertTrue(accountPage.getDisplayStatusOfprofileButton(),"profileButton is not displated");
		}
	

	
}
