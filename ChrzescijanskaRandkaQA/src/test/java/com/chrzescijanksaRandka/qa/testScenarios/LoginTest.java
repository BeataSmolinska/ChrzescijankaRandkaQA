package com.chrzescijanksaRandka.qa.testScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.chrzescijanska.randka.pages.AccountPage;
import com.chrzescijanska.randka.pages.HomePage;
import com.chrzescijanska.randka.pages.LoginPage;
import com.chrzescijanskaRandka.qa.base.Base;
import com.chrzescijanskja.randka.ulils.Utils;

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
		// driver.quit();

	}

	@Test(priority=1)
		public void verifyLoggingIntoTheApplicationUsingValidCredentials() {
		
		loginPage.clickOnFirstLoginButton();
		    loginPage.login(dataProp.getProperty("validEmail"),dataProp.getProperty("validPassword"));
			AccountPage accountPage = new AccountPage(driver);
			Assert.assertTrue(accountPage.getDisplayStatusOfprofileButton(),"profileButton is not displated");
	}		
			@Test(priority=2)
			public void verifyLoggingIntoTheApplicationUsingInvalidCredentials() {
				loginPage.login(Utils.generateEmailWithTimeStamp(),prop.getProperty("invalidPassword"));
				  loginPage. waitForTextInEmailPasswordNotMatchingWarningElement();
			

			loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
				
				Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected Warning message is not displayed");
				//Assert.assertEquals(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText(), (dataProp.getProperty("emailPasswordNoMatchWarning")), "Login failed!");
		
			}
			
		}


