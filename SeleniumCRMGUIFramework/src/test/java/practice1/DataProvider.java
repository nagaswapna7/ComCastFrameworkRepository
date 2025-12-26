package practice1;

import org.testng.annotations.Test;

public class DataProvider {
	
	
	
	
	@Test(dataProvider = "getData")
	public void m1()
	{
		
	}

	@Test
	public Object[][] getData() {
		Object[][] obj = new Object[3][2];

		obj[0][0] = "Ramya";
		obj[0][1] = "Ramya";

		obj[0][2] = "Ramya";

		obj[1][0] = "Ramya";
		obj[1][1] = "Ramya";
		obj[1][2] = "Ramya";

		return obj;

	}

}
