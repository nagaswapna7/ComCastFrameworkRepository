package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectAndVerifyDataINDBWithGUI {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		
		//Create Project in GUI using selenium code
		String projectName="Instagram_01";
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8084");
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createBy")).sendKeys("Ramya");
		
		Select sel= new Select(driver.findElement(By.name("status")));
		
		sel.selectByVisibleText("On Going");
		sel.selectByIndex(0);
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		
		//Verify the project in backend (DB) using JDBC
		boolean flag = false;
		
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "tigerroot", "tigerroot");
		System.out.println("=========Execution Done========");
		Statement stat = conn.createStatement();
		ResultSet resultset = stat.executeQuery("select * from students");
		
		while(resultset.next())
		{
			String actProjectName = resultset.getString(4);
			if(projectName.equals(actProjectName))
			{
				flag=true;
				System.out.println(projectName + " is available Db==PASS");
			}
		}
		
		if(flag==false)
		{
			System.out.println(projectName +"is not available==FAIL");
			Assert.fail();
		}
		
		// Step 5:close the connection
		conn.close();
		
		

	}

}
