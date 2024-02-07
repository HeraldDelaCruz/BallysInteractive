package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class LoginPage {

	WebDriver driver;
	CommonUtils commonUtils;
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}
	
	
	//objects
	@FindBy(id = "email")
	private WebElement emailField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(css = "button[title='Sign in with Newspapers.com")
	private WebElement UsersLoginButton;
	
	@FindBy(css = ".body")
	private WebElement ErrorMessage;
	
	
	//methods
	public void enterEmailAddress(String email) {
		commonUtils.inputTextIntoElement(emailField, email,commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterPassword(String password) {
		commonUtils.inputTextIntoElement(passwordField, password,commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void clickOnUserLogin() {
		commonUtils.clickOnElement(UsersLoginButton,commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public String getErrorMessage() {
		return commonUtils.getTextFromElement(ErrorMessage, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public boolean checkUserLoginButtonStatus() {
		return commonUtils.isButtonEnabled(UsersLoginButton, commonUtils.EXPLICIT_WAIT_TIME);
	}
}

