package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {

	@Test
	public void createContactTest() {
		System.out.println("execute login");
		System.out.println("execute navigate to contact");
		System.out.println("execute create contact");
		System.out.println("execute verify contact");
		System.out.println("execute logout");

		
	}

	@Test
	public void createcontactWithMobileNumberTest() {
		System.out.println("execute createcontactWithMobileNumberTest");
	}

	@Test
	public String getTitle() {
		System.out.println("Test executed");
		return "Google";
	}

}
