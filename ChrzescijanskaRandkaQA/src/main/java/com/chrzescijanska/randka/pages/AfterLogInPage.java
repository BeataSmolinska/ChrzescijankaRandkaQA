package com.chrzescijanska.randka.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AfterLogInPage {
	WebDriver driver;
	
	public AfterLogInPage (WebDriver driver) {
		this.driver = driver;
	}
	
By wyloguj_btn = By.className("tiny button radius btn-logout");

public void clickingLogo_btn() {
	//driver.findElement(logo_btn);
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 //wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("img#logo_img")))).click();
   
}

}
