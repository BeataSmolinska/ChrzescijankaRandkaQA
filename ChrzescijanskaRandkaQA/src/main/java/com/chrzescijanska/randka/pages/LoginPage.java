package com.chrzescijanska.randka.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	@FindBy(id ="login_panel")
	private WebElement firstLoginButton;

	@FindBy(id ="username")
	private WebElement userField;

	@FindBy(id ="password")
	private WebElement passwordField;

	@FindBy(id ="login")
	private WebElement secondaryLoginButton;

	@FindBy(id = "kleo-login-result")
	private WebElement emailPasswordNotMatchingWarning;

	public void waitForTextInEmailPasswordNotMatchingWarningElement() {

		wait.until(ExpectedConditions.textToBePresentInElement(emailPasswordNotMatchingWarning, "Nieznany adres email."));

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

	public AccountPage login(String emailText, String passwordText) {

		userField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		clickOnSecondaryLoginButton();

		return new AccountPage(driver);

	}

	public String retrieveEmailPasswordNotMatchingWarningMessageText() {

		String warningText = emailPasswordNotMatchingWarning.getText();
		return warningText;

	}

}
