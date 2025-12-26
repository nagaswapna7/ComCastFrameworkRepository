package practice.hometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {

	@Test
	public void homePageTest(Method mtd) {

		Reporter.log(mtd.getName() + "Test Start",true);

		SoftAssert assertobj = new SoftAssert();

		Reporter.log("step_1",true);
		Reporter.log("step_2",true);
		assertobj.assertEquals("Home", "Home");
		Reporter.log("step_3",true);
		// assertobj.assertEquals("Home-CRM", "Home-CRM");
		assertobj.assertEquals("Title", "Title");

		Reporter.log("step_4",true);

		assertobj.assertAll();

//		System.out.println("step_1");
//		System.out.println("step_2");
//		Assert.assertEquals("Home", "Home-Page");
//		System.out.println("step_3");
//		Assert.assertEquals("Home-CRM", "Home-CRM");
//		System.out.println("step_4");

		Reporter.log(mtd.getName() + "TestEnd",true);

	}

	@Test
	public void verifyLoginHomePageTest(Method mtd) {

		Reporter.log(mtd.getName() + "Test Start");

		SoftAssert assertobj = new SoftAssert();

		Reporter.log("step_1",true);
		Reporter.log("step_2",true);
		assertobj.assertTrue(true);
		Reporter.log("step_3",true);
		Reporter.log("step_4",true);

		assertobj.assertAll();

//		System.out.println("step_1");
//		System.out.println("step_2");
//		Assert.assertTrue(true);
//		System.out.println("step_3");
//		System.out.println("step_4");

		Reporter.log(mtd.getName() + "TestEnd",true);

	}

}
