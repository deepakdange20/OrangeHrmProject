package com.orange.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.orange.listener.CustomListener;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orrange.base.TestBase;

@Listeners(CustomListener.class)
public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod 
	public void setUp()
	{
		lauchBrowser();
		loginPage = new LoginPage();
	}
	@Test
	public void verifyLoginPageTitle()
	{
		String loginTitle=loginPage.loginPageTitle();
		Assert.assertEquals(loginTitle, "OrangeHRM");
	}
	
	@Test
	public void verifyLoginPageTest()
	{
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		//String loginPageTittle=	driver.getTitle();	
		Assert.assertTrue(true, "OrangeHRM");
	}
	
	@Test
	public void verifyElemetsVisibilityTest()
	{
		loginPage.elementVisibility();
		Assert.assertTrue(false);
		//Assert.assertTrue(true);
	//	Assert.assertTrue(true);
			
	}
	@Test
	public void verifyForgotPasswordLink()
	{
		String title=loginPage.forgotPassword();
		Assert.assertTrue(false, title);
	

	}
	
	@AfterMethod
	public void logOutApp()
	{
	//	loginPage.logOut();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
