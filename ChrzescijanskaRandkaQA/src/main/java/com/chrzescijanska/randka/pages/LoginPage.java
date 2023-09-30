package com.chrzescijanska.randka.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="login_panel")
	private WebElement firstLoginButton;

	@FindBy(id = "username")
	private WebElement userField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login")
	private WebElement secondaryLoginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public AccountPage clickOnFirstLoginButton() {
		firstLoginButton.click();
		return new AccountPage(driver);
		
	}


	public void enterUsername(String emailText) {
		userField.sendKeys(emailText);
	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public AccountPage clickOnSecondaryLoginButton() {

		secondaryLoginButton.click();
		return new AccountPage(driver);
		
	}
	
	public AccountPage login(String emailText,String passwordText) {
		
		userField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		clickOnSecondaryLoginButton();
		return new AccountPage(driver);
		
	}
	

	}

