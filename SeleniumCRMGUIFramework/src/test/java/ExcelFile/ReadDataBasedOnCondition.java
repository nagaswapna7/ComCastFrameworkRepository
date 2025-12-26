package ExcelFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		String expectedTestId = "tc_01";

		String data1 = "";
		String data2 = "";
		String data3 = "";
		boolean flag = false;

		// Step 1: get the Excel path location & java Object of the Physical Excel file
		FileInputStream fis = new FileInputStream("C:\\Users\\buddu\\OneDrive\\Desktop\\testScriptdata.xlsx");

		// Step 2: Open Workbook in read Mode
		Workbook wb = WorkbookFactory.create(fis);

		// Step 3: get the control of the "org" sheet
		Sheet sh = wb.getSheet("org");

		int rowcount = sh.getLastRowNum();

		for (int i = 0; i <= rowcount; i++) {

			// It will repeat the tc_id again and again
			String data = "";

			// If any cell contains null i want to continue my execution dont stop and
			// handle exception

			try {
				data = sh.getRow(i).getCell(0).toString();

				if (data.equals(expectedTestId)) {
					flag=true;
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
					data3 = sh.getRow(i).getCell(3).toString();

				}

			} catch (Exception e) {
			}
		}
		
		if(flag==true)
		{
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}
		else
		{
			System.out.println(expectedTestId + " data is not available");
		}
			

		}

	}


