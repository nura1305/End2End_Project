package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	private By signIn = By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a/span");
	private By popup = By.xpath("//button[text()='NO THANKS']");
	private By title = By.xpath("//*[@id=\"content\"]/div/div/h2");
	private By navigation = By.xpath("/html/body/header/div[2]/div/nav/ul");
	private By header = By.cssSelector("div[class*='video-banner'] p");

	public LandingPage(WebDriver driver) { // constructor to create a driver instance in HomePage
		this.driver = driver;
	}

	public WebElement getlogin() {
		return driver.findElement(signIn);
	}

	public int getPopupSize() {
		return driver.findElements(popup).size();
	}

	public WebElement getPopUp() {
		return driver.findElement(popup);
	}

	public WebElement getNavigation() {
		return driver.findElement(navigation);
	}

	public WebElement getTittle() {
		return driver.findElement(title);
	}

	public WebElement getHeader() {
		return driver.findElement(header);
	}

}
