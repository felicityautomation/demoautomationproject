package testdata;

import org.testng.annotations.DataProvider;

public class LoginDataProiver {
	
	
	@DataProvider(name = "logindata")
	public Object[][] getLoginData() {
		Object[][] data= {{"sfljlsfj","welcom1"},{"iuwoierk39080284kjl@sfdjfl.com","Dummypassword"},{"sfsdfsderere@lsjfldf.com","sjflsjdf"}};
		return data;
	}

}
