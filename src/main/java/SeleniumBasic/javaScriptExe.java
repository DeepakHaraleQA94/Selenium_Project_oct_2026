package SeleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaScriptExe {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		 JavascriptExecutor js = ((JavascriptExecutor)driver);
		 js.executeScript("document.getElementById('name').value='Admin'");
		 js.executeScript("document.getElementsByName('start')[0].click()");
		 String getURL = js.executeScript("return document.URL").toString();
		 System.out.println(getURL);
			String getTitle = js.executeScript("return document.title").toString();
			System.out.println(getTitle);

			String javascript = "document.getElementById('alertBtn').style.border='5px solid red'";
			js.executeScript(javascript);
			
			js.executeScript("document.getElementById('btn1').scrollIntoView()");
			js.executeScript("alert('hello');");


			



		
	}
}
