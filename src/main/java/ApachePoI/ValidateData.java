package ApachePoI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ValidateData {

	@Test
	public void getData() throws InterruptedException, IOException {
		String excelPath = "C:\\Users\\Hp\\eclipse-workspace\\Selenium_Project_oct_2026\\src\\main\\java\\DataLayer\\TestData.xlsx";
		FileInputStream getExcel = new FileInputStream(excelPath);
		XSSFWorkbook ActionOnSheet = new XSSFWorkbook(getExcel);
		XSSFSheet sheetName = ActionOnSheet.getSheet("Sheet1");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		int rowNo = sheetName.getLastRowNum();
		for (int i = 1; i <= rowNo; i++) {
			XSSFRow r = sheetName.getRow(i);

			driver.findElement(By.name("username")).sendKeys(r.getCell(0).getStringCellValue());

			driver.findElement(By.name("password")).sendKeys(r.getCell(1).getStringCellValue());

			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(4000);
			String url = driver.getCurrentUrl();
			 r.createCell(3).setCellValue(url);
			 
			if(r.getCell(2).getStringCellValue().equals(url)) {
				r.createCell(4).setCellValue("Pass");
			}else
			{
				r.createCell(4).setCellValue("failed");
			}
			
			Thread.sleep(2000);
			driver.close();
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Thread.sleep(2000);
		}
		
		

		FileOutputStream save = new FileOutputStream(excelPath);
		ActionOnSheet.write(save);

	}

}

