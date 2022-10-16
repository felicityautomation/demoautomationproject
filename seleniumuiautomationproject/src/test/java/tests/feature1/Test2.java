package tests.feature1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test2 {
	
	@Test
	public void loginTest() {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com");
		driver.quit();
	}

}
