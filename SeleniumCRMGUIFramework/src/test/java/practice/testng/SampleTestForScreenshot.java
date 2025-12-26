package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {
	
	@Test
	public void amazonTest() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//Create an Object to EvenFiring WebDriver
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		
		//step 2: use getScreenshot method to get  file type of screenshot
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		//Step 3 : Store Screenshot on local driver
		FileUtils.copyFile(srcFile, new File("./Screenshot/test.png"));
	}

}
