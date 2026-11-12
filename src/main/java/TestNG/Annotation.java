package TestNG;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation {

	
	
	@BeforeClass
	public void launchBrowser() {
		Reporter.log("launch browser...",true);
		Reporter.log("enter URL...",true);
	}
	
	
	
	@BeforeMethod
	public void clickOnLoginBtn() {
		Reporter.log("enter username and password...",true);
		Reporter.log("click On login button...",true);
	}
	
	
	@Test
	public void validateLoginPage() {
		Reporter.log("Landing to the home page...",true);
	}
	
	@Test
	public void validateLoginPage1() {
		Reporter.log("Landing to the home page1...",true);
	}
	
	@AfterMethod
	public void LogoutApp() {
		Reporter.log("logOut application...",true);
	}
	
	@AfterClass
	public void closeBrowser() {
		Reporter.log("close browser...",true);
	}
	
	
	
}
