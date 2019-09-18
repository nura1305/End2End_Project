package elnurainc;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	LandingPage l;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void startBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is inititalized (Title)");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}

	@Test
	public void validatePageText() throws IOException {

		l = new LandingPage(driver);

//		compare title text from the browser with the actual text (reflected in the requirement documentation)
		Assert.assertEquals(l.getTittle().getText(), "FEATURED COURSES");
		log.info("Successfully validated Title text");
		log.error("Unable to validate text");

	}

	@Test
	public void validatePageHeader() {

		Assert.assertEquals(l.getHeader().getText(),"Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("Successfully validated Header text");

	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}

}
