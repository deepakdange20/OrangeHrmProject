package com.orange.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orange.pages.AddEmployee;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orange.utils.AddEmployeeExcel;
import com.orrange.base.TestBase;

public class AddEmployeeTest extends TestBase {
	
	HomePage homePage;
	
	LoginPage loginPage;
	AddEmployee addEmployee;
	public AddEmployeeTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@DataProvider
	public Iterator<Object[]> excelDataItrator() throws InvalidFormatException, IOException
	{
		 ArrayList<Object[]> eData=AddEmployeeExcel.getExcelData();
		return eData.iterator();
	}
	
	@BeforeClass
	public void setUp() {
		lauchBrowser();
		loginPage = new LoginPage();
		homePage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		addEmployee = new AddEmployee();
	}

	
	@Test(dataProvider = "excelDataItrator")
	public void verifyaddEmployee(String FirstName, String MiddleName, String LastName, String EmpID) throws IOException
	{
		homePage.mouseHoverOnPIM();
		homePage.addEmployee();
		
		System.out.println(FirstName);
		addEmployee.getFirstName(FirstName);
		
		addEmployee.getMiddleName().clear();
		addEmployee.getMiddleName().sendKeys(MiddleName);
		
		addEmployee.getLastName().clear();
		addEmployee.getLastName().sendKeys(LastName);
		
		addEmployee.getEmployeeId().clear();
		addEmployee.getEmployeeId().sendKeys(EmpID);
	
	//	addEmployee.clickOnuplaodPhoto();
	//	addEmployee.getFile();
	}
	
	@Test
	public void uplaodfile() throws IOException, InterruptedException
	{
		homePage.mouseHoverOnPIM();
		homePage.addEmployee();
		addEmployee.clickOnuplaodPhoto();
	//	addEmployee.uplaodPhoto();
		Thread.sleep(2000);
		addEmployee.getFile();
	}
}
