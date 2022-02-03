package com.orange.listener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.orange.utils.TestUtils;
import com.orrange.base.TestBase;

public class CustomListener extends TestUtils implements ITestListener { //or extends TestListenerAdapter

	 public void onTestStart(ITestResult result) 
	 {
	    System.out.println("Test Started");
	  }

	  
	  public void onTestSuccess(ITestResult result)
	  {
		  System.out.println("Test success");
	  }

	
	  public  void onTestFailure(ITestResult result) 
	  {
		  takeScreenShot(result.getMethod().getMethodName());
		  System.out.println("Test failed with timeout:"+(result.getEndMillis() - result.getStartMillis()));
		  System.out.println("Test failed");
	  }

	 
	 public void onTestSkipped(ITestResult result)
	 {
		 System.out.println("Test Skipped");
	    
	  }

	 

	   public void onTestFailedWithTimeout(ITestResult result) 
	   {
	    onTestFailure(result);
	    System.out.println("Test failed with timeout:"+(result.getEndMillis() - result.getStartMillis()));
	   }

	
	
}

