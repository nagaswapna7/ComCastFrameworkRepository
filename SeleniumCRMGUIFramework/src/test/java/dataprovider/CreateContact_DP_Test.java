package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	
	@Test(dataProvider = "getData")
	public void createContactTest(String firstname, String lastname)
	{
		System.out.println("FirstName : "+ firstname + ", LastName : "+ lastname );
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0] = "Ramya";
		objArr[0][1] = "Katari";
		
		objArr[1][0] = "Deepika";
		objArr[1][1] = "Mudra";
		
		objArr[2][0] = "AdiLakshmi";
		objArr[2][1] = "Mudra";
		
		return objArr;
	}

}
