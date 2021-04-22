package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTesting {

	public static void main(String[] args) {

		WebDriver driver = null;
		String browser = "chrome";
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/saipraveen/downloads/chromedriver");

			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/saipraveen/downloads/geckodriver");

			driver = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Please pass the correct browser");
		}

		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Google")) {
			System.out.println("Correct Title");
		} else {
			System.out.println("Incorrect Title");
		}
		String url = driver.getCurrentUrl();
		System.out.println(url);
		driver.quit();

	}

}
