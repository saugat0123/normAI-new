package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXlSData {

	@DataProvider(name="testdata")
	public String[][] getData(Method method) throws EncryptedDocumentException, IOException {
		String excelsheetName = method.getName();
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelsheetName);
		
		int totalRows = sheetName.getLastRowNum();
		Row rowCells = sheetName.getRow(0);
		int totalColumns = rowCells.getLastCellNum();
		
		DataFormatter format = new DataFormatter();
		String[][] testData = new String[totalRows][totalColumns];
		for (int i = 0; i < totalRows; i++) {
		    for (int j = 0; j < totalColumns; j++) {
		        if (sheetName.getRow(i + 1) != null && sheetName.getRow(i + 1).getCell(j) != null) {
		            testData[i][j] = format.formatCellValue(sheetName.getRow(i + 1).getCell(j));
//		            System.out.println(testData[i][j]);
		        } else {
		            testData[i][j] = "";
//		            System.out.println("Empty cell");
		        }
		    }
		}
		
		return testData;
				
	}

}
