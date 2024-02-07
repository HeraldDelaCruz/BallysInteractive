package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BlogSitePage;
import pages.BrowsePage;
import pages.HomePage;
import pages.RedeemPage;
import pages.RegisterPage;

import utils.CommonUtils;


public class HomeSteps {
	
	WebDriver driver;
	private HomePage homePage;
	private CommonUtils commonUtils;
	private RegisterPage registerPage;
	private RedeemPage redeemPage;
	private BrowsePage browsePage;
	private BlogSitePage blogSitePage;
	
	
	@Given("User is in the websites Home page")
	public void user_is_in_the_websites_home_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		commonUtils = new CommonUtils(driver);
	}
	
	
	@When("User clicks on {int} days trial button")
	public void user_clicks_on_days_trial_button(Integer int1) {
	   homePage = new HomePage(driver);
	   
	   
	   registerPage = homePage.clickOnFreeTrialButton();
	}
	
	
	@Then("User should redirect to Register Page")
	public void user_should_redirect_to_register_page() throws Throwable {
	   
	   String pageTitle = commonUtils.getWebPageTitle();
	   Assert.assertEquals(pageTitle, "Start a Free Trial - Newspapers.com™"); 
	   
	}
	
	@Then("Signup Header text should displayed")
	public void signup_header_text_should_displayed() {
		Assert.assertTrue(registerPage.isRegisterTextDisplayed());
	}
	
	@When("User clicks on redeem a gift button")
	public void user_clicks_on_redeem_a_gift_button() {
	    redeemPage = homePage.clickOnRedeemButton();
	}
	
	@Then("User should redirect to Redeem Page")
	public void user_should_redirect_to_redeem_page() throws Throwable {
		String pageTitle = commonUtils.getWebPageTitle();
		Assert.assertEquals(pageTitle, "Redeem your gift subscription - Newspapers.com");    
	}
	
	@Then("Redeem gift text should displayed")
	public void redeem_gift_text_should_displayed() {
		Assert.assertTrue(redeemPage.isRedeemHeaderDisplayed());
	   
	}
	
	@When("User clicks on explore all location")
	public void user_clicks_on_explore_all_location() {
	    browsePage = homePage.clickOnExploreLocationsButton();
	}
	
	@Then("User should redirect to Browse Page")
	public void user_should_redirect_to_browse_page() throws Throwable {
		String pageTitle = commonUtils.getWebPageTitle();
		Assert.assertEquals(pageTitle, "Browse"); 
	}
	
	@Then("Browse Header text should be displayed")
	public void browse_header_text_should_be_displayed() {
	    Assert.assertTrue(browsePage.isRedeemHeaderDisplayed());
	}
	
	
	@When("User clicks on Blogs")
	public void user_clicks_on_blogs() {
	    blogSitePage = homePage.clickOnBlogSiteButton();
	}
	
	
	@Then("User should redirect to Official Blog site")
	public void user_should_redirect_to_official_blog_site() throws Throwable {
		String pageTitle = commonUtils.getWebPageTitle();
		Assert.assertEquals(pageTitle, "- The official blog of Newspapers.com");  
	}
	
	
	@Then("Blog Logo should displayed in the page")
	public void blog_logo_should_displayed_in_the_page() {
		Assert.assertTrue(blogSitePage.isBlogLogoDisplayed());
	} 

	
	
}
