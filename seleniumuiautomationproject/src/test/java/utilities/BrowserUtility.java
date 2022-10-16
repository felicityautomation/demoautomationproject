package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserUtility {
	final static long implicitWait=30;
	
	public static WebDriver getDriver() {
		String browserName=System.getProperty("browser");
		Reporter.log("Running test on the browser:="+browserName,true);
		WebDriver driver=null;
		if(browserName==null) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		return driver;
	}

}
