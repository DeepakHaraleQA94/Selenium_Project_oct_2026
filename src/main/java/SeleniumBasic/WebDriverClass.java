package SeleniumBasic;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverClass {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().refresh();
		
		String title = driver.getTitle();
		System.out.println("current page title is "+ title);
		
		
		String url = driver.getCurrentUrl();
		System.out.println("cuurent page url is "+ url);
		
		
		
		
		Thread.sleep(3000);
		
		
		driver.close();
	}
}
