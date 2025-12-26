package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleTest {

	public static void main(String[] args) throws Throwable {

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
		while (resultset.next()) {
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4)+"\t"+resultset.getString(5)+"\t"+resultset.getString(6));
		}
		resultset.next();
		// Step 5:close the connection
		conn.close();

	}

}
