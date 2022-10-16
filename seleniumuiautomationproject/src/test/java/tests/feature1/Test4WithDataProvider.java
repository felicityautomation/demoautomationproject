package tests.feature1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import testdata.LoginDataProiver;

public class Test4WithDataProvider {
	
	@Test(dataProvider = "logindata",dataProviderClass = LoginDataProiver.class)
	public void test4(String user,String password) {
		System.out.println("User name:="+user);
		System.out.println("Passowrd:="+password);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		boolean flag=driver.findElement(By.linkText("Find your account and log in.")).isDisplayed();
		Assert.assertEquals(flag, true,"Verify error message");
		driver.quit();
	}

}
