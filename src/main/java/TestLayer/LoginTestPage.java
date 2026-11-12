package TestLayer;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ParentLayer.TestBase;
import PomPages.LoginPage;
import UtilityLayer.dataProvider;
import UtilityLayer.listenr;

//@Listeners(UtilityLayer.listenr.class)
public class LoginTestPage extends TestBase{
	dataProvider provider;
	LoginPage login;
	public LoginTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@BeforeMethod
	public void preMethod() throws IOException, InterruptedException {
		Intilization();
		 login = new LoginPage();
	}
	
	
//	@DataProvider
//	public Object[][] testData() {
//		Object data[][] =  {{"Admin","admin123"},
//							{"test", "test@123"}
//							};
//		return data;
//		
//		}
	
	@DataProvider(name = "excelData")
	public Object[][] testData() throws IOException {
		provider = new dataProvider();
		Object[][] data = provider.CollectDataFromExcel("Sheet3");
		return data;
	}
	
	
	@Test(dataProvider = "excelData")
	public void validateLoginPage(String uname, String passwd) {
		
		login.enterUsername(uname);
		login.enterPass(passwd);
		login.clickOnLoginBtn();

		String actualResult = driver.getCurrentUrl();
		String ExpectedResult = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(actualResult, ExpectedResult, "Not Matching url, TC failed");
		Reporter.log("TC passed",true);
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
