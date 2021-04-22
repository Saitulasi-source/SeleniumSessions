package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author saipraveen
 *
 */
public class BrowserUtil {
	WebDriver driver;

	/**
	 * This method is used to initialize the WebDriver based on the given browser
	 * name
	 * 
	 * @param browserName
	 * @return This method returns the driver
	 */
	public WebDriver init_driver(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		case "safari":
			driver = new SafariDriver();

		default:
			System.out.println("Please pass the correct browser name : " + browserName);
			break;
		}
		return driver;
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
