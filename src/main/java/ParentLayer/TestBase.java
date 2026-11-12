package ParentLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException {
		 prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Selenium_Project_oct_2026\\src\\main\\java\\enviromentLayer\\config.properties");
		prop.load(file);
	}
	
	
	public void Intilization() throws InterruptedException {
		String browserName = prop.getProperty("browserName");
		if(browserName.equals("Chrome")) {
			 driver = new ChromeDriver();
		}else if(browserName.equals("edge")) {
			 driver = new EdgeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else {
			System.out.println("enter valid browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));
		
		
	}
}
