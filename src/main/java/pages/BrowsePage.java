package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class BrowsePage {
	WebDriver driver;
	private CommonUtils commonUtils;
	
	public BrowsePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}
	
	//objects
	@FindBy(css = "div[class='Browse_BrowseHeading__J270v'] h1")
	private WebElement BrowseHeaderText;
	
	//methods
	public boolean isRedeemHeaderDisplayed() {
		return commonUtils.isElementDisplayed(BrowseHeaderText,commonUtils.EXPLICIT_WAIT_TIME);
	}
}