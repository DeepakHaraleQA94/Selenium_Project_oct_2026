package UtilityLayer;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ParentLayer.TestBase;

public class utility extends TestBase {

	public utility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void captureScreenshot(String methodName) throws Throwable {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Hp\\eclipse-workspace\\Selenium_Project_oct_2026\\ScreenShot\\"+methodName+".png");
		FileHandler.copy(src, des);
	}
	
	
	public static ExtentReports getExtentReport() {
		
		ExtentReports report = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		report.attachReporter(sparkReporter);
		
		return report;
		
	}
	}

	


