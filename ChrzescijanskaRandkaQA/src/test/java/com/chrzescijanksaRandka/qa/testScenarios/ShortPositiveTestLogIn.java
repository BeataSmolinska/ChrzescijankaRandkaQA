package com.chrzescijanksaRandka.qa.testScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.chrzescijanska.randka.pages.HomePage;


public class ShortPositiveTestLogIn {
	
	WebDriver driver;
	
	
	@BeforeTest
public void beforetest() {
		
		
	


driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("https://www.chrzescijanskarandka.pl/");



	}
	public void shortPositiveTestLogIn() {
		HomePage page = new HomePage(driver);
		//HomePage page = new HomePage(driver);
		//page.clickZaloguj();
       
		

		
		}
		
			
			
		
	
	
	
	
	

}

