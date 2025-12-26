package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test2 {
	
	@Test(dataProvider = "getData")
	public void createContactTest(String firstname, String lastname, long phoneNumber)
	{
		System.out.println("FirstName :"+ firstname + ", LastName :"+ lastname  +", PhoneNumber:" +phoneNumber);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0] = "Ramya";
		objArr[0][1] = "Katari";
		objArr[0][2] = 7386273494L;

		
		objArr[1][0] = "Deepika";
		objArr[1][1] = "Mudra";
		objArr[1][2] = 8855226633L;

		
		objArr[2][0] = "AdiLakshmi";
		objArr[2][1] = "Mudra";
		objArr[2][2] = 7744118899L;

		
		return objArr;
	}

}
