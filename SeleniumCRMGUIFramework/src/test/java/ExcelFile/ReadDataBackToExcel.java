package ExcelFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\buddu\\OneDrive\\Desktop\\testScriptdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("org");
		
		Row row = sh.getRow(1); 
		
		Cell cel = row.createCell(4);
		
		cel.setCellType(CellType.STRING);
		
		cel.setCellValue("FAIL");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\buddu\\OneDrive\\Desktop\\testScriptdata.xlsx");
		
		
		wb.write(fos);
		
		wb.close();
		
		System.out.println("====Executed=====");




	}

}
