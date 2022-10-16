package pages.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WebActions;

public class FbLoginPage {
	
	//WebDriver reference
	WebDriver driver;
	
	//Constructor to initialize driver reference
	public FbLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Element locators
	By textFieldEmailId= By.id("email");
	By textFieldPassword=By.name("pass");
	By buttonLogin=By.name("login");
	By buttonCreateNewAccount=By.xpath("//a[@data-testid='open-registration-form-button']");
	By popUpSingUp=By.xpath("//div[text()='Sign Up']");
	By errorMessageInvalidLogin=By.xpath("//div[contains(text(), 'The email ')]");
	
	//Functionalities offered by the page
	public void clickCreateNewAccountButton() {
		WebActions.click(driver, buttonCreateNewAccount);
	}
	
	public void setEmailId(String email) {
		WebActions.set(driver, textFieldEmailId, email);
	}

	public void setPassword(String password) {
		WebActions.set(driver, textFieldPassword, password);
	}
	
	public void clickLoginButton() {
		WebActions.click(driver, buttonLogin);
	}
	
	public boolean isPopupSignUpExist() {
		return WebActions.isElementExist(driver, popUpSingUp);
	}
	
	public boolean isErrorMessageInvalidLoginExist() {
		return WebActions.isElementExist(driver, errorMessageInvalidLogin);
	}
	
	public void login(String email,String password) {
		this.setEmailId(email);
		this.setPassword(password);
		this.clickLoginButton();
	}
}
