package SeleniumBasic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildPopUp {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.id("PopUp")).click();
		 Set<String> windowsId = driver.getWindowHandles();
		 System.out.println(windowsId);
		 
		 Iterator<String> itr = windowsId.iterator();
		  String mainWindow = itr.next();
		  String child1 = itr.next();
		  String child2 = itr.next();
		  System.out.println(mainWindow);
		  System.out.println(child1);
		  System.out.println(child2);
		  
		 driver.switchTo().window(child1);
		 driver.manage().window().maximize();
		 driver.close();
		 
		 driver.switchTo().window(child2);
		 driver.manage().window().maximize();
		 driver.close();
		 
		 driver.switchTo().window(mainWindow);
		 driver.close();
		 
		 
		 
		 
		 
		 
	}

}
