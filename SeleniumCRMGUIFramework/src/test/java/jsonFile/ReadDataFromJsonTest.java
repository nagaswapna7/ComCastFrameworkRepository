package jsonFile;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {
	public static void main(String[] args) throws Throwable, IOException, ParseException {

		// Step 1: parse Json Physical file in to java Object using jsonParse class

		// convert json file into java physical object

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\buddu\\OneDrive\\Desktop\\data\\appCommonData.json"));

		// Step 2:Convert Java Object into JsonObject using down casting

		JSONObject map = (JSONObject) obj;

		// step 3: Get the Value from the Json

		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
	}

}
