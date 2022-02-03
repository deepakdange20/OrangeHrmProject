package com.orange.pages;

import java.nio.file.WatchEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orange.utils.TestUtils;
import com.orrange.base.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='txtPassword']")
	private WebElement passWord;
	
	@FindBy(xpath ="//input[@type='submit']" )
	private WebElement login;
	
	@FindBy (xpath = "//a[text()='Forgot your password?']")
	private WebElement forgotPassword;
	
	@FindBy(xpath = "(//div[@class='inner']//div)[1]")
	private WebElement succussFP;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLogin() {
		return login;
	}


	public WebElement getForgotPassword() {
		return forgotPassword;
	}

	public WebElement getSuccussFP() {
		return succussFP;
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassWord() {
		return passWord;
	}

	public String forgotPassword()
	{
		getForgotPassword().click();
		return getSuccussFP().getText();
	}
	
	public void elementVisibility()
	{
		boolean un = userName.isDisplayed();
		boolean pw = passWord.isDisplayed();
		boolean lg = login.isEnabled();
	}

	public String loginPageTitle() 
	{
		return driver.getTitle();
	}
	
	public HomePage doLogin(String un , String pw)
	{
		TestUtils.sendKeys(driver, 10, getUserName(), un);
		getPassWord().sendKeys(pw);
		getLogin().click();
		return  new HomePage();
	}
	
	
}
