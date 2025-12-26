package practice.datadriventestingpropertyFile;

import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrgTest5 {
	@Test
	public void createOrgtest(XmlTest test) throws Throwable {
		
		//read common data from Json File
		// Step 1: parse Json Physical file in to java Object using jsonParse class

				// convert json file into java physical object

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader("C:\\Users\\buddu\\OneDrive\\Desktop\\data\\appCommonData.json"));

				// Step 2:Convert Java Object into JsonObject using down casting

				JSONObject map = (JSONObject) obj;


		String URL = test.getParameter("url");
		String BROWSER = test.getParameter("browser");
		String USERNAME = test.getParameter("username");
		String PASSWORD =test.getParameter("password");

		// generate the random Number
		Random random = new Random();
		int randomInt = random.nextInt(5000);

		System.out.println(randomInt);

		// read test script data from Excel File
		FileInputStream fis1 = new FileInputStream("C:\\Users\\buddu\\OneDrive\\Desktop\\testScriptdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis1);

		Sheet sh = wb.getSheet("org");

		Row row = sh.getRow(1);

		String orgName = row.getCell(2).toString() + randomInt;

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

		// Step 4: Enter all the details & create new Organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 5: Log out
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.linkText("Sign Out")).click();

		//driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
		// sc.close();

	}


}
