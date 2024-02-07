package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class RegisterPage {
	WebDriver driver;
	private CommonUtils commonUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}
	
	//objects
	@FindBy(css = ".NewspapersEntry_Heading__kO_oq")
	private WebElement RegisterHeaderText;
	
	
	//methods
	public boolean isRegisterTextDisplayed() {
		return commonUtils.isElementDisplayed(RegisterHeaderText,commonUtils.EXPLICIT_WAIT_TIME);
	}
}
