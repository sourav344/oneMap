package Functions.Uitlities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	WebDriver driver ;
	
public Utility(WebDriver driver) {
		this.driver = driver;
	}

public void verifyElementPresent(List<WebElement> ls) {
	
	
	   if(ls.size()==1)
	   {
		   System.err.println("Element is displayed");
	   }
		
	   
	   else
	   {
		   System.err.println("Element is not displayed");
	   }
	}
	
	public void waitUntilElementAppears(WebElement ele)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	 public static String[][] getExcelData(String fileName, String sheetName) throws IOException {
	        String[][] data = null;
	        try {
	 
	            FileInputStream fis = new FileInputStream(fileName);
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            XSSFRow row = sheet.getRow(0);
	            int noOfRows = sheet.getPhysicalNumberOfRows();
	            int noOfCols = row.getLastCellNum();
	            Cell cell;
	            data = new String[noOfRows - 1][noOfCols];
	 
	            for (int i = 1; i < noOfRows; i++) {
	                for (int j = 0; j < noOfCols; j++) {
	                    row = sheet.getRow(i);
	                    cell = row.getCell(j);
	                    data[i - 1][j] = cell.getStringCellValue();
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("The exception is: " + e.getMessage());
	        }
	        return data;
	    }
	
	
	
}
