package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class HomePage {
	WebDriver driver;
	private CommonUtils commonUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}
	
	//objects
	@FindBy(css = ".d-none.d-xl-inline")
	private WebElement HomeLoginButton;
	
	@FindBy(css = ".text-truncate.d-inline-block.mw-150p")
	private WebElement UsersName;
	
	@FindBy(id = "keyword-input")
	private WebElement KeywordField;

	@FindBy(id = "date-input")
	private WebElement DateField;
	
	@FindBy(id = "location-input")
	private WebElement LocationField;
	
	@FindBy(css = "button[class='ml-sm-2 ml-md-3 mt-2 mt-sm-0 d-none d-sm-block position-relative border-info btn btn-primary btn-lg']")
	private WebElement SearchIconButton;
	
	@FindBy(css = "button[class='text-wrap selected dropdown-item'] span[class='font-weight-bold']")
	private WebElement LocationDropdown;
	
	@FindBy(css = ".btn.btn-lg.btn-primary.ft-btn.mb-sm-n3.mb-md-0.rounded-pill")
	private WebElement FreeTrialButton;
	
	@FindBy(css = "a[class='btn btn-link']")
	private WebElement RedeemButton;

	@FindBy(css = "button[class='rounded-pill btn btn-outline-primary']")
	private WebElement ExploreLocations;
	
	@FindBy(css = "#blogFooter")
	private WebElement BlogSiteButton;
	
	
	//methods
	public LoginPage clickOnHomePageLoginButton() {
		commonUtils.clickOnElement(HomeLoginButton, commonUtils.EXPLICIT_WAIT_TIME);
		return new LoginPage(driver);
	}
	
	public boolean displayOfUsersName() {
		return commonUtils.isElementDisplayed(UsersName, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public String getDisplayUsersName() {
		return commonUtils.getTextFromElement(UsersName, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterSearchKeyword(String keyword) {
		commonUtils.inputTextIntoElement(KeywordField, keyword, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterSearchDate(String date) {
		commonUtils.inputTextIntoElement(DateField, date, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public void enterSearchLocation(String loc) {
		commonUtils.inputTextIntoElement(LocationField, loc, commonUtils.EXPLICIT_WAIT_TIME);
		commonUtils.hitEnterKey(LocationField, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public SearchResultPage clickOnSearchIcon() {
		commonUtils.clickOnElement(SearchIconButton, commonUtils.EXPLICIT_WAIT_TIME);
		return new SearchResultPage(driver);
	}
	
	public void clickOnLocationDropdown() {
		commonUtils.clickOnElement(LocationDropdown, commonUtils.EXPLICIT_WAIT_TIME);
	}
	
	public RegisterPage clickOnFreeTrialButton() {
		commonUtils.clickOnElement(FreeTrialButton, commonUtils.EXPLICIT_WAIT_TIME);
		return new RegisterPage(driver);
	}
	
	public RedeemPage clickOnRedeemButton() {
		commonUtils.clickOnElement(RedeemButton, commonUtils.EXPLICIT_WAIT_TIME);
		return new RedeemPage(driver);
	}
	
	public BrowsePage clickOnExploreLocationsButton() {
		commonUtils.clickOnElement(ExploreLocations, commonUtils.EXPLICIT_WAIT_TIME);
		return new BrowsePage(driver);
	}

	
	public BlogSitePage clickOnBlogSiteButton() {
		commonUtils.clickOnElement(BlogSiteButton, commonUtils.EXPLICIT_WAIT_TIME);
		return new BlogSitePage(driver);
	}
		
}
