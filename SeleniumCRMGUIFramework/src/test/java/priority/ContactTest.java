package priority;

import org.testng.annotations.Test;

   public class ContactTest {
	// if in case this test is fail remaining 2 tests also fail
	@Test
	public void createContactTest() {
		System.out.println("execute createContact with -->HDFC");
	}

	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() {
		// System.out.println("create contact ICICI");
		//System.out.println("execute query insert contact in DB ==> ICICI");

		//System.out.println("execute modifyContactTest with ICICI =>ICICI_1");
		System.out.println("execute modifyContactTest with HDFC =>ICICI");

	}

	@Test(dependsOnMethods = "modifyContactTest")

	public void deleteContactTest() {
		// if we don't have data base access
		//System.out.println("execute query insert contact in DB ==> UPI");

		// System.out.println("create UPI contact");

		//System.out.println("execute deleteContactTest UPI");
		System.out.println("execute deleteContactTest ICICI");

	}

}
