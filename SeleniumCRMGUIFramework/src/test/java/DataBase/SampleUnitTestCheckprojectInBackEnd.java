package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleUnitTestCheckprojectInBackEnd {

	@Test
	public void projectCheckTest() throws Throwable
	{
		
		String expectedProjectName="20";
		boolean flag = false;
		
		// Step 1: load/register the database driver
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);

		// Step 2:Connect to Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "tigerroot", "tigerroot");
		System.out.println("=========Execution Done========");
		// Step 3:Create sql Statement
		Statement stat = conn.createStatement();
		// Step 4:execute select query and get result
		ResultSet resultset = stat.executeQuery("select * from students");
		
		while(resultset.next())
		{
			String actProjectName = resultset.getString(3);
			//System.out.println(actProjectName);
			//to check weather the expected project is available or not
			if(expectedProjectName.equals(actProjectName))
			{
				flag=true;
				System.out.println(expectedProjectName + " is available==PASS");
			}
		}
		
		if(flag==false)
		{
			System.out.println(expectedProjectName +"is available==FAIL");
			Assert.fail();
		}
		
		// Step 5:close the connection
		conn.close();
	}

	}


