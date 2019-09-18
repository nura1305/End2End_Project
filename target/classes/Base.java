package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	public static WebDriver driver; // Best practice: set the driver object on a class/global level
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

//		Connect properties file to Base class
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		prop.load(fis); // properties class gets the knowledge of the created file through fis
		String browserName = System.getProperty("browser"); // invoking driver type from mvn
//		String browserName = prop.getProperty("browser"); // choosing browser type from properties file  
		System.out.println(browserName);

//		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + "/src/main/java/resources/chromedriver");

			driver = new ChromeDriver();

//		} else if (browserName.equals("firefox")) {
//
//			System.setProperty("webdriver.gecko.driver",
//					System.getProperty("user.dir") + "/src/main/java/resources/geckodriver");
//			driver = new FirefoxDriver();
//
//		} else if (browserName.equals("safari")) {
//			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
//			driver = new SafariDriver();
//
//		}

//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenshot(String result) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,
				new File("/Users/elnuraamatova/eclipse-workspace/EndToEndProject/" + result + "Screenshot.png"));

	}

}
