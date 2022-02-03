package com.orange.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orrange.base.TestBase;

public class TestUtils extends TestBase {
	
	
	public TestUtils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void sendKeys(WebDriver driver , int timeout, WebElement ele , String text)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element= wait.until(ExpectedConditions.visibilityOf(ele));
		element.sendKeys(text);
	}
	public static void sendKeys(WebDriver driver , int timeout, By xpath , String text)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		element.sendKeys(text);
	}
	public static void click(WebDriver driver , int timeout, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(ele));
		element.click();
	}
	
	public void takeScreenShot(String methodName)
	{
		Date d = new Date();
		String dd=d.toString().replace(':', '_');
	
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\Smart\\eclipse-workspace\\WebSite\\ScreenShot\\"+methodName+"_"+dd+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			System.out.println("File not found");
		}
		
	}
}
