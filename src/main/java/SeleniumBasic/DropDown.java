package SeleniumBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement country = driver.findElement(By.id("country"));
		List<WebElement> list = country.findElements(By.tagName("option"));
		 int length = list.size();
		 System.out.println(length);
		for(int i=0; i<=length-1; i++) {
			String options = list.get(i).getText();
			System.out.println(options);
			if(options.equals("Japan")) {
			list.get(i).click();
			}
		 
//		 for(WebElement obj:list) {
//			String option=obj.getText().toString();
//			 System.out.println(option);
//			 
//			 if(option.equals("India")) {
//				 obj.click();
//			 }
		}
		
		
		
		
		
		
		
		
		
//		Select select = new Select(country);
//		select.selectByIndex(2);
//		Thread.sleep(3000);
//		select.selectByVisibleText("France");
//		Thread.sleep(3000);
//		select.selectByValue("usa");
//		
		
		
		
	}
}
