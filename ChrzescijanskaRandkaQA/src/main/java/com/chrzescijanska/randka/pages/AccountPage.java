package com.chrzescijanska.randka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;

	@FindBy(css = ".icon-user.hide-for-medium-down")
	WebElement profileButton;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean getDisplayStatusOfprofileButton() {
		boolean displayStatus = profileButton.isDisplayed();
		return displayStatus;
	}
}
