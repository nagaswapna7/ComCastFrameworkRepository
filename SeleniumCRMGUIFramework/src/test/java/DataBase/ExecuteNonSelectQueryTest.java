package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		// Step 1: load/register the database driver
				Driver driverref = new Driver();
				DriverManager.registerDriver(driverref);

				// Step 2:Connect to Database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "tigerroot", "tigerroot");
				System.out.println("=========Execution Done========");
				
				// Step 3:Create sql Statement
				Statement stat = conn.createStatement();
				
				// Step 4:execute select query and get result
                int result= stat.executeUpdate("insert into students values('6','Ramya','Katari','20','katarikatari123@gmail.com','2025-09-29');");
                System.out.println(result);

				// Step 5:close the connection
                   conn.close();
	}

}
