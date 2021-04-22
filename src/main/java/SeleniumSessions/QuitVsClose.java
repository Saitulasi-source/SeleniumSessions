package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/saipraveen/downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("Page title is : " + title);
		if (title.equals("Google")) {
			System.out.println("Correct Title");
		} else {
			System.out.println("Incorrect Title");
		}
		String url = driver.getCurrentUrl();
		System.out.println(url);
		System.out.println(driver.getPageSource());
		//driver.quit();
		driver.close();
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());

	}

}
