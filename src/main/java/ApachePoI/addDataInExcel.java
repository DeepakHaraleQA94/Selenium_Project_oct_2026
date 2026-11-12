package ApachePoI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class addDataInExcel {

	String path = "C:\\Users\\Hp\\eclipse-workspace\\Selenium_Project_oct_2026\\src\\main\\java\\DataLayer\\TestData.xlsx";
	@Test
	public void addData() throws IOException, InterruptedException {

		FileInputStream Excelpath = new FileInputStream(path);
	
		XSSFWorkbook ActionOnExcel = new XSSFWorkbook(Excelpath);
		
		 XSSFSheet sheetName = ActionOnExcel.getSheet("Sheet2");
		 
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 Thread.sleep(3000);
		 driver.findElement(By.name("username")).sendKeys("Admin");
		 driver.findElement(By.name("password")).sendKeys("admin123");
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[3]")).click();
		 Thread.sleep(3000);
		  WebElement leaveDropDown = driver.findElement(By.xpath("//div[@class='oxd-multiselect-wrapper']"));
		  leaveDropDown.click();
		  List<WebElement> list = driver.findElements(By.xpath("//div[@class='oxd-multiselect-wrapper']//div[@role='listbox']"));
	
		      int length = list.size();
		    for(int i=0; i<length; i++) {
		      String listValue = list.get(i).getText();
		    	System.out.println(i+" " +list.get(i).getText());
		   XSSFRow createRowValue = sheetName.createRow(i);
		 
		   createRowValue.createCell(1).setCellValue(i+" "+listValue);
		 }
		   FileOutputStream save = new FileOutputStream(path);
		   
		   ActionOnExcel.write(save);
		 
	}
}
