package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class BlogSitePage {
	WebDriver driver;
	private CommonUtils commonUtils;
	
	public BlogSitePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}
	
	
	//objectd
	@FindBy(css = "img[alt='FishWrap The official blog of Newspapers.com']")
	private WebElement BlogLogo;
	
	
	//methods
	public boolean isBlogLogoDisplayed() {
		return commonUtils.isElementDisplayed(BlogLogo, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
}
