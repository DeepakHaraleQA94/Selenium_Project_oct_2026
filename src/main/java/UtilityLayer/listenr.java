package UtilityLayer;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ParentLayer.TestBase;

public class listenr extends TestBase implements ITestListener {
	utility util;
	
	ExtentReports report = utility.getExtentReport();
	ExtentTest eTest;
	public listenr() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	  public void onStart(ITestContext context) {
		    Reporter.log("Test Class excution started", true);
		  }
	
	public void onTestStart(ITestResult result) {
	    String methodName = result.getMethod().getMethodName();
	    Reporter.log("[TEST STARTED] Test Case: " + methodName, true);

	    eTest = report.createTest(methodName);
	    eTest.log(Status.INFO, "Test execution started: " + methodName);

	  }
	
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		  Reporter.log("Test case execution succeess"+methodName,true);
		  
		   eTest = report.createTest(methodName);
		    eTest.log(Status.PASS, "Test execution completed: " + methodName);
	  }
	
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		  Reporter.log("Test case execution failed"+methodName,true);
		  
		   eTest = report.createTest(methodName);
		    eTest.log(Status.FAIL, "Test execution failed: " + methodName);
		    eTest.log(Status.INFO, result.getThrowable());  
		  try {
			 util = new utility();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			util.captureScreenshot(methodName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		  Reporter.log("Test case execution skipped"+methodName,true);
		  
		   eTest = report.createTest(methodName);
		    eTest.log(Status.SKIP, "Test execution skipped: " + methodName);
	  }

	
	public void onFinish(ITestContext context) {
		report.flush();
		  Reporter.log("Test case execution completed",true);
	  }

	
}
