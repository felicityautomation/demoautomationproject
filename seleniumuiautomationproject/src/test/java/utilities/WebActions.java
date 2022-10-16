package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebActions {
	
	public static void click(WebDriver driver,By locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		Reporter.log("Clicking on element with locator:="+locator.toString(),true);
		driver.findElement(locator).click();
	}
	public static void set(WebDriver driver,By locator,String value) {
		Reporter.log("Setting text:="+value+" in the element with locator:="+locator.toString(),true);
		driver.findElement(locator).sendKeys(value);
	}

	public static void launchUrl(WebDriver driver,String url) {
		Reporter.log("Launching the browser with URL:="+url,true);
		driver.get(url);
	}

	public static void closeBrowser(WebDriver driver) {
		Reporter.log("Closing the browser",true);
		driver.quit();
	}

	public static String getBrowserTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public static boolean isElementExist(WebDriver driver,By locator) {
		return driver.findElement(locator).isDisplayed();
	}

}
