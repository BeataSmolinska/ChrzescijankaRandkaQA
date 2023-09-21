package com.chrzescijanska.randka.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
WebDriver driver;

	public LoginPage (WebDriver driver) {
	this.driver = driver;
	}
	By logInBox = By.id("username");
	By passwordBox = By.id("password");
	By logIn_btn = By.id("login");
	
	public void enterUsername() {
		driver.findElement(logInBox).sendKeys("Tester");
	}
public void enterPassword() {
	driver.findElement(passwordBox).sendKeys("lespak13");
}

public void verifyLogIn() {
	driver.findElement(logIn_btn).click();
	 
	
	
}
}
