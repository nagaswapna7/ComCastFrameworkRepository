package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SimpleReportTest {

	public ExtentReports report;

	@BeforeSuite
	public void configBS() {
		
		//Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// Add Env Information & Create Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-10");

	}

	@AfterSuite
	public void configAS() {
		report.flush();

	}

	@Test
	public void createContactWithORG() {

		ExtentTest test = report.createTest("createContactWithORG");

		test.log(Status.INFO, "Login To App");
		test.log(Status.INFO, "Navigate to Contact Page");
		test.log(Status.INFO, "Create Contact");

		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created");
		}

		else {
			test.log(Status.FAIL, "Contact is not Created");
		}

	}

	@Test
	public void createContactWithPhoneNumber() {

		ExtentTest test = report.createTest("createContactWithPhoneNumber");
		test.log(Status.INFO, "Login To App");
		test.log(Status.INFO, "Navigate to Contact Page");
		test.log(Status.INFO, "Create Contact");

		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is Created");
		}

		else {
			test.log(Status.FAIL, "Contact is not Created");
		}



	}

	@Test
	public void createContactTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");
		
		
		TakesScreenshot eDriver = (TakesScreenshot) driver;
		String filepath = eDriver.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = report.createTest("createContactTest");

		test.log(Status.INFO, "Login To App");
		test.log(Status.INFO, "Navigate to Contact Page");
		test.log(Status.INFO, "Create Contact");

		if ("HDFC".equals("HDC")) {
			test.log(Status.PASS, "Contact is Created");

		} else {
			test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
		}
		driver.close();

	}

}
