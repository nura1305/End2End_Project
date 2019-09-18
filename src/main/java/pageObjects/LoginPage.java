package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	private By email = By.id("user_email");
	private By password = By.id(("user_password"));
	private By login = By.cssSelector(("[value='Log In']"));
	
	
	public LoginPage(WebDriver driver) {   //constructor to create a driver instance in HomePage
		this.driver=driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}

}
