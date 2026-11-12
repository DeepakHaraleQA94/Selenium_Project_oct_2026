package PomPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ParentLayer.TestBase;

public class LoginPage extends TestBase {

	// 1. object factory 2.cunstructor 3. Action fucntion
	
	@FindBy(name = "username") 
	private WebElement uname;
	
	@FindBy(name = "password")
	private WebElement passwd;
	
	@FindBy(xpath = "//button[@type='submit']")
	 private WebElement loginBtn;
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String userName) {
		uname.sendKeys(userName);
	}
	
	public void enterPass(String password) {
		passwd.sendKeys(password);
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	
}
