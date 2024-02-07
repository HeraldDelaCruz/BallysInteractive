package steps;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;


public class CommonSteps {
	
	WebDriver driver;
	
	@Given("User is in the Home page")
	public void user_is_in_the_home_page() {
		driver = DriverFactory.getDriver();
		
	}
	
}