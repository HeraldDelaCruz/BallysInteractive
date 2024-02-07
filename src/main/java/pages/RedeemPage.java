package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class RedeemPage {

	WebDriver driver;
	private CommonUtils commonUtils;

	public RedeemPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}

	//objects
	@FindBy(css = ".h4.mb-4.text-secondary2")
	private WebElement RedeemHeaderText;

	
	//method
	public boolean isRedeemHeaderDisplayed() {
		return commonUtils.isElementDisplayed(RedeemHeaderText,commonUtils.EXPLICIT_WAIT_TIME);
	}
}
