package tests.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.facebook.FbLoginPage;
import testdata.LoginDataProiver;
import utilities.BrowserUtility;
import utilities.WebActions;

public class FbTest1 {

	@Test
	public void createNewAccountTest() {
		WebDriver driver=BrowserUtility.getDriver();
		WebActions.launchUrl(driver, "https://www.facebook.com");
		FbLoginPage fbLoginPage=new FbLoginPage(driver);
		fbLoginPage.clickCreateNewAccountButton();
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "Facebook – log in or sign up","Verify page title");
		boolean popUpExist=fbLoginPage.isPopupSignUpExist();
		Assert.assertEquals(popUpExist, true,"Verify Sign up popup displayed");
		WebActions.closeBrowser(driver);
	}
	
	
	@Test(dataProvider = "logindata",dataProviderClass = LoginDataProiver.class)
	public void loginTest(String user,String pwd) {
		WebDriver driver=BrowserUtility.getDriver();
		WebActions.launchUrl(driver, "https://www.facebook.com");
		FbLoginPage fbLoginPage=new FbLoginPage(driver);
		fbLoginPage.login(user, pwd);
		boolean errorExist=fbLoginPage.isErrorMessageInvalidLoginExist();
		Assert.assertEquals(errorExist, true,"Verify error message is displayed");
		driver.quit();
	}
}
