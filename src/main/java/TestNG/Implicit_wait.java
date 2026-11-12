package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Implicit_wait {

	@Test
	public void implicitWait() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
//		it will not work on the brower action it will work on only your web element
//		String currentPageUrl = driver.getCurrentUrl();
//		String expectedPageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index" ;
		
//		Assert.assertEquals(currentPageUrl, expectedPageUrl);
//		Reporter.log("Url Matching",true);
		
		 WebElement userName = driver.findElement(By.xpath("//p[text()='John Doe']"));
		 String actualName = userName.getText();
		 String expectedName = "John Doe";
		 
		 Assert.assertEquals(actualName, expectedName, "TC Not maching , TC failed");
		 Reporter.log("Result Maching , Tc Passed",true);
		 
		 
		
		
	}

	
}
