package tests.module2;

import org.testng.annotations.Test;

import utilities.DriverScript;
import utilities.KeywordActions;

public class KeywordDrivenTest1 {

	@Test
	public void keywordTest2() throws Exception {
		DriverScript driverScript=new DriverScript();
		driverScript.runScript("testdata/MasterData.xlsx", "Module2", "TC3");
	}
}
