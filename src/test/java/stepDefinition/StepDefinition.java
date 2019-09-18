package stepDefinition;

import org.testng.Assert;
import org.testng.AssertJUnit;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.Base;

public class StepDefinition extends Base {
	@Given("^Initialize browser with chrome$")
	public void initialize_browser_with_chrome() throws Throwable {
		driver = initializeDriver();

	}

	@Given("^Navigate to \"([^\"]*)\" website$")
	public void navigate_to_website(String arg1) throws Throwable {
		driver.get(arg1);

	}

	@Given("^Click on Login button on Homepage to land on Secure SignIn page$")
	public void click_on_Login_button_on_Homepage_to_land_on_Secure_SignIn_page() throws Throwable {

		LandingPage l = new LandingPage(driver);
		if (l.getPopupSize() > 0) {
			l.getPopUp().click();
		}
		l.getlogin().click();
	}
	
	@When("^user enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
    }

	@Then("^Verify that user has successfully loged in$")
	public void verify_that_user_has_successfully_loged_in() throws Throwable {
		PortalHomePage ph = new PortalHomePage(driver);
		Assert.assertTrue(ph.getSearch().isDisplayed());

	}
	
	@Then("^Verify that Navigation bar is displayed$")
    public void verify_that_navigation_bar_is_displayed() throws Throwable {
		LandingPage l = new LandingPage(driver);
		AssertJUnit.assertTrue(l.getNavigation().isDisplayed());
		System.out.println("Navigatio is displayed");
    }
	
	@Then("^Verify that page title is displayed$")
    public void verify_that_page_title_is_displayed() throws Throwable {
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTittle().getText(), "FEATURED COURSES");
		System.out.println("Page title is displayed");

    }
	
	@And("^Close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }

}
