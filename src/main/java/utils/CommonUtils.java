package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonUtils {

	WebDriver driver;
	
	public CommonUtils(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public final int IMPLICIT_WAIT_TIME=10;
	public final int PAGE_LOAD_TIME=15;
	public final int EXPLICIT_WAIT_TIME=10;
	
	public void clickOnElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		 
	}
	
	public void inputTextIntoElement(WebElement element,String textInput,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textInput);
		
	}
	
	public void hitEnterKey(WebElement element,long durationInSeconds) {
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.sendKeys(Keys.ENTER);
		
	}
	
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
		
	}
	
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);	
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
		
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
		
	}
	
	public void javaScriptClick(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",webElement);
		
	}
	
	public void javaScriptType(WebElement element,long durationInSeconds,String textToBeTyped) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'",webElement);
		
	}
	
	public String getTextFromElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		return webElement.getText();
		
	}
	
	public boolean isElementDisplayed(WebElement element,long durationInSeconds) {
		
		try {
			WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
			return webElement.isDisplayed();
		}catch(Throwable e) {
			return false;
		}
		
	}
	
	public String getWebPageTitle() throws Throwable {	
		Thread.sleep(1000);
		return driver.getTitle();
	}
	
	public boolean isButtonEnabled(WebElement element,long durationInSeconds) {
		
		try {
			WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
			return webElement.isEnabled();
		}catch(Throwable e) {
			return false;
		}
	}
	
	
	
}

