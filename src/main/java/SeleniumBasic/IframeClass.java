package SeleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Hp/Downloads/attractive_iframe_practice%20(1).html");
//		WebElement frame1 = driver.findElement(By.id("frame1"));

		driver.switchTo().frame("frame1");

		WebElement getTextOfFrame1 = driver.findElement(By.xpath("//p[contains(text(),'This is the first iframe')]"));
		System.out.println(getTextOfFrame1.getText());

		driver.switchTo().frame("frame2");

		WebElement text = driver.findElement(By.id("frame2Input"));
		text.clear();
		text.sendKeys("Selenium Java");
		driver.switchTo().defaultContent();
		WebElement text1 = driver
				.findElement(By.xpath("//div[text()='Tip: switch into each iframe before locating its elements.']"));
		System.out.println(text1.getText());
	}
}
