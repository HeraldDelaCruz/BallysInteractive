package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class SearchResultPage {
	WebDriver driver;
	private CommonUtils commonUtils;
	
	public SearchResultPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils = new CommonUtils(driver);
	}	
	
	//objects
	@FindBy(css = ".text-center.bg-down-arrow.text-white.pt-3.pb-5.h5")
	private WebElement FreeAccessText;
	
	@FindBy(css = ".text-center.text-white.my-2")
	private WebElement NoResultHeaderText;
	
	@FindBy(css = "body > div:nth-child(1) > div:nth-child(2) > main:nth-child(2) > div:nth-child(1) > "
			+ "div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) >"
			+ " div:nth-child(2) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)")
	private WebElement NewspaperSearchResult;

	@FindBy(css = "button[title='Collections and Articles']")
	private WebElement CategoryFilter;
	
	@FindBy(css = "button[title='Newspapers']")
	private WebElement NewspaperFilter;
	
	@FindBy(css = "button[title='Sort']")
	private WebElement SortFilter;
	
	@FindBy(css = "button[title='More Filters']")
	private WebElement MoreFilter;
	
	@FindBy(css = "button[class='btn text-capitalize text-muted d-none d-sm-inline']")
	private WebElement ClearAllFilter;
	
	@FindBy(css = "#logo")
	private WebElement SearchResultHeaderLogo;
	
	
	
	//methods
	public boolean isFreeAccessTextDisplayed() {
		return commonUtils.isElementDisplayed(FreeAccessText, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public boolean isHeaderTextDisplayed() {
		return commonUtils.isElementDisplayed(NoResultHeaderText, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public boolean isNewspaperResultDisplayed() {
		
		return commonUtils.isElementDisplayed(NewspaperSearchResult, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	
	public boolean isCategoryFiltertDisplayed() {
		return commonUtils.isElementDisplayed(CategoryFilter, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public boolean isNewsPaperFilterDisplayed() {
		return commonUtils.isElementDisplayed(NewspaperFilter, commonUtils.EXPLICIT_WAIT_TIME);
		
	}

	public boolean isSortFilterDisplayed() {
		return commonUtils.isElementDisplayed(SortFilter, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public boolean isMoreResultDisplayed() {
		return commonUtils.isElementDisplayed(MoreFilter, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public boolean isSearchResultLogoDisplayed() {
		return commonUtils.isElementDisplayed(SearchResultHeaderLogo, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	public boolean isClearAllDisplayed() {
		return commonUtils.isElementDisplayed(ClearAllFilter, commonUtils.EXPLICIT_WAIT_TIME);
		
	}
	
	
	
}
