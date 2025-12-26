package practice.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContactWithSupportDateTest {

	//Test Case 5
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		// Read the data from the property file
		FileInputStream fis = new FileInputStream("C:\\Users\\buddu\\OneDrive\\Desktop\\data\\commondata.properties");

		Properties pobj = new Properties();

		pobj.load(fis);

		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");

		// generate the random Number
		Random random = new Random();
		int randomInt = random.nextInt(5000);

		System.out.println(randomInt);

		// read test script data from Excel File
		FileInputStream fis1 = new FileInputStream("C:\\Users\\buddu\\OneDrive\\Desktop\\testScriptdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis1);

		Sheet sh = wb.getSheet("org");

		Row row = sh.getRow(4);

		String LastName = row.getCell(2).toString() + randomInt;

		// Step 6: close the Workbook

		wb.close();

		// At compilation it is null
		WebDriver driver = null;

		// at the time of execution in Run Time based on user input it going to take
		// decision
		// driver object behaves differently in Run Time polymorphism

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else
		// if user forgot to give the data at run time (unexpected enter will click)
		{
			driver = new ChromeDriver();
		}

		System.out.println(BROWSER);
		System.out.println(URL);

		// WebDriver driver = new FirefoxDriver();

		// Step 1: Login to App
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 2 : navigate to Organization module
		driver.findElement(By.linkText("Contacts")).click();

		// Step 3: Click on "Create Organization" Button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		Date dateobj = new Date();

		// System.out.println(dateobj.toString());

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sim.format(dateobj);
		System.out.println(startDate);

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 60);
		String endDate = sim.format(cal.getTime());

		System.out.println(endDate);

		// Step 4: Enter all the details & create new Organization
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);

		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify the Header Phone Number info expected result


		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();

		if (actStartDate.equals(startDate)) {
			System.out.println(startDate + " information is verified==PASS");
		} else {
			System.out.println(startDate + " information is not verified==FAIL");
		}

		
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();

		if (actEndDate.equals(endDate)) {
			System.out.println(endDate + " information is verified==PASS");
		} else {
			System.out.println(endDate + " information is not verified==FAIL");
		}

		// Step 5: Log out
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.linkText("Sign Out")).click();

		// driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
		// sc.close();

	}

}
