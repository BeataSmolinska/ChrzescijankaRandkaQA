package com.chrzescijanksaRandka.qa.testScenarios;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.chrzescijanska.randka.pages.AfterLogInPage;
import com.chrzescijanska.randka.pages.HomePage;
import com.chrzescijanska.randka.pages.LoginPage;
import com.chrzescijanskaRandka.qa.base.Base;



public class LoginTest extends Base{
	LoginPage loginPage;
	
	LoginTest (){
		super();
	}
	  WebDriver driver;
	
	@BeforeTest
public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.naviageToLoginPage();
		

	}
	
	@Test
	public void test() {
		driver.quit();
	}
}






