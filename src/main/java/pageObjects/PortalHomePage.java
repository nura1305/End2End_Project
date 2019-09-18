package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {
	
	public WebDriver driver;
	private By search = By.id("search-courses");
//	private By password = By.id(("user_password"));
//	private By login = By.cssSelector(("[value='Log In']"));
	
	
	public PortalHomePage(WebDriver driver) {   //constructor to create a driver instance in HomePage
		this.driver=driver;
	}

	public WebElement getSearch() {
		return driver.findElement(search);
	}
	
//	public WebElement getPassword() {
//		return driver.findElement(password);
//	}
//	
//	public WebElement getLogin() {
//		return driver.findElement(login);
//	}

}
