package pl.chrzescijanska.randka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(className = "header-login-button")
	private WebElement zalogujButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnZalogujButton() {
		zalogujButton.click();
	}

	public LoginPage naviageToLoginPage() {

		zalogujButton.click();
		return new LoginPage(driver);

	}
	public boolean getDisplayStatusOfzalogujButton() {
		boolean displayStatus = zalogujButton.isDisplayed();
		return displayStatus;

}
}