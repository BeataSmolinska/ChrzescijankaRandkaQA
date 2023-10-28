package com.chrzescijanksaRandka.qa.testScenarios;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.chrzescijanskaRandka.qa.base.Base;

import pl.chrzescijanska.randka.pages.AccountPage;
import pl.chrzescijanska.randka.pages.HomePage;
import pl.chrzescijanska.randka.pages.LoginPage;
import pl.chrzescijanskja.randka.ulils.Utils;

public class LoginTest extends Base {
	LoginPage loginPage;

	LoginTest() {
		super();
	}

	public WebDriver driver;

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

	@Test(priority = 1)
	public void verifyLoggingIntoTheApplicationUsingValidCredentials() {

		loginPage.clickOnFirstLoginButton();
		loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfprofileButton(), "profileButton is not displated");
	}

	@Test(priority = 2)
	public void verifyLoggingIntoTheApplicationUsingInvalidCredentials() {
		loginPage.login(Utils.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		loginPage.waitForTextInEmailPasswordNotMatchingWarningElement();
		loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();

		Assert.assertTrue(
				loginPage.retrieveEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNoMatchWarning")),
				"Expected Warning message is not displayed");

	}

	@Test(priority = 3)
	public void verifyLoggingIntoTheApplicationUsingKeyboardKeysTabAndEnter() {

		loginPage.loginUsingTabAndEnter(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfprofileButton(), "profileButton is not display");
	}

	@Test(priority = 4)
	public void VerifyLoggingIntoTheApplicationWithoutProvidingAnyCredentials() {
		loginPage.clickOnFirstLoginButton();
		loginPage.clickOnSecondaryLoginButton();
		Assert.assertTrue(loginPage.getDisplayStatusOfsecondaryLoginButton(), "secondaryLoginButton is not display");

	}

}
