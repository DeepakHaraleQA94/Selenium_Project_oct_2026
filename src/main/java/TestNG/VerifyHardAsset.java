package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class VerifyHardAsset {

	@Test
	public void verifyLoginPage() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
//		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(30));
//	WebElement	 uname = driver.findElement(By.name("username"));
//		w.until(ExpectedConditions.visibilityOf(uname));
		
//		uname.sendKeys("Admin");
		
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		

		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https123://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		

		
		Assert.assertEquals(actualResult, expectedResult,"TC failed");
		Reporter.log("TC Passed", true);
		System.out.println("continue...!");
		
		if(actualResult.equals(expectedResult)) {
			System.out.println("TC passed");
		}else {
			System.out.println("TC Failed");
		}
		
		
	}
}
