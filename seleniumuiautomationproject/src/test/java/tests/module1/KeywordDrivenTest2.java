package tests.module1;

import org.testng.annotations.Test;

import utilities.DriverScript;
import utilities.KeywordActions;

public class KeywordDrivenTest2 {

	@Test
	public void keywordTest1() throws Exception {
//		KeywordActions actions=new KeywordActions();
//		actions.performAction("openBrowser", null, null, null);
//		actions.performAction("openUrl", null, null, "https://www.facebook.com/");
//		actions.performAction("setText", "id", "email", "jsfljs@jslfjdsl.com");
//		actions.performAction("setText", "id", "pass", "Welcome1");
//		actions.performAction("click", "name", "login", null);
//		actions.performAction("verifyTitle", "", "", "Facebook – log in or sign up");
//		actions.performAction("closeBrowser", "", "", null);
		
		DriverScript driverScript=new DriverScript();
		driverScript.runScript("testdata/MasterData.xlsx", "Module1", "TC1");
	}
	
	@Test
	public void keywordTest2() throws Exception {
		DriverScript driverScript=new DriverScript();
		driverScript.runScript("testdata/MasterData.xlsx", "Module1", "TC2");
	}
}
