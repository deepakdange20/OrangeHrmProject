package com.orange.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orrange.base.BrowserSettings;
import com.orrange.base.TestBase;

public class HomePageTest  extends TestBase{
	private	HomePage homePage;
	private LoginPage loginPage;
	WebDriver driver;
	public HomePageTest() {
		super();
	}
	
	@BeforeClass
	public void initialization()
	{
		lauchBrowser();
	}
	
	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage();
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test
	public void VerifyEmployeeLink()
	{
		homePage.mouseHoverOnPIM();
		homePage.getEmployeeList();
		Assert.assertTrue(true);
	}
	
	@Test 
	public void verifyAddEmployeeLink()
	{
		homePage.mouseHoverOnPIM();
		String urlAddEmployee=homePage.addEmployee();
		System.out.println(urlAddEmployee);
		Assert.assertEquals(urlAddEmployee,"https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
	}
	
	@AfterMethod
	public void logOutApp()
	{
		homePage.mouseOverWelcome();
		homePage.logOut();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
