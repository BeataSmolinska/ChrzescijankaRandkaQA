package com.chrzescijanskaRandka.qa.base;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	
	public Properties prop;
	public Properties dataProp;
	WebDriver driver;
	public Base() {


		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")
		+ "\\src\\main\\java\\com\\chrzescijanska\\randka\\qa\\config\\config.properties");
		dataProp= new Properties();
		File dataPropFile = new File (System.getProperty("user.dir") + "\\src\\test\\java\\com\\chrzescijanska\\ranska\\qa\\testData\\testData.properties");
		try {
		FileInputStream dataFis = new FileInputStream(dataPropFile);
		dataProp.load(dataFis);}
		catch (Throwable e) {
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(com.chrzescijanskja.randka.ulils.Utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(com.chrzescijanskja.randka.ulils.Utils.PAGE_LOAD_TIME));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
