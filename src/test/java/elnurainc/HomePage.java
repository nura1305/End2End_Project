package elnurainc;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base { // inheriting the Base class allows to access methods in Base and call them
	// where the driver was initialized

	@BeforeTest
	public void startBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is inititalized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
		
	}

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		
		LandingPage l = new LandingPage(driver); // PageObject file
		if (l.getPopupSize() > 0) {
			l.getPopUp().click();
		}
		l.getlogin().click();

		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
//		System.out.println(text); no need to print on the console, just print it in the logs
		log.info(text);
		lp.getLogin().click();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "restricted@abc.com";
		data[0][1] = "abcd134";
		data[0][2] = "Restricted user";

		data[1][0] = "nonrestricted@abc.com";
		data[1][1] = "abHJX134";
		data[1][2] = "Non restricted user";

		return data;

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
