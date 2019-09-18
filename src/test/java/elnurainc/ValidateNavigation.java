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

public class ValidateNavigation extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void startBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is inititalized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the Home page (Navigation)");
	}

	@Test
	public void validateNavigationBar() throws IOException {

		LandingPage l = new LandingPage(driver);

//		compare title text from the browser with the actual text (reflected in the requirement documentation)

		AssertJUnit.assertTrue(l.getNavigation().isDisplayed());
		log.info("Successfully validated Navigation bar");

	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver=null;
	}

}
