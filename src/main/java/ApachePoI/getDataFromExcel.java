package ApachePoI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class getDataFromExcel {

	
	@Test
	public void getExcelData() throws IOException {
		
		FileInputStream Excelpath = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\Selenium_Project_oct_2026\\src\\main\\java\\DataLayer\\TestData.xlsx");
	
		XSSFWorkbook ActionOnExcel = new XSSFWorkbook(Excelpath);
		
		 XSSFSheet sheetName = ActionOnExcel.getSheet("Sheet2");
		 
//		  XSSFRow getRow = sheetName.getRow(0);
//		  String getData = getRow.getCell(1).toString();
//		  System.out.println(getData);
		 
		 int getRow = sheetName.getLastRowNum();
		 
		 for(int i=0; i<getRow; i++) {
			 XSSFRow getMultipleRowValue = sheetName.getRow(i);
			  short getLastCell = getMultipleRowValue.getLastCellNum();
			  for(int c=0; c<getLastCell; c++) {
				 String getValue = getMultipleRowValue.getCell(c).toString();
				 System.out.println(getValue);
			  }
		 }
		 
		 
		  
		 
		 
		
		
	}
}
