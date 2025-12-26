package practice.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrgTest {

	// Test Case 6

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

		Sheet sh = wb.getSheet("contact");

		Row row = sh.getRow(7);

		String orgName = row.getCell(2).toString() + randomInt;
		String ContactLastName = row.getCell(3).toString();

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
		driver.findElement(By.linkText("Organizations")).click();

		// Step 3: Click on "Create Organization" Button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify the Header Phone Number info expected result

		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + "header verified==PASS");
		} else {
			System.out.println(orgName + "header verified==FAIL");
		}

		// Step 5: Navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();

		// Step 6: Click on "Create contact" Button
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Step 7: Enter all the details & create new Organization
		driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// Switch to Child Window
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String acturl = driver.getCurrentUrl();

			if (acturl.contains("module=Accounts")) {
				break;
			}
		}

		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		// dynamic xpath
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// Switch to parent window

		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();

		while (it1.hasNext()) {
			String windowID = it1.next();
			driver.switchTo().window(windowID);

			String acturl = driver.getCurrentUrl();

			if (acturl.contains("Contacts&action")) {
				break;
			}
		}

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify the header msg with expected result
		headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (headerInfo.contains(ContactLastName)) {
			System.out.println(ContactLastName + "header verified==PASS");
		} else {
			System.out.println(ContactLastName + "header verified==FAIL");
		}

		// Verify the header OrgName Info with expected result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();

		System.out.println(actOrgName);
		
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "information is created==PASS");
		} else {
			System.out.println(orgName + "information is not created==FAIL");
		}

		// Step 6: Log out
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.linkText("Sign Out")).click();

		// driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
		// sc.close();

	}

}
