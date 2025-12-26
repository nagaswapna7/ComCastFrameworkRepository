package ExcelFile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipledataFromExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub

		// Step 1: get the Excel path location & java Object of the Physical Excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\buddu\\OneDrive\\Desktop\\testScriptdata.xlsx");

		// Step 2: Open Workbook in read Mode
		Workbook wb = WorkbookFactory.create(fis);

		// Step 3: get the control of the "org" sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		

		// Row row=sh.getRow(1);

		// String column1Data = row.getCell(0).toString();
		// String column2Data = row.getCell(1).toString();

//		System.out.println(column1Data);
//		System.out.println(column2Data);

		//System.out.println(column1Data + "\t" + column2Data);

		// ================================================

		// I want to all data in the Excel
		//Even though the data in excel will change/modify/add it will get the data
		int rowcount = sh.getLastRowNum();

		for (int i = 1; i < rowcount; i++) {

			Row row = sh.getRow(i);

			String column1Data = row.getCell(0).toString();
			String column2Data = row.getCell(1).toString();

			System.out.println(column1Data + "\t" + column2Data);

		}

		wb.close();

	}

}
