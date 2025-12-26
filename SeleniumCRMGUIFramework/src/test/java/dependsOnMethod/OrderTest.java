package dependsOnMethod;

import org.testng.annotations.Test;

public class OrderTest {

	/*
	 * @Test() public void createOrderTest() {
	 * System.out.println("execute create order test==>123");
	 * 
	 * String str=null; System.out.println(str.equals("123")); }
	 * 
	 * @Test(dependsOnMethods = "createOrderTest") public void billingAndOrderTest()
	 * { System.out.println("execute Billing and order test==>123");
	 * 
	 * }
	 */

	@Test(invocationCount = 10)
	public void createOrderTest() {
		System.out.println("execute create order test==>123");

	}

	@Test(enabled = false)
	public void billingAndOrderTest() {
		System.out.println("execute Billing and order test==>123");

	}

}
