package driverFactory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

	static WebDriver driver;
	
	public static WebDriver init_browser(String browserName) {
				
		if(browserName.equals("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equals("edge")) {
			
			driver = new EdgeDriver();
			
		}else {
			System.out.println("Please input correct browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		
		return driver;
		
	}
	
}

