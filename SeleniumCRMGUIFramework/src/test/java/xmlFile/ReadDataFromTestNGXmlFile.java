package xmlFile;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestNGXmlFile {
	
	@Test
	public void sampleTest(XmlTest test)
	
	{
		System.out.println("Execute Sample Test");
		System.out.println(test.getParameter("browser"));
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("username"));
		System.out.println(test.getParameter("password"));
	}

}
