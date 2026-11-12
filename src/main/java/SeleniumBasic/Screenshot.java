package SeleniumBasic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class Screenshot {

	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
		driver.findElement(By.name("username")).sendKeys("Admin123");
		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath(" //button[text()=' Login ']")).click();
		Thread.sleep(4000);
		 File TempScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    String random = RandomString.make(2);
		    String Projectpath = System.getProperty("user.dir");
		    File destination = new File(Projectpath+"\\ScreenShot\\"+random+".png");
		    
//		 File destination = new File("C:\\Users\\Hp\\eclipse-workspace\\Selenium_Project_oct_2026\\ScreenShot\\img1.png");
		 FileHandler.copy(TempScreenshot, destination);
	}
}
