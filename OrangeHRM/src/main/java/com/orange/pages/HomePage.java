package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orrange.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
	private WebElement PIM;
	
	@FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']")
	private WebElement employeeList;
	
	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	WebElement addEmployee;
	
	@FindBy(xpath = "//a[@id='welcome']")
	private WebElement welcomeUserLink;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	public void mouseHoverOnPIM() {
		Actions actions = new Actions(driver);
		actions.moveToElement(PIM).build().perform();
	}

	public void getEmployeeList() {
		employeeList.click();
	}
	
	public String addEmployee() {
		addEmployee.click();
		return driver.getCurrentUrl();
	}

	public void mouseOverWelcome()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(welcomeUserLink).click().build().perform();
	}
	
	public void logOut()
	{
		logout.click();
	}
	
	
}
