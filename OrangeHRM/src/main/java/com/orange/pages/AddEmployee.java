package com.orange.pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.orange.utils.AddEmployeeExcel;
import com.orrange.base.TestBase;

public class AddEmployee extends TestBase{

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='middleName']")
	private WebElement middleName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='employeeId']")
	private WebElement employeeId;
	
	@FindBy (xpath = "//input[@type='file']")
	WebElement uploadFile;
	
	public AddEmployee() {
		PageFactory.initElements(driver,this);
	}

	public void getFirstName(String fn) {
		firstName.clear();
		firstName.sendKeys(fn);
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmployeeId() {
		return employeeId;
	}
	
	public void clickOnuplaodPhoto() throws IOException
	{
		uploadFile.sendKeys("C:\\Users\\Smart\\Desktop\\AutoItScript\\fileuploadxyz.exe");
	//	Actions actions = new Actions(driver);
	//	actions.moveToElement(uploadFile).click().build().perform();
		//uploadFile.click();
	}
	
	public void getFile() throws IOException {
		Runtime.getRuntime().exec("C:\\Users\\Smart\\Desktop\\AutoItScript\\fileuploadxyz.exe");
	}
}
