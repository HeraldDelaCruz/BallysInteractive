package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import io.cucumber.java.en.Then;

public class LoginStep{
	
	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Given("User is in the website Landing page")
	public void user_is_in_the_website_landing_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
	}

	@When("User navigates the Login page")
	public void user_navigates_the_login_page() {
	   loginPage = homePage.clickOnHomePageLoginButton();
	}

	@When("^User enters \"([^\"]*)\" in email field and \"([^\"]*)\" in password field$")
	public void user_enters_in_email_field_and_in_password_field(String email, String password) {
	    loginPage.enterEmailAddress(email);
	    loginPage.enterPassword(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnUserLogin();
	}

	@Then("^User should redirect to Home page with users logged-in named \"([^\"]*)\"$")
	public void user_should_redirect_to_home_page_with_users_logged_in_named(String usersname) {
		String expectedName = homePage.getDisplayUsersName();
		Assert.assertEquals(expectedName, usersname);
	}

	@Then("^An error prompt appear with (.+)$")
	public void an_error_prompt_appear_with_(String scenario) {
	    String errorMessage = loginPage.getErrorMessage();
	    Assert.assertEquals(errorMessage, "There is a problem with your email/password. Forgot your password?");
	}

	@Then("Login button should be disabled")
	public void login_button_should_be_disabled() {
		Assert.assertFalse(loginPage.checkUserLoginButtonStatus());
	}
	
}
