package tests.feature1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class Test1 {

	@Test
	public void loginTest() throws FileNotFoundException, IOException, ParseException {
		//		WebDriver driver=new ChromeDriver();
		//		driver.get("https://www.facebook.com");
		//		driver.quit();

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("testdata/mydata.json"));
		JSONObject jsonObject = (JSONObject)obj;
		String name = (String)jsonObject.get("user");
		String password = (String)jsonObject.get("password");
		JSONArray subjects = (JSONArray)jsonObject.get("credentials");

		for(Object o:subjects) {
			JSONObject myObj = (JSONObject)o;
			System.out.println((String)myObj.get("user"));
			System.out.println((String)myObj.get("password"));
		}
		
		Iterator iterator = subjects.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		//		System.out.println(name);
		//		System.out.println(password);
	}

}
