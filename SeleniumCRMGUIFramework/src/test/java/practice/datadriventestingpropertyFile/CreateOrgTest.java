package practice.datadriventestingpropertyFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

		// step 1 : get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\buddu\\OneDrive\\Desktop");

		// step 2 : using Properties class, load all the keys
		Properties pObj = new Properties();

		pObj.load(fis);

		// step 3 : get the value based on key
		String BROWSER = pObj.getProperty("url");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("url");
		String PASSWORD = pObj.getProperty("url");
		
		
		//It is manual Intervention so not use in real projects
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the Browser");
//		String browser = sc.next();
		
		//At compilation it is null
		WebDriver driver = null;
		
		//at the time of execution in Run Time based on user input it going to take decision
		//driver object behaves differently in Run Time polymorphism
		
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
			//if user forgot to give the data at run time (unexpected enter will click)
		{
			driver = new ChromeDriver();
		}
		
		System.out.println(BROWSER);
		System.out.println(URL);

		//WebDriver driver = new FirefoxDriver();
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.quit();
		//sc.close();

	}

}
