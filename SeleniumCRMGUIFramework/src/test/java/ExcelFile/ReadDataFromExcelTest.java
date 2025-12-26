package ExcelFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		// TODO Auto-generated method stub
		
		//Step 1: get the Excel path location  & java Object of the Physical Excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\buddu\\OneDrive\\Desktop\\testScriptdata.xlsx");
		
		//Step 2: Open Workbook in read Mode
		Workbook wb = WorkbookFactory.create(fis);

		
		//Step 3: get the control of the "org" sheet
		 Sheet sh =wb.getSheet("org");
		
		//Step 4: get the control of the "1st" Row
		 Row row = sh.getRow(1);
		
		//Step 5: get the control of the "2nd" cell & read the String data
//		 Cell cel=row.getCell(1);
//		 
//		 String data=cel.getStringCellValue();
		 
		 //String data = row.getCell(1).getStringCellValue();
		 
		// double data = row.getCell(3).getNumericCellValue();
		 
		 //String data = row.getCell(3).getStringCellValue();
		 
		 String data = row.getCell(1).toString();
		 
		 System.out.println(data);
		
		//Step 6: close the  Workbook
		 
		 wb.close();

	}

}
