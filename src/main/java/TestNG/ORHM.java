package TestNG;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ORHM {
	WebDriver driver;
	private WebElement uname;
@Parameters("BrowserName")
	@Test
	public void verifyLoginPage(String BrowserName ) throws InterruptedException {
		if(BrowserName.equals("Chrome")) {
			 driver = new ChromeDriver();
		}else if(BrowserName.equals("edge")) {
			driver = new EdgeDriver();
		}else if(BrowserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else {
			System.out.println("Enter Valid Browser Name");
		}

		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		Thread.sleep(3000);
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(30));
	WebElement	 uname = driver.findElement(By.name("username"));
		w.until(ExpectedConditions.visibilityOf(uname));
		
		uname.sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		

		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https123://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
//		if(actualResult.equals(expectedResult)) {
//			System.out.println("TC passed");
//		}else {
//			System.out.println("TC Failed");
//		}
		
		Assert.assertEquals(actualResult, expectedResult,"TC failed");
		Reporter.log("TC Passed", true);
		
	}
}
