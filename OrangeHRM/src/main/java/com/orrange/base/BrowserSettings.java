package com.orrange.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSettings {

	public static WebDriver launchChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mahesh\\Desktop\\A\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver launchFirfoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\mahesh\\Desktop\\A\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	
}
