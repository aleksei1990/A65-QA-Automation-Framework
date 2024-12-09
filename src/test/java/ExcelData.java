import com.google.common.collect.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

//public class ExcelData extends BaseTest {
//
//    @DataProvider(name = "excel-data")
//    public Object[][] excelDP() throws IOException{
//        Object[][] arrObj = getExcelData("Location of excel", "Name of excel sheet");
//        return arrObj;
//    }
//
//    public String[][] getExcelData(String fileName, String sheetName) {
//        String[][] data = null;
//        try {
//            FileInputStream fis = new FileInputStream(fileName);
//            XSSFWorkbook wb = new XSSFWorkbook(fis);
//            XSSFSheet sh = wb.getSheet(sheetName);
//            XSSFRow row = sh.getRow(0);
//            int noOfRows = sh.getPhysicalNumberOfRows();
//            int noOfCols = row.getLastCellNum();
//            Table.Cell cell;
//            data = new String[noOfRows-1][noOfCols];
//            for (int i = 1; i< noOfRows; i++){
//                for (int j = 0; j < noOfCols; j++){
//                    row = sh.getRow(i);
//                    cell = row.getCell(j);
//                    data[i-1][j] = cell.getStringCellValue();
//
//                }
//            }
//        }
//        catch (Exception e){
//            System.out.println("The exception is: " + e.getMessage());
//        }
//        return data;
//    }
//    @Test(dataProvider = "excel-data")
//    public void search(String keyWork1, String keyWork2){
//        WebElement txtBox = driver.findElement(By.cssSelector("input[type='email']"));
//        txtBox.sendKeys(keyWork1," ", keyWork2);
//        Reporter.log("Keyword entered is:" +keyWork1+ " " + keyWork2);
//        txtBox.sendKeys(Keys.ENTER);
//        Reporter.log("Search result are displayed");
//    }
//}
