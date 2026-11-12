package UtilityLayer;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataProvider {

	
	String EXCEL_SHEET_PATH = "C:\\Users\\Hp\\eclipse-workspace\\Selenium_Project_oct_2026\\src\\main\\java\\DataLayer\\TestData.xlsx";
	
	@DataProvider(name = "excelData")
	public Object[][] CollectDataFromExcel(String SheetName) throws IOException {

	    FileInputStream findpath = new FileInputStream(EXCEL_SHEET_PATH);
	    XSSFWorkbook action = new XSSFWorkbook(findpath);

	    XSSFSheet sheetName = action.getSheet(SheetName);

	    int lastRow = sheetName.getLastRowNum();
	    int lastCell = sheetName.getRow(0).getLastCellNum();

	    Object[][] data = new Object[lastRow][lastCell];

	    for (int r = 1; r <= lastRow; r++) {

	        for (int c = 0; c < lastCell; c++) {

	            data[r - 1][c] =
	                sheetName.getRow(r).getCell(c).toString();

	            System.out.println(data[r - 1][c]);
	        }
	    }

	    action.close();
	    findpath.close();

	    return data;
	}

}
