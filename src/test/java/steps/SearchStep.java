package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultPage;

public class SearchStep {
	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private LoginPage loginPage;
		
	@Given("User is in the Home page")
	public void user_is_in_the_home_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
	}
	
	
	@When("User enters {string} , {string} and {string}")
	public void user_enters_and(String keyword, String date, String location) {
		homePage.enterSearchKeyword(keyword);
		homePage.enterSearchDate(date);
		homePage.enterSearchLocation(location);
		
		if (!location.isEmpty())
			homePage.clickOnLocationDropdown();
		
	}

	@When("User clicks search button")
	public void user_clicks_search_button() {
		searchResultPage = homePage.clickOnSearchIcon();
	}

	
	@Then("User redirect to Search Result Page")
	public void user_redirect_to_search_result_page() throws Throwable {
		Assert.assertTrue(searchResultPage.isSearchResultLogoDisplayed());
	}

	
	@Then("Free Access button should be present in the page")
	public void free_access_button_should_be_present_in_the_page() {
		Assert.assertTrue(searchResultPage.isFreeAccessTextDisplayed());
	}
	
	
	@Then("No Result Text should be displayed")
	public void no_result_text_should_be_displayed() {
		Assert.assertTrue(searchResultPage.isHeaderTextDisplayed());
	}
	
	@Given("User is loggedin to the website")
	public void user_is_loggedin_to_the_website() {
	    loginPage = new LoginPage(driver);
	    
	    homePage.clickOnHomePageLoginButton();
	    loginPage.enterEmailAddress("lourdes100@test.com");
	    loginPage.enterPassword("Test123!");
	    loginPage.clickOnUserLogin();
	}
	
	
	@Then("Newspaper search result should displayed in the Page")
	public void newspaper_search_result_should_displayed_in_the_page() {
		Assert.assertTrue(searchResultPage.isNewspaperResultDisplayed());
	}

	@Then("Filters should be displayed in the page")
	public void filters_should_be_displayed_in_the_page() {
		Assert.assertTrue(searchResultPage.isNewsPaperFilterDisplayed());
		Assert.assertTrue(searchResultPage.isSortFilterDisplayed());
		Assert.assertTrue(searchResultPage.isClearAllDisplayed());
		
	}
}
