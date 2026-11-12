package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Explicit_SoftAssert {

	@Test
	public void verifyLoginPage() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//		driver.findElement(By.name("username")).sendKeys("Admin");
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

//		1st Check point

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualResult, expectedResult, "TC failed");


//	 2rd check point

		String title = driver.getTitle();
		String expectedTitle = "OrangeHRM";
		soft.assertEquals(title, expectedTitle);
	

//	3rd check point

		WebElement Checktext = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Dashboard']")));
		String actualText = Checktext.getText();
		String ExpectedText = "Dashboard";
		soft.assertEquals(actualText, ExpectedText);
		
		soft.assertAll();
	}

	
}
