package SeleniumBasic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction {

	public static void main(String[] args) throws InterruptedException {
		  WebDriver driver = new ChromeDriver();

	        try {
	            driver.manage().window().maximize();

	            // Open OrangeHRM login page
	            driver.get(
	                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
	            );

	            WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(15));

	            JavascriptExecutor js = (JavascriptExecutor) driver;

	            // Wait for Username field
	            WebElement username = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                    By.name("username")
	                )
	            );

	            // Enter Username using JavaScript
	            js.executeScript(
	                "arguments[0].value = arguments[1];",
	                username, "Admin"
	            );

	            // Enter Password using JavaScript
	            WebElement password =
	                driver.findElement(By.name("password"));

	            js.executeScript(
	                "arguments[0].value = arguments[1];",
	                password, "admin123"
	            );

	            // Highlight Login button
	            WebElement loginButton = driver.findElement(
	                By.xpath("//button[@type='submit']")
	            );

	            js.executeScript(
	                "arguments[0].style.border='3px solid red';",
	                loginButton
	            );

	            Thread.sleep(1000);

	            // Click Login using JavaScript
	            js.executeScript("arguments[0].click();", loginButton);

	            // Wait until Dashboard loads
	            wait.until(
	                ExpectedConditions.urlContains("/dashboard")
	            );

	            // Get current URL
	            String currentURL =
	                (String) js.executeScript("return document.URL;");

	            System.out.println("Current URL: " + currentURL);

	            // Get page title
	            String pageTitle =
	                (String) js.executeScript("return document.title;");

	            System.out.println("Page Title: " + pageTitle);

	            // Scroll down by 500 pixels
	            js.executeScript("window.scrollBy(0, 500);");

	            Thread.sleep(1000);

	            // Scroll to bottom of page
	            js.executeScript(
	                "window.scrollTo(0, document.body.scrollHeight);"
	            );

	            Thread.sleep(1000);

	            // Scroll back to top
	            js.executeScript("window.scrollTo(0, 0);");

	            // Highlight Dashboard heading, if present
	            WebElement heading = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//h6")
	                )
	            );

	            js.executeScript(
	                "arguments[0].style.border='3px solid red';",
	                heading
	            );

	            // Flash effect: temporarily change heading background
	            for (int i = 0; i < 3; i++) {
	                js.executeScript(
	                    "arguments[0].style.backgroundColor='yellow';",
	                    heading
	                );
	                Thread.sleep(300);

	                js.executeScript(
	                    "arguments[0].style.backgroundColor='';",
	                    heading
	                );
	                Thread.sleep(300);
	            }

	            // Generate JavaScript alert
	            js.executeScript("alert('OrangeHRM Login Successful!');");

	            Thread.sleep(1000);

	            // Accept alert
	            driver.switchTo().alert().accept();

	            // Navigate back
	            js.executeScript("window.history.back();");

	            Thread.sleep(1500);

	            // Navigate forward
	            js.executeScript("window.history.forward();");

	            Thread.sleep(1500);

	            // Refresh page
	            js.executeScript("window.location.reload();");

	            Thread.sleep(2000);

	            System.out.println("JavaScriptExecutor examples completed.");

	        } finally {
	            // Close browser
	            driver.quit();
	        }
	    }
}
