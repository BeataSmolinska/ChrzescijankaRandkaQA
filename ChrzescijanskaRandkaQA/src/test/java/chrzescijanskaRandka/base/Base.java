package chrzescijanskaRandka.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public Properties prop;
	public Properties dataProp;
	WebDriver driver;
	protected WebDriverWait wait;

	public Base() {

		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\pl\\chrzescijanskaRandka\\config\\config.properties");
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\pl\\chrzescijanskaRandka\\testData\\testData.properties");
		try {
			FileInputStream dataFis = new FileInputStream(dataPropFile);
			dataProp.load(dataFis);
		} catch (Throwable e) {
			e.printStackTrace();

		}

		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("Safari")) {
			driver = new SafariDriver();
		}

		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(pl.chrzescijanskaRandka.utils.Utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(pl.chrzescijanskaRandka.utils.Utils.PAGE_LOAD_TIME));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}

	public void waitForElementToBeClickable(By Name) {
		wait.until(ExpectedConditions.elementToBeClickable(Name));
	}

	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void waitForTextToBePresentInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
}