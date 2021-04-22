package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunch {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/Users/saipraveen/downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
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
		System.out.println(driver.getPageSource());
		driver.close();

	}

}
