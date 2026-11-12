package SeleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptClass {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('name').value='john'");
		Thread.sleep(3000);
		js.executeScript("document.getElementsByName('start')[0].click()");
		String getURL = js.executeScript("return document.URL").toString();
		System.out.println(getURL);
		
		String getTitle = js.executeScript("return document.title").toString();
		System.out.println(getTitle);
		
		String javascript = "document.getElementById('alertBtn').style.border='5px solid black'";
		
		js.executeScript(javascript);
		
		js.executeScript("document.getElementById('btn2').scrollIntoView()");
		
		js.executeScript("document.getElementById('btn2').click()");
		
		js.executeScript("alert('hello');");

		

	}
}
