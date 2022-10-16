package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class KeywordActions {
	
	WebDriver driver;
	
	public void performAction(String action,String locatorType,String locatorValue,String testData) throws Exception {
		switch(action) {
		case "openBrowser":
			this.driver=BrowserUtility.getDriver();
			break;
		case "openUrl":
			WebActions.launchUrl(driver, testData);
			break;
		case "setText":
			WebActions.set(driver, getElement(locatorType,locatorValue), testData);
			break;
		case "click":
			WebActions.click(driver, getElement(locatorType,locatorValue));
			break;
		case "verifyTitle":
			Assert.assertEquals(testData, WebActions.getBrowserTitle(driver));
			break;
		case "closeBrowser":
			WebActions.closeBrowser(driver);
			break;
		default:
			throw new Exception("Invalid action,not supported by framework. Action:="+action);
		}

	}
	
	private By getElement(String locatorType,String locatorValue) throws Exception {
		switch(locatorType) {
		case "id":
			return By.id(locatorValue);
		case "name":
			return By.name(locatorValue);
		case "xpath":
			return By.xpath(locatorValue);
		default:
			throw new Exception("Invalid locator type specified:="+locatorType);
		}
	}
}
